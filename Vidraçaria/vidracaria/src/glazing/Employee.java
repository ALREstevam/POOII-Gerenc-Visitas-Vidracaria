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
    
    public enum employeeTypes{
        administrator, technician, manager, driver, assembler,
    }
    
    private String nome;
    private String cpf;
    private String telefone;
    private employeeTypes tipo;

    
}
