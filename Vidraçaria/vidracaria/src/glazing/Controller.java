/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glazing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class Controller {
    private final List<Client> clients;
    private final List<Employee> employees;
    private final List<Project> projects;
    private final List<Vehicle> vehicles;
    private final List<Visit> visits;
    

    public Controller() {
        this.clients = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.visits = new ArrayList<>();
    }
    
    /**
     * 
     * Adds the submitted object to the clients list 
     * @param client instance of Client class
     * @see Client
     */
    public void append(Client client){
        this.clients.add(client);
    }
    
    /**
     * 
     * Adds the submitted object to the employees list 
     * @param employee instance of Employee class
     * @see Employee
     */
    public void append(Employee employee){
        this.employees.add(employee);
    }
    
    /**
     * 
     * Adds the submitted object to the projects list 
     * @param project instance of Project class
     * @see Project
     */
    public void append(Project project){
        this.projects.add(project);
    }
    
    /**
     * 
     * Adds the submitted object to the vehicles list 
     * @param vehicle instance of Vehicle class
     * @see Vehicle
     */
    public void append(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }
    
    /**
     * 
     * Adds the submitted object to the visits list 
     * @param visit instance of Visit class
     * @see Visit
     */
    public void append(Visit visit){
        this.visits.add(visit);
    }
    
    /**
     * Removes the given object of clients list if it exists on it
     * @return <tt>true</tt> if the given object was found in clients list and successfully removed
     * @param client instance of class Client
     * @see Client
     */
   public boolean remove(Client client){
        return this.clients.remove(client);
    }
    
   /**
     * Removes the given object of employees list if it exists on it
     * @return <tt>true</tt> if the given object was found in employees list and successfully removed
     * @param employee instance of class Employee
     * @see Employee
     */
    public boolean remove(Employee employee){
        return this.employees.remove(employee);
    }
    
    /**
     * Removes the given object of projects list if it exists on it
     * @return <tt>true</tt> if the given object was found in projects list and successfully removed
     * @param project instance of class Project
     * @see Project
     */
    public boolean remove(Project project){
        return this.projects.remove(project);
    }
    
    /**
     * Removes the given object of vehicles list if it exists on it
     * @return <tt>true</tt> if the given object was found in vehicles list and successfully removed
     * @param vehicle instance of class Vehicles
     * @see Vehicle
     */
    public boolean remove(Vehicle vehicle){
        return this.vehicles.remove(vehicle);
    }
    
    /**
     * Removes the given object of visits list if it exists on it
     * @return <tt>true</tt> if the given object was found in visits list and successfully removed
     * @param visit instance of class Visit
     * @see Visit
     */
    public boolean remove(Visit visit){
        return this.visits.remove(visit);
    }    
}
