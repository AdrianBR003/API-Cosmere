package com.cosmere_backend.Model.MistBorn;

import com.cosmere_backend.Model.CCharacter;
import jakarta.persistence.*;
import lombok.NonNull;

@Entity
@PrimaryKeyJoinColumn(name = "id_Character")  // Une su PK a la PK de la tabla padre
@Table(name = "mistborn_character")
public class MistBornCharacter extends CCharacter{

    private String rolSociety;

    private String mistbornType;

    private String alomanticPower;

    private Boolean usesHemalurgy;


    public MistBornCharacter() {
    }

    public MistBornCharacter(@NonNull String name_Character, int age_Character, @NonNull Long id_Libro_Original, String rolSociety, String mistbornType, String alomanticPower, Boolean usesHemalurgy) {
        super(name_Character, age_Character, id_Libro_Original, "MistBorn");
        this.rolSociety = rolSociety;
        this.mistbornType = mistbornType;
        this.alomanticPower = alomanticPower;
        this.usesHemalurgy = usesHemalurgy;
    }

    // Metodos

    @Override
    public String toString() {
        return "MistBornCharacter{" +
                "nameCharacter='" + super.name_Character + '\'' +
                ", ageCharacter=" + super.age_Character +
                ", saga='" + saga + '\'' +
                ", rolSociety='" + rolSociety + '\'' +
                ", mistbornType='" + mistbornType + '\'' +
                ", alomanticPower='" + alomanticPower + '\'' +
                ", usesHemalurgy=" + usesHemalurgy +
                ", id_Character=" + id_Character +
                ", name_Character='" + name_Character + '\'' +
                ", age_Character=" + age_Character +
                ", id_Libro_Original=" + id_Libro_Original +
                ", saga='" + saga + '\'' +
                ", listaLibrosAparece=" + listaLibrosAparece +
                '}';
    }


    // Getter and Setter

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

    public String getMistbornType() {
        return mistbornType;
    }

    public void setMistbornType(String mistbornType) {
        this.mistbornType = mistbornType;
    }

    public String getAlomanticPower() {
        return alomanticPower;
    }

    public void setAlomanticPower(String alomanticPower) {
        this.alomanticPower = alomanticPower;
    }

    public Boolean getUsesHemalurgy() {
        return usesHemalurgy;
    }

    public void setUsesHemalurgy(Boolean usesHemalurgy) {
        this.usesHemalurgy = usesHemalurgy;
    }
}
