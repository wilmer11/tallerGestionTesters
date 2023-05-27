package com.keycode.gestion.controller;

import com.keycode.gestion.jpa.entity.Productos;
import com.keycode.gestion.service.impl.ProductosService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductosControllerTest {
    @Mock
    private ProductosService productosService;

    @InjectMocks
    private ProductosController productosController;

    @Test
    void obtenerProductosSuccess(){
        Mockito.when(productosService.obtenerProductos())
                .thenReturn(new ArrayList<>());
        List<Productos> result = productosController.llamarProductos();
        Assert.notNull(result, "Empty list");
        Mockito.verify(productosService, Mockito.times(1))
                .obtenerProductos();
    }

    @Test
    void obtenerProductoByIdSuccess(){
        Mockito.when(productosService.obtenerProductoById(Mockito.anyLong()))
                .thenReturn(new Productos());
        Productos result = productosController.llamarProductoById(Mockito.anyLong());
        Assert.notNull(result, "Empty product");
        Mockito.verify(productosService, Mockito.times(1))
                .obtenerProductoById(Mockito.anyLong());
    }

    @Test
    void crearProductoSuccess(){
        Mockito.when(productosService.crearProducto(Mockito.any()))
                .thenReturn(new Productos());
        String result = productosController.crearProducto(Mockito.any());
        Assert.notNull(result, "No create");
        Mockito.verify(productosService, Mockito.times(1))
                .crearProducto(Mockito.any());
    }

    @Test
    void eliminarProductoSuccess() {
         Mockito.doNothing().when(productosService).eliminarProducto(Mockito.anyLong());
         String result = productosController.eliminarProducto(Mockito.anyLong());
         Assert.notNull(result, "No delete");
         Mockito.verify(productosService, Mockito.times(1))
                 .eliminarProducto(Mockito.anyLong());
    }

    @Test
    void actualizarProductoSuccess(Long id){
        Mockito.when(productosService.actualizarProducto(Mockito.any()))
                .thenReturn(new Productos());
        String result = productosController.actualizarProducto(id, Mockito.any());
        Assert.notNull(result, "No update");
        Mockito.verify(productosService, Mockito.times(1))
                .actualizarProducto(Mockito.any());
    }
}
