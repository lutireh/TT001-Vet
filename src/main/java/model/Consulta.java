/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Calendar;

/**
 *
 * @author Luiza Rehbein
 */
public class Consulta {
  private int id;
  private Calendar data;
  private Calendar hora;
  private int idAnimal;
  private int idVet;
  private int idCliente;
  private int idTratamento;

    public Consulta(int id, Calendar data, Calendar hora, int idAnimal, int idVet, int idCliente, int idTratamento) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.idAnimal = idAnimal;
        this.idVet = idVet;
        this.idCliente = idCliente;
        this.idTratamento = idTratamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
     public int getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(int idTratamento) {
        this.idTratamento= idTratamento;
    }
}
