package com.cosmere_backend.cosmere_backend.API.Controller;

import com.cosmere_backend.cosmere_backend.Model.Book;
import com.cosmere_backend.cosmere_backend.Model.CCharacter;
import com.cosmere_backend.cosmere_backend.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CCharacterController {
    @Autowired
    private CharacterService characterService;

    // GET
    @GetMapping
    public List<CCharacter> getAllCharacters() {
        List<CCharacter> characters = characterService.getAllCharacters();
        System.out.println("Characters: " + characters.toString());
        return characters;
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getAllBooks(@PathVariable Long id) {
        List<Book> books = characterService.getAllBooks(id);
        if (books.isEmpty()) {
            return ResponseEntity.notFound().build(); // Respondera a la peticion con 404
        }
        return ResponseEntity.ok(books); // Responderá con 200 OK + los libros en el cuerpo
    }

    @GetMapping("/{id}")
    public CCharacter getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

    // CREATE
    @PostMapping
    public CCharacter createCharacter(@RequestBody CCharacter character) {
        return characterService.createCharacter(character);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
    }
}
