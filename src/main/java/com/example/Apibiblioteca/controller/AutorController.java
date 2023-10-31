package com.example.Apibiblioteca.controller;

import com.example.Apibiblioteca.dto.AutorDto;
import com.example.Apibiblioteca.service.Autorservicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autor")
public class AutorController {
    private final Autorservicio AutorImpl;

    @GetMapping("/consultaAutor")
    public ResponseEntity<List<AutorDto>> consultaAutor() {

        List<AutorDto> lista = AutorImpl.consultaAutor();


        return new ResponseEntity<>(lista, HttpStatus.OK);

    }

    @PostMapping("/crearAutor")
    public ResponseEntity<String> crearAutor(@RequestBody AutorDto autorDto) {
        String resultado = AutorImpl.crearAutor(autorDto);
        if (resultado != null) {
            return new ResponseEntity<>(resultado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al crear el autor.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAutor")
    public ResponseEntity<AutorDto> findAutor(@RequestParam String nombre) {
        AutorDto autor = AutorImpl.findAutor(nombre);
        if (autor != null) {
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modificarAutor/{id}")
    public ResponseEntity<String> modificarAutor(@PathVariable Long id, @RequestBody AutorDto autorDto) {
        String resultado = AutorImpl.modificarAutor(id, autorDto);
        if (resultado != null) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al modificar el autor.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/bajaAutor/{id}")
    public ResponseEntity<String> bajaAutor(@PathVariable Long id) {
        String resultado = AutorImpl.bajaAutor(id);
        if (resultado != null) {
            return new ResponseEntity<>(resultado, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Error al dar de baja el autor.", HttpStatus.BAD_REQUEST);
        }
    }
}


