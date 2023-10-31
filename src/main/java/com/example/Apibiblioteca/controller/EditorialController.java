package com.example.Apibiblioteca.controller;

import com.example.Apibiblioteca.dto.EditorialDto;
import com.example.Apibiblioteca.dto.LibroDto;
import com.example.Apibiblioteca.model.Editorial;
import com.example.Apibiblioteca.service.Editorialservicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editorial")
@RequiredArgsConstructor
public class EditorialController {
    private final Editorialservicio EditorialImpl;

    @GetMapping("/consultaEditorial")
    public ResponseEntity<List<EditorialDto>> consultaEditorial() {

        List<EditorialDto> lista = EditorialImpl.consultaEditorial();


        return new ResponseEntity<>(lista, HttpStatus.OK);

    }
    @PostMapping("/crearEditorial")
    public ResponseEntity<String> crearEditorial(@RequestBody EditorialDto editorialDto) {
        String resultado = EditorialImpl.crearEditorial(editorialDto);
        if (resultado != null) {
            return new ResponseEntity<>(resultado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al crear la editorial.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findEditorial")
    public ResponseEntity<EditorialDto> findEditorial(@RequestParam String nombre) {
        EditorialDto editorial = EditorialImpl.findEditorial(nombre);
        if (editorial != null) {
            return new ResponseEntity<>(editorial, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modificarEditorial/{id}")
    public ResponseEntity<String> modificarEditorial(@PathVariable Long id, @RequestBody EditorialDto editorialDto) {
        String resultado = EditorialImpl.modificarEditorial(id, editorialDto);
        if (resultado != null) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al modificar la editorial.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/bajaEditorial/{id}")
    public ResponseEntity<String> bajaEditorial(@PathVariable Long id) {
        String resultado = EditorialImpl.bajaEditorial(id);
        if (resultado != null) {
            return new ResponseEntity<>(resultado, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Error al dar de baja la editorial.", HttpStatus.BAD_REQUEST);
        }
    }
}




