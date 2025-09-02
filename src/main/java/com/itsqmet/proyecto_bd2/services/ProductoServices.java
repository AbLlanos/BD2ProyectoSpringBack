package com.itsqmet.proyecto_bd2.services;

import com.itsqmet.proyecto_bd2.entity.Producto;
import com.itsqmet.proyecto_bd2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServices {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> mostrarProductos() {
        return productoRepository.findAll();
    }

    // Buscar producto por ID
    public Optional<Producto> buscarPorId(String id) {
        return productoRepository.findById(id);
    }

    // Guardar producto y devolver el objeto guardado
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Eliminar producto por ID
    public void eliminarProducto(String id) {
        productoRepository.deleteById(id);
    }


}
