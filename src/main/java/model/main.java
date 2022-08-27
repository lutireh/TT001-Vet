
package model;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Luiza Rehbein
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente c1 = new Cliente(1,"Luiza", "199999999", "12332-123", "luiza123@gmail.com");
        Animal a1 = new Animal(1, "Luffy", Calendar.getInstance(), 'M',"Mancando",1);
        Animal a2 = new Animal(2, "Amendoim", Calendar.getInstance(), 'M',"Sono demais",1);
        
        c1.addAnimal(a1);
        c1.addAnimal(a2);
        
        System.out.println(c1);
        
        List<Animal> listaExterna = c1.getAnimais();
        Animal a3 = new Animal(3,"  ",Calendar.getInstance(),' '," ",1);
        listaExterna.add(a3);
        System.out.println(c1);
    }
    
}
