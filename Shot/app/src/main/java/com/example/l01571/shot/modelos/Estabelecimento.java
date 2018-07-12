package com.example.l01571.shot.modelos;


public class Estabelecimento {

    private final String nome, imagem;


    public Estabelecimento(String nome, String imagem){
        this.nome = nome;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }
}
