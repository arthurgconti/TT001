/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Date;
import java.util.List;
import model.Consulta;
import model.ConsultaDAO;

/**
 *
 * @author arthurgconti
 */
public class ConsultaTableModel extends GenericTableModel {

    public ConsultaTableModel(List vDados) {
        super(vDados, new String[]{"data", "horário", "comentário", "status"});

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return Date.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return consulta.getDataConsulta();
            case 1:
                return consulta.getHora();
            case 2:
                return consulta.getComentario();
            case 3:
                return consulta.isTerminou() == true?"Realizada":"Marcada";

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                consulta.setDataConsulta((Date) aValue);
                break;
            case 1:
                consulta.setHora((String) aValue);
                break;
            case 2:
                consulta.setComentario((String) aValue);
                break;
            case 3:
                  consulta.setTerminou((Boolean) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }

        ConsultaDAO.getInstance().update(consulta);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
