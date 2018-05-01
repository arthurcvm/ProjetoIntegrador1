/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author arthurcvm
 */
public class Faculdade {
    private int idFaculdade;
    private String nome;
    private String CNPJ;
    private String rua;
    private int numero;
    private String bairro;
    private String convenio;
    private String cidade;
    private String estado;

    public Faculdade() {
    }

    public Faculdade(int idFaculdade, String nome, String CNPJ, String rua, int numero, String bairro, String convenio, String cidade, String estado) {
        this.idFaculdade = idFaculdade;
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.convenio = convenio;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getIdFaculdade() {
        return idFaculdade;
    }

    public void setIdFaculdade(int idFaculdade) {
        this.idFaculdade = idFaculdade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }    

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
