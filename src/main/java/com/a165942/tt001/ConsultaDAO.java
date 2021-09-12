/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a165942.tt001;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arthurgconti
 */
public class ConsultaDAO extends DAO {

    private static ConsultaDAO instance;

    private ConsultaDAO() {
        getConnection();
        createTable();
    }

    public static ConsultaDAO getInstance() {
        return (instance == null ? (instance = new ConsultaDAO()) : instance);
    }

    public Consulta create(String data, String horario, String comentario,
            int idAnimal, int idVet, int idTratamento, int terminado) {
        try {
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO consulta"
                    + " (data,horario,comentario,id_animal,id_vet,id_tratamento,"
                    + "terminado) "
                    + "VALUES (?,?,?,?,?,?,?)");
            pstm.setString(1, data);
            pstm.setString(2, horario);
            pstm.setString(3, comentario);
            pstm.setInt(4, idAnimal);
            pstm.setInt(5, idVet);
            pstm.setInt(6, idTratamento);
            pstm.setInt(7, terminado);
            executeUpdate(pstm);

        } catch (SQLException e) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return this.retrieveById(lastId("consulta", "id"));
    }

    private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        DateFormat formatter;
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data;

        try {
            boolean terminou = rs.getInt("terminado") == 1;
            data = (Date) formatter.parse(rs.getString("data"));

            consulta = new Consulta(rs.getInt("id"), rs.getInt("id_tratamento"),
                    rs.getInt("id_vet"), rs.getInt("id_animal"),
                    data, rs.getString("horario"), rs.getString("comentario"), terminou);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return consulta;
    }

    public List retrieve(String sql) {
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet(sql);

        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return consultas;
    }

    public Consulta retrieveById(int id) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM "
                + "consulta WHERE id = " + id);
        return (consultas.isEmpty() ? null : consultas.get(0));
    }

    public Consulta retrieveByAnimalId(int idAnimal) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM "
                + "consulta WHERE id_animal = " + idAnimal);
        return (consultas.isEmpty() ? null : consultas.get(0));
    }

    public Consulta retrieveByVetId(int idVet) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM "
                + "consulta WHERE id_vet = " + idVet);
        return (consultas.isEmpty() ? null : consultas.get(0));
    }

    public Consulta retrieveByTreatmentId(int idTreatment) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM "
                + "consulta WHERE id_tratamento = " + idTreatment);
        return (consultas.isEmpty() ? null : consultas.get(0));
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM consulta");
    }

    public List retrieveAllByAnimalId(int idAnimal) {
        return this.retrieve("SELECT * FROM "
                + "consulta WHERE id_animal = " + idAnimal);

    }

    public List retrieveAllByVetId(int idVet) {
        return this.retrieve("SELECT * FROM "
                + "consulta WHERE id_vet = " + idVet);

    }

    public List retrieveAllByTreatmentId(int idTreatment) {
        return this.retrieve("SELECT * FROM "
                + "consulta WHERE id_tratamento = " + idTreatment);

    }

    public void update(Consulta consulta) {
        PreparedStatement pstm;

        try {
            pstm = ConsultaDAO.getConnection().prepareStatement("UPDETE consulta "
                    + "SET data=?, horario = ?, comentario = ?, "
                    + "id_animal = ?, id_vet = ?,"
                    + "id_tratamento, terminado = ? WHERE id = ?");
            pstm.setString(1, "" + consulta.getDataConsulta());
            pstm.setString(2, consulta.getHora());
            pstm.setString(3, consulta.getComentario());
            pstm.setInt(4, consulta.getIdAnimal());
            pstm.setInt(5, consulta.getIdVeterinario());
            pstm.setInt(6,consulta.getIdTratamento());
            pstm.setInt(7, (consulta.isTerminou() ? 1 : 0));
            pstm.setInt(8, consulta.getIdConsulta());

            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Consulta consulta) {
        PreparedStatement pstm;
        try {
            pstm = ConsultaDAO.getConnection().prepareStatement("DELETE FROM consulta WHERE id = ?");
            pstm.setInt(1, consulta.getIdConsulta());
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}
