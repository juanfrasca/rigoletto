
package com.proyectoegg.rigoletto.servicios;

import com.proyectoegg.rigoletto.entidades.DetallePedido;
import com.proyectoegg.rigoletto.repositorios.PedidoRepositorio;
import java.util.List;
import javax.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServicios {
    
    @Autowired
    PedidoRepositorio pedidorepositorio;
    
    @Transient
    public double getmontoTotal(List<DetallePedido> productos) {
        double monto = 0;
        for (DetallePedido producto : productos) {
            monto += producto.getCantidad() * producto.getProducto().getPrecio();
        }
        return monto;
    }
}
