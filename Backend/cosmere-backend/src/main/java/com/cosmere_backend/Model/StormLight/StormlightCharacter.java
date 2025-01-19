package com.cosmere_backend.Model.StormLight;

import com.cosmere_backend.Model.CCharacter;
import com.cosmere_backend.Model.MistBorn.MistbornType;
import jakarta.persistence.*;
import lombok.NonNull;

@Entity
@PrimaryKeyJoinColumn(name = "id_Character")  // Une su PK a la PK de la tabla padre
@Table(name = "stormlight_character")
public class StormlightCharacter extends CCharacter{

    @Enumerated(EnumType.STRING)
    private StormlightType radiantOrder;

    private Boolean bondedSpren;

    private Integer stormlightLevel;

    // Constructores

    public StormlightCharacter() {
    }

    public StormlightCharacter(@NonNull String name_Character, int age_Character, @NonNull Long id_Libro_Original, @NonNull String saga, StormlightType radiantOrder, Boolean bondedSpren, Integer stormlightLevel) {
        super(name_Character, age_Character, id_Libro_Original, saga);
        this.radiantOrder = radiantOrder;
        this.bondedSpren = bondedSpren;
        this.stormlightLevel = stormlightLevel;
    }

    // Metodos

    @Override
    public String toString() {
        return "StormlightCharacter{" +
                "radiantOrder=" + radiantOrder +
                ", bondedSpren=" + bondedSpren +
                ", stormlightLevel=" + stormlightLevel +
                ", id_Character=" + id_Character +
                ", name_Character='" + name_Character + '\'' +
                ", age_Character=" + age_Character +
                ", id_Libro_Original=" + id_Libro_Original +
                ", saga='" + saga + '\'' +
                ", listaLibrosAparece=" + listaLibrosAparece +
                '}';
    }

    // Getter and Setter


    public StormlightType getRadiantOrder() {
        return radiantOrder;
    }

    public void setRadiantOrder(StormlightType radiantOrder) {
        this.radiantOrder = radiantOrder;
    }

    public Boolean getBondedSpren() {
        return bondedSpren;
    }

    public void setBondedSpren(Boolean bondedSpren) {
        this.bondedSpren = bondedSpren;
    }

    public Integer getStormlightLevel() {
        return stormlightLevel;
    }

    public void setStormlightLevel(Integer stormlightLevel) {
        this.stormlightLevel = stormlightLevel;
    }
}
