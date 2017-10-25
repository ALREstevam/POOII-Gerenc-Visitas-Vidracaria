package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persons.Employee;
import persons.Client;
import visit.Visit;
import visit.Vehicle;
import visit.Project;
import local.persistence.LocalPersistenceV2;
import my.exceptions.FileCouldNotBeCreatetException;
import my.exceptions.FileDoesNotExistException;
import persons.Driver;

public class Controller implements Serializable{

    private List<Client> clients;
    private List<Employee> employees;
    private List<Project> projects;
    private List<Vehicle> vehicles;
    private List<Visit> visits;
    

    public Controller() {
        this.clients = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.visits = new ArrayList<>();
    }
    
    public Controller(Controller copy) {
        this();
        this.clients = copy.clients;
        this.employees = copy.employees;
        this.projects = copy.projects;
        this.vehicles = copy.vehicles;
        this.visits = copy.visits;
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

    public List<Client> getClients() {
        List<Client> rsp = new ArrayList<>(this.clients.size());
        Collections.copy(rsp, this.clients);
        return rsp;
    }

    public List<Employee> getEmployees() {
        //ArrayList <Integer> numbersCopy = new ArrayList<Integer>(numbers);
        
        ArrayList<Employee> rsp = new ArrayList<Employee>(this.employees.size());
        //Collections.copy(rsp, this.employees);
        
        
        return rsp;
    }

    public List<Project> getProjects() {
        List<Project> rsp = new ArrayList<>(this.projects.size());
        Collections.copy(rsp, this.projects);
        return rsp;
    }

    public List<Vehicle> getVehicles() {
        List<Vehicle> rsp = new ArrayList<>(this.vehicles.size());
        Collections.copy(rsp, this.vehicles);
        return rsp;
    }

    public List<Visit> getVisits() {
        List<Visit> rsp = new ArrayList<>(this.visits.size());
        Collections.copy(rsp, this.visits);
        return rsp;
    }
    
    public List<Driver> getDrivers(){
        List<Driver> drivers = new ArrayList<>();
        
        for(Employee e : this.employees){
            if(e instanceof Driver){
                drivers.add((Driver) e);
            }
        }
        
        List<Driver> rsp = new ArrayList<>(drivers.size());
        Collections.copy(rsp, drivers);
        return rsp;
    }
    
    public boolean persistIt() throws FileCouldNotBeCreatetException{
        LocalPersistenceV2<Controller> pers = new LocalPersistenceV2<>();
        return pers.persist(this, "__MainController__");
    }
    
    public static Controller loadIt(){
        LocalPersistenceV2<Controller> pers = new LocalPersistenceV2<>();
        Controller aux;
        try {
            return pers.load(Controller.class, "__MainController__");//There is a file to be loaded and become a controller object
        } catch (FileDoesNotExistException ex) {
            Controller ctrl =  new Controller();//Thre is no file to be loaded, just load a empty controller
            try {
                pers.persist(ctrl, "__MainController__");
            } catch (FileCouldNotBeCreatetException ex1) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex1);
                System.exit(-1);
            }
            return ctrl;
        }
    }
    
    
}
