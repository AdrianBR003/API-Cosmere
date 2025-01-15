package com.cosmere_backend.Service;


import com.cosmere_backend.API.DTO.BookDTO;
import com.cosmere_backend.API.DTO.CCharacterDTO;
import com.cosmere_backend.Repository.IBookRepository;
import com.cosmere_backend.Repository.ICCharacterRepository;
import com.cosmere_backend.Repository.IRCharacterBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private ICCharacterRepository icCharacterRepository;

    @Autowired
    IBookRepository iBookRepository;

    @Autowired
    private IRCharacterBookRepository irCharacterBookRepository;


    /**
     * <p>Con este método definimos a partir del <code>BookDTO</code> el contenido concreto que vamos a enviar</p>
     */
    public List<BookDTO> getAllBook() {
        return iBookRepository.findAll()
                .stream()
                .map(book -> new BookDTO(book.getId_Book(), book.getName_Book(), book.getSaga_Book(), book.getPages_Book()))
                .collect(Collectors.toList());
    }

}
