package com.proyectoegg.rigoletto.servicios;

import com.proyectoegg.rigoletto.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicios {
    
    @Autowired
    UsuarioRepositorio usuariorepositorio;
}
