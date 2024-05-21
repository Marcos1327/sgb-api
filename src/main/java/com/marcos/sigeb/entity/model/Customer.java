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

    /**
     * Para nao esquecer
     *
     * cascade = CascadeType.ALL: Esta propriedade indica que todas as operações de persistência (como persistir, mesclar, remover, atualizar, etc.)
     * realizadas no cliente também devem ser aplicadas aos endereços associados. Isso significa que se você deletar um cliente,
     * o JPA também tentará deletar todos os endereços associados a esse cliente.
     *
     * orphanRemoval = true: Esta propriedade indica que se um endereço associado for removido da lista de endereços do cliente, ele deve ser deletado do banco de dados.
     * Em outras palavras, se a referência do cliente ao endereço for removida, o endereço será considerado órfão e será removido do banco de dados.
     * */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Address> endereços;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Emprestimo> emprestimos;


    private String numeroContato;
    private LocalDate dataCadastro;

    public Customer() {
    }

    public Customer(Long customerId, String nome, String sobrenome, String idade, List<Address> endereços, List<Emprestimo> emprestimos, String numeroContato, LocalDate dataCadastro) {
        this.customerId = customerId;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.endereços = endereços;
        this.emprestimos = emprestimos;
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

    public void setEndereços(List<Address> endereços) {
        this.endereços = endereços;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
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
}
