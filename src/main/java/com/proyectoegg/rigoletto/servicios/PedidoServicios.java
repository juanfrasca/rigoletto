
package com.proyectoegg.rigoletto.servicios;

import com.proyectoegg.rigoletto.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServicios {
    
    @Autowired
    PedidoRepositorio pedidorepositorio;
}
