package com.keycode.gestion.service;

import com.keycode.gestion.jpa.entity.Productos;
import com.keycode.gestion.jpa.repository.ProductosRepository;
import com.keycode.gestion.service.impl.ProductosService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import javax.xml.transform.Result;

@ExtendWith(MockitoExtension.class)
public class ProductosServiceTest {
    @Mock
    private ProductosRepository productosRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private ProductosService productosService;

    @Test
    void crearProducto() {
        Productos productos1 = new Productos();
        Mockito.when(productosRepository.save(Mockito.any()))
                .thenReturn(productos1);
        Productos result = productosService.crearProducto(Mockito.any());
        Assertions.assertNotNull(result);
        Mockito.verify(productosRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void eliminarProducto(Long id){
        Mockito.doNothing().when(productosRepository).deleteById(Mockito.anyLong());
        Productos result = productosService.eliminarProducto(id);
        Assertions.assertNotNull(result);
        Mockito.verify(productosRepository, Mockito.times(1)).deleteById(Mockito.anyLong());
    }
}
