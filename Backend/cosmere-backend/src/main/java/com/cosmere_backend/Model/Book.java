package com.cosmere_backend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Book;

    @NonNull
    private String name_Book;

    @NonNull
    private String saga_Book;

    private int pages_Book;

    @ManyToMany(mappedBy = "listaLibrosAparece")
    private List<CCharacter> lCharacters = new ArrayList<>();

    // Constructor adicional...

    public Book(){}

    public Book(@NonNull String nameBook, @NonNull String saga, int pages) {
        this.name_Book = nameBook;
        this.saga_Book = saga;
        this.pages_Book = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id_Book=" + id_Book +
                ", name_Book='" + name_Book + '\'' +
                ", saga_Book='" + saga_Book + '\'' +
                ", pages_Book=" + pages_Book +
                '}';
    }

    // Getter and Setter (Bug Lombook)

    public List<CCharacter> getlCharacters() {
        return lCharacters;
    }

    public Long getId_Book() {
        return id_Book;
    }

    public void setId_Book(Long id_Book) {
        this.id_Book = id_Book;
    }

    public @NonNull String getName_Book() {
        return name_Book;
    }

    public void setName_Book(@NonNull String name_Book) {
        this.name_Book = name_Book;
    }

    public @NonNull String getSaga_Book() {
        return saga_Book;
    }

    public void setSaga_Book(@NonNull String saga_Book) {
        this.saga_Book = saga_Book;
    }

    public int getPages_Book() {
        return pages_Book;
    }

    public void setPages_Book(int pages_Book) {
        this.pages_Book = pages_Book;
    }
}
