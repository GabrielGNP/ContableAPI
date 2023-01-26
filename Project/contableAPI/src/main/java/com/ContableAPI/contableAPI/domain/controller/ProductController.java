package com.ContableAPI.contableAPI.domain.controller;

import com.ContableAPI.contableAPI.domain.models.publico.Product;
import com.ContableAPI.contableAPI.persistence.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping(value = "/saveProduct")
    public ResponseEntity<String> saveAProduct(@RequestBody Product product){
        if(productoRepository.saveProduct(product)){
            return ResponseEntity.status(HttpStatus.CREATED).body("correct save");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("data saving error");
        }
    }

    @PostMapping(value = "/savesProducts")
    public ResponseEntity<List<String>> savesProducts(@RequestBody List<Product> products){
        List<String> restSaves = new ArrayList<String>();
        products.forEach(product -> {
            if(productoRepository.saveProduct(product)){
                restSaves.add("correct save: "+product.getName() + " " + product.getTrademark());
            }else{
                restSaves.add("ERROR, failed to save: "+product.getName() + " " + product.getTrademark());
            }
        });
        return ResponseEntity.status(HttpStatus.OK).body(restSaves);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Product>> getListProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productoRepository.listProducts());
    }
}
