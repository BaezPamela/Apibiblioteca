package com.example.Apibiblioteca.service;

import com.example.Apibiblioteca.dto.AutorDto;

import org.springframework.stereotype.Service;

import java.util.List;


public interface Autorservicio {

    List<AutorDto> consultaAutor();
    String crearAutor(AutorDto autorDto);
    AutorDto findAutor(String nombre);
    String modificarAutor(Long id, AutorDto autorDto);
    String bajaAutor(Long id);


}
