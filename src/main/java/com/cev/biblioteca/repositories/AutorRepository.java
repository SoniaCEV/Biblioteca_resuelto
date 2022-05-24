package com.cev.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cev.biblioteca.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, String> {
	public List<Autor> findByEdad(int n);
}
