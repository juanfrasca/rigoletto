
package com.proyectoegg.rigoletto.repositorios;

import com.proyectoegg.rigoletto.entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

    @Query("SELECT c FROM Producto c WHERE c.nombre LIKE %:q%")
    public List<Producto> buscarProducto(@Param("q") String q);
    
}
