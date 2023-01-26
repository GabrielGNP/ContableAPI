package com.ContableAPI.contableAPI.persistence.repository;

import com.ContableAPI.contableAPI.domain.models.personal.PurchaseProducts;
import com.ContableAPI.contableAPI.persistence.mappers.PurchaseProductsMapper;
import com.ContableAPI.contableAPI.persistence.models.personal.MovimientoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import java.util.Date;
import java.sql.Date;
import java.util.List;

@Repository
public class MovimientoProductoRepository {

    @Autowired
    private MovimientoProductoCrudRepository movimientoProductoCrudRepository;

    @Autowired
    private PurchaseProductsMapper mapper;

    public boolean savePurchase(PurchaseProducts purchaseProducts){
        try{
            movimientoProductoCrudRepository.save(mapper.toMovimientoProducto(purchaseProducts));
            return true;
        }catch(Exception e){
            System.err.println(e);
            return false;
        }
    }

    public List<PurchaseProducts> listPurchasesDate(Date date){
        System.out.println("______________________________________________");
        System.out.println("MovimientoProductoRepository");
        System.out.println("date: "+ date);
        System.out.println("______________________________________________");
        List<MovimientoProducto> movProd = movimientoProductoCrudRepository.obtenerListaDeMovimientosSegunFecha(date);
        movProd.forEach(mp -> {
            System.out.println(mp.getFecha());
        });
        return mapper.toPurchaseProducts(movimientoProductoCrudRepository.obtenerListaDeMovimientosSegunFecha(date));
    }

    public List<PurchaseProducts> listPurchasesAProduct(Integer idProduct){
        return mapper.toPurchaseProducts(movimientoProductoCrudRepository.obtenerListaDeMovimientosSegunProducto(idProduct));
    }
}
