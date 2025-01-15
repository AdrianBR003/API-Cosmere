package com.cosmere_backend.API.Controller;


import com.cosmere_backend.API.DTO.BookDTO;
import com.cosmere_backend.API.DTO.CCharacterDTO;
import com.cosmere_backend.Service.BookService;
import com.cosmere_backend.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // GET
    @GetMapping
    public List<BookDTO> getAllCharacters() {
        List<BookDTO> books = bookService.getAllBook();
        System.out.println("Books: " + books.toString());
        return books;
    }
}
