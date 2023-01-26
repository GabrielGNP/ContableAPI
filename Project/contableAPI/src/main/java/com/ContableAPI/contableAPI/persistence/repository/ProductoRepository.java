package com.ContableAPI.contableAPI.persistence.repository;

import com.ContableAPI.contableAPI.domain.models.publico.Product;
import com.ContableAPI.contableAPI.persistence.mappers.ProductMapper;
import com.ContableAPI.contableAPI.persistence.models.publico.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    public boolean saveProduct(Product product){
        try{
            productoCrudRepository.save(mapper.toProducto(product));
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public List<Product> listProducts(){
        return mapper.toProducts((List<Producto>) productoCrudRepository.findAll());
    }
}
