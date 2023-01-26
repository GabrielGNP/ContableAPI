package com.ContableAPI.contableAPI.persistence.repository;

import com.ContableAPI.contableAPI.domain.models.publico.Product;
import com.ContableAPI.contableAPI.domain.models.publico.ShopProduct;
import com.ContableAPI.contableAPI.persistence.mappers.ShopProductMapper;
import com.ContableAPI.contableAPI.persistence.models.publico.ProductoLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoLocalRepository {

    @Autowired
    private ProductoLocalCrudRepository productoLocalCrudRepository;

    @Autowired
    private ShopProductMapper mapper;

    public boolean saveShopProduct(ShopProduct shopProduct){
        try{
            productoLocalCrudRepository.save(mapper.toProductoLocal(shopProduct));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<ShopProduct> listProducts(){
        return mapper.toShopProducts((List<ProductoLocal>)productoLocalCrudRepository.findAll());
    }

    public boolean saveNewPrice(Integer idShopProduct, String newPrice){
        System.out.println(idShopProduct);
        System.out.println(newPrice);
        try{
            productoLocalCrudRepository.updateNuevoPrecio(idShopProduct, newPrice);
            return true;
        }catch (Exception e){

            System.err.println(e);
            return false;
        }
    }

    public List<ShopProduct> listProductsInShop(Integer idShop){
        return mapper.toShopProducts(productoLocalCrudRepository.obtenerListaDeProductos(idShop));
    }

    public List<ShopProduct> listShopsWhitProduct(Integer idProduct){
        return mapper.toShopProducts(productoLocalCrudRepository.obtenerListaDeLocalesSegunProducto(idProduct));
    }

    public String getHistoryPriceOfProductInShop(Integer idProduct, Integer idShop){
        return productoLocalCrudRepository.obtenerPrecioHistoricoDeProducto(idProduct, idShop);
    }

}
