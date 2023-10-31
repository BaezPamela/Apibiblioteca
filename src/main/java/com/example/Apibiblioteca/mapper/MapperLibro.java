package com.example.Apibiblioteca.mapper;

import com.example.Apibiblioteca.dto.LibroDto;
import com.example.Apibiblioteca.model.Libro;

public class MapperLibro {
    //convierto la entidad Libro en Dto
    public static LibroDto toDto(Libro libro) {
        LibroDto libroDto = new LibroDto();
        libroDto.setTitulo(libro.getTitulo());
        libroDto.setNombre_Autor(libro.getAutor().getNombre());
        libroDto.setEditorial(libro.getEditorial().getNombre());
        libroDto.setAlta(libro.getAlta());

        return libroDto;
    }

    //convierto un Dto en una entidad libro
    public static Libro toEntity(LibroDto libroDto) {
        Libro libro = new Libro();
        libro.setTitulo(libroDto.getTitulo());
        libro.setAutor(libro.getAutor());
        libro.setEditorial(libro.getEditorial());
        libro.setAlta(libro.getAlta());
        return libro;
    }
}