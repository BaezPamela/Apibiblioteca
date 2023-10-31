package com.example.Apibiblioteca.service;

import com.example.Apibiblioteca.dto.EditorialDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Editorialservicio {

    List<EditorialDto> consultaEditorial();
    String crearEditorial(EditorialDto editorialDto);
    EditorialDto findEditorial(String nombre);
    String modificarEditorial(Long id, EditorialDto editorialDto);
    String bajaEditorial(Long id);


}
