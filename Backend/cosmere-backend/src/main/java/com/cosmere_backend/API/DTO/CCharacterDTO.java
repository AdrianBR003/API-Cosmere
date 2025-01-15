package com.cosmere_backend.API.DTO;

import jakarta.persistence.Entity;


public class CCharacterDTO {
    private Long id_Character;
    private String name_Character;
    private int age_Character;
    private Long id_libro_Original;


    public CCharacterDTO(Long idCharacter, String nameCharacter) {
        this.id_Character = idCharacter;
        this.name_Character = nameCharacter;
    }

    public CCharacterDTO(Long id_Character, String name_Character, int age_Character, Long id_libro_Original) {
        this.id_Character = id_Character;
        this.name_Character = name_Character;
        this.age_Character = age_Character;
        this.id_libro_Original = id_libro_Original;
    }

    // Metodos



    @Override
    public String toString() {
        return "CCharacterDTO{" +
                "id_Character=" + id_Character +
                ", name_Character='" + name_Character + '\'' +
                ", age_Character=" + age_Character +
                ", id_libro_Original=" + id_libro_Original +
                '}';
    }


    // Getter and Setter


    public int getAge_Character() {
        return age_Character;
    }

    public void setAge_Character(int age_Character) {
        this.age_Character = age_Character;
    }

    public Long getId_libro_Original() {
        return id_libro_Original;
    }

    public void setId_libro_Original(Long id_libro_Original) {
        this.id_libro_Original = id_libro_Original;
    }

    public Long getId_Character() {
        return id_Character;
    }

    public void setId_Character(Long id_Character) {
        this.id_Character = id_Character;
    }

    public String getName_Character() {
        return name_Character;
    }

    public void setName_Character(String name_Character) {
        this.name_Character = name_Character;
    }
}
