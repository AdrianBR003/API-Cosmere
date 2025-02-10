package com.cosmere_backend.Service;

import com.cosmere_backend.API.DTO.BookDTO;
import com.cosmere_backend.API.DTO.CCharacterDTO;
import com.cosmere_backend.API.DTO.DTOchild.MistBornDTO;
import com.cosmere_backend.API.DTO.DTOchild.StormLightDTO;
import com.cosmere_backend.Model.Book;
import com.cosmere_backend.Model.CCharacter;
import com.cosmere_backend.Model.MistBorn.MistbornCharacter;
import com.cosmere_backend.Model.StormLight.StormlightCharacter;
import com.cosmere_backend.Repository.IBookRepository;
import com.cosmere_backend.Repository.ICCharacterRepository;
import com.cosmere_backend.Repository.IRCharacterBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .map(character -> new CCharacterDTO(character.getId_Character(), character.getName_Character(), character.getFechaNacimiento(), character.getFechaMuerte(), character.getTitulos(), character.getId_Libro_Original(), character.getSaga()))
                .collect(Collectors.toList());
    }

    /**
     * <p>Recogemos todos los personajes Detalladamente</p>
     */
    public List<CCharacterDTO> getAllCharactersDetails() {
        return icCharacterRepository.findAll()
                .stream()
                .map(character -> getCharacterById(character.getId_Character()))
                .collect(Collectors.toList());
    }


    public CCharacterDTO getCharacterById(Long id) {
        CCharacter character = icCharacterRepository.findById(id).orElse(null);
        assert character != null;
        System.out.println("Character GET =" + character.getName_Character() + character.getClass().getName());

        // Verificar el tipo de subclase
        if (character instanceof MistbornCharacter mistbornCharacter) {
            System.out.println("Devolviendo MistBornCharacter DTO");
            System.out.println(mistbornCharacter.toString());

            return new MistBornDTO(
                    mistbornCharacter.getId_Character(),
                    mistbornCharacter.getName_Character(),
                    mistbornCharacter.getFechaNacimiento(),
                    mistbornCharacter.getFechaMuerte(),
                    mistbornCharacter.getTitulos(),
                    mistbornCharacter.getId_Libro_Original(),
                    mistbornCharacter.getSaga(),
                    mistbornCharacter.getMistbornType(),
                    mistbornCharacter.getRolSociety(),
                    mistbornCharacter.getCapacidades());
        } else if (character instanceof StormlightCharacter stormlightCharacter) {
            System.out.println("Devolviendo StormLightCharacter DTO");
            return new StormLightDTO(
                    stormlightCharacter.getId_Character(),
                    stormlightCharacter.getName_Character(),
                    stormlightCharacter.getFechaNacimiento(),
                    stormlightCharacter.getFechaMuerte(),
                    stormlightCharacter.getTitulos(),
                    stormlightCharacter.getId_Libro_Original(),
                    stormlightCharacter.getSaga(),
                    stormlightCharacter.getRadiantOrder(),
                    stormlightCharacter.getBondedSpren(),
                    stormlightCharacter.getStormlightLevel()
            );
        } else {
            // Si no es ninguna de las subclases
            return new CCharacterDTO(
                    character.getId_Character(),
                    character.getName_Character(),
                    character.getFechaNacimiento(),
                    character.getFechaMuerte(),
                    character.getTitulos(),
                    character.getId_Libro_Original(),
                    character.getSaga()
            );
        }
    }


    /**
     * <p>Este método nos va a devolver todos los libros a partir de la ID del CCharacter</p>
     *
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
     *
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
