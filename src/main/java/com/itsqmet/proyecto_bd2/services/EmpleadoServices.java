package com.itsqmet.proyecto_bd2.services;

import com.itsqmet.proyecto_bd2.entity.Empleado;
import com.itsqmet.proyecto_bd2.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServices {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Obtener todos
    public List<Empleado> mostrarEmpleados() {
        return empleadoRepository.findAll();
    }

    // Buscar por ID
    public Optional<Empleado> buscarPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    // Guardar
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    // Eliminar
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

}
