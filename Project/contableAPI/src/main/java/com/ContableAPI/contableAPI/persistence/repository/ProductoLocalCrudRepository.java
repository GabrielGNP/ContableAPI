package com.ContableAPI.contableAPI.persistence.repository;

import com.ContableAPI.contableAPI.persistence.models.publico.ProductoLocal;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductoLocalCrudRepository extends CrudRepository<ProductoLocal, Integer> {

    @Transactional  //<--| Necesarios para poder realizar un UPDATE
    @Modifying      //<--| Necesarios para poder realizar un UPDATE
    @Query(value = "UPDATE contabledb.producto_local set costo_fecha = CONCAT (costo_fecha, :newPrice) WHERE id_ProdLoc= :id",nativeQuery = true)
    //@Query(value = ":query",nativeQuery = true)
    void updateNuevoPrecio(
            @Param("id") Integer id,
            @Param("newPrice") String newPriceDate);
    //void guardarNuevoPrecio(@Param("query") String query);

    @Query(value = "SELECT * FROM contabledb.producto_local WHERE id_local = :id",nativeQuery = true)
    List<ProductoLocal> obtenerListaDeProductos(@Param("id") int id);

    @Query(value = "SELECT * FROM contabledb.producto_local WHERE id_producto = :idProd",nativeQuery = true)
    List<ProductoLocal> obtenerListaDeLocalesSegunProducto(@Param("idProd") int idProd);

    @Query(value = "SELECT costo_fecha FROM contabledb.producto_local WHERE id_producto = :idProd and id_local = :idLoc",nativeQuery = true)
    String obtenerPrecioHistoricoDeProducto(@Param("idProd") int idProd, @Param("idLoc") int idLoc);
}
