package com.cosmere_backend.Service;

import com.cosmere_backend.API.DTO.BookDTO;
import com.cosmere_backend.API.DTO.CCharacterDTO;
import com.cosmere_backend.Model.Book;
import com.cosmere_backend.Model.CCharacter;
import com.cosmere_backend.Repository.ICCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    private ICCharacterRepository characterRepository;

    /**
     * <p>Con este método definimos a partir del <code>CCharacterDTO</code> el contenido concreto que vamos a enviar</p>
     */
    public List<CCharacterDTO> getAllCharacters() {
        return characterRepository.findAll()
                .stream()
                .map(character -> new CCharacterDTO(character.getId_Character(), character.getName_Character(), character.getAge_Character(), character.getId_Libro_Original()))
                .collect(Collectors.toList());
    }

    public CCharacterDTO getCharacterById(Long id) {
        CCharacter character = characterRepository.findById(id).orElse(null);
        if (character == null) {
            return null;
        }

        // Convertir a DTO
        return new CCharacterDTO(
                character.getId_Character(),
                character.getName_Character(),
                character.getAge_Character(),
                character.getId_Libro_Original()
        );
    }

//    public BookDTO getBookBycId(Long id){
//        Book book = getCharacterById(id).getId_libro_Original();
//    }

    public CCharacter createCharacter(CCharacter character) {
        return characterRepository.save(character);
    }

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }
}
