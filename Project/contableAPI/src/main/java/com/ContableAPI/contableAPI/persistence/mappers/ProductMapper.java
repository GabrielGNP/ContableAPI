package com.ContableAPI.contableAPI.persistence.mappers;

import com.ContableAPI.contableAPI.domain.models.publico.Product;
import com.ContableAPI.contableAPI.persistence.models.publico.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "marca", target = "trademark"),
            @Mapping(source = "descripcion", target = "description"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "productoLocals",ignore = true)
    Producto toProducto(Product product);
    List<Producto> toProductos(List<Product> products);

}
