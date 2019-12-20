package com.proyectoegg.rigoletto.repositorios;

import com.proyectoegg.rigoletto.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, String> {
  
    @Query("SELECT c FROM DetallePedido c WHERE c.cantidad = :cantidad")
    public DetallePedido buscarDetallePedidoCantidad(@Param("cantidad") String cantidad);
}
