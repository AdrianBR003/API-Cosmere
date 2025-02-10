package com.cosmere_backend.API.DTO;


import com.cosmere_backend.API.DTO.DTOchild.MistBornDTO;
import com.cosmere_backend.API.DTO.DTOchild.StormLightDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MistBornDTO.class, name = "mistborn"),
        @JsonSubTypes.Type(value = StormLightDTO.class, name = "stormlight")
})
public class CCharacterDTO {
    @JsonProperty
    private Long id_Character;
    @JsonProperty
    private String name_Character;
    @JsonProperty
    private int fechaNacimiento;
    @JsonProperty
    private int fechaMuerte;
    @JsonProperty
    private List<String> titulos;
    @JsonProperty
    private Long id_libro_Original;
    @JsonProperty
    private String saga_inicial;


    public CCharacterDTO(Long idCharacter, String nameCharacter) {
        this.id_Character = idCharacter;
        this.name_Character = nameCharacter;
    }

    public CCharacterDTO(Long id_Character, String name_Character, int fechaNacimiento, int fechaMuerte, List<String> titulos, Long id_libro_Original, String saga_inicial) {
        this.id_Character = id_Character;
        this.name_Character = name_Character;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaMuerte = fechaMuerte;
        this.titulos = titulos;
        this.id_libro_Original = id_libro_Original;
        this.saga_inicial = saga_inicial;
    }

    // Metodos

    @Override
    public String toString() {
        return "CCharacterDTO{" +
                "id_Character=" + id_Character +
                ", name_Character='" + name_Character + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaMuerte=" + fechaMuerte +
                ", titulos=" + titulos +
                ", id_libro_Original=" + id_libro_Original +
                ", saga_inicial='" + saga_inicial + '\'' +
                '}';
    }


    // Getter and Setter


    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getSaga_inicial() {
        return saga_inicial;
    }

    public void setSaga_inicial(String saga_inicial) {
        this.saga_inicial = saga_inicial;
    }
}
