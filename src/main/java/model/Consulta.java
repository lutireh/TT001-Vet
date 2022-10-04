    
package model;


/**
 *
 * @author Luiza Rehbein
 */
public class Consulta {
  private int id;
  private String data;
  private String hora;
  private int idAnimal;
  private int idVet;
  private int idCliente;
  private int idTratamento;

    public Consulta(int id, String  data, String  hora, int idAnimal, int idVet, int idCliente, int idTratamento) {
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

    public String  getData() {
        return data;
    }

    public void setData(String  data) {
        this.data = data;
    }

    public String  getHora() {
        return hora;
    }

    public void setHora(String  hora) {
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
