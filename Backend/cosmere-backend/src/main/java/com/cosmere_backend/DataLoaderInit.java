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

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

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

            MistbornCharacter kelsier = new MistbornCharacter("Kelsier",984,1022,1L, Arrays.asList("Superviviente de Hatshin", ""),"MistBorn","Ladron",MistbornType.MISTBORN,Arrays.asList("Hemalurgia", "Nacido de la Bruma"));
            MistbornCharacter hammond = new MistbornCharacter("Hammond",984,1022,1L, Arrays.asList("Banda del Superviviente", ""),"MistBorn","Ladron",MistbornType.MISTBORN,Arrays.asList("Hemalurgia", "Nacido de la Bruma"));
            MistbornCharacter vin = new MistbornCharacter("Vin",984,1022,1L, Arrays.asList("La Guerrera del Imperio Final", ""),"MistBorn","Ladron",MistbornType.MISTBORN,Arrays.asList("Hemalurgia", "Nacido de la Bruma"));
            StormlightCharacter kaladin = new StormlightCharacter("Kaladin",1153,0,1L,Arrays.asList("Bendito por la Tormenta", "Heraldo del Viento"),"StormLight", StormlightType.CORREDOR_VIENTO,true,4);
            MistbornCharacter marsh = new MistbornCharacter("Marsh",984,1022,1L, Arrays.asList("Inquisidor del imperio final", ""),"MistBorn","Ladron",MistbornType.MISTBORN,Arrays.asList("Hemalurgia", "Nacido de la Bruma"));



            // Antes de nada guardamos el libro en la base de datos

            // Mistborn
            Book eif = new Book("El Imperio Final","MistBorn", 2000);
            bookRepository.save(eif);
            Book epa = new Book("El pozo de la Ascension", "MistBorn",2000);
            bookRepository.save(epa);
            Book ehe = new Book("El Heroe de las Eras", "MistBorn",2000);
            bookRepository.save(ehe);
//            Book adl = new Book("Aleacion de Ley", "MistBorn",2000);
//            bookRepository.save(adl);
//            Book sdi = new Book("Sombras de Identidad", "MistBorn",2000);
//            bookRepository.save(sdi);
//            Book bdd = new Book("Brazales de Duelo", "MistBorn",2000);
//            bookRepository.save(bdd);
//            Book emp = new Book("El Metal Perdido", "MistBorn",2000);
//            bookRepository.save(emp);

            // Archivo
            Book twok = new Book("The Way of Kings","StormLight", 2000);
            bookRepository.save(twok);
            Book wod = new Book("Words of Radiance", "StormLight", 2000);
            bookRepository.save(wod);
            Book o = new Book("Oathbringer", "StormLight", 2000);
            bookRepository.save(o);
            Book rosw = new Book("Rhythm of War", "StormLight", 2000);
            bookRepository.save(rosw);
            Book vyv = new Book("Viento y Verdad", "StormLight", 2000);
            bookRepository.save(vyv);

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
            vin.addBook(eif);
            vin.setFirstBook(eif);
            kaladin.addBook(twok);
            kaladin.setFirstBook(twok);


            characterRepository.save(kelsier);
            characterRepository.save(hammond);
            characterRepository.save(marsh);
            characterRepository.save(kaladin);
            characterRepository.save(vin);
        }

    }
}