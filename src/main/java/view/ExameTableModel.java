package view;

import java.util.List;
import model.Cliente;
import model.ClienteDAO;
import model.Animal;
import model.AnimalDAO;
import model.Veterinario;
import model.VeterinarioDAO;
import model.Exame;
import model.ExameDAO;


/**
 *
 * @author Luiza Rehbein
 */
public class ExameTableModel extends GenericTableModel {

    public ExameTableModel(List vDados) {
        super(vDados, new String[]{"tipo", "data", "hora","animal","veterinario","cliente"});
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
        Exame exame = (Exame) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return exame.getTipo();
            case 1:
                return exame.getData();
            case 2:
                return exame.getHora();
            case 3:
                Animal animal = AnimalDAO.getInstance().retrieveById(exame.getIdAnimal());
                if (animal != null) {
                    return animal.getNome();
                }
                return "";
            case 4:
                Veterinario vet = VeterinarioDAO.getInstance().retrieveById(exame.getIdVet());
                if (vet != null) {
                    return vet.getNome();
                }
                return "";
             case 5:
                Cliente cliente = ClienteDAO.getInstance().retrieveById(exame.getIdCliente());
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
        Exame exame = (Exame) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                exame.setTipo((String) aValue);
                break;
            case 1:
                exame.setData((String) aValue);
                break;
            case 2:
                exame.setHora((String) aValue);
                break;
            case 3:
                exame.setIdAnimal((int) aValue);
                break;
            case 4:
                exame.setIdVet((int) aValue);
                break;
            case 5:
                exame.setIdCliente((int) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }

        ExameDAO.getInstance().update(exame);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}