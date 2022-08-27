
package model;

import java.util.Calendar;

/**
 *
 * @author Luiza Rehbein
 */
public class Animal {
    private int id;
    private String nome;
    private Calendar data_nascimento;
    private char sexo;
    private String sintomas;
    private int idEspecie;

    public Animal(int id, String nome, Calendar data_nascimento, char sexo, String sintomas, int idEspecie) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.sintomas = sintomas;
        this.idEspecie = idEspecie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
     public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas= sintomas;
    } 
    
    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie= idEspecie;
    }
    
    
    @Override
    public String toString(){
        return "\nnome: "+this.nome;
    }
}
