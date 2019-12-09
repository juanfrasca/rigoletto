package com.proyectoegg.rigoletto.repositorios;

import com.proyectoegg.rigoletto.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido,Integer>{
    
}
