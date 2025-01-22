package com.cosmere_backend.API.Controller;

import com.cosmere_backend.Model.MistBorn.MistbornCharacter;
import com.cosmere_backend.Service.MistBornService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/characters/mistborn")
public class MistBornController {

    @Autowired
    private MistBornService service;

    @GetMapping
    public List<MistbornCharacter> getAllMistBornCharacters() {
        return service.getAllMistBornCharacters();
    }
}
