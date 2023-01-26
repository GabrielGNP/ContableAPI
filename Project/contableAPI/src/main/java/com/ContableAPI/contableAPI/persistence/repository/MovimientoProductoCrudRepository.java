package com.ContableAPI.contableAPI.persistence.repository;

import com.ContableAPI.contableAPI.persistence.models.personal.MovimientoProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import java.util.Date;
import java.util.List;
import java.sql.Date;

@Repository
public interface MovimientoProductoCrudRepository extends CrudRepository<MovimientoProducto, Integer> {
    @Query(value = "SELECT * FROM contabledb.movimiento_producto WHERE fecha = :date",nativeQuery = true)
    List<MovimientoProducto> obtenerListaDeMovimientosSegunFecha(@Param("date")Date date);

    @Query(value = "SELECT * FROM contabledb.movimiento_producto WHERE producto = :idProd", nativeQuery = true)
    List<MovimientoProducto> obtenerListaDeMovimientosSegunProducto(@Param("idProd") int idProd);
}
