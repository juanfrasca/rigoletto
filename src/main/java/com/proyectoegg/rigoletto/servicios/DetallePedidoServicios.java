package com.proyectoegg.rigoletto.servicios;

import com.proyectoegg.rigoletto.repositorios.DetallePedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServicios {
    
    @Autowired
    DetallePedidoRepositorio detallepedidorepositorio;
}
