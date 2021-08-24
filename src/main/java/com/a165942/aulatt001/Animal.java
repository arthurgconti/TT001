package com.a165942.aulatt001;

public class Animal {

    private int id;
    private String nome;
    private String dataNasc;
    private String sexo;
    private int id_especie;
    private int id_cliente;

    public Animal(int id, String nome, String dataNasc, String sexo, int id_especie, int id_cliente) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.id_especie = id_especie;
        this.id_cliente = id_cliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public int getId_especie() {
        return id_especie;
    }

    public int getId_cliente() {
        return id_cliente;
    }
    
    

    @Override
    public String toString() {
        return "Animal{ \nnome: " + nome + "\n}";
    }
}
