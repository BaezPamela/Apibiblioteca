package com.example.Apibiblioteca.model;
import jakarta.persistence.*;
import lombok.*;



@Entity
//@Table(schema = "libro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String isbn; //antes Long
    @Column
    private String titulo;
    @Column(name="autor_nombre")
    private String nombreAutor;
    @Column
    private Integer anioPublicacion;
    @Column
    private Integer ejemplares;
    @Column
    private Integer prestados;
    @Column
    private Integer restantes;
    @Column
    private Boolean alta;

    @ManyToOne
    @JoinColumn(name= "editorial_id")
    private Editorial editorial;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;


}
