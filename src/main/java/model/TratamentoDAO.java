/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class TratamentoDAO extends DAO {

    private static TratamentoDAO instance;

    private TratamentoDAO() {
        getConnection();
        createTable();
    }

    public static TratamentoDAO getInstance() {
        return (instance == null ? (instance = new TratamentoDAO()) : instance);
    }

    public Tratamento create(int idAnimal, String nome, String dataIni,
            String dataFim, int terminado) {
        try {
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO tratamento"
                    + " (id_animal,nome,dataIni,dataFim,terminado) VALUES (?,?,?,?,?)");
            pstm.setInt(1, idAnimal);
            pstm.setString(2, nome);
            pstm.setString(3, dataIni);
            pstm.setString(4, dataFim);
            pstm.setInt(5, terminado);
            executeUpdate(pstm);

        } catch (SQLException e) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return this.retrieveById(lastId("tratamento", "id"));
    }

    private Tratamento buildObject(ResultSet rs) {
        Tratamento tratamento = null;
//        DateFormat formatter;
//        formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            boolean terminou = rs.getInt("terminado") == 1;
//            dataInicio = formatter.parse(rs.getString("dataIni"));
//            dataFim = formatter.parse(rs.getString("dataFim"));

            tratamento = new Tratamento(rs.getInt("id"), rs.getInt("id_animal"),
                    rs.getString("nome"), rs.getString("dataIni"), rs.getString("dataFim"), terminou);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
//        } catch (ParseException ex) {
//            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return tratamento;
    }

    public List retrieve(String sql) {
        List<Tratamento> tratamentos = new ArrayList();
        ResultSet rs = getResultSet(sql);

        try {
            while (rs.next()) {
                tratamentos.add(buildObject(rs));
            }

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return tratamentos;
    }

    public Tratamento retrieveById(int id) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM "
                + "tratamento WHERE id = " + id);
        return (tratamentos.isEmpty() ? null : tratamentos.get(0));
    }

    public Tratamento retrieveFirstByAnimalId(int id) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM "
                + "tratamento WHERE id_animal = " + id);
        return (tratamentos.isEmpty() ? null : tratamentos.get(0));
    }

    public List<Tratamento> retrieveAllByAnimalId(int id) {
        return this.retrieve("SELECT * FROM tratamento where id_animal = " + id);
    }

    public List retrieveBySimilarName(String name) {
        return this.retrieve("SELECT * FROM tratamento WHERE nome LIKE '%" + name + "%'");
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM tratamento");
    }

    public void update(Tratamento tratamento) {
        PreparedStatement pstm;

        try {
            pstm = TratamentoDAO.getConnection().prepareStatement("UPDATE tratamento "
                    + "SET id_animal=?, nome = ?, dataIni = ?, "
                    + "dataFim = ?, terminado = ? WHERE id = ?");
            pstm.setInt(1, tratamento.getIdAnimal());
            pstm.setString(2, tratamento.getNome());
            pstm.setString(3, "" + tratamento.getDat_ini());
            pstm.setString(4, "" + tratamento.getDat_fim());
            pstm.setInt(5, (tratamento.isTerminou() ? 1 : 0));
            pstm.setInt(6, tratamento.getIdTratamento());

            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Tratamento tratamento) {
        PreparedStatement pstm;
        try {
            pstm = TratamentoDAO.getConnection().prepareStatement("DELETE FROM tratamento WHERE id = ?");
            pstm.setInt(1, tratamento.getIdTratamento());
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void endTreatment(Tratamento tratamento) {
        PreparedStatement pstm;

        try {
            pstm = TratamentoDAO.getConnection().prepareStatement("UPDATE tratamento "
                    + "SET id_animal=?, nome = ?, dataIni = ?, "
                    + "dataFim = ?, terminado = ? WHERE id = ?");
            pstm.setInt(1, tratamento.getIdAnimal());
            pstm.setString(2, tratamento.getNome());
            pstm.setString(3, "" + tratamento.getDat_ini());
            pstm.setString(4, "" + tratamento.getDat_fim());
            pstm.setInt(5, 1);
            pstm.setInt(6, tratamento.getIdTratamento());

            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}
