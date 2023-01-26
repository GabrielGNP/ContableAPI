package com.ContableAPI.contableAPI.domain.controller;

import com.ContableAPI.contableAPI.domain.models.publico.Shop;
import com.ContableAPI.contableAPI.persistence.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Shop")
public class ShopController {

    @Autowired
    private LocalRepository localRepository;

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveShop(@RequestBody Shop shop){
        if(localRepository.saveLocal(shop)){
            return ResponseEntity.status(HttpStatus.CREATED).body("correct save");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("data saving error");
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Shop>> listAllShops(){
        return ResponseEntity.status(HttpStatus.OK).body(localRepository.listShops());
    }
}
