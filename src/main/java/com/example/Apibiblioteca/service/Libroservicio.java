package com.example.Apibiblioteca.service;

import com.example.Apibiblioteca.dto.LibroDto;

import org.springframework.stereotype.Service;

import java.util.List;

public interface Libroservicio {
    List<LibroDto> consultaLibros();
    String crearLibro(LibroDto libroDto);
    LibroDto findLibro(String titulo);
    String modificarLibro(Long id, LibroDto libroDto);
    String bajaLibro(Long id);



}
