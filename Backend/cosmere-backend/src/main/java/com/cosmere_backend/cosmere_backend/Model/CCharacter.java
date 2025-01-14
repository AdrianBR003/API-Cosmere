package com.cosmere_backend.cosmere_backend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characters")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CCharacter {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCharacter;
    @NonNull
    private String nameCharacter;
    private int ageCharacter;
    @NonNull
    private Long idLibroOriginal;
    @NonNull

    // Tabla Relacional
    @ManyToMany
    @JoinTable(
            name = "Character_Book", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "idCharacter"), // FK hacia esta tabla
            inverseJoinColumns = @JoinColumn(name = "idBook") // FK hacia la tabla Book
    )
    private List<Long> ListaIdLibrosAparece = new ArrayList<>();

    // Constructores
    public CCharacter(@NonNull String nameCharacter, @NonNull Long idLibroOriginal) {
        this.nameCharacter = nameCharacter;
        this.idLibroOriginal = idLibroOriginal;
    }

    // Metodos
    public void addIdBook(Long idBook) {
        // TODO Hacer una verificacion de que no existe o sea nulo
        ListaIdLibrosAparece.add(idBook);
    }

}
