package com.cosmere_backend.Repository;

import com.cosmere_backend.Model.MistBorn.MistBornCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMistBornCharacterRepository extends JpaRepository<MistBornCharacter, Long> {
}
