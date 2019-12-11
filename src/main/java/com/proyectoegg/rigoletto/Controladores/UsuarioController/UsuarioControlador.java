package com.proyectoegg.rigoletto.Controladores.UsuarioController;

import com.proyectoegg.rigoletto.entidades.Usuario;
import com.proyectoegg.rigoletto.errores.ErrorServicio;
import com.proyectoegg.rigoletto.repositorios.UsuarioRepositorio;
import com.proyectoegg.rigoletto.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/rigoletto/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicios us;

    @Autowired
    private UsuarioRepositorio user;

    @PostMapping("/registrar")
    public String registrar(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String domicilio, @RequestParam String telefono, @RequestParam String email, @RequestParam String clave, @RequestParam String zona) throws ErrorServicio {
        us.crearUsuario(nombre, apellido, domicilio, telefono, email, clave, zona);
        return "redirect:/index";

    }
    
    @PostMapping("/ingreso")
    public String login(@RequestParam String email, @RequestParam String clave) throws ErrorServicio {

        if (user.buscarPorMail(email) != null) {
            Usuario users = user.buscarPorMail(email);

            if (users.getClave().equals(clave)) {
                return "redirect:/";
            }
        }
        return "redirect:/registro";
    }


}
