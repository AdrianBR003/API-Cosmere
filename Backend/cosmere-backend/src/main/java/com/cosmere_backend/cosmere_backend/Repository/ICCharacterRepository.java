package com.cosmere_backend.cosmere_backend.Repository;

import com.cosmere_backend.cosmere_backend.Model.Book;
import com.cosmere_backend.cosmere_backend.Model.CCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICCharacterRepository extends JpaRepository<CCharacter, Long> {

        @Query("SELECT c.books FROM CCharacter c WHERE c.id = :idCharacter")
        List<Book> findBooksByCharacterId(@Param("idCharacter") Long idCharacter);

}

