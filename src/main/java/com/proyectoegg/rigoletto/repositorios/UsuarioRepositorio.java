package com.proyectoegg.rigoletto.repositorios;

//import com.proyectoegg.rigoletto.entidades.DetallePedido;
import com.proyectoegg.rigoletto.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
    //aca podriamos validar el pedido se me ocurre el nombre ordenado por apellido  
    //con el detalle del pedido donde se unen las dos tablas y con el id del usuario 
    @Query("SELECT c FROM Usuario c WHERE c.nombre LIKE %:q% OR c.apellido LIKE %:q%")
    public List<Usuario> buscarUsuario(@Param("q") String q);
    
    //Juan aca va el buscar por mail y buscar por clave para poder validar el usuario
    @Query("SELECT c FROM Usuario c WHERE c.email = :email")
    public Usuario buscarPorMail(@Param("email") String email);
    
    @Query("SELECT c FROM Usuario c WHERE c.clave = :clave")
    public Usuario buscarPorClave(@Param("clave") String clave);
   
    //@Query("SELECT c FROM DetallePedido c WHERE c.id LIKE %"+":producto"+"%"+":cantidad")
    //public List<DetallePedido> buscarDetalleProducto(@Param("producto,cantidad")String producto,String cantidad);

}
