package com.itsqmet.proyecto_bd2.controller;


import com.itsqmet.proyecto_bd2.entity.Producto;
import com.itsqmet.proyecto_bd2.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductoController {

    @Autowired
    private ProductoServices productoServicio;

    // Leer todos los productos
    @GetMapping
    public List<Producto> leer() {
        return productoServicio.mostrarProductos();
    }

    // Buscar producto por ID
    @GetMapping("/{id}")
    public Optional<Producto> buscarPorId(@PathVariable String id) {
        return productoServicio.buscarPorId(id);
    }

    // Guardar producto
    @PostMapping("/guardar")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoServicio.guardarProducto(producto);
    }


    // Eliminar producto
    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable String id) {
        productoServicio.eliminarProducto(id);
    }

    //Actualizar Producto

    @PutMapping("/actualizar/{id}")
    public Producto actualizarProducto(@PathVariable String id, @RequestBody Producto producto){
        Optional<Producto> productoOptional = productoServicio.buscarPorId(id);
        if (productoOptional.isPresent()){

            Producto productoExistente=productoOptional.get();

            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setCantidad(producto.getCantidad());
            productoExistente.setIva(producto.getIva());
            productoExistente.setProveedor(producto.getProveedor());
            productoExistente.setCategoria(producto.getCategoria());

            return productoServicio.guardarProducto(productoExistente);

        }
        return null;
    }

}