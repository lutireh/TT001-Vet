
package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiza Rehbein
 */
public class AnimalDAO extends DAO{
    
    private static AnimalDAO instance;
    
    private AnimalDAO(){
        getConnection();
        createTable();
    }
    
    //Singleton
    public static AnimalDAO getInstane(){
        return (instance == null ? (instance = new AnimalDAO()) : instance);
    }
    
    public Animal create(int id, String nome, Calendar data_nascimento, String sexo, String sintomas, int id_especie){
        try{
            PreparedStatement pstm;
            pstm = DAO.getConnection().prepareStatement("INSERT INTO animal"
            +" (id, nome, data_nascimento, sexo, sintomas,id_especie)"
            + "VALUES (?,?,?,?,?,?)");
            pstm.setInt(1,id);
            pstm.setString(2,nome);
            pstm.setDate(3, new Date(data_nascimento.getTimeInMillis()));
            pstm.setString(4,sexo);
            pstm.setString(5,sintomas);
            pstm.setInt(6,id_especie);
            executeUpdate(pstm);
                    
        }catch (SQLException e){
           Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
     return this.retrieveById(lastId("animal", "id"));   
    }
    
    private Animal buildObject(ResultSet rs){
        Animal animal = null;
        try{
          //  Calendar rs = Calendar.getInstance();
            
            animal = new Animal(rs.getInt("id"), 
                    rs.getString("nome"),
                    rs.setTime(rs.getDate(rs.getTimeInMillis("data_nascimento"))),
                    rs.getString("sexo"),
                    rs.getString("sintomas"),
                    rs.getInt("id_especie"));
            
        }catch (SQLException e){
           System.err.println("Exception: " + e.getMessage());
        }
        return animal;
    }
    
    public List retrieve(String query) {
        List<Animal> animais = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                animais.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animais;
    }
    
     public List retrieveAll() {
        return this.retrieve("SELECT * FROM animal");
    }

   /* public Animal retrieveById(int id) {
        List<Animal> animais = this.retrieve("SELECT * FROM animal WHERE id = " + id);
        return (animais.isEmpty() ? null : animais.get(0));
    }

    public List<Animal> retrieveByClientId(int id) {
        List<Animal> animais = this.retrieve("SELECT * FROM animal where id_cliente = " + id);

        return (animais.isEmpty() ? null : animais);
    }
    public List retrieveBySimilarName(String name,int id) {
        return this.retrieve("SELECT * FROM animal WHERE nome LIKE '%" + name + "%' AND id_especie = "+id);
    }

    public void update(Animal animal) {
        PreparedStatement pstm;
        try {
            pstm = DAO.getConnection().prepareStatement("UPDATE animal SET id=?, nome=?, data_nascimento=?,"
                    + "sexo=?, sintomas=?, id_especie=? WHERE id=?");
            pstm.setInt(1, animal.getId());
            pstm.setString(2, animal.getNome());
            pstm.setCalendar(3, animal.getData_nascimento());
            pstm.setString(4, animal.getSexo());
            pstm.setString(5, animal.getSintomas());
            pstm.setInt(6, animal.getId_especie());
            
            executeUpdate(pstm);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Animal animal) {
        PreparedStatement pstm;

        try {
            pstm = DAO.getConnection().prepareStatement("DELETE FROM animal WHERE id = ?");
            pstm.setInt(1, animal.getId());
            executeUpdate(pstm);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public List<Consulta> getLastAppointments(int id){
            return ConsultaDAO.getInstance().retrieve("SELECT * "
                    + "FROM consulta "
                    + "WHERE id_animal = "+id
                    + " LIMIT 5");
            
    }*/

    
}
