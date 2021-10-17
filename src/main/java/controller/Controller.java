package controller;

import javax.swing.JLabel;
import javax.swing.JTable;
import model.Animal;
import model.Cliente;
import model.Consulta;
import model.EspecieDAO;
import model.Exame;
import model.Tratamento;
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

    public static void setSelected(Object selected) {
        if (selected instanceof Cliente) {
            selectedClient = (Cliente) selected;
            selectedClientLabel.setText(selectedClient.getNome());
            selectedAnimalLabel.setText("");
            selectedSpecieLabel.setText("");
        } else if (selected instanceof Animal) {
            selectedAnimal = (Animal) selected;
            selectedAnimalSpecie = EspecieDAO.getInstance().retrieveById(selectedAnimal.getId_especie()).getNome();
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
            default:
                break;
        }
    }

    public static void setLabelValues() {
        selectedClientLabel.setText(selectedClient.getNome());
        selectedAnimalLabel.setText(selectedAnimal.getNome());
        selectedSpecieLabel.setText(selectedAnimalSpecie);
    }
}
