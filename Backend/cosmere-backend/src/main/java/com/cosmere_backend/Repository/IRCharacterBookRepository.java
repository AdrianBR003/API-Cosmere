package com.cosmere_backend.Repository;

import com.cosmere_backend.Model.CCharacterBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface IRCharacterBookRepository extends JpaRepository<CCharacterBook, Long> {

    @Query("SELECT cb.book.id_Book FROM CCharacterBook cb WHERE cb.character.id_Character = :id_character")
    List<Long> findBooksByCharacterId(@Param("id_character") Long id_character);

    @Query("SELECT cb.character.id_Character FROM CCharacterBook cb WHERE cb.book.id_Book = :id_book")
    List<Long> findCharactersByBookId(@Param("id_book") Long id_book);
}
