package com.itsqmet.proyecto_bd2.services;

import com.itsqmet.proyecto_bd2.entity.Categoria;
import com.itsqmet.proyecto_bd2.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todos
    public List<Categoria> mostrarCategoria() {
        return categoriaRepository.findAll();
    }

    // Buscar
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    // Guardar
    public Categoria guardarCategoria(Categoria producto) {
        return categoriaRepository.save(producto);
    }

    // Eliminar
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }


}
