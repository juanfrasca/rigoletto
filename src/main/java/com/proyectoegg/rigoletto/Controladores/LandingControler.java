package com.proyectoegg.rigoletto.Controladores;

import com.proyectoegg.rigoletto.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LandingControler {

    @Autowired
    private UsuarioServicios usuarioservicio;

    @GetMapping("/")
    public String landing() {
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/l")
    public String loginL() {
        return "indexL.html";
    }

    @GetMapping("/listado")
    public String listado() {
        return "ejemplolistado.html";
    }

    @GetMapping("/cargar")
    public String producto() {
        return "producto.html";
    }
    
    @GetMapping("/listadoproducto")
    public String listadoProducto(){
        return "listadoproducto.html ";
    }

}
