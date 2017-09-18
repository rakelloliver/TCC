package com.example.raquel.tccalfabetaja;

/**
 * Created by raquel on 17/09/17.
 */

public class DadosCrianca {
    String nomeCrianca;
    String idade;
    int codigoCrianca;



    public  DadosCrianca(){

    }
    public  DadosCrianca (int codigoCrianca, String nome, String idade){
        this.codigoCrianca = codigoCrianca;
        this.nomeCrianca = nome;
        this.idade = idade;
    }
    public  DadosCrianca (String nome, String idade){
        this.nomeCrianca = nome;
        this.idade = idade;
    }



    public String getNomeCrianca() {
        return nomeCrianca;
    }

    public void setNomeCrianca(String nomeCrianca) {
        this.nomeCrianca = nomeCrianca;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public int getCodigoCrianca() {
        return codigoCrianca;
    }

    public void setCodigoCrianca(int codigoCrianca) {
        this.codigoCrianca = codigoCrianca;
    }
}
