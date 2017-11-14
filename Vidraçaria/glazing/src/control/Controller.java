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
import local.persistence.nLocalPersistence;
import my.exceptions.FileCouldNotBeCreatetException;
import my.exceptions.FileDoesNotExistException;
import persons.Administrator;
import persons.Assembler;
import persons.Draftsman;
import persons.Driver;
import persons.LegalPerson;
import persons.PhysicalPerson;
import persons.Secretary;

public class Controller implements Serializable{

    //Maps
    private Map<String, Client> clients;
    private Map<String, Employee> employees;
    private Map<String, Project> projects;
    private Map<String, Vehicle> vehicles;
    private Map<String, Visit> visits;
    
    //Control Helpers
    private transient final ControlHelper<Client> helpCli = new ControlHelper<>();
    private transient final ControlHelper<Employee> helpEmp = new ControlHelper<>();
    private transient final ControlHelper<Project> helpProj= new ControlHelper<>();
    private transient final ControlHelper<Vehicle> helpVeh = new  ControlHelper<>();
    private transient final ControlHelper<Visit> helpVis = new ControlHelper<>();
    
    /**
     * Instantiates a new controller
     */
    public Controller() {
        this.clients = new TreeMap<>();
        this.employees = new TreeMap<>();
        this.projects = new TreeMap<>();
        this.vehicles = new TreeMap<>();
        this.visits = new TreeMap<>();
    }
    
    /**
     * Instantiates a new controller copying the parameters from other one
     * @param copy a controller
     */
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
     * @return a client map
     * @see Client
     */
    public Map<String, Client> getClients() {
        Map<String, Client> rsp = Collections.unmodifiableMap(this.clients);
        return rsp;
    }

    /**
     * Returns a unmodifiableMap of
     * @return  a map of employees
     */
    public Map<String,Employee> getEmployees() {
        Map<String,Employee> rsp = Collections.unmodifiableMap(this.employees);
        return rsp;
    }

    /**
     * Returns a unmodifiableMap of projects
     * @return a project map
     */
    public Map<String,Project> getProjects() {
        Map<String,Project> rsp = Collections.unmodifiableMap(this.projects);
        return rsp;
    }

    /**
     * Returns a unmodifiableMap of vehicles
     * @return a vehicle map
     */
    public Map<String,Vehicle> getVehicles() {
        Map<String,Vehicle> rsp = Collections.unmodifiableMap(this.vehicles);
        return rsp;
    }

    /**
     * Returns a unmodifiableMap of visits
     * @return a visit map
     */
    public Map<String,Visit> getVisits() {
        Map<String,Visit> rsp = Collections.unmodifiableMap(this.visits);
        return rsp;
    }
    
    /**
     * Returns a unmodifiableMap of drivers
     * @return a drivers map
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
     * Updates a Client using the old one's description
     * @param newCli a client
     * @param oldCliDescription a description
     * @return a boolean
     */
    public boolean update(Client newCli, String oldCliDescription){
        return helpCli.update(this.clients, oldCliDescription, newCli);
    }
    
    /**
     * Updates a employee using the old one's description
     * @param newEmp a employee 
     * @param oldEmpDescription a description
     * @return a boolean
     */
    public boolean update(Employee newEmp, String oldEmpDescription){
        return helpEmp.update(this.employees, oldEmpDescription, newEmp);
    }
    
    /**
     * Updates a Project using the old one's description
     * @param newProj a project
     * @param oldProjDescription a description
     * @return a boolean
     */
    public boolean update(Project newProj, String oldProjDescription){
        return helpProj.update(this.projects, oldProjDescription, newProj);
    }
    
    /**
     * Updates a Vehicle using the old one's description
     * @param newVeh a vehicle
     * @param oldVehDescription a description
     * @return a boolean
     */
    public boolean update(Vehicle newVeh, String oldVehDescription){
        return helpVeh.update(this.vehicles, oldVehDescription, newVeh);
    }
    
    /**
     * Updates a Visit using the old one's description
     * @param newVis a visit
     * @param oldVisDescription a description
     * @return a boolean
     */
    public boolean update(Visit newVis, String oldVisDescription){
        return helpVis.update(this.visits, oldVisDescription, newVis);
    }
    
    /*===================================================================*/
    /**
     * Persists the controller using default configurations
     * @return a boolean
     * @throws FileCouldNotBeCreatetException if the file could not be created
     */
    public boolean persistIt() throws FileCouldNotBeCreatetException{
        nLocalPersistence<Controller> pers = new nLocalPersistence<>();
        return pers.persist(this, "__MainController__");
    }
    
    /**
     * Loads the controller using default configurations
     * @return a controller
     */
    public static Controller loadIt(){
        nLocalPersistence<Controller> pers = new nLocalPersistence<>();
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

    public Map<String, Secretary> getSecretary() {
        Map<String,Secretary> secs = new TreeMap<>();
       
       
        Iterator it = this.employees.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            secs.put((String)pair.getKey(), (Secretary)pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
       
        Map<String, Secretary> rsp = Collections.unmodifiableMap(secs);
        return rsp;
    }

    public Map<String, Draftsman> getDraftsman() {
         Map<String,Draftsman> drafts = new TreeMap<>();
       
       
        Iterator it = this.employees.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            drafts.put((String)pair.getKey(), (Draftsman)pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
       
        Map<String, Draftsman> rsp = Collections.unmodifiableMap(drafts);
        return rsp;
    }
    
    public Map<String, LegalPerson> getLegalPerson() {
        Map<String,LegalPerson> lperson = new TreeMap<>();
       
       
        Iterator it = this.employees.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            lperson.put((String)pair.getKey(), (LegalPerson)pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
       
        Map<String, LegalPerson> rsp = Collections.unmodifiableMap(lperson);
        return rsp;
    }
    
    public Map<String, PhysicalPerson> getPhysicalPerson() {
        Map<String,PhysicalPerson> pperson = new TreeMap<>();
       
       
        Iterator it = this.employees.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            pperson.put((String)pair.getKey(), (PhysicalPerson)pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
       
        Map<String, PhysicalPerson> rsp = Collections.unmodifiableMap(pperson);
        return rsp;
    }

    public Map<String, Administrator> getAdministrator() {
        Map<String,Administrator> adm = new TreeMap<>();
       
       
        Iterator it = this.employees.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            adm.put((String)pair.getKey(), (Administrator)pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
       
        Map<String, Administrator> rsp = Collections.unmodifiableMap(adm);
        return rsp;
    }

    public Map<String, Assembler> getAssembler() {
        Map<String,Assembler> ass = new TreeMap<>();
       
       
        Iterator it = this.employees.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            ass.put((String)pair.getKey(), (Assembler)pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
       
        Map<String, Assembler> rsp = Collections.unmodifiableMap(ass);
        return rsp;
    }

    public Map<String, Driver> getDriver() {
        Map<String,Driver> drv = new TreeMap<>();
       
       
        Iterator it = this.employees.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            drv.put((String)pair.getKey(), (Driver)pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
       
        Map<String, Driver> rsp = Collections.unmodifiableMap(drv);
        return rsp;
    }
}
