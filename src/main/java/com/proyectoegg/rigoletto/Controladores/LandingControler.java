
package com.proyectoegg.rigoletto.Controladores;

import com.proyectoegg.rigoletto.errores.ErrorServicio;
import com.proyectoegg.rigoletto.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LandingControler {

    @Autowired
    private UsuarioServicios usuarioservicio;

    @GetMapping("/")
    public String PaginaPrincipal() throws ErrorServicio {
        return "index.html";
    }

    @PostMapping("/registrar")
    public String Registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String domicilio, @RequestParam String telefono, @RequestParam String email, @RequestParam String clave, @RequestParam String zona) throws ErrorServicio {
        usuarioservicio.crearUsuario(nombre, apellido, domicilio, telefono, email, clave, zona);
        return "redirect:/";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam String id) {
        try {
            usuarioservicio.borrarUsuario(id);
            return "redirect:/autor/listado";
        } catch (Exception ex) {
            return "redirect:/autor/listado?error=No se pudo eliminar los datos del usuario que desea.";
        }
    }

}
