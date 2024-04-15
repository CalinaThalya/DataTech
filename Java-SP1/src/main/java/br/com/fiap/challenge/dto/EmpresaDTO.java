package br.com.fiap.challenge.dto;

import javax.validation.constraints.NotBlank;

public class EmpresaDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String nomeFantasia; 

    @NotBlank
    private String cnpj; 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}