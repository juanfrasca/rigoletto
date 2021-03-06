package com.proyectoegg.rigoletto.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idProducto;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    private Double precio;

    
    private String foto;
    
    private String descripcion;
      
    private String tipoProducto;

    public void crearProducto() {
    /*Esto va en el paquete de Servicios*/
    }

    public void modificarProducto() {
    /*Esto va en el paquete de Servicios*/
    }

    public void borrarProducto() {
    /*Esto va en el paquete de Servicios*/
    }

    public void listarProducto() {
    /*Esto va en el paquete de Servicios*/
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
