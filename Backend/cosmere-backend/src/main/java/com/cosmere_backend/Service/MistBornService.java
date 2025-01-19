package com.cosmere_backend.Service;

import com.cosmere_backend.Model.MistBorn.MistbornCharacter;
import com.cosmere_backend.Repository.IMistBornCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MistBornService {

    @Autowired
    private IMistBornCharacterRepository repository;

    public List<MistbornCharacter> getAllMistBornCharacters() {
        return repository.findAll();
    }
}
