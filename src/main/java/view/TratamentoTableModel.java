package view;

import java.util.List;
import model.Cliente;
import model.ClienteDAO;
import model.Animal;
import model.AnimalDAO;
import model.Veterinario;
import model.VeterinarioDAO;
import model.Tratamento;
import model.TratamentoDAO;


/**
 *
 * @author Luiza Rehbein
 */
public class TratamentoTableModel extends GenericTableModel {

    public TratamentoTableModel(List vDados) {
        super(vDados, new String[]{"tipo", "consultas_realizadas", "total_consultas", "animal","veterinario","cliente"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return int.class;
            case 2:
                return int.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
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
                return tratamento.getConsultas_realizadas();
            case 2:
                return tratamento.getTotal_consultas();
            case 3:
                Animal animal = AnimalDAO.getInstance().retrieveById(tratamento.getIdAnimal());
                if (animal != null) {
                    return animal.getNome();
                }
                return "";
            case 4:
                Veterinario vet = VeterinarioDAO.getInstance().retrieveById(tratamento.getIdVet());
                if (vet != null) {
                    return vet.getNome();
                }
                return "";
             case 5:
                Cliente cliente = ClienteDAO.getInstance().retrieveById(tratamento.getIdCliente());
                if (cliente != null) {
                    return cliente.getNome();
                }
                return "";
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
                tratamento.setConsultas_realizadas((int) aValue);
                break;
            case 2:
                tratamento.setTotal_consultas((int) aValue);
                break;
            case 3:
                tratamento.setIdAnimal((int) aValue);
                break;
            case 4:
                tratamento.setIdVet((int) aValue);
                break;
            case 5:
                tratamento.setIdCliente((int) aValue);
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