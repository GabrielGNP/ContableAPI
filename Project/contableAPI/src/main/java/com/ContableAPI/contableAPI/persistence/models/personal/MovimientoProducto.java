package com.ContableAPI.contableAPI.persistence.models.personal;

import com.ContableAPI.contableAPI.persistence.models.publico.ProductoLocal;


import javax.persistence.*;
import java.sql.Date;
//import java.util.Date;

@Entity
@Table(name = "movimiento_producto")
public class MovimientoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    private Integer producto;

    private Integer cantidad;

    private Date fecha;

    private String descripcion;

    private Double descuento;

    @ManyToOne
    @JoinColumn(name = "producto", updatable = false, insertable = false)
    private ProductoLocal productoLocal;

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public ProductoLocal getProductoLocal() {
        return productoLocal;
    }

    public void setProductoLocal(ProductoLocal productoLocal) {
        this.productoLocal = productoLocal;
    }
}
