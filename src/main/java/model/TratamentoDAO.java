
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
public class TratamentoDAO extends DAO{
     private static TratamentoDAO instance;

    private TratamentoDAO() {
        getConnection();
        createTable();
    }

    public static TratamentoDAO getInstance() {
        return (instance == null ? (instance = new TratamentoDAO()) : instance);
    }

    public Tratamento create(int id, String nome, int consultas_realizadas,
            int total_consultas, int idAnimal, int idVet, int idCliente) {
        try {
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO tratamento"
                    + " (nome,consultas_realizadas,total_consultas,idAnimal,idVet,idCLiente) VALUES (?,?,?,?,?,?)");
            pstm.setString(1, nome);
            pstm.setInt(2, consultas_realizadas);
            pstm.setInt(3, total_consultas);
            pstm.setInt(4, idAnimal);
            pstm.setInt(5, idVet);
            pstm.setInt(6, idCliente);
            executeUpdate(pstm);

        } catch (SQLException e) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return this.retrieveById(lastId("tratamento", "id"));
    }

    private Tratamento buildObject(ResultSet rs) {
        Tratamento tratamento = null;
        try {
            tratamento = new Tratamento(rs.getInt("id"), rs.getString("nome"),
            rs.getInt("consultas_realizadas"),rs.getInt("total_consultas"),rs.getInt("idAnimal"),
                    rs.getInt("idVet"),rs.getInt("idCliente"));

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return tratamento;
    }

    public List retrieve(String sql) {
        List<Tratamento> tratamentos = new ArrayList();
        ResultSet rs = getResultSet(sql);

        try {
            while (rs.next()) {
                tratamentos.add(buildObject(rs));
            }

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return tratamentos;
    }

    public Tratamento retrieveById(int id) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM "
                + "tratamento WHERE id = " + id);
        return (tratamentos.isEmpty() ? null : tratamentos.get(0));
    }

    public Tratamento retrieveFirstByAnimalId(int idAnimal) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM "
                + "tratamento WHERE idAnimal = " + idAnimal);
        return (tratamentos.isEmpty() ? null : tratamentos.get(0));
    }

    public List retrieveAllByAnimalId(int idAnimal) {
        return this.retrieve("SELECT * FROM tratamento where idAnimal = " + idAnimal);
    }

    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM tratamento WHERE nome LIKE '%" + nome + "%'");
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM tratamento");
    }

    public void update(Tratamento tratamento) {
        PreparedStatement pstm;

        try {
            pstm = TratamentoDAO.getConnection().prepareStatement("UPDATE tratamento "
                    + "SET id=?, nome = ?, consultas_realizadas = ?, "
                    + "total_consultas = ?, IdAnimal = ?, IdVet=?, IdCliente=? WHERE id = ?");
            pstm.setInt(1, tratamento.getId());
            pstm.setString(2, tratamento.getNome());
            pstm.setInt(1, tratamento.getConsultas_realizadas());
            pstm.setInt(1, tratamento.getTotal_consultas());
            pstm.setInt(1, tratamento.getIdAnimal());
            pstm.setInt(1, tratamento.getIdVet());
            pstm.setInt(1, tratamento.getIdCliente());
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Tratamento tratamento) {
        PreparedStatement pstm;
        try {
            pstm = TratamentoDAO.getConnection().prepareStatement("DELETE FROM tratamento WHERE id = ?");
            pstm.setInt(1, tratamento.getId());
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
