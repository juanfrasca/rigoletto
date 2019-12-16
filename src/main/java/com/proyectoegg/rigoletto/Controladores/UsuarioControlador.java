package com.proyectoegg.rigoletto.Controladores;

import com.proyectoegg.rigoletto.entidades.Usuario;
import com.proyectoegg.rigoletto.errores.ErrorServicio;
import com.proyectoegg.rigoletto.repositorios.UsuarioRepositorio;
import com.proyectoegg.rigoletto.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

     @GetMapping("/registro")
    public String registro() throws ErrorServicio {
        return "registro.html";
    }
     @GetMapping("/modificar")
    public String modif() throws ErrorServicio {
        return "editarUsuario.html";
    }
     @GetMapping("/logear")
    public String log() throws ErrorServicio {
        return "login.html";
    }
     
    
    @PostMapping("/registrar")
    public String registrar(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String domicilio, @RequestParam String telefono, @RequestParam String email, @RequestParam String clave, @RequestParam String zona) throws ErrorServicio {
        System.out.println("hola");
        us.crearUsuario(nombre, apellido, domicilio, telefono, email, clave, zona);
        return "redirect:/login";
        
    }
    
      
    @PostMapping("/ingreso")
    public String login(@RequestParam String email, @RequestParam String clave) throws ErrorServicio {

        if (user.buscarPorMail(email) != null) {
            Usuario users = user.buscarPorMail(email);

            if (users.getClave().equals(clave)) {
                return "redirect:/l";
            }
        }
        return "redirect:/registro";
    }

    @GetMapping("/editarUsuario")
    public String actualizacion(@RequestParam(required = false) String id, @RequestParam(required = false) String error,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String domicilio,@RequestParam String telefono,@RequestParam String email,@RequestParam String clave,@RequestParam String zona,ModelMap modelo) {
        if (id != null) {
            Usuario usuario = us.buscarUsuarios(id);
            modelo.put("asuario", usuario);
        } else {
            modelo.put("usuario", new Usuario());
        }

        modelo.put("error", error);

        return "indexL.html";
    }
    @PostMapping("/registro")
    public String actualizar(@RequestParam(required = false) String id, @RequestParam String nombre, @RequestParam String apellido,@RequestParam String domicilio,@RequestParam String telefono,@RequestParam String email,@RequestParam String clave,@RequestParam String zona,ModelMap modelo) {

        try {
            us.modificar(id, nombre, apellido, domicilio,telefono,email,clave,zona);
        } catch (Exception ex) {
            return "redirect:indexL" + id + "&error=" + ex.getMessage();
        }

        return "redirect:/index";
    }
}
