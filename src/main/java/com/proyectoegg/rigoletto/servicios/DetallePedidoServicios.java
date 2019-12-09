package com.proyectoegg.rigoletto.servicios;

import com.proyectoegg.rigoletto.entidades.DetallePedido;
import com.proyectoegg.rigoletto.entidades.Producto;
import com.proyectoegg.rigoletto.errores.ErrorServicio;
import com.proyectoegg.rigoletto.repositorios.DetallePedidoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServicios {

    @Autowired
    DetallePedidoRepositorio detallepedidorepositorio;

    public List<DetallePedido> listarDetallePedido() {
        return detallepedidorepositorio.findAll();
    }

    public void crearDetallePedido(Producto producto, Integer cantidad) throws ErrorServicio {
        DetallePedido detallepedido = new DetallePedido();
        detallepedido.setProducto(producto);
        detallepedido.setCantidad(cantidad);
        detallepedidorepositorio.save(detallepedido);
    }

    public void validarDetalle(Producto producto, Integer cantidad) throws ErrorServicio {
        if (producto == null){
            throw new ErrorServicio("No se ha ingresado ningún producto.");
        }
        if (cantidad == 0 || cantidad == null){
            throw new ErrorServicio("No se ha ingresado ninguna cantidad.");
        }
        
    }
}
