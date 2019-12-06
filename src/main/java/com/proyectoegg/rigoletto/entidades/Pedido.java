package com.proyectoegg.rigoletto.entidades;

import com.proyectoegg.rigoletto.enumeraciones.Estado;
import com.proyectoegg.rigoletto.enumeraciones.MedioDePago;
import com.proyectoegg.rigoletto.enumeraciones.TipoEntrega;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    private Usuario usuario;

    private Date fecha_hora;

    private MedioDePago medioPago;

    private Estado estado;

    private String domicilio;

    private Long telefono;

    private TipoEntrega tipoEntrega;

    private List<DetallePedido> productos;

    public void crearPedido() {
    /*Esto va en el paquete de Servicios*/
    }

    public void modificarPedido() {
    /*Esto va en el paquete de Servicios*/
    }

    public void borrarPedido() {
    /*Esto va en el paquete de Servicios*/
    }

    public void listarPedido() {
    /*Esto va en el paquete de Servicios*/
    }
    
    @Transient
    public double getmontoTotal() {
        double monto = 0;
        for (DetallePedido producto : productos) {
            monto += producto.getCantidad()*producto.getProducto().getPrecio();
        }
        return monto;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public MedioDePago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioDePago medioPago) {
        this.medioPago = medioPago;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public List<DetallePedido> getProductos() {
        return productos;
    }

    public void setProductos(List<DetallePedido> productos) {
        this.productos = productos;
    }
}
