package com.cosmere_backend.API.Controller;

import com.cosmere_backend.Model.MistBorn.MistbornCharacter;
import com.cosmere_backend.Model.StormLight.StormlightCharacter;
import com.cosmere_backend.Service.MistBornService;
import com.cosmere_backend.Service.StormLightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/characters/stormlight")
public class StormLightController {

    @Autowired
    private StormLightService stormLightService;

    @GetMapping
    public List<StormlightCharacter> getAllStormLightCharacters() {
        return stormLightService.getAllStormLightCharacters();
    }
}