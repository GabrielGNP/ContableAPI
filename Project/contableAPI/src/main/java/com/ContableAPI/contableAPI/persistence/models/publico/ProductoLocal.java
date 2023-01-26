package com.ContableAPI.contableAPI.persistence.models.publico;

import com.ContableAPI.contableAPI.persistence.models.personal.MovimientoProducto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto_local")
public class ProductoLocal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prodloc")
    private Integer idProductoLocal;

    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "id_local")
    private Integer idLocal;

    @Column(name = "costo_fecha")
    private String costoFecha;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_local", insertable = false, updatable = false)
    private Local local;

    @OneToMany(mappedBy = "productoLocal")
    private List<MovimientoProducto> movimientoProductos;

    public Integer getIdProductoLocal() {
        return idProductoLocal;
    }

    public void setIdProductoLocal(Integer idProductoLocal) {
        this.idProductoLocal = idProductoLocal;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public String getCostoFecha() {
        return costoFecha;
    }

    public void setCostoFecha(String costoFecha) {
        this.costoFecha = costoFecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<MovimientoProducto> getMovimientoProductos() {
        return movimientoProductos;
    }

    public void setMovimientoProductos(List<MovimientoProducto> movimientoProductos) {
        this.movimientoProductos = movimientoProductos;
    }
}
