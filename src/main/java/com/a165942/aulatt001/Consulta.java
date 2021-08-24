package com.a165942.aulatt001;

import java.util.Calendar;

public class Consulta {
    
    private int idTratamento;
    private int idVeterinario;
    private int idAnimal;
    private Calendar dataConsulta;
    private int hora;
    private String comentarios;
    private boolean terminou;

    public Consulta(int idTratamento, int idVeterinario, int idAnimal, Calendar dataConsulta, int hora, String comentarios, boolean terminou) {
        this.idTratamento = idTratamento;
        this.idVeterinario = idVeterinario;
        this.idAnimal = idAnimal;
        this.dataConsulta = dataConsulta;
        this.hora = hora;
        this.comentarios = comentarios;
        this.terminou = terminou;
    }
    
    


    
}