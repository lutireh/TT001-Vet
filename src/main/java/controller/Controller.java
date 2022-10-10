
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Animal;
import model.Cliente;
import model.Consulta;
import model.Especie;
import model.Exame;
import model.Tratamento;
import model.Veterinario;
import view.ExameCadastro;
import view.TratamentoCadastro;
import javax.swing.JTable;
import model.AnimalDAO;
import model.ClienteDAO;
import model.ConsultaDAO;
import model.ExameDAO;
import model.TratamentoDAO;
import model.VeterinarioDAO;
import view.GenericTableModel;


/**
 *
 * @author Luiza Rehbein
 */
public class Controller {
   private static List<Cliente> clientes = new ArrayList<>();
    public static List<Cliente> getClientes(){
       return Controller.clientes;
   }

    public static void addClientes(Cliente cliente) {
        Controller.clientes.add(cliente);
    }
   private static Cliente selectedCliente = null; 
   private static Animal selectedAnimal = null;
   private static Consulta selectedConsulta = null;
   private static Especie selectedEspecie = null;
   private static Exame selectedExame = null;
   private static Tratamento selectedTratamento = null;
   private static Veterinario selectedVet  = null;
  
   
    public static void setTableModel(JTable table, GenericTableModel tableModel) {
        table.setModel(tableModel);
    }
  
    public static Animal getSelectedAnimal(){
      return selectedAnimal;
    }
    
    public static Cliente getSelectedCliente(){
      return selectedCliente;
    }
     
    public static Consulta getSelectedConsulta(){
      return selectedConsulta;
    }
  
    public static Especie getSelectedEspecie(){
      return selectedEspecie;
    }
  
    public static Exame getSelectedExame(){
      return selectedExame;
    }
  
    public static Tratamento getSelectedTratamento(){
      return selectedTratamento;
    }
  
    public static Veterinario getSelectedVet(){
      return selectedVet;
    }
  
    public static Animal criarAnimal(int id, String nome, String dataNascimento, String sexo, String sintomas) {
        return AnimalDAO.getInstance().create(id, nome, dataNascimento, sexo, sintomas,selectedCliente.getId(),selectedEspecie.getId());
    }

    public static void deletarAnimal(JTable table) {
        AnimalDAO.getInstance().delete(selectedAnimal);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }

    public static Cliente criarCliente(String nome, String telefone, String endereco, String cep, String email) {
        return ClienteDAO.getInstance().create(nome, telefone, endereco, cep, email);
    }

    public static void deletarCliente(JTable table) {
        ClienteDAO.getInstance().delete(selectedCliente);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }
    
    public static Consulta criarConsulta(int id, String data, String hora) {
         return ConsultaDAO.getInstance().create(id, data, hora, selectedAnimal.getId(), selectedVet.getId(), selectedCliente.getId(), selectedTratamento.getId() );
    }

    public static void deletarConsulta(JTable table) {
        ConsultaDAO.getInstance().delete(selectedConsulta);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }
    
     public static Exame criarExame(int id, String tipo, String data, String hora) {
        return ExameDAO.getInstance().create(id, tipo, data, hora, selectedAnimal.getId(), selectedVet.getId(), selectedCliente.getId());
    }

    public static void deletarExame(JTable table) {
        ExameDAO.getInstance().delete(selectedExame);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }

    public static Tratamento criarTratamento(int id, String nome, int consultas_realizadas, int total_consultas) {
        return TratamentoDAO.getInstance().create(id, nome, consultas_realizadas, total_consultas, selectedAnimal.getId(), selectedVet.getId(),selectedCliente.getId());
    }

    public static Veterinario criarVeterinario(int id, String nome, String telefone) {
        return VeterinarioDAO.getInstance().create(id, nome, telefone);
    }
    
     public static void deletarVeterinario(JTable table) {
        VeterinarioDAO.getInstance().delete(selectedVet);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }
}
