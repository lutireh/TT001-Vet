/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiza Rehbein
 */
public abstract class DAO {
    public static final String DBURL = "jdbc:sqlite:vet2021.db";
    private static Connection con;
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
   
    //Conectando com o SQLite
    public static Connection getConnection(){
        if (con ==null){
            try{
                con = DriverManager.getConnection(DBURL);
                if(con != null){
                    DatabaseMetaData meta = con.getMetaData();
                }
            }catch (SQLException e){
                System.err.println("Exception "+ e.getMessage());
            }
        }
        return con;
    }
    
    protected ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;

        try {
            s = (Statement) con.createStatement();
            rs = s.executeQuery(query);

        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return rs;
    }
    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    protected int lastId(String tableName, String primaryKey) {
        Statement s;
        int lastId = -1;
        try {
            s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(" + primaryKey + ") AS id FROM " + tableName);
            if (rs.next()) {
                lastId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return lastId;
    }

    public static void terminar() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    protected final boolean createTable(){
        try{
            PreparedStatement stmt;
            
            //Tabela Cliente
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS cliente (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "nome VARCHAR, \n"
                    + "telefone VARCHAR,\n"
                    +"endereco VARCHAR,\n"
                    +"cep VARCHAR,\n"                    
                    +"email VARCHAR);\n");
            executeUpdate(stmt);
            
            //Tabela Animal
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS animal (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "nome VARCHAR, \n"
                    + "data_nascimento TEXT,\n"
                    +"sexo VARCHAR,\n"
                    +"sintomas VARCHAR,\n"
                    + "id_especie INT);\n");  
            executeUpdate(stmt);
                    
             //Tabela Consulta
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS consulta (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "data VARCHAR, \n"
                    + "hora TEXT);\n");  
            executeUpdate(stmt);
            
             //Tabela Consulta
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS especie (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "nome VARCHAR);\n");  
            executeUpdate(stmt);

             //Tabela Exame
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS exame (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "tipo VARCHAR, \n"
                    + "data VARCHAR, \n"
                    + "hora TEXT);\n"); 
            executeUpdate(stmt);
            
            //Tabela Tratamento
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS tratamento (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "nome VARCHAR, \n"
                    + "consultas_realizadas INTEGER, \n"
                    + "total_consultas INTEGER);\n"); 
            executeUpdate(stmt);
            
            //Tabela Veterinario
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS veterinario (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "nome VARCHAR, \n"
                    + "telefone VARCHAR);\n"); 
            executeUpdate(stmt);
            return true;
            
        }catch(SQLException ex){
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    }
}
