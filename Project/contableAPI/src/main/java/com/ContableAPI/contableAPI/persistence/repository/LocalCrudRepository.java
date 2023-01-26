package com.ContableAPI.contableAPI.persistence.repository;

import com.ContableAPI.contableAPI.persistence.models.publico.Local;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalCrudRepository extends CrudRepository<Local, Integer> {
}
