package com.cibertec.cl2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idGenero;

    public String nombre;

    // Getters and setters
}