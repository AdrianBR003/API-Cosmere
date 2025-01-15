package com.cosmere_backend.Service;

import com.cosmere_backend.API.DTO.BookDTO;
import com.cosmere_backend.API.DTO.CCharacterDTO;
import com.cosmere_backend.Model.Book;
import com.cosmere_backend.Model.CCharacter;
import com.cosmere_backend.Repository.IBookRepository;
import com.cosmere_backend.Repository.ICCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cosmere_backend.Repository.IRCharacterBookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    private ICCharacterRepository icCharacterRepository;

    @Autowired
    IBookRepository iBookRepository;

    @Autowired
    private IRCharacterBookRepository irCharacterBookRepository;

    /**
     * <p>Con este método definimos a partir del <code>CCharacterDTO</code> el contenido concreto que vamos a enviar</p>
     */
    public List<CCharacterDTO> getAllCharacters() {
        return icCharacterRepository.findAll()
                .stream()
                .map(character -> new CCharacterDTO(character.getId_Character(), character.getName_Character(), character.getAge_Character(), character.getId_Libro_Original()))
                .collect(Collectors.toList());
    }

    public CCharacterDTO getCharacterById(Long id) {
        CCharacter character = icCharacterRepository.findById(id).orElse(null);
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

    /**
     * <p>Este método nos va a devolver todos los libros a partir de la ID del CCharacter</p>
     * @param id
     * @return
     */
    public List<BookDTO> getAllBookById(Long id) {
        List<Long> listaB = irCharacterBookRepository.findBooksByCharacterId(id);
        return listaB.stream()
                .map(bookId -> iBookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found")))
                .map(book -> new BookDTO(book.getId_Book(), book.getName_Book(), book.getSaga_Book(), book.getPages_Book())) // Transforma a DTO
                .collect(Collectors.toList());
    }

    /**
     * <p>Este método nos va a devolver el libro Inicial a partir de la ID</p>
     * @param id
     * @return
     */
    public BookDTO getFirstBookById(Long id) {
        CCharacter character = icCharacterRepository.findById(id).orElse(null);
        if (character == null) {
            return null;
        }
        Book book = iBookRepository.findById(character.getId_Libro_Original()).orElse(null);
        assert book != null;
        return new BookDTO(book.getId_Book(), book.getName_Book(), book.getName_Book(), book.getPages_Book());
    }

    public CCharacter createCharacter(CCharacter character) {
        return icCharacterRepository.save(character);
    }

    public void deleteCharacter(Long id) {
        icCharacterRepository.deleteById(id);
    }
}
