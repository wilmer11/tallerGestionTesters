package com.keycode.gestion.controller;

import com.keycode.gestion.jpa.entity.Productos;
import com.keycode.gestion.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private IProductosService productosService;

    @GetMapping()
    public List<Productos> llamarProductos(){
        return productosService.obtenerProductos();
    }

    @GetMapping("/{id}")
    public Productos llamarProductoById(@PathVariable Long id) {
        return productosService.obtenerProductoById(id);
    }

    @PostMapping("/new")
    public String crearProducto(@RequestBody Productos producto) {
        productosService.crearProducto(producto);
        return "Enviado";
    }

    @PutMapping("/update/{id}")
    public String actualizarProducto(@PathVariable Long id, @RequestBody Productos producto){
        Productos editarProducto = productosService.obtenerProductoById(id);
        editarProducto.setNombre(producto.getNombre());
        editarProducto.setPrecio(producto.getPrecio());
        productosService.actualizarProducto(editarProducto);
        return "Producto editado";
    }

    @DeleteMapping("/delete/{id}")
    public String eliminarProducto(@PathVariable Long id){
        productosService.eliminarProducto(id);
        return "Producto eliminado";
    }
}
