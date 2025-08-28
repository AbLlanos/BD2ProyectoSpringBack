package com.itsqmet.proyecto_bd2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VentaDetalle {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_detalle;

        private int cantidad;
        private double precio_unitario;
        private double subtotal;

        @ManyToOne
        @JoinColumn(name = "id_venta")
        private Venta venta;

        @ManyToOne
        @JoinColumn(name = "id_producto")
        private Producto producto;



}
