package com.cosmere_backend.cosmere_backend;

import com.cosmere_backend.cosmere_backend.Model.CCharacter;
import com.cosmere_backend.cosmere_backend.Repository.ICharacterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderInit implements CommandLineRunner {

    private final ICharacterRepository characterRepository;

    public DataLoaderInit(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Inserta datos iniciales si no existen
        if (characterRepository.count() == 0) {
            characterRepository.save(new CCharacter("Kaladin"));
            characterRepository.save(new CCharacter("Shallan"));
            characterRepository.save(new CCharacter("Dalinar"));
        }
    }
}