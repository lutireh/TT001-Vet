
package model;

/**
 *
 * @author Luiza Rehbein
 */
public class Tratamento {
    private int id;
    private String nome;
    private int consultas_realizadas;
    private int total_consultas;
    private int idAnimal;
    private int idVet;
    private int idCliente;

    public Tratamento(int id, String nome, int consultas_realizadas, int total_consultas, int idAnimal, int idVet, int idCliente) {
        this.id = id;
        this.nome = nome;
        this.consultas_realizadas = consultas_realizadas;
        this.total_consultas = total_consultas;
        this.idAnimal = idAnimal;
        this.idVet = idVet;
        this.idCliente = idCliente;
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

    public int getConsultas_realizadas() {
        return consultas_realizadas;
    }

    public void setConsultas_realizadas(int consultas_realizadas) {
        this.consultas_realizadas = consultas_realizadas;
    }

    public int getTotal_consultas() {
        return total_consultas;
    }

    public void setTotal_consultas(int total_consultas) {
        this.total_consultas = total_consultas;
    }
    
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal= idAnimal;
    }
    
     public int getIdVet() {
        return idVet;
    }

    public void setIdVet(int idVet) {
        this.idVet= idVet;
    }
    
     public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente= idCliente;
    }
}
