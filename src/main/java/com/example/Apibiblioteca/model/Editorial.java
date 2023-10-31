package com.example.Apibiblioteca.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Editorial {
    @Id
    @Column
        private Long id;
    @Column
        private String nombre;
    @Column
        private Boolean alta;
    @OneToMany(mappedBy= "editorial")
    private List<Libro> libros;



    }
