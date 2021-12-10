package view;

import java.util.Date;
import java.util.List;
import model.Tratamento;
import model.TratamentoDAO;

/**
 *
 * @author arthurgconti
 */
public class TratamentoTableModel extends GenericTableModel {

    public TratamentoTableModel(List vDados) {
        super(vDados, new String[]{"nome", "Data de início", "Data do término", "status"});

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return String.class;
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
            Tratamento tratamento = (Tratamento) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return tratamento.getNome();
            case 1:
                return tratamento.getDat_ini();
            case 2:
                return tratamento.getDat_fim();
            case 3:
                return tratamento.isTerminou() == true?"Finalizado":"Em andamento";

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Tratamento tratamento = (Tratamento) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                tratamento.setNome((String) aValue);
                break;
            case 1:
                tratamento.setDat_ini((String) aValue);
                break;
            case 2:
                tratamento.setDat_fim((String) aValue);
                break;
            case 3:
                  tratamento.setTerminou((Boolean) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }

        TratamentoDAO.getInstance().update(tratamento);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
