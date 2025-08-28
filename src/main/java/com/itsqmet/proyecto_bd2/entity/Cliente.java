package com.itsqmet.proyecto_bd2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private String nombre;
    private String apellido;
    private String cedula;
    private String email;
    private String telefono;
    private String direccion;

    private String usuario;
    private String password;

    // Rol directo
    private String rol;

}
