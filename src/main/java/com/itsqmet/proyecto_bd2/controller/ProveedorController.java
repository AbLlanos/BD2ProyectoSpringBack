package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.entity.Proveedor;
import com.itsqmet.proyecto_bd2.services.ProveedorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedor")
@CrossOrigin(origins = "http://localhost:4200")

public class ProveedorController {

    @Autowired
    private ProveedorServices proveedorServices;

    // Leer
    @GetMapping
    public List<Proveedor> leer() {
        return proveedorServices.mostrarProveedor();
    }

    // Buscar
    @GetMapping("/{id}")
    public Optional<Proveedor> buscarPorId(@PathVariable Long id) {
        return proveedorServices.buscarPorId(id);
    }

    // Guardar
    @PostMapping("/guardar")
    public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
        return proveedorServices.guardarProveedor(proveedor);
    }


    // Eliminar
    @DeleteMapping("/eliminar/{id}")
    public void eliminarProveedor(@PathVariable Long id) {
        proveedorServices.eliminarProveedor(id);
    }

    //Actualizar

    @PutMapping("/actualizar/{id}")
    public Proveedor actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor){
        Optional<Proveedor> proveedorOptional = proveedorServices.buscarPorId(id);
        if (proveedorOptional.isPresent()){

            Proveedor proveedorExistente = proveedorOptional.get();

            proveedorExistente.setNombre(proveedor.getNombre());

            return proveedorServices.guardarProveedor(proveedorExistente);

        }
        return null;
    }

}
