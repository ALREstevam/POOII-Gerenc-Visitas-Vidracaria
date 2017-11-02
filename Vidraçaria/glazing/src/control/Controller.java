package control;

import com.sun.javafx.UnmodifiableArrayList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
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

    private Map<String, Client> clients;
    private Map<String, Employee> employees;
    private Map<String, Project> projects;
    private Map<String, Vehicle> vehicles;
    private Map<String, Visit> visits;
    
    
    private transient final ControlHelper<Client> helpCli = new ControlHelper<>();
    private transient final ControlHelper<Employee> helpEmp = new ControlHelper<>();
    private transient final ControlHelper<Project> helpProj= new ControlHelper<>();
    private transient final ControlHelper<Vehicle> hepVeh = new  ControlHelper<>();
    private transient final ControlHelper<Visit> helpVis = new ControlHelper<>();


    public Controller() {
        this.clients = new TreeMap<>();
        this.employees = new TreeMap<>();
        this.projects = new TreeMap<>();
        this.vehicles = new TreeMap<>();
        this.visits = new TreeMap<>();
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
        this.helpCli.insert(clients, client);
    }
    
    /**
     * 
     * Adds the submitted object to the employees list 
     * @param employee instance of Employee class
     * @see Employee
     */
    public void append(Employee employee){
        this.employees.put(employee.describe(),employee);
    }
    
    /**
     * 
     * Adds the submitted object to the projects list 
     * @param project instance of Project class
     * @see Project
     */
    public void append(Project project){
        this.projects.put(project.describe(),project);
    }
    
    /**
     * 
     * Adds the submitted object to the vehicles list 
     * @param vehicle instance of Vehicle class
     * @see Vehicle
     */
    public void append(Vehicle vehicle){
        this.vehicles.put(vehicle.describe(), vehicle);
    }
    
    /**
     * 
     * Adds the submitted object to the visits list 
     * @param visit instance of Visit class
     * @see Visit
     */
    public void append(Visit visit){
        this.visits.put(visit.describe(),visit);
    }
    
    /**
     * Removes the given object of clients list if it exists on it
     * @return <tt>true</tt> if the given object was found in clients list and successfully removed
     * @param client instance of class Client
     * @see Client
     */
   public boolean remove(Client client){
        return this.clients.remove(client.describe(),client);
    }
    
   /**
     * Removes the given object of employees list if it exists on it
     * @return <tt>true</tt> if the given object was found in employees list and successfully removed
     * @param employee instance of class Employee
     * @see Employee
     */
    public boolean remove(Employee employee){
         return this.employees.remove(employee.describe(), employee);
    }
    
    /**
     * Removes the given object of projects list if it exists on it
     * @return <tt>true</tt> if the given object was found in projects list and successfully removed
     * @param project instance of class Project
     * @see Project
     */
    public boolean remove(Project project){
        return this.projects.remove(project.describe(), project);
    }
    
    /**
     * Removes the given object of vehicles list if it exists on it
     * @return <tt>true</tt> if the given object was found in vehicles list and successfully removed
     * @param vehicle instance of class Vehicles
     * @see Vehicle
     */
    public boolean remove(Vehicle vehicle){
        return this.vehicles.remove(vehicle.describe(), vehicle);
    }
    
    /**
     * Removes the given object of visits list if it exists on it
     * @return <tt>true</tt> if the given object was found in visits list and successfully removed
     * @param visit instance of class Visit
     * @see Visit
     */
    public boolean remove(Visit visit){
        return this.visits.remove(visit.describe(), visit);
    }  

    /**
     * Returns a unmodifiableMap of clients
     * @return 
     * @see Client
     */
    public Map<String, Client> getClients() {
        Map<String, Client> rsp = Collections.unmodifiableMap(this.clients);
        return rsp;
    }

    /**
     * Returns a unmodifiableMap of
     * @return 
     */
    public Map<String,Employee> getEmployees() {
        Map<String,Employee> rsp = Collections.unmodifiableMap(this.employees);
        return rsp;
    }

    /**
     * Returns a unmodifiableMap of projects
     * @return 
     */
    public Map<String,Project> getProjects() {
        Map<String,Project> rsp = Collections.unmodifiableMap(this.projects);
        return rsp;
    }

    /**
     * Returns a unmodifiableMap of vehicles
     * @return 
     */
    public Map<String,Vehicle> getVehicles() {
        Map<String,Vehicle> rsp = Collections.unmodifiableMap(this.vehicles);
        return rsp;
    }

    /**
     * Returns a unmodifiableMap of visits
     * @return 
     */
    public Map<String,Visit> getVisits() {
        Map<String,Visit> rsp = Collections.unmodifiableMap(this.visits);
        return rsp;
    }
    
    /**
     * Returns a unmodifiableMap of drivers
     * @return 
     */
    public Map<String,Driver> getDrivers(){
        Map<String,Driver> drivers = new TreeMap<>();
       
       
        Iterator it = this.employees.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            drivers.put((String)pair.getKey(), (Driver)pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
       
        Map<String, Driver> rsp = Collections.unmodifiableMap(drivers);
        return rsp;
    }
    
    /**
     * Persists the controller using default configurations
     * @return
     * @throws FileCouldNotBeCreatetException 
     */
    public boolean persistIt() throws FileCouldNotBeCreatetException{
        LocalPersistenceV2<Controller> pers = new LocalPersistenceV2<>();
        return pers.persist(this, "__MainController__");
    }
    
    /**
     * Loads the controller using default configurations
     * @return 
     */
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
