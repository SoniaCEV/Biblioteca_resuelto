package com.cev.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cev.biblioteca.entities.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String>{
	public List<Libro> findByPaginasGreaterThan(int n);
	public List<Libro> findByAutor_nif(String nif);
}
