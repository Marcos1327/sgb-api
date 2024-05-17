package com.marcos.sigeb.entity.dto;

public class AddressDTO {

    private String cep;
    private String logradouro;
    private String localidade;

    public AddressDTO() {
    }

    public AddressDTO(String cep, String logradouro, String localidade) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.localidade = localidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}
