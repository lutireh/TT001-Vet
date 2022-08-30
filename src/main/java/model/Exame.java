
package model;


/**
 *
 * @author Luiza Rehbein
 */
public class Exame {
    private int id;
    private String tipo;
    private String data;
    private String hora;
    private int idAnimal;
    private int idVet;
    private int idCliente;

    public Exame(int id, String tipo, String data, String hora, int idAnimal, int idVet, int idCliente) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.hora = hora;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
