package com.marcos.sigeb.service;

import com.marcos.sigeb.entity.dto.BookDTO;
import com.marcos.sigeb.entity.model.Book;
import com.marcos.sigeb.handlers.BusinessException;
import com.marcos.sigeb.handlers.ResourceNotFoundException;
import com.marcos.sigeb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(BookDTO bookDTO) {
        Book book = new Book();

        if (findByTitulo(bookDTO.getTitulo()) != null) {
            throw new BusinessException("Livro já cadastrado: " + bookDTO.getTitulo());
        }
        book.setId(null);
        book.setTitulo(bookDTO.getTitulo());
        book.setAutor(bookDTO.getAutor());
        book.setEditora(bookDTO.getEditora());
        book.setAnoPublicacao(bookDTO.getAnoPublicacao());
        book.setNumeroExemplaresDisponiveis(bookDTO.getNumeroExemplaresDisponiveis());
        if (bookDTO.getNumeroExemplaresDisponiveis() > 0) {
            book.setAvailableBook(true);
        } else {
            book.setAvailableBook(false);
        }

        return bookRepository.save(book);

    }

    public Book updateBook(Long id, BookDTO bookDTO) {
        Book book = findById(id);

        if (bookDTO.getTitulo() != null) {
            book.setTitulo(bookDTO.getTitulo());
        }
        if (bookDTO.getAutor() != null) {
            book.setAutor(bookDTO.getAutor());
        }
        if (bookDTO.getEditora() != null) {
            book.setEditora(bookDTO.getEditora());
        }
        if (bookDTO.getAnoPublicacao() != null) {
            book.setAnoPublicacao(bookDTO.getAnoPublicacao());
        }
        if (bookDTO.getNumeroExemplaresDisponiveis() != null) {
            book.setNumeroExemplaresDisponiveis(bookDTO.getNumeroExemplaresDisponiveis());
        }

        if (availableBook(id)) {
            book.setAvailableBook(true);
        } else {
            book.setAvailableBook(false);
        }

        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = findById(id);
        bookRepository.delete(book);
    }

    private boolean availableBook(Long id) {
        Book book = findById(id);
        return book.getNumeroExemplaresDisponiveis() > 0;
    }

    public Book findBookById(Long id) {
        return findById(id);
    }

    private Book findByTitulo(String titulo) {
        return bookRepository.findBookByTitulo(titulo);
    }

    private Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado" + id));
    }

}
