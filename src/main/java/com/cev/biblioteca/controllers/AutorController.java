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

@RestController
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	
	//Listado con todos los autores:
	@GetMapping(path = "/autores")
	public List<Autor> getAutores(){
		return autorService.getAutores();
	}
	
	//Alta de un nuevo autor:
	@PostMapping(path = "/autores")
	public void postAutor(@RequestBody Autor autor) {
		autorService.postAutor(autor);
	}
	
	//Autor con un NIF concreto:
	@GetMapping(path = "/autores/{nif}")
	public Autor getAutores(@PathVariable(name="nif") String nif){
		Optional<Autor> result = autorService.getAutor(nif);
		if(result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundException();
		}
	}
	
	//Lista de autores con n años:
	
	@GetMapping(path="/autores/edad/{n}")
	public List<Autor> getAutoresByEdadGreaterThan(@PathVariable(name="n") int n){
		
		List<Autor> result = autorService.getAutoresByEdad(n);
		if(result.size()>0) {
			return result;
		} else {
			throw new NotFoundException();
		}
	}
	
}
