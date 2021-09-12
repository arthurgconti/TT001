package com.a165942.tt001;


public class Veterinario {
    
    private int idVeterinario;
    private String nome;
    private String email;
    private String telefone;

    public Veterinario(int idVeterinario, String nome, String email, String telVeterinario) {
        this.idVeterinario = idVeterinario;
        this.nome = nome;
        this.email = email;
        this.telefone = telVeterinario;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
  
    
    
    
}
