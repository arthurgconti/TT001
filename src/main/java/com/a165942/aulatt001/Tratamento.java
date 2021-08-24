package com.a165942.aulatt001;

import java.util.Calendar;

public class Tratamento {
    private String nome;
    private Calendar dat_ini;
    private Calendar del_fim;
    private int idAnimal;
    private boolean terminou;

    public Tratamento(String nome, Calendar dat_ini, Calendar del_fim,
                        int idAnimal, boolean terminou) {
        this.nome = nome;
        this.dat_ini = dat_ini;
        this.del_fim = del_fim;
        this.idAnimal = idAnimal;
        this.terminou = terminou;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDat_ini() {
        return dat_ini;
    }

    public void setDat_ini(Calendar dat_ini) {
        this.dat_ini = dat_ini;
    }

    public Calendar getDel_fim() {
        return del_fim;
    }

    public void setDel_fim(Calendar del_fim) {
        this.del_fim = del_fim;
    }

    public int getIdAnimal() {
        return idAnimal;
    }


    public boolean isTerminou() {
        return terminou;
    }

    public void setTerminou(boolean terminou) {
        this.terminou = terminou;
    }

 
}
