package com.cev.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cev.biblioteca.entities.Autor;
import com.cev.biblioteca.entities.Libro;
import com.cev.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;

	public List<Autor> getAutores(){
		return autorRepository.findAll();
	}
	
	public void postAutor(Autor autor) {
		autorRepository.save(autor);
	}
	
	public Optional<Autor> getAutor(String nif) {
		return autorRepository.findById(nif);
	}
	
	public List<Autor> getAutoresByEdad(int edad){
		return autorRepository.findByEdad(edad);
	}
}
