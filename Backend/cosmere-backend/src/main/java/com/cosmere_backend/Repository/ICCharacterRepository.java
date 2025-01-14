package com.cosmere_backend.Repository;

import com.cosmere_backend.Model.Book;
import com.cosmere_backend.Model.CCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICCharacterRepository extends JpaRepository<CCharacter, Long> {
}

