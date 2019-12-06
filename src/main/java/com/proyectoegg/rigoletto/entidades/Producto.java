package com.proyectoegg.rigoletto.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto {

    @Id
    private Integer idProducto;

    private String nombre;

    private Double precio;

    private byte[] foto;


    public void crearProducto() {
    }

    public void modificarProducto() {
    }

    public void borrarProducto() {
    }

    public void listarProducto() {
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
