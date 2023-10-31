package com.example.Apibiblioteca.repository;

import com.example.Apibiblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findBynombre(String nombre);
}
