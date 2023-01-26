package com.ContableAPI.contableAPI.domain.controller;

import com.ContableAPI.contableAPI.domain.models.publico.PriceDate;
import com.ContableAPI.contableAPI.domain.models.publico.Product;
import com.ContableAPI.contableAPI.domain.models.publico.Shop;
import com.ContableAPI.contableAPI.domain.models.publico.ShopProduct;
import com.ContableAPI.contableAPI.persistence.repository.ProductoLocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/ProductsInShop")
public class ShopProductController {
    @Autowired
    private ProductoLocalRepository productoLocalRepository;

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveProductInShop(@RequestBody ShopProduct shopProduct){
        shopProduct.setDateCost(shopProduct.getDateCost()+"|");
        if(productoLocalRepository.saveShopProduct(shopProduct)){
            return ResponseEntity.status(HttpStatus.OK).body("correct save");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("data saving error");
        }
    }

    @PostMapping(value = "/saves")
    public ResponseEntity<List<String>> savesProductsInShop(@RequestBody List<ShopProduct> shopProducts){
        List<String> restSaves = new ArrayList<String>();
        shopProducts.forEach(shopProduct -> {
            shopProduct.setDateCost(shopProduct.getDateCost()+"|");
            if(productoLocalRepository.saveShopProduct(shopProduct)){
                restSaves.add("correct save");
            }else{
                restSaves.add("data saving error");
            }
        });
        return ResponseEntity.status(HttpStatus.OK).body(restSaves);
    }

    @PostMapping(value = "/savePrice")
    public ResponseEntity<String> saveNewPrice(@RequestBody PriceDate newPriceDate){
        newPriceDate.setNewPrice(newPriceDate.getNewPrice()+"|");
        if (productoLocalRepository.saveNewPrice(newPriceDate.getIdShopProduct(), newPriceDate.getNewPrice())){
            return ResponseEntity.status(HttpStatus.OK).body("Correct update");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("price update error");
        }
    }

    @GetMapping(value = "/list/all")
    public ResponseEntity<List<ShopProduct>> listAllShopProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productoLocalRepository.listProducts());
    }

    @GetMapping(value = "/list/productsInShop{id}")
    //public ResponseEntity<List<ShopProduct>> listAllProductsInSHop(@PathVariable("id") int idShop){
    public ResponseEntity<List<Product>> listAllProductsInSHop(@PathVariable("id") int idShop){
        List<ShopProduct> shopsProducts = productoLocalRepository.listProductsInShop(idShop);
        List<Product> products = new LinkedList<>();
        shopsProducts.forEach(shopProduct -> {
            products.add(shopProduct.getProduct());
        });
        //return ResponseEntity.status(HttpStatus.OK).body(productoLocalRepository.listProductsInShop(idShop));
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping(value = "/list/shopWhitProduct{id}")
    //public ResponseEntity<List<ShopProduct>> listAllShopWhitAProduct(@PathVariable("id") int idProduct){
    public ResponseEntity<List<Shop>> listAllShopWhitAProduct(@PathVariable("id") int idProduct){
        List<ShopProduct> shopsProducts = productoLocalRepository.listShopsWhitProduct(idProduct);
        List<Shop> shops = new LinkedList<>();
        shopsProducts.forEach(shopProduct -> {
            shops.add(shopProduct.getShop());
        });
        //return ResponseEntity.status(HttpStatus.OK).body(productoLocalRepository.listShopsWhitProduct(idProduct));
        return ResponseEntity.status(HttpStatus.OK).body(shops);
    }

    static class PricesForDates{
        private String price;
        private String date;

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    @GetMapping(value = "/Hprice/shop{idShop}/product{idProd}")
    //public ResponseEntity<String> getHistoryPrice(@PathVariable("idShop") int idShop, @PathVariable("idProd") int idProd){
    public ResponseEntity<List<PricesForDates>> getHistoryPrice(@PathVariable("idShop") int idShop, @PathVariable("idProd") int idProd){
        String historyPrices = productoLocalRepository.getHistoryPriceOfProductInShop(idProd, idShop);
        PricesForDates priceDate = new PricesForDates();
        List<PricesForDates> prices = new LinkedList<>();
        StringBuilder price = new StringBuilder();
        StringBuilder date = new StringBuilder();
        int comp = 0;
        for (int i = 0; i < historyPrices.length(); i++) {
            switch (historyPrices.charAt(i)){
                case '|':
                    priceDate.setPrice(price.toString());
                    priceDate.setDate(date.toString());
                    prices.add(priceDate);
                    priceDate = new PricesForDates();
                    comp=0;
                    price = new StringBuilder();
                    date = new StringBuilder();
                    break;
                case '_':
                    comp=1;
                    break;
                default:
                    if(comp==0){
                        price.append(historyPrices.charAt(i));
                    }else if(comp==1){
                        date.append(historyPrices.charAt(i));
                    }
                    break;
            }
        }
        //return ResponseEntity.status(HttpStatus.OK).body(productoLocalRepository.getHistoryPriceOfProductInShop(idProd, idShop));
        return ResponseEntity.status(HttpStatus.OK).body(prices);
    }
}
