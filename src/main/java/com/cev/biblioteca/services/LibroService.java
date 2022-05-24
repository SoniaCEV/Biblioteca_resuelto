package com.cev.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cev.biblioteca.entities.Libro;
import com.cev.biblioteca.repositories.LibroRepository;

@Service
public class LibroService {
	@Autowired
	private LibroRepository libroRepository;

	public List<Libro> getLibros(){
		return libroRepository.findAll();
	}
	
	public void postLibro(Libro libro) {
		libroRepository.save(libro);
	}
	
	public Optional<Libro> getLibro(String isbn) {
		return libroRepository.findById(isbn);
	}
	
	public List<Libro> getLibrosAutor(String nif){
		return libroRepository.findByAutor_nif(nif);
	}
	
	public List<Libro> getLibrosPaginas (int n){
		return libroRepository.findByPaginasGreaterThan(n);
	}
}
