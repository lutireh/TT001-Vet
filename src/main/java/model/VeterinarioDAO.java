
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luiza Rehbein
 */
public class VeterinarioDAO extends DAO{
     private static VeterinarioDAO instance;

    private VeterinarioDAO() {
        getConnection();
        createTable();
    }

    public static VeterinarioDAO getInstance() {
        return (instance == null ? (instance = new VeterinarioDAO()) : instance);
    }

    public Veterinario create(String nome, String telefone) {
        try {
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO veterinario"
                    + " (nome,telefone) VALUES (?,?)");
            pstm.setString(1, nome);
            pstm.setString(2, telefone);
            executeUpdate(pstm);

        } catch (SQLException e) {
            Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return this.retrieveById(lastId("veterinario", "id"));
    }

    private Veterinario buildObject(ResultSet rs) {
        Veterinario veterinario = null;
        try {
            veterinario = new Veterinario(rs.getInt("id"), rs.getString("nome"),rs.getString("telefone"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return veterinario;
    }

    public List retrieve(String query) {
        List<Veterinario> veterinarios = new ArrayList();
        ResultSet rs = getResultSet(query);

        try {
            while (rs.next()) {
                veterinarios.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return veterinarios;
    }

    public Veterinario retrieveById(int id) {
        List<Veterinario> veterinarios = this.retrieve("SELECT * FROM "
                + "veterinario WHERE id = " + id);
        return (veterinarios.isEmpty() ? null : veterinarios.get(0));
    }

    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM veterinario WHERE nome LIKE '%" + nome + "%'");
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM veterinario");
    }

    public void update(Veterinario veterinario) {
        PreparedStatement pstm;
        try {
            pstm = DAO.getConnection().prepareStatement("UPDATE veterinario "
                    + "SET nome=?, telefone=? WHERE id=?");
            pstm.setString(1, veterinario.getNome());
            pstm.setString(2, veterinario.getTelefone());
            pstm.setInt(3, veterinario.getId());
            executeUpdate(pstm);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Veterinario veterinario) {
        PreparedStatement pstm;
        try {
            pstm = VeterinarioDAO.getConnection().prepareStatement("DELETE FROM veterinario WHERE id = ?");
            pstm.setInt(1, veterinario.getId());
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
