package com.cosmere_backend.cosmere_backend.API;

import com.cosmere_backend.cosmere_backend.Model.CCharacter;
import com.cosmere_backend.cosmere_backend.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<CCharacter> getAllCharacters() {
        List<CCharacter> characters =  characterService.getAllCharacters();
        System.out.println("Characters: " + characters.toString());
        return characters;
    }

    @GetMapping("/{id}")
    public CCharacter getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

    @PostMapping
    public CCharacter createCharacter(@RequestBody CCharacter character) {
        return characterService.createCharacter(character);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
    }
}
