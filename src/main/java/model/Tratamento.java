package model;

import java.util.Date;

public class Tratamento {

    private int idTratamento;
    private int idAnimal;
    private String nome;
    private Date dat_ini;
    private Date dat_fim;
    private boolean terminou;

    public Tratamento(int idTratamento, int idAnimal, String nome, Date dat_ini, Date dat_fim, boolean terminou) {
        this.idTratamento = idTratamento;
        this.idAnimal = idAnimal;
        this.nome = nome;
        this.dat_ini = dat_ini;
        this.dat_fim = dat_fim;
        this.terminou = terminou;
    }

    public int getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(int idTratamento) {
        this.idTratamento = idTratamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDat_ini() {
        return dat_ini;
    }

    public void setDat_ini(Date dat_ini) {
        this.dat_ini = dat_ini;
    }

    public Date getDat_fim() {
        return dat_fim;
    }

    public void setDat_fim(Date dat_fim) {
        this.dat_fim = dat_fim;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public boolean isTerminou() {
        return terminou;
    }

    public void setTerminou(boolean terminou) {
        this.terminou = terminou;
    }

    @Override
    public String toString() {
        return "Tratamento{\nCódigo Tratamento: " + idTratamento
                + "\nid Animal: " + idAnimal
                + "\nTratamento: " + nome
                + "\nInício: " + dat_ini
                + "\nTérmino: " + dat_fim
                + "\nStatus: " + (terminou == true ? "Finalizado" : "Em andamento")
                + "\n}";
    }

}
