package com.proyectoegg.rigoletto.repositorios;

import com.proyectoegg.rigoletto.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer>{
    
}
