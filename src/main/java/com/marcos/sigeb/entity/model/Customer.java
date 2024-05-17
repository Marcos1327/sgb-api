package com.marcos.sigeb.entity.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String nome;
    private String sobrenome;
    private String idade;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Address> endereços;
    private String numeroContato;
    private LocalDate dataCadastro;

    public Customer() {
    }

    public Customer(Long customerId, String nome, String sobrenome, String idade, List<Address> endereços, String numeroContato, LocalDate dataCadastro) {
        this.customerId = customerId;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.endereços = endereços;
        this.numeroContato = numeroContato;
        this.dataCadastro = dataCadastro;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public List<Address> getEndereços() {
        return endereços;
    }

    public void setEndereço(List<Address> endereços) {
        this.endereços = endereços;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerId +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade='" + idade + '\'' +
                ", endereço='" + endereços + '\'' +
                ", numeroContato='" + numeroContato + '\'' +
                '}';
    }
}
