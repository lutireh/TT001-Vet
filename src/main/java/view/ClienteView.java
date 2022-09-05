
package view;

import controller.Controller;
import java.util.List;
import java.util.Scanner;
import model.Animal;
import model.Cliente;

/**
 *
 * @author Luiza Rehbein
 */
public class ClienteView {
    private List<Cliente> clientes;

    public ClienteView() {
        this.clientes = Controller.getClientes();
    }
    
    private void listarAnimais(int clienteEscolhido){
        List<Animal> animais = clientes.get(clienteEscolhido).getAnimais();
        for(Animal animal : animais){
            System.out.println(animal.getId()+"  " +animal.getNome());
            animal.toString();
        }
    }
    
    private void listarClientes(){
              for(Cliente cliente : clientes ){
            System.out.println(cliente.getId()+"  " +cliente.getNome());
        }
    }
    
    private int escolhaCliente(int escolhaCli){
        if(escolhaCli >= this.clientes.size()){
            System.out.println("Cliente inválido");
           return 0;
        }
        int escolha = escolhaCli-1;
            System.out.println(clientes.get(escolha).getId()+"  " +clientes.get(escolha).getNome());
            return escolha;
        }   
    
    public void mostrarMenu(){
        System.out.println("Todos os clientes\n");
        listarClientes();
        System.out.println("Escolha um dos clientes(pela id): ");
        Scanner scanner = new Scanner(System.in);
        int escolhaCli = scanner.nextInt();
        System.out.println("\nCliente escolhido\n");
        int clienteEscolhido = escolhaCliente(escolhaCli);
        System.out.println("\nTodos os animais do cliente escolhido\n");
        this.listarAnimais(clienteEscolhido);
        
    }
    
}
