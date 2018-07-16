package com.example.l01571.shot.modelos;


import java.io.Serializable;

public class Estabelecimento implements Serializable {

    private String nome, imagem, endereco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem){
        this.imagem = imagem;
    }


}
