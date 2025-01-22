package com.cosmere_backend.API.DTO.DTOchild;

import com.cosmere_backend.API.DTO.CCharacterDTO;
import com.cosmere_backend.Model.MistBorn.MistbornType;

public class MistBornDTO extends CCharacterDTO {

    private String rolSociety;
    private MistbornType mistbornType;
    private String alomanticPower;
    private Boolean usesHemalurgy;

    public MistBornDTO(Long id_Character, String name_Character, int age_Character, Long id_libro_Original, String sagaInicial, String rolSociety, MistbornType mistbornType, String alomanticPower, Boolean usesHemalurgy) {
        super(id_Character, name_Character, age_Character, id_libro_Original, sagaInicial);
        this.rolSociety = rolSociety;
        this.mistbornType = mistbornType;
        this.alomanticPower = alomanticPower;
        this.usesHemalurgy = usesHemalurgy;
    }


    // Getter and Setter

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
