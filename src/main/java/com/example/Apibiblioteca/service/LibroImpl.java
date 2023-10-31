package com.example.Apibiblioteca.service;

import com.example.Apibiblioteca.dto.LibroDto;
import com.example.Apibiblioteca.mapper.MapperLibro;
import com.example.Apibiblioteca.model.Libro;
import com.example.Apibiblioteca.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibroImpl implements Libroservicio{
    private final  LibroRepository libroRepository;//INYECCION DE REPOSITORIOS

    @Override
    public List<LibroDto> consultaLibros() {
        List<LibroDto>listaLibros= libroRepository.findAll().stream()
                                  .map(MapperLibro::toDto)//mapea el objeto libro al Dto
                                  .collect(Collectors.toList());//colecta los datos en una lista
        return listaLibros;
    }

    @Override
    public String crearLibro(LibroDto librodto) {
        Libro libroEntity= MapperLibro.toEntity(librodto);
        libroRepository.save(libroEntity);

         return "el libro fue guardado con exito";

    }

    @Override
    public LibroDto findLibro(String titulo) {
       Libro libroEntity=  libroRepository.findByTitulo(titulo);
       LibroDto libroDto= MapperLibro.toDto(libroEntity);

       return libroDto;

    }

    @Override
    public String modificarLibro(Long id, LibroDto libroDto) {

        Libro libro = libroRepository.findById(id).orElseThrow();

        libro.setTitulo(libroDto.getTitulo());
        libro.setNombreAutor(libroDto.getNombre_Autor());
        libroDto.setEditorial(libro.getEditorial().getNombre()); //libro.setEditorial(libroDto.getEditorial());
        libro.setAlta(libroDto.getAlta());

        libroRepository.save(libro);

        return "El libro fue modificado con exito";


    }

    @Override
    public String bajaLibro(Long id) {
        libroRepository.deleteById(id);

        return "El libro fue eliminado con exito";


    }
}
