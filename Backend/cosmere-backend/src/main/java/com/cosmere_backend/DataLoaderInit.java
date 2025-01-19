package com.cosmere_backend;

import com.cosmere_backend.Model.Book;
import com.cosmere_backend.Model.MistBorn.MistbornCharacter;
import com.cosmere_backend.Model.MistBorn.MistbornType;
import com.cosmere_backend.Model.StormLight.StormlightCharacter;
import com.cosmere_backend.Model.StormLight.StormlightType;
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

            MistbornCharacter kelsier = new MistbornCharacter("Kelsier",20,0L,"ladron", MistbornType.MISTBORN,"All",false);
            MistbornCharacter hammond = new MistbornCharacter("Hammond",20,0L,"ladron",MistbornType.MISTBORN,"All",false);
            MistbornCharacter marsh = new MistbornCharacter("Marsh",20,0L,"inquisidor",MistbornType.INQUISITOR,"All",true);
            StormlightCharacter kaladin = new StormlightCharacter("Kaladin",19,0L,"StormLight", StormlightType.CORREDOR_VIENTO,true,4);


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

            kaladin.addBook(twok);
            kaladin.setFirstBook(twok);


            characterRepository.save(kelsier);
            characterRepository.save(hammond);
            characterRepository.save(marsh);
            characterRepository.save(kaladin);
        }

    }
}