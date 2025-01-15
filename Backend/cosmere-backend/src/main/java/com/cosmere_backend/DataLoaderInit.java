package com.cosmere_backend;

import com.cosmere_backend.Model.Book;
import com.cosmere_backend.Model.CCharacter;
import com.cosmere_backend.Repository.IBookRepository;
import com.cosmere_backend.Repository.ICCharacterRepository;
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

            CCharacter kaladin = new CCharacter("Kaladin");
            CCharacter shallan = new CCharacter("Shallan");
            CCharacter dalinar = new CCharacter("Dalinar");

            Book twok = new Book("The Way of Kings","StormLight", 2000);
            Book eif = new Book("El Imperio Final","MistBorn", 2000);

            // Antes de nada guardamos el libro en la base de datos
            bookRepository.save(twok);
            bookRepository.save(eif);

            // Relacionar los libros entre ellos

            // Primero Guardamos la ID del libro ya que es el primero en el que aparece el personaje
            kaladin.setFirstBook(twok);
            System.out.println("Kaladin.toString = " + kaladin.toString());
            kaladin.addBook(twok);
            shallan.setFirstBook(twok);
            shallan.addBook(twok);
            dalinar.setFirstBook(twok);
            dalinar.addBook(twok);

            kaladin.addBook(eif);
            shallan.addBook(eif);
            dalinar.addBook(eif);



            characterRepository.save(kaladin);
            characterRepository.save(shallan);
            characterRepository.save(dalinar);
        }

    }
}