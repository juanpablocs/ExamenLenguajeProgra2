package com.cibertec.cl2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.cl2.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}