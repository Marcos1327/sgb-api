package com.marcos.sigeb.entity.dto;


import com.marcos.sigeb.entity.model.Address;

import java.util.List;

public class CustomerDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String idade;
    private List<AddressDTO> endereços;
    private String numeroContato;
    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String nome, String sobrenome, String idade, List<AddressDTO> endereços, String numeroContato) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.endereços = endereços;
        this.numeroContato = numeroContato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public List<AddressDTO> getEndereço() {
        return endereços;
    }

    public void setEndereço(List<AddressDTO> endereços) {
        this.endereços = endereços;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }

}
