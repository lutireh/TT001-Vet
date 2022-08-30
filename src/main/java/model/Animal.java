
package model;


/**
 *
 * @author Luiza Rehbein
 */
public class Animal {
    private int id;
    private String nome;
    private String data_nascimento;
    private String sexo;
    private String sintomas;
    private int idCliente;
    private int idEspecie;

    public Animal(int id, String nome, String data_nascimento, String sexo, String sintomas, int idCliente, int idEspecie) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.sintomas = sintomas;
        this.idCliente = idCliente;
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

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
     public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas= sintomas;
    } 
    
     public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
