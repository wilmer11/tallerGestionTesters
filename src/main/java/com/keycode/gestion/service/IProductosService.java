package com.keycode.gestion.service;

import com.keycode.gestion.jpa.entity.Productos;
import java.util.List;

public interface IProductosService {
    Productos crearProducto(Productos productos);
    List<Productos> obtenerProductos();
    Productos obtenerProductoById(Long id);
    Productos actualizarProducto(Productos productos);
    Productos eliminarProducto(Long id);
}
