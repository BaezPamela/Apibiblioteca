package com.example.Apibiblioteca.repository;

import com.example.Apibiblioteca.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {
    Editorial findByNombre(String nombre);
}
