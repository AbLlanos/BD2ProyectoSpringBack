package com.itsqmet.proyecto_bd2.services;

import com.itsqmet.proyecto_bd2.entity.Venta;
import com.itsqmet.proyecto_bd2.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServices {

    @Autowired
    private VentaRepository ventaRepository;

    // Obtener todos
    public List<Venta> mostrarVentas() {
        return ventaRepository.findAll();
    }

    // Buscar por ID
    public Optional<Venta> buscarPorId(Long id) {
        return ventaRepository.findById(id);
    }

    // Guardar
    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Eliminar
    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }

}
