package view;

import java.util.List;
import model.Veterinario;
import model.VeterinarioDAO;

/**
 *
 * @author Luiza Rehbein
 */
public class VeterinarioTableModel extends GenericTableModel {

    public VeterinarioTableModel(List vDados) {
        super(vDados, new String[]{"nome", "telefone"});
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veterinario vet = (Veterinario) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return vet.getNome();
            case 1:
                return vet.getTelefone();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         Veterinario vet = (Veterinario) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                vet.setNome((String) aValue);
                break;
            case 1:
                vet.setTelefone((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }

        VeterinarioDAO.getInstance().update(vet);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}