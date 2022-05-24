package com.cev.biblioteca.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cev.biblioteca.entities.Autor;
import com.cev.biblioteca.entities.Libro;
import com.cev.biblioteca.exceptions.NotFoundException;
import com.cev.biblioteca.services.AutorService;
import com.cev.biblioteca.services.LibroService;

@RestController
public class LibroController {
	@Autowired
	private LibroService libroService;
	
	//Lista de todos los libros:
	@GetMapping(path = "/libros")
	public List<Libro> getLibros(){
		return libroService.getLibros();
	}
	
	//Alta de un nuevo libro:
	@PostMapping(path = "/libros")
	public void postLibro(@RequestBody Libro libro) {
		libroService.postLibro(libro);
	}
	
	//Libro con un ISBN concreto:
	
	@GetMapping(path = "/libros/{isbn}")
	public Libro getLibro(@PathVariable(name="isbn") String isbn){
		Optional<Libro> result = libroService.getLibro(isbn);
		if(result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundException();
		}
	}
	
	
	//Lista de libros de un autor concreto:
	
	@GetMapping(path = "/libros/autor/{nif}")
	public List<Libro> getLibrosAutor(@PathVariable(name="nif") String nif){
		List<Libro> result = libroService.getLibrosAutor(nif);
		if(result.size()>0) {
			return result;
		} else {
			throw new NotFoundException();
		}
	}
	
	
	//Lista de libros con más de n páginas:
	
	@GetMapping(path = "/libros/paginas/{n}")
	public List<Libro> getLibrosPaginas(@PathVariable(name="n") int n){
		List<Libro> result = libroService.getLibrosPaginas(n);
		if(result.size()>0) {
			return result;
		} else {
			throw new NotFoundException();
		}
	}
	
	
	
}
