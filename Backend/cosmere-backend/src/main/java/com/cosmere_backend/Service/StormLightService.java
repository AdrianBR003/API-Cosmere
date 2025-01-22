package com.cosmere_backend.Service;

import com.cosmere_backend.Model.MistBorn.MistbornCharacter;
import com.cosmere_backend.Model.StormLight.StormlightCharacter;
import com.cosmere_backend.Repository.IMistBornCharacterRepository;
import com.cosmere_backend.Repository.IStormLightCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StormLightService {

    @Autowired
    private IStormLightCharacterRepository iStormLightCharacterRepository;

    public List<StormlightCharacter> getAllStormLightCharacters() {
        return iStormLightCharacterRepository.findAll();
    }
}
