
package com.proyectoegg.rigoletto.servicios;

import com.proyectoegg.rigoletto.entidades.DetallePedido;
import com.proyectoegg.rigoletto.entidades.Pedido;
import com.proyectoegg.rigoletto.entidades.Usuario;
import com.proyectoegg.rigoletto.errores.ErrorServicio;
import com.proyectoegg.rigoletto.repositorios.PedidoRepositorio;
import java.util.Date;
import java.util.List;
import javax.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServicios {
    
    @Autowired
    PedidoRepositorio pedidorepositorio;
    
    @Transient
    public void crearPedido(Usuario usuario, String telefono, String domicilio, List<DetallePedido> productos) throws ErrorServicio{
        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setTelefono(telefono);
        pedido.setDomicilio(domicilio);
        pedido.setProductos(productos);
        pedido.setFecha_hora(new Date());
        pedidorepositorio.save(pedido);
        
        
             
    }
    
    @Transient
    public double getmontoTotal(List<DetallePedido> productos) {
        double monto = 0;
        for (DetallePedido producto : productos) {
            monto += producto.getCantidad() * producto.getProducto().getPrecio();
        }
        return monto;
    }
}
