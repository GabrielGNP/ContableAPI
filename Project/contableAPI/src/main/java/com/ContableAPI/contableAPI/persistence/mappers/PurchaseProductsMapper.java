package com.ContableAPI.contableAPI.persistence.mappers;

import com.ContableAPI.contableAPI.domain.models.personal.PurchaseProducts;
import com.ContableAPI.contableAPI.persistence.models.personal.MovimientoProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = ShopProductMapper.class)
public interface PurchaseProductsMapper {
    @Mappings({
            @Mapping(source = "idMovimiento", target = "purchaseId"),
            @Mapping(source = "producto", target = "product"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "descuento", target = "discount"),
            @Mapping(source = "productoLocal", target = "shopProduct"),
    })
    PurchaseProducts toPurchaseProduct(MovimientoProducto movimientoProducto);
    List<PurchaseProducts> toPurchaseProducts(List<MovimientoProducto> movimientoProductos);

    @InheritInverseConfiguration
    MovimientoProducto toMovimientoProducto(PurchaseProducts purchaseProduct);
    List<MovimientoProducto> toMovimientoProductos(List<PurchaseProducts> purchaseProducts);

}
