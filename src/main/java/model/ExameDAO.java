
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
public class ExameDAO extends DAO{
     private static ExameDAO instance;

    private ExameDAO() {
        getConnection();
        createTable();
    }

    public static ExameDAO getInstance() {
        return (instance == null ? (instance = new ExameDAO()) : instance);
    }
    
    
    public Exame create(String tipo, String data, String hora, int idAnimal, int idVet, int idCliente) {
        try {
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO exame (tipo,data,hora,idAnimal,idVet,idCliente) VALUES (?,?,?,?,?,?)");
            pstm.setString(1,tipo);
            pstm.setString(2,data);
            pstm.setString(3,hora);
            pstm.setInt(4, idAnimal);
            pstm.setInt(5, idVet);
            pstm.setInt(6, idCliente);
            executeUpdate(pstm);

        } catch (SQLException e) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return this.retrieveById(lastId("exame","id"));
    }

    private Exame buildObject(ResultSet rs) {
        Exame exame = null;
        try {
            exame = new Exame(rs.getInt("id"), 
                    rs.getString("tipo"),
                    rs.getString("data"), 
                    rs.getString("hora"), 
                    rs.getInt("idAnimal"), 
                    rs.getInt("idVet"), 
                    rs.getInt("idCliente"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exame;
    }

    public List retrieve(String sql) {
        List<Exame> exames = new ArrayList();
        ResultSet rs = getResultSet(sql);

        try {
            while (rs.next()) {
                exames.add(buildObject(rs));
            }

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return exames;
    }

    public Exame retrieveById(int id) {
        List<Exame> exames = this.retrieve("SELECT * FROM exame WHERE id = " + id);
        return (exames.isEmpty() ? null : exames.get(0));
    }
    
    public List retrieveByTipo(String tipo){
        return this.retrieve("SELECT * FROM exame WHERE tipo LIKE '%" + tipo + "%'");
    }
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM exame");
    }
    
    
    public void update(Exame exame){
        PreparedStatement pstm;
        
        try {
            pstm = ExameDAO.getConnection().prepareStatement("UPDATE exame SET tipo=?, data=?, hora=?, idAnimal = ?, idVet=?, idCliente=? WHERE id=?");
            pstm.setString(1,exame.getTipo());
            pstm.setString(2,exame.getData());
            pstm.setString(3,exame.getHora());
            pstm.setInt(4,exame.getIdAnimal());
            pstm.setInt(5,exame.getIdVet());
            pstm.setInt(6,exame.getIdCliente());
            pstm.setInt(7,exame.getId());
            executeUpdate(pstm); 
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    public void delete(Exame exame){
        PreparedStatement pstm;
         try {
             pstm = ExameDAO.getConnection().prepareStatement("DELETE FROM exame WHERE id = ?");
             pstm.setInt(1,exame.getId());
             executeUpdate(pstm);
             
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}
