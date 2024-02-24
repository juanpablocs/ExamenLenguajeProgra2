package com.cibertec.cl2.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.cl2.model.Genero;
import com.cibertec.cl2.model.Pelicula;
import com.cibertec.cl2.service.GeneroService;
import com.cibertec.cl2.service.PeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

	@Autowired
	private PeliculaService peliService;
	@Autowired
	private GeneroService generoService;
	
	private static final List<String> NOMBRES_GENEROS = Arrays.asList("Acción", "Comedia", "Drama", "Fantasía", "Terror");

	@GetMapping("")
	public String getAll(Model model ) {
		
		List<Pelicula> listPelis = peliService.getAll();
		
		model.addAttribute("peliculas", listPelis);
		
		inicializarGeneros();
		
		return "peliculaList";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		List<Genero> listGeneros = generoService.getAll();
		
		model.addAttribute("generos", listGeneros);
		return "peliculaRegister";
	}
	
	@PostMapping("/register")
	public String create(
			@RequestParam("name") String name, 
			@RequestParam("director") String director,
			@RequestParam("genero") Long genero,
			Model model
	){
		
		Pelicula p = new Pelicula();
		p.nombre = name;
		p.director = director;
		p.genero = generoService.getById(genero);
		peliService.create(p);
		
		return "redirect:/peliculas";
	}
	
	
	@GetMapping("/edit/{id}")
	public String getByID(@PathVariable Long id, Model model) {
		Pelicula p = peliService.getById(id);
		
		model.addAttribute("pelicula", p);
		List<Genero> listGeneros = generoService.getAll();
		
		model.addAttribute("generos", listGeneros);
		return "peliculaEdit";
	}
	
	@PostMapping("/edit")
	public String edit(
			@RequestParam("id") Long id, 
			@RequestParam("name") String name, 
			@RequestParam("director") String director, 
			@RequestParam("genero") Long genero, 
			Model model
	) {
		
		Pelicula p = peliService.getById(id);
		p.nombre = name;
		p.director = director;
		p.genero = generoService.getById(genero);
		
		peliService.create(p);

		return "redirect:/peliculas";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		peliService.delete(id);
		return "redirect:/peliculas";
	}
	
	private void inicializarGeneros() {
	    NOMBRES_GENEROS.forEach(nombreGenero -> {
	        generoService.agregarSiNoExiste(nombreGenero);
	    });
	}
}
