package com.ContableAPI.contableAPI.persistence.repository;

import com.ContableAPI.contableAPI.domain.models.publico.Shop;
import com.ContableAPI.contableAPI.persistence.mappers.ShopMapper;
import com.ContableAPI.contableAPI.persistence.models.publico.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocalRepository {

    @Autowired
    private LocalCrudRepository localCrudRepository;

    @Autowired
    private ShopMapper mapper;

    public boolean saveLocal(Shop shop){
        try {
            localCrudRepository.save(mapper.toLocal(shop));
            return true;
        }catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Shop> listShops(){
        return mapper.toShops((List<Local>) localCrudRepository.findAll());
    }

}
