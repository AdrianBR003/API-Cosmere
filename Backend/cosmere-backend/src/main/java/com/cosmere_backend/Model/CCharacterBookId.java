package com.cosmere_backend.Model;

import java.io.Serializable;
import java.util.Objects;

public class CCharacterBookId implements Serializable {
    private Long id_Character;
    private Long id_Book;

    public CCharacterBookId() {}

    public CCharacterBookId(Long id_Character, Long id_Book) {
        this.id_Character = id_Character;
        this.id_Book = id_Book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CCharacterBookId that = (CCharacterBookId) o;
        return Objects.equals(id_Character, that.id_Character) && Objects.equals(id_Book, that.id_Book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Character, id_Book);
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

}