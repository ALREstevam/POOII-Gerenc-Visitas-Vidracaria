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
public class Visit {
    //ATTRIBUTES
    private Client client;
    private Employee[] employee;
    private Vehicle vehicle;
    private String subject;
    private String comments;
    private Project project;

    //CONSTRUCTOR
    public Visit(Client client, Employee[] employee, Vehicle vehicle) {
        this.client = client;
        this.employee = employee;
        this.vehicle = vehicle;
    }
    
    
    //GETTERS AND SETTERS
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee[] getEmployee() {
        return employee;
    }

    public void setEmployee(Employee[] employee) {
        this.employee = employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    
    
    
    
    
    
    
    
}
