package com.cosmere_backend.Repository;

import com.cosmere_backend.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {
}
