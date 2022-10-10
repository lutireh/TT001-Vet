package view;

import java.util.List;
import model.Cliente;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;
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
public class ConsultaTableModel extends GenericTableModel {

    public ConsultaTableModel(List vDados) {
        super(vDados, new String[]{"data", "hora", "animal","veterinario","cliente","tratamento"});
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
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return consulta.getData();
            case 1:
                return consulta.getHora();
            case 2:
                Animal animal = AnimalDAO.getInstance().retrieveById(consulta.getIdAnimal());
                if (animal != null) {
                    return animal.getNome();
                }
                return "";
            case 3:
                Veterinario vet = VeterinarioDAO.getInstance().retrieveById(consulta.getIdVet());
                if (vet != null) {
                    return vet.getNome();
                }
                return "";
             case 4:
                Cliente cliente = ClienteDAO.getInstance().retrieveById(consulta.getIdCliente());
                if (cliente != null) {
                    return cliente.getNome();
                }
                return "";
             case 5:
                Tratamento tratamento = TratamentoDAO.getInstance().retrieveById(consulta.getIdTratamento());
                if (tratamento != null) {
                    return tratamento.getNome();
                }
                return ""; 
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                consulta.setData((String) aValue);
                break;
            case 1:
                consulta.setHora((String) aValue);
                break;
            case 2:
                consulta.setIdAnimal((int) aValue);
                break;
            case 3:
                consulta.setIdVet((int) aValue);
                break;
            case 4:
                consulta.setIdCliente((int) aValue);
                break;
            case 5:
                consulta.setIdTratamento((int) aValue);
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