package com.cosmere_backend.API.DTO.DTOchild;

import com.cosmere_backend.API.DTO.CCharacterDTO;
import com.cosmere_backend.Model.StormLight.StormlightType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;

public class StormLightDTO extends CCharacterDTO {

    @Enumerated(EnumType.STRING)
    private StormlightType radiantOrder;

    private Boolean bondedSpren;


    private Integer stormlightLevel;

    public StormLightDTO(Long id_Character, String name_Character, int fechaNacimiento, int fechaMuerte, List<String> titulos, Long id_libro_Original, String saga_inicial, StormlightType radiantOrder, Boolean bondedSpren, Integer stormlightLevel) {
        super(id_Character, name_Character, fechaNacimiento, fechaMuerte, titulos, id_libro_Original, saga_inicial);
        this.radiantOrder = radiantOrder;
        this.bondedSpren = bondedSpren;
        this.stormlightLevel = stormlightLevel;
    }

    // Metodos


    @Override
    public String toString() {
        return "StormLightDTO{" +
                "radiantOrder=" + radiantOrder +
                ", bondedSpren=" + bondedSpren +
                ", stormlightLevel=" + stormlightLevel +
                '}';
    }

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
