package com.example.Apibiblioteca.service;

import com.example.Apibiblioteca.dto.AutorDto;
import com.example.Apibiblioteca.mapper.MapperAutor;
import com.example.Apibiblioteca.model.Autor;
import com.example.Apibiblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutorImpl implements Autorservicio{
    private final AutorRepository autorRepository;

    @Override
    public  List<AutorDto> consultaAutor() {
        List<AutorDto>listaAutor= autorRepository.findAll().stream()
                .map(MapperAutor::toDto)//mapea el objeto Autor al Dto
                .collect(Collectors.toList());//colecta los datos en una lista
        return listaAutor;
    }


    @Override
    public String crearAutor(AutorDto autorDto) {
        Autor autorEntity= MapperAutor.toEntity(autorDto);
        autorRepository.save(autorEntity);

        return "el Autor fue guardado con exito";
    }

    @Override
    public AutorDto findAutor(String nombre) {
        Autor autorEntity=  autorRepository.findBynombre(nombre);
        AutorDto autorDto= MapperAutor.toDto(autorEntity);

        return autorDto;
    }


    @Override
    public String modificarAutor(Long id, AutorDto autorDto) {
        Autor autor = autorRepository.findById(id).orElseThrow();

        autor.setNombre(autorDto.getNombre());
        autor.setAlta(autorDto.getAlta());

        autorRepository.save(autor);

        return "El autor fue modificado con exito";
    }

    @Override
    public String bajaAutor(Long id) {
        autorRepository.deleteById(id);

        return "El autor fue eliminado con exito";

    }
}
