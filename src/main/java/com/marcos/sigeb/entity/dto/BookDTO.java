package com.marcos.sigeb.entity.dto;

import java.time.LocalDate;

public class BookDTO {

    private String titulo;
    private String autor;
    private String editora;
    private LocalDate anoPublicacao;
    private Integer numeroExemplaresDisponiveis;

    public BookDTO() {
    }

    public BookDTO(String titulo, String autor, String editora, LocalDate anoPublicacao, Integer numeroExemplaresDisponiveis) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.numeroExemplaresDisponiveis = numeroExemplaresDisponiveis;
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
}
