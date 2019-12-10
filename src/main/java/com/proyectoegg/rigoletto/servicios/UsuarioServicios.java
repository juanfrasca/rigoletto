package com.proyectoegg.rigoletto.servicios;

import com.proyectoegg.rigoletto.entidades.Usuario;
import com.proyectoegg.rigoletto.errores.ErrorServicio;
import com.proyectoegg.rigoletto.repositorios.UsuarioRepositorio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicios {
    
    @Autowired
    UsuarioRepositorio usuariorepositorio;
    
    @Transactional
    public void registrar(String nombre, String apellido, String domicilio, String telefono, String email, String clave, String zona) throws ErrorServicio{
        
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDomicilio(domicilio);
        usuario.setTelefono(telefono);
        usuario.setEmail(email);
        usuario.setClave(clave);
        usuario.setZona(zona);
        usuariorepositorio.save(usuario);
        
    }
    
    private void validar(String nombre, String apellido, String domicilio, String telefono, String email, String clave, String zona) throws ErrorServicio {
        
        if( nombre == null || nombre.isEmpty()){
            throw new ErrorServicio ("El nombre de usuario no puede ser nulo.");
        }
        
        if( apellido == null || apellido.isEmpty()){
            throw new ErrorServicio("El apellido de usuario no puede ser nulo.");
        }
        
        if( domicilio == null || domicilio.isEmpty()){
            throw new ErrorServicio("El domicilio no puede ser nulo.");
        }
        
        if( telefono == null || telefono.isEmpty() || telefono.length() <10 || telefono.length() >10){
            throw new ErrorServicio("El telefono no puede ser nulo o el telefono no puede tener menos de 10 digitos y tampoco mas.");
            
        }
        
        if(email == null || email.isEmpty() || email.contains("@") || email.indexOf('.') < 0){
            throw new ErrorServicio("El email no puede ser nulo o email es invalido.");
           
        }
        
        if( clave == null || clave.isEmpty() || clave.length() <=3 || clave.length()>=8 ){
            throw new ErrorServicio("La clave no puede ser nula tiene que tener mas de 3 digitos y menos de 8 digitos.");   
        }
    }
}
