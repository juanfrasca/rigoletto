
package com.proyectoegg.rigoletto.repositorios;

import com.proyectoegg.rigoletto.entidades.Pedido;
import com.proyectoegg.rigoletto.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer>{
    
    @Query("SELECT c FROM Pedido c WHERE c.usuario=:q")
    public List<Pedido> buscarPedido(@Param("q") Usuario q);
}
