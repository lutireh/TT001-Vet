package view;

import java.util.List;
import model.Animal;
import model.AnimalDAO;
import model.Especie;
import model.EspecieDAO;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author Luiza Rehbein
 */
public class AnimalTableModel extends GenericTableModel {

    public AnimalTableModel(List vDados) {
        super(vDados, new String[]{"nome", "data de nascimento", "sexo", "sintomas","cliente","espécie"});

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
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return animal.getNome();
            case 1:
                return animal.getData_nascimento();
            case 2:
                if (animal.getSexo().equals("m")) 
                    return "Macho";
                else if(animal.getSexo().equals("f"))
                    return "Fêmea";
                
                return "";
             case 3:
                return animal.getSintomas();
             case 4:
                Cliente cliente = ClienteDAO.getInstance().retrieveById(animal.getIdCliente());
                if (cliente != null) {
                    return cliente.getNome();
                }
                return "";
            case 5:
                if(animal.getIdEspecie()==0)
                    return "";
                Especie especie= EspecieDAO.getInstance().retrieveById(animal.getIdEspecie());
                if (especie != null) {
                    return especie.getNome();
                }
                return "";

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                animal.setNome((String) aValue);
                break;
            case 1:
                animal.setData_nascimento((String) aValue);
                break;
            case 2:
                animal.setSexo((String) aValue);
                break;
            case 3:
                 animal.setSintomas((String) aValue);
                break;
            case 4:
                animal.setIdCliente((int) aValue);
                break;
            case 5:
                 animal.setIdEspecie((int) aValue);
                 break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }

        AnimalDAO.getInstance().update(animal);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}