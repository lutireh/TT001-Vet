
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

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
    
}
