package com.cosmere_backend.cosmere_backend.Repository;

import com.cosmere_backend.cosmere_backend.Model.CCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharacterRepository extends JpaRepository<CCharacter, Long> {
}

