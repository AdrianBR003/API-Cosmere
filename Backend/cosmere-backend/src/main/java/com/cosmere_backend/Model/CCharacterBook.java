package com.cosmere_backend.Model;

import jakarta.persistence.*;

@Entity
@IdClass(CCharacterBookId.class) // !!Asociar la clave primaria compuesta
@Table(name = "character_book")
public class CCharacterBook {

    @Id
    @Column(name = "id_Character")
    private Long id_Character;

    @Id
    @Column(name = "id_Book")
    private Long id_Book;

    @ManyToOne
    @JoinColumn(name = "id_Character", insertable = false, updatable = false)
    private CCharacter character;

    @ManyToOne
    @JoinColumn(name = "id_Book", insertable = false, updatable = false)
    private Book book;

    public CCharacterBook() {}


    public CCharacterBook(CCharacter character, Book book) {
        this.character = character;
        this.book = book;
        this.id_Character = character.getId_Character();
        this.id_Book = book.getId_Book();
    }


    // Getters y Setters

    public Long getId_Character() {
        return id_Character;
    }

    public void setId_Character(Long id_Character) {
        this.id_Character = id_Character;
    }

    public Long getId_Book() {
        return id_Book;
    }

    public void setId_Book(Long id_Book) {
        this.id_Book = id_Book;
    }

    public CCharacter getCharacter() {
        return character;
    }

    public void setCharacter(CCharacter character) {
        this.character = character;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
