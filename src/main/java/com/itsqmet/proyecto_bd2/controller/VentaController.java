package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.entity.Venta;
import com.itsqmet.proyecto_bd2.services.VentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venta")
@CrossOrigin(origins = "http://localhost:4200")
public class VentaController {

    @Autowired
    private VentaServices ventaService;

    // Leer todos
    @GetMapping
    public List<Venta> leer() {
        return ventaService.mostrarVentas();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Optional<Venta> buscarPorId(@PathVariable String id) {
        return ventaService.buscarPorId(id);
    }

    // Guardar
    @PostMapping("/guardar")
    public Venta guardar(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }

    // Eliminar
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable String id) {
        ventaService.eliminarVenta(id);
    }

    // Actualizar
    @PutMapping("/actualizar/{id}")
    public Venta actualizar(@PathVariable String id, @RequestBody Venta venta) {
        Optional<Venta> ventaOptional = ventaService.buscarPorId(id);
        if (ventaOptional.isPresent()) {
            Venta ventaExistente = ventaOptional.get();

            ventaExistente.setFecha(venta.getFecha());
            ventaExistente.setTotal(venta.getTotal());
            ventaExistente.setIva_total(venta.getIva_total());
            ventaExistente.setEstado(venta.getEstado());

            return ventaService.guardarVenta(ventaExistente);
        }
        return null;
    }
}
