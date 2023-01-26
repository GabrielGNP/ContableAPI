package com.ContableAPI.contableAPI.domain.controller;

import com.ContableAPI.contableAPI.domain.models.personal.PurchaseProducts;
import com.ContableAPI.contableAPI.persistence.repository.MovimientoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.Date;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/Purchase")
public class PurchaseProductsController {

    @Autowired
    private MovimientoProductoRepository movimientoProductoRepository;

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveaPurchase(@RequestBody PurchaseProducts purchaseProducts){
        if(movimientoProductoRepository.savePurchase(purchaseProducts)){
            return ResponseEntity.status(HttpStatus.OK).body("correct save");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR data saving");
        }
    }

    @PostMapping(value = "/saves")
    public ResponseEntity<List<String>> savesPurchases(@RequestBody List<PurchaseProducts> purchaseProducts){
        List<String> response = new LinkedList<>();
        purchaseProducts.forEach(purchaseProduct -> {
            if(movimientoProductoRepository.savePurchase(purchaseProduct)){
                response.add("correct save");
            }else {
                response.add("ERROR data saving");
            }
        });
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @GetMapping(value = "/list/date{date}")
    public ResponseEntity<List<PurchaseProducts>> listPurchasesByDate(@PathVariable("date") Date date){
        //System.out.println(date);
        return ResponseEntity.status(HttpStatus.OK).body(movimientoProductoRepository.listPurchasesDate(date));

    }

    @GetMapping(value = "/list/product{id}")
    public ResponseEntity<List<PurchaseProducts>> listPurchasesByProduct(@PathVariable("id") int idProduct){
        return ResponseEntity.status(HttpStatus.OK).body(movimientoProductoRepository.listPurchasesAProduct(idProduct));
    }
}
