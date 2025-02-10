package com.cosmere_backend.API.DTO.DTOchild;

import com.cosmere_backend.API.DTO.CCharacterDTO;
import com.cosmere_backend.Model.MistBorn.MistbornType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MistBornDTO extends CCharacterDTO {

    @JsonProperty
    private MistbornType mistbornType;
    @JsonProperty
    private String rolSociety;
    @JsonProperty
    private List<String> capacidades;

    public MistBornDTO(Long id, String name_Character, int fechaNacimiento, int fechaMuerte, List<String> titulos, Long id_libro_Original, String saga_inicial, MistbornType mistbornType, String rolSociety, List<String> capacidades) {
        super(id, name_Character, fechaNacimiento, fechaMuerte, titulos, id_libro_Original, saga_inicial);
        this.mistbornType = mistbornType;
        this.rolSociety = rolSociety;
        this.capacidades = capacidades;
    }

    @Override
    public String toString() {
        return "MistBornDTO{" +
                "mistbornType=" + mistbornType +
                ", rolSociety='" + rolSociety + '\'' +
                ", capacidades=" + capacidades +
                '}';
    }

    // Getter and Setter



    public List<String> getCapacidades() {
        return capacidades;
    }

    public void setCapacidades(List<String> capacidades) {
        this.capacidades = capacidades;
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
