package com.cosmere_backend.API.DTO;

import jakarta.persistence.Entity;


public class BookDTO {
    private Long id_Book;
    private String name_Book;
    private String saga_Book;
    private int pages_Book;



    public BookDTO(Long id_Book, String name_Book, String saga_Book, int pages_Book) {
        this.id_Book = id_Book;
        this.name_Book = name_Book;
        this.saga_Book = saga_Book;
        this.pages_Book = pages_Book;
    }

    // Metodos

    @Override
    public String toString() {
        return "BookDTO{" +
                "id_Book=" + id_Book +
                ", name_Book='" + name_Book + '\'' +
                ", saga_Book='" + saga_Book + '\'' +
                ", pages_Book=" + pages_Book +
                '}';
    }


    // Getter y Setter

    public Long getId_Book() {
        return id_Book;
    }

    public void setId_Book(Long id_Book) {
        this.id_Book = id_Book;
    }

    public String getName_Book() {
        return name_Book;
    }

    public void setName_Book(String name_Book) {
        this.name_Book = name_Book;
    }

    public String getSaga_Book() {
        return saga_Book;
    }

    public void setSaga_Book(String saga_Book) {
        this.saga_Book = saga_Book;
    }

    public int getPages_Book() {
        return pages_Book;
    }

    public void setPages_Book(int pages_Book) {
        this.pages_Book = pages_Book;
    }
}
