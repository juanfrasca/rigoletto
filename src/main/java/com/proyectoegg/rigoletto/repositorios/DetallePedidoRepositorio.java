package com.proyectoegg.rigoletto.repositorios;

import com.proyectoegg.rigoletto.entidades.DetallePedido;
import com.proyectoegg.rigoletto.entidades.Producto;
import com.proyectoegg.rigoletto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, String> {

    //@Query("SELECT c FROM Producto c WHERE c.nombre = :nombre")
    //public Producto buscarProductoPorNombre(@Param("nombre") String nombre);

    //@Query("SELECT c FROM Producto c WHERE c.precio = :precio")
    //public Producto buscarProductoPorPrecio(@Param("precio") String precio);

    //@Query("SELECT c FROM Usuario c WHERE c.nombre = :nombre")
    //public Usuario buscarPorNombre(@Param("nombre") String nombreusuario);

    //@Query("SELECT c FROM Usuario c WHERE c.direccion = :direccion")
    //public Usuario buscarPorDireccion(@Param("direccion") String direccion);

    //@Query("SELECT c FROM Usuario c WHERE c.telefono = :telefono")
    //public Usuario buscarPorTelefono(@Param("telefono") String telefono);
}
