package com.cosmere_backend.Repository;

import com.cosmere_backend.Model.CCharacterBook;
import com.cosmere_backend.Model.StormLight.StormlightCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStormLightCharacterRepository extends JpaRepository<StormlightCharacter, Long> {
}
