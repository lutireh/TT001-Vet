package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import model.Animal;
import model.Cliente;
import model.Consulta;
import model.Especie;
import model.Exame;
import model.Tratamento;
import model.Veterinario;
import javax.swing.JTable;
import model.AnimalDAO;
import model.ClienteDAO;
import model.ConsultaDAO;
import model.EspecieDAO;
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
   private static List<Animal> animal = new ArrayList<>();
   private static List<Especie> especies = new ArrayList<>();
   private static List<Tratamento> tratamento = new ArrayList<>();
   private static List<Veterinario> veterinario = new ArrayList<>();
   
    public static Animal getAnimal(int index) {
        return animal.get(index);
    }

    public static Especie getEspecie(int index) {
        return especies.get(index);
    }
   
    public static Cliente getCliente(int index) {
        return clientes.get(index);
    }
    
     public static Veterinario getVeterinario(int index) {
        return veterinario.get(index);
    }
    
    public static Tratamento getTratamento(int index) {
        return tratamento.get(index);
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
  
    public static void setSelected(Object selected){
        
        if(selected instanceof Cliente){
            selectedCliente = (Cliente) selected;
        }
        else if (selected instanceof Animal){
            selectedAnimal = (Animal) selected;
        }
        else if (selected instanceof Consulta){
            selectedConsulta = (Consulta) selected;
        }
        else if (selected instanceof Especie){
            selectedEspecie = (Especie) selected;
        }
        else if (selected instanceof Exame){
            selectedExame = (Exame) selected;
        }
        else if (selected instanceof Tratamento){
            selectedTratamento = (Tratamento) selected;
        }
        else if (selected instanceof Veterinario){
            selectedVet = (Veterinario) selected;
        }
         else if (selected instanceof Especie){
            selectedEspecie = (Especie) selected;
        }
    }
    
    public static void initializeComboBox(JComboBox combo, String type){
        combo.removeAllItems();
        if(type.equals("Cliente")){
            setComboBox(combo, ClienteDAO.getInstance().retrieveAll(),type);
        }
        else if(type.equals("Especie")){
            setComboBox(combo, EspecieDAO.getInstance().retrieveAll(),type);
        }
        else if(type.equals("Animal")){
             setComboBox(combo, AnimalDAO.getInstance().retrieveAll(),type);
        }
        else if(type.equals("Veterinario")){
             setComboBox(combo, VeterinarioDAO.getInstance().retrieveAll(),type);
        }
        else if(type.equals("Tratamento")){
             setComboBox(combo, TratamentoDAO.getInstance().retrieveAll(),type);
        }
        else if(type.equals("Sexo")){
            setComboBox(combo,new ArrayList<>(List.of("Femea","Macho","Indefinido")) ,"Sexo");
        }
            
    }
    
    private static void setComboBox(JComboBox combo, List<Object> objs,String type){
        
       switch (type) {
           case "Cliente":
               clientes.clear();
               for ( Object obj: objs){
                   combo.addItem(((Cliente)obj).getNome());
                   clientes.add((Cliente) obj);
               }      break;
           case "Especie":
               especies.clear();
               for ( Object obj: objs){
                   combo.addItem(((Especie)obj).getNome());
                   especies.add((Especie)obj);
               }      break;
           case "Animal":
               animal.clear();
               for(Object obj: objs){
                   combo.addItem(((Animal)obj).getNome());
                   animal.add((Animal) obj);
               }  break;
           case "Veterinario":
               for(Object obj: objs){
                   combo.addItem(((Veterinario)obj).getNome());
                   veterinario.add((Veterinario)obj);
               }  break;
           case "Tratamento":
               for(Object obj: objs){
                   combo.addItem(((Tratamento)obj).getNome());
                   tratamento.add((Tratamento)obj);
               }  break;
           case "Sexo":
               for(Object obj: objs){
                   combo.addItem(obj);
               }  break;
           default:
               break;
       }
        
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
  
    public static Animal criarAnimal( String nome, String dataNascimento, String sexo, String sintomas) {
        return AnimalDAO.getInstance().create(nome, dataNascimento, sexo, sintomas,selectedCliente.getId(),selectedEspecie.getId());
    }

    public static void deletarAnimal(JTable table) {
        AnimalDAO.getInstance().delete(selectedAnimal);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }

    public static Cliente criarCliente(String nome, String telefone, String endereco, String cep, String email) {
        return ClienteDAO.getInstance().create(nome, telefone, endereco, cep, email);
    }
    
    
    
     public static Especie criarEspecie(String nome) {
        return EspecieDAO.getInstance().create(nome);
    }
    
    public static void deletarCliente(JTable table) {
        ClienteDAO.getInstance().delete(selectedCliente);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }
    
    public static Consulta criarConsulta( String data, String hora) {
         return ConsultaDAO.getInstance().create( data, hora, selectedAnimal.getId(), selectedVet.getId(), selectedCliente.getId(), selectedTratamento.getId());
    }

    public static void deletarConsulta(JTable table) {
        ConsultaDAO.getInstance().delete(selectedConsulta);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }
    
     public static Exame criarExame(String tipo, String data, String hora) {
        return ExameDAO.getInstance().create(tipo, data, hora, selectedAnimal.getId(), selectedVet.getId(), selectedCliente.getId());
    }

    public static void deletarExame(JTable table) {
        ExameDAO.getInstance().delete(selectedExame);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }

    public static Tratamento criarTratamento(String nome, int consultas_realizadas, int total_consultas) {
        return TratamentoDAO.getInstance().create(nome, consultas_realizadas, total_consultas, selectedAnimal.getId(), selectedVet.getId(),selectedCliente.getId());
    }
    
    public static void deletarTratamento(JTable table) {
        TratamentoDAO.getInstance().delete(selectedTratamento);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }

    public static Veterinario criarVeterinario(String nome, String telefone) {
        return VeterinarioDAO.getInstance().create(nome, telefone);
    }
    
     public static void deletarVeterinario(JTable table) {
        VeterinarioDAO.getInstance().delete(selectedVet);
        ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
    }
}
