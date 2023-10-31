package com.example.Apibiblioteca.model;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;


@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
    public class Autor {
        @Id@GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private Boolean alta;

      //establesco la relacion uno-muchos
        @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

}
