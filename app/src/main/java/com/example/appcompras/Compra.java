package com.example.appcompras;

import java.io.Serializable;

public class Compra implements Serializable {

    private String nome;
    private String cidade;
    private String produtos;
    private float total;
    private String formaPag;
    private int parcelas;

    public Compra(String nome, String cidade, String produtos, float total, String formaPag, int parcelas) {
        this.nome = nome;
        this.cidade = cidade;
        this.produtos = produtos;
        this.total = total;
        this.formaPag = formaPag;
        this.parcelas = parcelas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(String formaPag) {
        this.formaPag = formaPag;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}
