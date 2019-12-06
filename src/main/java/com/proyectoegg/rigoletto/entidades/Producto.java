package com.proyectoegg.rigoletto.entidades;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private String nombre;

    private Double precio;

    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] foto;


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
