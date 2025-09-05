package com.itsqmet.proyecto_bd2.controller;


import com.itsqmet.proyecto_bd2.entity.Categoria;
import com.itsqmet.proyecto_bd2.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "http://localhost:4200")

public class CategoriaController {

    @Autowired
    private CategoriaServices categoriaServices;

    // Leer
    @GetMapping
    public List<Categoria> leer() {
        return categoriaServices.mostrarCategoria();
    }

    // Buscar
    @GetMapping("/{id}")
    public Optional<Categoria> buscarPorId(@PathVariable String id) {
        return categoriaServices.buscarPorId(id);
    }

    // Guardar
    @PostMapping("/guardar")
    public Categoria guardarCategoria(@RequestBody Categoria categoria) {
        return categoriaServices.guardarCategoria(categoria);
    }


    // Eliminar
    @DeleteMapping("/eliminar/{id}")
    public void eliminarCategoria(@PathVariable String id) {
        categoriaServices.eliminarCategoria(id);
    }

    //Actualizar

    @PutMapping("/actualizar/{id}")
    public Categoria actualizarCategoria(@PathVariable String id, @RequestBody Categoria categoria){
        Optional<Categoria> categoriaOptional = categoriaServices.buscarPorId(id);
        if (categoriaOptional.isPresent()) {
            Categoria categoriaExistente = categoriaOptional.get();

            categoriaExistente.setNombre(categoria.getNombre());
            categoriaExistente.setDescripcion(categoria.getDescripcion());

            return categoriaServices.guardarCategoria(categoriaExistente);
        }
        return null;
    }

}
