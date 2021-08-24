package com.a165942.aulatt001;

public class Exame {
    private int idExame;
    private String desExame;

    public Exame(int idExame, String desExame) {
        this.idExame = idExame;
        this.desExame = desExame;
    }

    

    public String getDesExame() {
        return desExame;
    }

    public void setDesExame(String desExame) {
        this.desExame = desExame;
    }

    public int getIdExame() {
        return idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }
    
}