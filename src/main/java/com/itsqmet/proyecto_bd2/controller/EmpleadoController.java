package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.entity.Empleado;
import com.itsqmet.proyecto_bd2.services.EmpleadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {

    @Autowired
    private EmpleadoServices empleadoService;

    // Leer todos
    @GetMapping
    public List<Empleado> leer() {
        return empleadoService.mostrarEmpleados();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Optional<Empleado> buscarPorId(@PathVariable String id) {
        return empleadoService.buscarPorId(id);
    }

    // Guardar
    @PostMapping("/guardar")
    public Empleado guardar(@RequestBody Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
    }

    // Eliminar
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable String id) {
        empleadoService.eliminarEmpleado(id);
    }

    // Actualizar
    @PutMapping("/actualizar/{id}")
    public Empleado actualizar(@PathVariable String id, @RequestBody Empleado empleado) {
        Optional<Empleado> empleadoOptional = empleadoService.buscarPorId(id);
        if (empleadoOptional.isPresent()) {
            Empleado empleadoExistente = empleadoOptional.get();

            empleadoExistente.setNombre(empleado.getNombre());
            empleadoExistente.setApellido(empleado.getApellido());
            empleadoExistente.setCargo(empleado.getCargo());
            empleadoExistente.setSalario(empleado.getSalario());
            empleadoExistente.setEmail(empleado.getEmail());
            empleadoExistente.setTelefono(empleado.getTelefono());
            empleadoExistente.setPassword(empleado.getPassword());
            empleadoExistente.setRol(empleado.getRol());

            return empleadoService.guardarEmpleado(empleadoExistente);
        }
        return null;
    }
}
