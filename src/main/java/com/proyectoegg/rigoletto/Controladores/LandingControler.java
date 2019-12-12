
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
    
    /*@GetMapping("/eliminar")
    public String eliminar(@RequestParam String id) {
        try {
            usuarioservicio.borrarUsuario(id);
            return "redirect:/autor/listado";
        } catch (Exception ex) {
            return "redirect:/autor/listado?error=No se pudo eliminar los datos del usuario que desea.";
        }
    }
    */ 

}
