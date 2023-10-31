package com.example.Apibiblioteca.dto;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDto {

    private String titulo;
    private String nombre_Autor;
    private String editorial;
    private Boolean alta;



}
