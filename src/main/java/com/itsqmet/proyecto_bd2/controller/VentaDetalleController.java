package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.entity.VentaDetalle;
import com.itsqmet.proyecto_bd2.services.VentaDetalleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venta-detalle")
@CrossOrigin(origins = "http://localhost:4200")
public class VentaDetalleController {

    @Autowired
    private VentaDetalleServices ventaDetalleService;

    // Leer todos
    @GetMapping
    public List<VentaDetalle> leer() {
        return ventaDetalleService.mostrarDetalles();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Optional<VentaDetalle> buscarPorId(@PathVariable String id) {
        return ventaDetalleService.buscarPorId(id);
    }

    // Guardar
    @PostMapping("/guardar")
    public VentaDetalle guardar(@RequestBody VentaDetalle detalle) {
        return ventaDetalleService.guardarDetalle(detalle);
    }

    // Eliminar
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable String id) {
        ventaDetalleService.eliminarDetalle(id);
    }

    // Actualizar
    @PutMapping("/actualizar/{id}")
    public VentaDetalle actualizar(@PathVariable String id, @RequestBody VentaDetalle detalle) {
        Optional<VentaDetalle> detalleOptional = ventaDetalleService.buscarPorId(id);
        if (detalleOptional.isPresent()) {
            VentaDetalle detalleExistente = detalleOptional.get();

            detalleExistente.setCantidad(detalle.getCantidad());
            detalleExistente.setPrecio_unitario(detalle.getPrecio_unitario());
            detalleExistente.setSubtotal(detalle.getSubtotal());
            detalleExistente.setVenta(detalle.getVenta());
            detalleExistente.setProducto(detalle.getProducto());

            return ventaDetalleService.guardarDetalle(detalleExistente);
        }
        return null;
    }
}
