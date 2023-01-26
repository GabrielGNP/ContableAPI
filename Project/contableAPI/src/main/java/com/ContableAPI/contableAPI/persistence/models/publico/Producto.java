package com.ContableAPI.contableAPI.persistence.models.publico;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    private String marca;

    private String descripcion;

    @OneToMany(mappedBy = "producto")
    private List<ProductoLocal> productoLocals;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ProductoLocal> getProductoLocals() {
        return productoLocals;
    }

    public void setProductoLocals(List<ProductoLocal> productoLocals) {
        this.productoLocals = productoLocals;
    }
}
