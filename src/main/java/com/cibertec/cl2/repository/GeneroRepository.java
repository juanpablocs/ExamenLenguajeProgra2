package com.cibertec.cl2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.cl2.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {

	Genero findByNombre(String nombre);
	
}