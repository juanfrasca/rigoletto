
package com.proyectoegg.rigoletto.repositorios;

import com.proyectoegg.rigoletto.entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String> {

    @Query("SELECT c FROM Producto c WHERE c.nombre = :nombre")
    public Producto buscarProductoPorNombre(@Param("nombre") String nombre);
    
    @Query("SELECT c FROM Producto c WHERE c.precio = :precio")
    public Producto buscarProductoPorPrecio (@Param("precio") String precio);
    
    @Query("SELECT c FROM Producto c WHERE c.tipo_producto = :tipoProducto")
    public Producto buscarProductoTipoProducto (@Param("tipoProducto") String tipoProducto);
    
}
