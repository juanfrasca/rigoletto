package com.proyectoegg.rigoletto.repositorios;

import com.proyectoegg.rigoletto.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    @Query("SELECT c FROM Usuario c WHERE c.nombre LIKE %:q% OR c.apellido LIKE %:q%")
    public List<Usuario> buscarUsuario(@Param("q") String q);
}
