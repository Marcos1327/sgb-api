package com.marcos.sigeb.entity.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String editora;
    private LocalDate anoPublicacao;
    private Integer numeroExemplaresDisponiveis;

    private boolean availableBook;
    public Book() {
    }

    public Book(String titulo, String autor, String editora, LocalDate anoPublicacao, Integer numeroExemplaresDisponiveis, boolean availableBook) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.numeroExemplaresDisponiveis = numeroExemplaresDisponiveis;
        this.availableBook = availableBook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public LocalDate getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(LocalDate anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getNumeroExemplaresDisponiveis() {
        return numeroExemplaresDisponiveis;
    }

    public void setNumeroExemplaresDisponiveis(Integer numeroExemplaresDisponiveis) {
        this.numeroExemplaresDisponiveis = numeroExemplaresDisponiveis;
    }

    public boolean isAvailableBook() {
        return availableBook;
    }

    public void setAvailableBook(boolean availableBook) {
        this.availableBook = availableBook;
    }
}
