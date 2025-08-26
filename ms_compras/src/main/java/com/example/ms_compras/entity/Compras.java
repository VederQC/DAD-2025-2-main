package com.example.ms_compras.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "compras")
@Data
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreProducto;
    private String descripcion;

    // No es necesario escribir getters, setters ni constructor
}
