package com.cosmere_backend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "characters")
public class CCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Character;

    @NonNull
    private String name_Character;

    private int age_Character;

    @NonNull
    private Long id_Libro_Original;

    @ManyToMany
    @JoinTable(
            name = "Character_Book",
            joinColumns = @JoinColumn(name = "id_Character"),
            inverseJoinColumns = @JoinColumn(name = "id_Book")
    )
    private List<Book> listaLibrosAparece = new ArrayList<>();

    // Constructores adicionales...

    public CCharacter(){}

    public CCharacter(@NonNull String nameCharacter) {
        this.name_Character = nameCharacter;
    }



    // Métodos adicionales...

    public void addBook(Book book) {
        if (!listaLibrosAparece.contains(book)) {
            listaLibrosAparece.add(book);
            book.getlCharacters().add(this);
        }
    }

    public void setFirstBook(Book book){
        if (book!=null) {
            this.id_Libro_Original = book.getId_Book();
        }
    }

    @Override
    public String toString() {
        return "CCharacter{" +
                "id_Character=" + id_Character +
                ", name_Character='" + name_Character + '\'' +
                ", age_Character=" + age_Character +
                ", id_Libro_Original=" + id_Libro_Original +
                '}';
    }

    // Getter and Setter (Bug Lombook)



    public Long getId_Character() {
        return id_Character;
    }

    public void setId_Character(Long id_Character) {
        this.id_Character = id_Character;
    }

    public @NonNull String getName_Character() {
        return name_Character;
    }

    public void setName_Character(@NonNull String name_Character) {
        this.name_Character = name_Character;
    }

    public int getAge_Character() {
        return age_Character;
    }

    public void setAge_Character(int age_Character) {
        this.age_Character = age_Character;
    }

    public @NonNull Long getId_Libro_Original() {
        return id_Libro_Original;
    }

    public void setId_Libro_Original(@NonNull Long id_Libro_Original) {
        this.id_Libro_Original = id_Libro_Original;
    }

    public List<Book> getListaLibrosAparece() {
        return listaLibrosAparece;
    }

    public void setListaLibrosAparece(List<Book> listaLibrosAparece) {
        this.listaLibrosAparece = listaLibrosAparece;
    }
}
