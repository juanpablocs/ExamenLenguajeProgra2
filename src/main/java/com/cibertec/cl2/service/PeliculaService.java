package com.cibertec.cl2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.cl2.model.Pelicula;
import com.cibertec.cl2.repository.PeliculaRepository;

@Service
public class PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepository;
	
	public List<Pelicula> getAll() {
		return peliculaRepository.findAll();
	}
	
	public Pelicula create(Pelicula peli) {
		return peliculaRepository.save(peli);
	}
	
	public void delete(Long id) {
		peliculaRepository.deleteById(id);
	}
	
	public Pelicula getById(Long id) {
		return peliculaRepository.findById(id).orElse(null);
	}
}
