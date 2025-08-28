package com.itsqmet.proyecto_bd2.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    private String nombre;

    private double precio;

    private int cantidad;

    private double iva;

    private String imgUrl;

    // Relación ManyToOne con Categoria
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    // Relación ManyToOne con Proveedor
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

}
