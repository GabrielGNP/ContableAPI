package com.ContableAPI.contableAPI.persistence.repository;

import com.ContableAPI.contableAPI.persistence.models.publico.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}
