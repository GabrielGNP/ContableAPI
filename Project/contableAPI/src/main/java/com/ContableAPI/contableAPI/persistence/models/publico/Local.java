package com.ContableAPI.contableAPI.persistence.models.publico;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "local")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Integer idLocal;

    private String nombre;

    private String descripcion;

    @OneToMany(mappedBy = "local")
    private List<ProductoLocal> productoLocalList;

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ProductoLocal> getProductoLocalList() {
        return productoLocalList;
    }

    public void setProductoLocalList(List<ProductoLocal> productoLocalList) {
        this.productoLocalList = productoLocalList;
    }
}
