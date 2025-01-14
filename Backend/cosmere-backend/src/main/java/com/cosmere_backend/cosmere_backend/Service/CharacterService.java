package com.cosmere_backend.cosmere_backend.Service;

import com.cosmere_backend.cosmere_backend.Model.Book;
import com.cosmere_backend.cosmere_backend.Model.CCharacter;
import com.cosmere_backend.cosmere_backend.Repository.ICCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    @Autowired
    private ICCharacterRepository characterRepository;

    public List<CCharacter> getAllCharacters() {
        return characterRepository.findAll();
    }

    public List<Book> getAllBooks(Long id) {
        return characterRepository.findBooksByCharacterId(id);
    }

    public CCharacter getCharacterById(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    public CCharacter createCharacter(CCharacter character) {
        return characterRepository.save(character);
    }

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }
}
