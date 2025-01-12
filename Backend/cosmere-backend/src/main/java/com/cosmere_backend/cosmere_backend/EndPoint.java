package com.cosmere_backend.cosmere_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class EndPoint {

    @RestController
    @RequestMapping("/characters")
    public class CharacterController {
        @GetMapping
        public List<String> getCharacters() {
            return List.of("Kaladin", "Shallan", "Dalinar");
        }
    }
}
