package com.cosmere_backend.cosmere_backend;

import com.cosmere_backend.cosmere_backend.Model.Book;
import com.cosmere_backend.cosmere_backend.Model.CCharacter;
import com.cosmere_backend.cosmere_backend.Repository.IBookRepository;
import com.cosmere_backend.cosmere_backend.Repository.ICCharacterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderInit implements CommandLineRunner {

    private final ICCharacterRepository characterRepository;
    private final IBookRepository bookRepository;

    public DataLoaderInit(ICCharacterRepository characterRepository, IBookRepository bookRepository) {
        this.characterRepository = characterRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Inserta datos iniciales si no existen
        if (characterRepository.count() == 0 && bookRepository.count()==0) {

            CCharacter kaladin = new CCharacter("Kaladin",1L);
            CCharacter shallan = new CCharacter("Shallan",1L);
            CCharacter dalinar = new CCharacter("Dalinar",1L);

            Book twok = new Book("The Way of Kings",2000, "StormLight");

            // Relacionar los libros entre ellos
            kaladin.addIdBook(twok.getIdBook());
            shallan.addIdBook(twok.getIdBook());
            dalinar.addIdBook(twok.getIdBook());

            characterRepository.save(kaladin);
            characterRepository.save(shallan);
            characterRepository.save(dalinar);
        }

    }
}