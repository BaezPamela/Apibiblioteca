package com.example.Apibiblioteca.mapper;

import com.example.Apibiblioteca.dto.EditorialDto;
import com.example.Apibiblioteca.model.Editorial;

public class MapperEditorial {
    public static EditorialDto toDto(Editorial editorial) {
        EditorialDto editorialDto = new EditorialDto();
        editorialDto.setNombre(editorial.getNombre());
        editorialDto.setAlta(editorial.getAlta());

        return editorialDto;
    }

    //convierto un Dto en una entidad libro
    public static Editorial toEntity(EditorialDto editorialDto) {
        Editorial editorial = new Editorial();
        editorial.setNombre(editorialDto.getNombre());
        editorial.setAlta(editorial.getAlta());
        return editorial;
    }
}


