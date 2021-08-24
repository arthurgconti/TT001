package com.a165942.tt001;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String cep;
    private String email;
    private List animais;

    public Cliente(int id, String nome, String endereco, String telefone, String cep, String email) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cep = cep;
        this.email = email;
        this.animais = new ArrayList<Animal>();
    }

    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.equals("")) {
            this.email = email;
        }
    }

    public boolean addAnimal(Animal animal) {
        if (!animal.getNome().isBlank()){
            animais.add(animal);
            return true;
        }
        return false;
    }

    public List<Animal> getAnimais() {
        List<Animal> copia = new ArrayList<>(animais);
        return copia;
    }

    @Override
    public String toString() {
        String descricao = "Cliente {\nnome: " + nome + "\nendereco: " + endereco + "\nTelefone: "
                + telefone + "\nCep: " + cep + "\nEmail: " + email + "\n}";
        String strAnimais = animais.toString();
        return descricao + "\n" + strAnimais;
    }

}
