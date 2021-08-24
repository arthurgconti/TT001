package com.a165942.aulatt001;


public class Veterinario {
    
    private int idVeterinario;
    private String nome;
    private String enderecoVeterinario;
    private String telVeterinario;
    
    public Veterinario(int idVeterinario, String nome, String enderecoVeterinario, String telVeterinario) {
        this.idVeterinario = idVeterinario;
        this.nome = nome;
        this.enderecoVeterinario = enderecoVeterinario;
        this.telVeterinario = telVeterinario;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public String getNome() {
        return nome;
    }

    public String getEnderecoVeterinario() {
        return enderecoVeterinario;
    }

    public String getTelVeterinario() {
        return telVeterinario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEnderecoVeterinario(String enderecoVeterinario) {
        this.enderecoVeterinario = enderecoVeterinario;
    }

    public void setTelVeterinario(String telVeterinario) {
        this.telVeterinario = telVeterinario;
    }
    
    
    
}
