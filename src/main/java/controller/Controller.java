package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Consulta;
import model.EspecieDAO;
import model.Exame;
import model.Tratamento;
import model.TratamentoDAO;
import model.Veterinario;
import view.GenericTableModel;

/**
 *
 * @author arthurgconti
 */
public class Controller {

    /*
    constantes para lidar com a função clearSelection, basicamente limpar 
    a seleção quando da dispose em um jForm
     */
    public final static int TRATAMENTO = 0;
    public final static int CONSULTA = 1;
    public final static int VETERINARIO = 2;
    public final static int ANIMAL = 3;
    public final static int CLIENTE = 4;

    private static Cliente selectedClient = null;
    private static Animal selectedAnimal = null;
    private static String selectedAnimalSpecie = null;
    private static Tratamento selectedTreatment = null;
    private static Exame selectedExam = null;
    private static Consulta selectedAppointment = null;
    private static Veterinario selectedVet = null;

    private static JLabel selectedClientLabel = null;
    private static JLabel selectedAnimalLabel = null;
    private static JLabel selectedSpecieLabel = null;

    public static Cliente getSelectedClient() {
        return selectedClient;
    }

    public static Animal getSelectedAnimal() {
        return selectedAnimal;
    }

    public static Tratamento getSelectedTreatment() {
        return selectedTreatment;
    }

    public static Exame getSelectedExam() {
        return selectedExam;
    }

    public static Consulta getSelectedAppointment() {
        return selectedAppointment;
    }

    public static Veterinario getSelectedVet() {
        return selectedVet;
    }

    public static void setLabel(JLabel client, JLabel animal, JLabel specie) {
        selectedClientLabel = client;
        selectedAnimalLabel = animal;
        selectedSpecieLabel = specie;
    }

    public static void setTableModel(JTable table, GenericTableModel tableModel) {
        table.setModel(tableModel);
    }

    public static void atualizarClientesNomesParecidos(JTable table, String nome) {
        if (!nome.equals("")) {
            ((GenericTableModel) table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveBySimilarName(nome));
        } else {
            ((GenericTableModel) table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveAll());
        }
    }

    public static Cliente criarCliente(String nome, String endereco, String cep, String email, String telefone) {
        return ClienteDAO.getInstance().create(nome, endereco, cep, email, telefone);
    }

    public static void deletarCliente(JTable table) {
        ClienteDAO.getInstance().delete(selectedClient);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());

    }

    public static Animal criarAnimal(String nome, String anoNasc, String sexo) {
        return AnimalDAO.getInstance().create(nome, anoNasc, sexo, selectedClient.getId());
    }

    public static void deletarAnimal(JTable table) {
        AnimalDAO.getInstance().delete(selectedAnimal);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }
    
    public static void criarTratamento(String tratamento){
        TratamentoDAO.getInstance().create(selectedAnimal.getId()
                , tratamento, new SimpleDateFormat("dd/MM/yyyy").format(new Date()), "", 0);
    }

    public static void setSelected(Object selected) {
        if (selected instanceof Cliente) {
            selectedClient = (Cliente) selected;
            selectedClientLabel.setText(selectedClient.getNome());
            selectedAnimalLabel.setText("");
            selectedSpecieLabel.setText("");
        } else if (selected instanceof Animal) {
            selectedAnimal = (Animal) selected;

            if (selectedAnimal.getId_especie() != 0) {
                selectedAnimalSpecie = EspecieDAO.getInstance().retrieveById(selectedAnimal.getId_especie()).getNome();
            } else {
                selectedAnimalSpecie = "";
            }
            selectedAnimalLabel.setText(selectedAnimal.getNome());
            selectedSpecieLabel.setText(selectedAnimalSpecie);
        } else if (selected instanceof Tratamento) {
            selectedTreatment = (Tratamento) selected;
        }
    }

    public static void clearSelection(int option) {
        switch (option) {
            case TRATAMENTO:
                selectedTreatment = null;
                break;
            case VETERINARIO:
                selectedVet = null;
                break;
            case CONSULTA:
                selectedAppointment = null;
                break;
            case ANIMAL:
                selectedAnimal = null;
                selectedSpecieLabel.setText("");
                selectedAnimalLabel.setText("");
                break;
            case CLIENTE:
                selectedClient = null;
                selectedClientLabel.setText("");
                break;
            default:
                break;
        }
    }

    public static void setLabelValues() {
        selectedClientLabel.setText(selectedClient.getNome());
        selectedAnimalLabel.setText(selectedAnimal.getNome());
        selectedSpecieLabel.setText(selectedAnimalSpecie);
    }

    public static List getAppointmentsAnimal() {
        List lista = AnimalDAO.getInstance().getLastAppointments(selectedAnimal.getId());
        List listaString = new ArrayList();

        for (Object obj : lista) {
            listaString.add("Data: " + ((Consulta) obj).getDataConsulta() + " | Horário:" + ((Consulta) obj).getHora());
        }
        return listaString;
    }
}
