package com.proyectoegg.rigoletto.repositorios;

import com.proyectoegg.rigoletto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
        
}
