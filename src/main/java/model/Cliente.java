

package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiza Rehbein
 */
public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String cep;
    private String email;
    private final List animais;
    
    public Cliente(int id, String nome, String telefone, String cep, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cep = cep;
        this.email = email;
        this.animais = new ArrayList<Animal>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void addAnimal(Animal animal){
        if(!animal.getNome().isBlank()){
            animais.add(animal);
        }
    }
    
    public List<Animal> getAnimais(){
        List<Animal> copia = new ArrayList(animais);
        return copia;
    }
    
    @Override
    public String toString() {
        String desc = "Cliente{" + "nome= " + nome + ",telefone " + telefone + ", CEP " + cep + "email " + email+"}";
        return desc + "\nAnimais{" + animais.toString()+"\n}";
    }
}
