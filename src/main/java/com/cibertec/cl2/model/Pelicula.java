package com.cibertec.cl2.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idPelicula;

    public String nombre;

    public String director;

    public Date fechaEstreno;

    @ManyToOne
    @JoinColumn(name = "idgenero")
    public Genero genero;

    // Getters and setters
}