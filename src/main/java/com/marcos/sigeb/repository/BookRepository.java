package com.marcos.sigeb.repository;

import com.marcos.sigeb.entity.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByTitulo(String titulo);

}
