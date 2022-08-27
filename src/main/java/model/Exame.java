
package model;

import java.util.Calendar;

/**
 *
 * @author Luiza Rehbein
 */
public class Exame {
    private int id;
    private String tipo;
    private Calendar data;
    private Calendar hora;
    private int idAnimal;
    private int idVet;
    private int idCliente;

    public Exame(int id, String tipo, Calendar data, Calendar hora, int idAnimal, int idVet, int idCliente) {
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

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
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
