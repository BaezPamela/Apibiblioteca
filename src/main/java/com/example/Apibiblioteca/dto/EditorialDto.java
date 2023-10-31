package com.example.Apibiblioteca.dto;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EditorialDto {
    private String nombre;
    private Boolean alta;
}
