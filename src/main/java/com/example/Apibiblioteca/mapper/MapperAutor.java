package com.example.Apibiblioteca.mapper;

import com.example.Apibiblioteca.dto.AutorDto;
import com.example.Apibiblioteca.model.Autor;


public class MapperAutor {
    public static AutorDto toDto(Autor autor) {
        AutorDto autorDto = new AutorDto();
        autorDto.setNombre(autor.getNombre());
        autorDto.setAlta(autor.getAlta());

        return autorDto;
    }

    //convierto un Dto en una entidad libro
    public static Autor toEntity(AutorDto autorDto) {
        Autor autor = new Autor();
        autor.setNombre(autorDto.getNombre());
        autor.setAlta(autor.getAlta());
        return autor;
    }
}

