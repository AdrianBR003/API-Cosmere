package com.cosmere_backend.cosmere_backend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "characters")
@ToString
@AllArgsConstructor
@Getter
@Setter
public class CCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public CCharacter(){}

    public CCharacter(String nombre){
        this.nombre = nombre;
    }

}
