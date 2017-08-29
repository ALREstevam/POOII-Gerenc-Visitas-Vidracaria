/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glazing;

/**
 *
 * @author andre
 */
public class Employee {
    //ATTRIBUTES
    public enum employeeTypes{
        administrator, technician, manager, driver, assembler,
    }
    
    private String nome;
    private String cpf;
    private String telefone;
    private employeeTypes tipo;
    
    //CONSTRUCTOR
    public Employee(String nome, String cpf, employeeTypes tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipo = tipo;
    }
    
    //GETTERS AND SETTERS
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public employeeTypes getTipo() {
        return tipo;
    }

    public void setTipo(employeeTypes tipo) {
        this.tipo = tipo;
    }
    

    
}
