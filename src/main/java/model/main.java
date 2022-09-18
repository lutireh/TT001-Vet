
package model;

import controller.Controller;
import view.ClienteView;

/**
 *
 * @author Luiza Rehbein
 */
public class main {

    public static void main(String[] args) {
       ClienteDAO.getInstance().create("Luiza Rehbein","4999854447","Rua Lalalalala","89852128","luiza@gmail.com");
//       Cliente c2 = new Cliente(2,"Maria dos Santos","499154847","Rua dos Santos","8549878","maria@gmail.com");
//       Cliente c3 = new Cliente(3,"Lucas Filho","8979854447","Rua do Lucas","8854128","lucas@gmail.com");
//       Animal c2a1= new Animal(3,"Bellinha","25/06/2015","Feminino","Diarreia",1,1);
//       Animal c3a1= new Animal(4,"Nino","12/11/2005","Masculino","Não esta enxergando",1,1);
//       c2.addAnimal(c2a1);
//       c3.addAnimal(c3a1);
//       Controller.addClientes(c2);
//       Controller.addClientes(c3);
        System.out.println(ClienteDAO.getInstance().retrieveAll());
//       ClienteView view = new ClienteView();
//       view.mostrarMenu();
    }
    
}
