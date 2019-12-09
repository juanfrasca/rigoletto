package com.proyectoegg.rigoletto.repositorios;

import com.proyectoegg.rigoletto.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
                
}
