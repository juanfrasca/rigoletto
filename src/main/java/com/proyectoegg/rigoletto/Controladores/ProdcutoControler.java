package com.proyectoegg.rigoletto.Controladores;

import com.proyectoegg.rigoletto.entidades.Producto;
import com.proyectoegg.rigoletto.errores.ErrorServicio;
import com.proyectoegg.rigoletto.repositorios.ProductoRepositorio;
import com.proyectoegg.rigoletto.servicios.ProductoServicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/rigoletto/administrador")
public class ProdcutoControler {
    
    @Autowired
    private ProductoServicios productoServicio;
    
    @Autowired
    private ProductoRepositorio productoRepositorio;
    
   @PostMapping("/cargar")
   public String cargarProducto(@RequestParam String producto, @RequestParam Double precio ) throws ErrorServicio{
       productoServicio.crearProducto(producto, precio);
       return "redirect:/";
       
   }
   
   @GetMapping("/mostrarlista")
   public String mostrarLista(ModelMap modelo){
       List<Producto> producto;
       producto = productoRepositorio.findAll();
       
       modelo.put("producto",producto);
       
       return "listadoproducto.html";
   }

    
    
}
