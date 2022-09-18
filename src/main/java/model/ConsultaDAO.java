
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
public class ConsultaDAO extends DAO{
   private static ConsultaDAO instance;
    
    private ConsultaDAO(){
        getConnection();
        createTable();
    }
    
    //Singleton
    public static ConsultaDAO getInstance(){
       return (instance == null ? (instance = new ConsultaDAO()) : instance);
    }
    
    public Consulta create(int id, String nome, String data, String hora, int idAnimal, int idVet, int idCliente, int idTratamento){
        try{
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO consulta"
            +" (nome, data, hora, idAnimal, idVet, id Cliente, idEspecie)"
            + "VALUES (?,?,?,?,?,?)");
            pstm.setString(1,data);
            pstm.setString(2,hora);
            pstm.setInt(3,idAnimal);
            pstm.setInt(4,idVet);
            pstm.setInt(5,idCliente);
            pstm.setInt(6,idTratamento);
            executeUpdate(pstm);
                    
        }catch (SQLException e){
           Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
     return this.retrieveById(lastId("consulta", "id"));   
    }
    
    private Consulta buildObject(ResultSet rs){
        Consulta consulta = null;
        try{
            consulta = new Consulta(rs.getInt("id"), 
                    rs.getString("data"),
                    rs.getString("hora"),
                    rs.getInt("idAnimal"),
                    rs.getInt("idVet"),
                    rs.getInt("idCliente"),
                    rs.getInt("idTratamento"));
            
        }catch (SQLException e){
           System.err.println("Exception: " + e.getMessage());
        }
        return consulta;
    }
    
    public List retrieve(String query) {
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consultas;
    }
    
     public List retrieveAll() {
        return this.retrieve("SELECT * FROM consulta");
    }

     public Consulta retrieveById(int id) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta WHERE id = " + id);
        return (consultas.isEmpty() ? null : consultas.get(0));
    }

    public List<Consulta> retrieveByClienteId(int idCliente) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta where id_cliente = " + idCliente);
        return (consultas.isEmpty() ? null : consultas);
    }
    
   public List<Consulta> retrieveByAnimalId(int idAnimal) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta where id_cliente = " + idAnimal);
        return (consultas.isEmpty() ? null : consultas);
    }
   
   public List<Consulta> retrieveByVetId(int idVet) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta where id_cliente = " + idVet);
        return (consultas.isEmpty() ? null : consultas);
    }
   
   public List<Consulta> retrieveByTratamentoId(int idTratamento) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta where id_cliente = " + idTratamento);
        return (consultas.isEmpty() ? null : consultas);
    }

    public void update(Consulta consulta) {
        PreparedStatement pstm;
        try {
            pstm = DAO.getConnection().prepareStatement("UPDATE consulta SET id=?, data=?, hora=?,"
                    + "idAnimal=?, idVet=?, idCliente=?, idTratamento=? WHERE id=?");
            pstm.setInt(1, consulta.getId());
            pstm.setString(2, consulta.getData());
            pstm.setString(3, consulta.getHora());
            pstm.setInt(4, consulta.getIdAnimal());
            pstm.setInt(5, consulta.getIdVet());
            pstm.setInt(6, consulta.getIdCliente());
            pstm.setInt(7, consulta.getIdTratamento());
            
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Consulta consulta) {
        PreparedStatement pstm;

        try {
            pstm = DAO.getConnection().prepareStatement("DELETE FROM consulta WHERE id = ?");
            pstm.setInt(1, consulta.getId());
            executeUpdate(pstm);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
}
