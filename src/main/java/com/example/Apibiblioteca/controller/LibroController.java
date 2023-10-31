package com.example.Apibiblioteca.controller;

import com.example.Apibiblioteca.dto.LibroDto;
import com.example.Apibiblioteca.service.Libroservicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController {
    private final Libroservicio LibroImpl;

    @GetMapping("/consultaLibros")
    public ResponseEntity<List<LibroDto>>consultaLibros(){

        List<LibroDto> lista= LibroImpl.consultaLibros();


        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/crearLibro")
    public ResponseEntity<String> crearLibro(@RequestBody LibroDto libroDto) {
        String resultado = LibroImpl.crearLibro(libroDto);
        if (resultado != null) {
            return new ResponseEntity<>(resultado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al crear el libro.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findLibro")
    public ResponseEntity<LibroDto> findLibro(@RequestParam String titulo) {
        LibroDto libro = LibroImpl.findLibro(titulo);
        if (libro != null) {
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modificarLibro/{id}")
    public ResponseEntity<String> modificarLibro(@PathVariable Long id, @RequestBody LibroDto libroDto) {
        String resultado = LibroImpl.modificarLibro(id, libroDto);
        if (resultado != null) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al modificar el libro.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/bajaLibro/{id}")
    public ResponseEntity<String> bajaLibro(@PathVariable Long id) {
        String resultado = LibroImpl.bajaLibro(id);
        if (resultado != null) {
            return new ResponseEntity<>(resultado, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Error al dar de baja el libro.", HttpStatus.BAD_REQUEST);
        }
    }
}




