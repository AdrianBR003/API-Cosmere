package com.cosmere_backend.Model;

import com.cosmere_backend.API.ListToJsonConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ccharacter")
@Inheritance(strategy = InheritanceType.JOINED) // Herencia de PK
public abstract class CCharacter {

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id_Character;
    @NonNull
    protected String name_Character;
    protected int fechaNacimiento;
    protected int fechaMuerte;
    @NonNull
    protected Long id_Libro_Original;

    @Convert(converter = ListToJsonConverter.class)
    @Column(columnDefinition ="TEXT")
    protected List<String> titulos;

    @NonNull
    protected String saga;
    @ManyToMany
    @JoinTable(
            name = "Character_Book",
            joinColumns = @JoinColumn(name = "id_Character"),
            inverseJoinColumns = @JoinColumn(name = "id_Book")
    )
    @Convert(converter = ListToJsonConverter.class)
    @Column(columnDefinition = "TEXT") // JSON
    protected List<Book> listaLibrosAparece = new ArrayList<>();

    public CCharacter(){}

    public CCharacter( @NonNull String name_Character, int fechaNacimiento, int fechaMuerte, @NonNull Long id_Libro_Original, List<String> titulos, @NonNull String saga) {
        this.name_Character = name_Character;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaMuerte = fechaMuerte;
        this.id_Libro_Original = id_Libro_Original;
        this.titulos = titulos;
        this.saga = saga;
    }

    public CCharacter(@NonNull String nameCharacter) {
        this.name_Character = nameCharacter;
    }

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
                ", age_Character=" + fechaNacimiento +
                ", saga_Character= " + saga +
                ", id_Libro_Original=" + id_Libro_Original +
                '}';
    }

    // Getter and Setter (Bug Lombook)


    public int getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(int fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public List<String> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<String> titulos) {
        this.titulos = titulos;
    }

    public List<Book> getListaLibrosAparece() {
        return listaLibrosAparece;
    }

    public void setListaLibrosAparece(List<Book> listaLibrosAparece) {
        this.listaLibrosAparece = listaLibrosAparece;
    }

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

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public @NonNull Long getId_Libro_Original() {
        return id_Libro_Original;
    }

    public void setId_Libro_Original(@NonNull Long id_Libro_Original) {
        this.id_Libro_Original = id_Libro_Original;
    }

    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }
}
