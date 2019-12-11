package com.proyectoegg.rigoletto.entidades;

import com.proyectoegg.rigoletto.enumeraciones.Estado;
import com.proyectoegg.rigoletto.enumeraciones.MedioDePago;
import com.proyectoegg.rigoletto.enumeraciones.TipoEntrega;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
public class Pedido implements Serializable{

    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;
    
   
    private Usuario usuario;

    @Column (nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_hora;

    @Enumerated(EnumType.STRING)
    private MedioDePago medioPago;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column (nullable = false)
    private String domicilio;

    @Column (nullable = false)
    private String telefono;

    @Enumerated(EnumType.STRING)
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

    
    @Id
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
     @ManyToOne(targetEntity = Usuario.class)
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }
   @OneToMany(targetEntity=DetallePedido.class, mappedBy="producto", 
fetch=FetchType.EAGER)
    public List<DetallePedido> getProductos() {
        return productos;
    }

    public void setProductos(List<DetallePedido> productos) {
        this.productos = productos;
    }
}
