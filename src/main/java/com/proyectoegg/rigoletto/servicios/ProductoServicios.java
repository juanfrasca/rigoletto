package com.proyectoegg.rigoletto.servicios;

import com.proyectoegg.rigoletto.entidades.Producto;
import com.proyectoegg.rigoletto.errores.ErrorServicio;
import com.proyectoegg.rigoletto.repositorios.ProductoRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicios {
    
    @Autowired
    ProductoRepositorio productorepositorio;
    
    @Transactional
    public void crearProducto(String nombre, Double precio, String tipoProducto, String foto) throws ErrorServicio {
        
        validar(nombre, precio, tipoProducto);
        
        Producto producto = new Producto();
        
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setTipoProducto(tipoProducto);
        producto.setFoto(foto);
        productorepositorio.save(producto);
    }
    
    @Transactional
    public void modificarProducto(String idProducto, String nombre, Double precio, String tipoProducto) throws ErrorServicio {
        validar(nombre, precio, tipoProducto);
        Optional<Producto> respuesta = productorepositorio.findById(idProducto);
        if (respuesta.isPresent()) {
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setFoto(nombre);
            producto.setTipoProducto(tipoProducto);
            
            productorepositorio.save(producto);
            
        } else {
            throw new ErrorServicio("No se a encontrado el producto solicitado.");
            
        }
        
    }
    
    public void validar(String nombre, Double precio, String tipoProducto) throws ErrorServicio {
        
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del producto no puede ser nulo.");
        }
        
        if (precio == null) {
            throw new ErrorServicio("El precio no puede ser nulo.");
        }
        
        if (tipoProducto == null || tipoProducto.isEmpty()) {
            throw new ErrorServicio("El tipo de producto no puede ser nulo.");
        }
    }
    
    public void borrarProducto() {
    /*Esto va en el paquete de Servicios*/
    }

    public void listarProducto() {
    /*Esto va en el paquete de Servicios*/
    }

}
