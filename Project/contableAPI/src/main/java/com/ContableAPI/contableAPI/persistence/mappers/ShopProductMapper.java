package com.ContableAPI.contableAPI.persistence.mappers;

import com.ContableAPI.contableAPI.domain.models.publico.ShopProduct;
import com.ContableAPI.contableAPI.persistence.models.publico.ProductoLocal;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, ShopMapper.class})
public interface ShopProductMapper {

    @Mappings({
            @Mapping(source = "idProductoLocal", target = "shopProductId"),
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "idLocal", target = "shopId"),
            @Mapping(source = "costoFecha", target = "dateCost"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "producto", target = "product"),
            @Mapping(source = "local", target = "shop"),
    })
    ShopProduct toShopProduct(ProductoLocal productoLocal);
    List<ShopProduct> toShopProducts (List<ProductoLocal> productoLocals);

    @InheritInverseConfiguration
    @Mapping(target = "movimientoProductos",ignore = true)
    ProductoLocal toProductoLocal(ShopProduct shopProduct);
    List<ProductoLocal> toProductoLocals(List<ShopProduct> shopProducts);
}
