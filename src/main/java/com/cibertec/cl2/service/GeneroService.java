package com.cibertec.cl2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.cl2.model.Genero;
import com.cibertec.cl2.repository.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository generoRepository;
	
	public List<Genero> getAll() {
		return generoRepository.findAll();
	}
	
	public Genero create(Genero peli) {
		return generoRepository.save(peli);
	}
	
	public void delete(Long id) {
		generoRepository.deleteById(id);
	}
	
	public Genero getById(Long id) {
		return generoRepository.findById(id).orElse(null);
	}
	
	public Genero agregarSiNoExiste(String nombreGenero) {
        Genero genero = generoRepository.findByNombre(nombreGenero);
        if (genero == null) {
            genero = new Genero();
            genero.nombre = nombreGenero;
            generoRepository.save(genero);
        }
        return genero;
    }
}
