package com.keycode.gestion.service.impl;

import com.keycode.gestion.jpa.entity.Productos;
import com.keycode.gestion.jpa.repository.ProductosRepository;
import com.keycode.gestion.service.IProductosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService implements IProductosService {
    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Productos crearProducto(Productos productos){return productosRepository.save(productos);}
    @Override
    public List<Productos> obtenerProductos(){return productosRepository.findAll();}
    @Override
    public Productos obtenerProductoById(Long id){return productosRepository.findById(id).get();}
    @Override
    public Productos actualizarProducto(Productos producto){return productosRepository.save(producto);}
    @Override
    public Productos eliminarProducto(Long id){
        Productos producto = productosRepository
                .findById(id)
                .orElseThrow();
        productosRepository.delete(producto);
        return producto;
    }
}
