package com.itsqmet.proyecto_bd2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proveedor;

    private String nombre;

    // Relación OneToMany con Producto
    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producto> productos;

}