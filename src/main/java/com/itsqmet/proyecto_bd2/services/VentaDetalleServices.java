package com.itsqmet.proyecto_bd2.services;

import com.itsqmet.proyecto_bd2.entity.VentaDetalle;
import com.itsqmet.proyecto_bd2.repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaDetalleServices {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;

    // Obtener todos
    public List<VentaDetalle> mostrarDetalles() {
        return ventaDetalleRepository.findAll();
    }

    // Buscar por ID
    public Optional<VentaDetalle> buscarPorId(Long id) {
        return ventaDetalleRepository.findById(id);
    }

    // Guardar
    public VentaDetalle guardarDetalle(VentaDetalle detalle) {
        return ventaDetalleRepository.save(detalle);
    }

    // Eliminar
    public void eliminarDetalle(Long id) {
        ventaDetalleRepository.deleteById(id);
    }

}
