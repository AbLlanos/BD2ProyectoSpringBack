package com.itsqmet.proyecto_bd2.services;

import com.itsqmet.proyecto_bd2.entity.Proveedor;
import com.itsqmet.proyecto_bd2.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServices {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos
    public List<Proveedor> mostrarProveedor() {
        return proveedorRepository.findAll();
    }

    // Buscar
    public Optional<Proveedor> buscarPorId(Long id) {
        return proveedorRepository.findById(id);
    }

    // Guardar
    public Proveedor guardarProveedor(Proveedor producto) {
        return proveedorRepository.save(producto);
    }

    // Eliminar
    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }

}
