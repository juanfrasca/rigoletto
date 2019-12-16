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
    public void crearProducto(String nombre, Double precio) throws ErrorServicio {

        validar(nombre, precio);

        Producto producto = new Producto();

        producto.setNombre(nombre);
        producto.setPrecio(precio);
        productorepositorio.save(producto);
    }

    @Transactional
    public void modificarProducto(String idProducto, String nombre, Double precio) throws ErrorServicio {
        validar(nombre, precio);
        Optional<Producto> respuesta = productorepositorio.findById(idProducto);
        if (respuesta.isPresent()) {
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);

            productorepositorio.save(producto);

        } else {
            throw new ErrorServicio("No se a encontrado el producto solicitado.");

        }

    }

    public void validar(String nombre, Double precio) throws ErrorServicio {

        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del producto no puede ser nulo.");
        }

        if (precio == null) {
            throw new ErrorServicio("El precio no puede ser nulo.");

        }
    }
}
