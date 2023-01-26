package com.ContableAPI.contableAPI.persistence.mappers;

import com.ContableAPI.contableAPI.domain.models.publico.Shop;
import com.ContableAPI.contableAPI.persistence.models.publico.Local;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.persistence.Entity;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ShopMapper {

    @Mappings({
            @Mapping(source = "idLocal", target = " shopId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
    })
    Shop toShop(Local local);
    List<Shop> toShops(List<Local> locals);

    @InheritInverseConfiguration
    @Mapping(target = "productoLocalList", ignore = true)
    Local toLocal(Shop shop);
    List<Local> toLocals(List<Shop> shops);


}
