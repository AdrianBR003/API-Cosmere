package com.cosmere_backend.Model.MistBorn;

import com.cosmere_backend.API.ListToJsonConverter;
import com.cosmere_backend.Model.CCharacter;
import jakarta.persistence.*;
import lombok.NonNull;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id_Character")  // Une su PK a la PK de la tabla padre
@Table(name = "mistborn_character")
public class MistbornCharacter extends CCharacter {

    private String rolSociety;
    @Enumerated(EnumType.STRING)
    private MistbornType mistbornType;

    @Convert(converter = ListToJsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<String> capacidades;

    public MistbornCharacter() {
    }

    public MistbornCharacter(@NonNull String name_Character, int fechaNacimiento, int fechaMuerte, @NonNull Long id_Libro_Original, List<String> titulos, @NonNull String saga, String rolSociety, MistbornType mistbornType, List<String> capacidades) {
        super(name_Character, fechaNacimiento, fechaMuerte, id_Libro_Original, titulos, saga);
        this.rolSociety = rolSociety;
        this.mistbornType = mistbornType;
        this.capacidades = capacidades;
    }

    // Metodos

    @Override
    public String toString() {
        return "MistbornCharacter{" +
                "rolSociety='" + rolSociety + '\'' +
                ", mistbornType=" + mistbornType +
                ", capacidades=" + capacidades +
                ", id_Character=" + id_Character +
                ", name_Character='" + name_Character + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaMuerte=" + fechaMuerte +
                ", id_Libro_Original=" + id_Libro_Original +
                ", titulos=" + titulos +
                ", saga='" + saga + '\'' +
                '}';
    }


    // Getter and Setter



    public List<String> getCapacidades() {
        return capacidades;
    }

    public void setCapacidades(List<String> capacidades) {
        this.capacidades = capacidades;
    }

    @Override
    public String getSaga() {
        return saga;
    }

    @Override
    public void setSaga(String saga) {
        this.saga = saga;
    }

    public String getRolSociety() {
        return rolSociety;
    }

    public void setRolSociety(String rolSociety) {
        this.rolSociety = rolSociety;
    }

    public MistbornType getMistbornType() {
        return mistbornType;
    }

    public void setMistbornType(MistbornType mistbornType) {
        this.mistbornType = mistbornType;
    }

}
