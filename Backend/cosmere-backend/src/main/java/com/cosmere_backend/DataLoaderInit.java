package com.cosmere_backend;

import com.cosmere_backend.Model.Book;
import com.cosmere_backend.Model.MistBorn.MistBornCharacter;
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

            MistBornCharacter kelsier = new MistBornCharacter("Kelsier",20,0L,"ladron","MistBorn","All",false);
            MistBornCharacter hammond = new MistBornCharacter("Hammond",20,0L,"ladron","MistBorn","All",false);
            MistBornCharacter marsh = new MistBornCharacter("Marsh",20,0L,"inquisidor","Inquisitor","All",true);

            Book twok = new Book("The Way of Kings","StormLight", 2000);
            Book eif = new Book("El Imperio Final","MistBorn", 2000);

            // Antes de nada guardamos el libro en la base de datos
            bookRepository.save(twok);
            bookRepository.save(eif);

            // Relacionar los libros entre ellos

            // Primero Guardamos la ID del libro ya que es el primero en el que aparece el personaje
            kelsier.setFirstBook(twok);
            System.out.println("Kelsier.toString = " + kelsier.toString());
            kelsier.addBook(twok);
            hammond.setFirstBook(twok);
            hammond.addBook(twok);
            marsh.setFirstBook(twok);
            marsh.addBook(twok);

            kelsier.addBook(eif);
            hammond.addBook(eif);
            marsh.addBook(eif);



            characterRepository.save(kelsier);
            characterRepository.save(hammond);
            characterRepository.save(marsh);
        }

    }
}