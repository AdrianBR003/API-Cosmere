package com.cosmere_backend.cosmere_backend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Book {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    @NonNull
    private String nameBook;
    @NonNull
    private String saga;
    private int pages;

    // Tabla Relacional
    @ManyToMany(mappedBy = "ListaIdLibrosAparece") // Indica que esta relación está mapeada por el atributo "books" en CCharacter
    private List<Long> characters = new ArrayList<>();

    // Constructor
    public Book(@NonNull String nameBook, int pages, @NonNull String saga) {
        this.nameBook = nameBook;
        this.pages = pages;
        this.saga = saga;
    }
}
