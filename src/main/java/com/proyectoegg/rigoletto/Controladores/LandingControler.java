package com.proyectoegg.rigoletto.Controladores;

import com.proyectoegg.rigoletto.entidades.Producto;
import com.proyectoegg.rigoletto.entidades.Usuario;
import com.proyectoegg.rigoletto.repositorios.ProductoRepositorio;
import com.proyectoegg.rigoletto.repositorios.UsuarioRepositorio;
import com.proyectoegg.rigoletto.servicios.UsuarioServicios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LandingControler {

     @Autowired
    private ProductoRepositorio productorepositorio;

    @Autowired
    private UsuarioServicios usuarioservicio;
    
    @Autowired
    private UsuarioRepositorio user;

    @GetMapping("/")
    public String landing() {
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/l")
    public String loginL(@RequestParam(required = false) String id, ModelMap model) {

        
        Optional<Usuario> respuesta = user.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            model.put("usuario", usuario);
        }

        return "indexL.html";
    }
    
    @GetMapping("/la")
    public String loginA(@RequestParam(required = false) String id, ModelMap model) {

        
        Optional<Usuario> respuesta = user.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            model.put("usuario", usuario);
        }
        List<Usuario> usuario;
        List<Producto> producto;
        usuario = user.findAll();
        producto = productorepositorio.findAll();

        model.put("usuario", usuario);
        model.put("producto", producto );

        return "indexA.html";
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
