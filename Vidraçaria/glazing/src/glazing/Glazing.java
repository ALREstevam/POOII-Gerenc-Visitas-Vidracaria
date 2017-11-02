package glazing;

import control.Controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import local.persistence.LocalPersistence;
import local.persistence.LocalPersistenceV2;
import local.persistence.ObjectKeeper;
import my.exceptions.FileCouldNotBeCreatetException;
import my.exceptions.FileDoesNotExistException;
import visit.Vehicle;
import visit.Visit;
import my.time.agenda.AgendaAllocator;
import persons.Administrator;
import persons.Client;
import persons.Driver;
import persons.LegalPerson;
import persons.PhysicalPerson;
import view.jframes.MainJFrame;
import visit.Project;
/**
 *
 * @author andre
 */
public class Glazing {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Controller ctrl = new Controller(Controller.loadIt());
        
        Client[] clis = new Client[3];
        Driver[] drvs = new Driver[3];
        Project[] prjs = new Project[3];
        Vehicle[] vehs = new Vehicle[3];
        
        
        clis[0] = new PhysicalPerson(1, "Rua 1", "Adamastor", "ada@mastor", "123-456");
        clis[1] = new PhysicalPerson(2, "Rua 2", "Maria Antonieta", "ada@mastor", "123-456");
        clis[2] = new LegalPerson(3, "Unk", "Unk", "Rua 3", "Mastor Ado", "ada@mastor", "123-456");
        
        
        drvs[0] = new Driver(2, 123, 125, "Josué", "josu@e.josue", "Rua3");
        drvs[1] = new Driver(2, 123, 125, "Josefa", "josu@efa", "Rua3");
        drvs[2] = new Driver(2, 123, 125, "Cleusa", "cleu@sa", "Rua88");
        
        vehs[0] = new Vehicle(2, 3, "abc123", "Carro 5");
        vehs[1] = new Vehicle(3, 1, "def456", "Moto");
        vehs[2] = new Vehicle(3, 5, "ght886", "Caminhão");
        
        prjs[0] = new Project("Prj1", "D-prj1", null, clis[0]);
        prjs[1] = new Project("Prj2", "D-prj2", null, clis[2]);
        prjs[2] = new Project("Prj3", "D-prj3", null, clis[0]);

        
        for(Client cli : clis){
            ctrl.append(cli);
        }
        
        for(Driver drv : drvs){
            ctrl.append(drv);
        }
        
        for(Vehicle veh : vehs){
            ctrl.append(veh);
        }
        
        for(Project proj : prjs){
            ctrl.append(proj);
        }
        
        MainJFrame iniframe = new MainJFrame(ctrl);
        iniframe.setVisible(true);
        
        try {
            ctrl.persistIt();
        } catch (FileCouldNotBeCreatetException ex) {
            Logger.getLogger(Glazing.class.getName()).log(Level.SEVERE, null, ex);
        }    
            
            
            /* Administrator adm1 = new Administrator("Anyone", 0, 0, "Adamastor1", "e@mail.com", "EmptyStr");
            Administrator adm2 = new Administrator("Anyone", 0, 0, "Adamastor2", "e@mail.com", "EmptyStr");
            Administrator adm3 = new Administrator("Anyone", 0, 0, "Adamastor3", "e@mail.com", "EmptyStr");
            
            
            List<Administrator> adms = new ArrayList<>();
            adms.add(adm1);
            adms.add(adm2);
            adms.add(adm3);
            
            ObjectKeeper<ArrayList<Administrator> > persistor = new LocalPersistenceV2();
            
            System.out.println(LocalPersistenceV2.fNameIt(ArrayList.class, "adms"));
            
            try {
            persistor.persist((ArrayList<Administrator>) adms, "adms");
            } catch (FileCouldNotBeCreatetException ex) {
            Logger.getLogger(Glazing.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            List<Administrator> admr = new ArrayList<>();
            ObjectKeeper<ArrayList<Administrator>> persistor2 = new LocalPersistenceV2<>();
            
            try {
            admr.addAll(persistor2.load(ArrayList.class, "adms"));
            
            
            } catch (FileDoesNotExistException ex) {
            Logger.getLogger(Glazing.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(Administrator adm : admr){
            System.out.println(adm.getName());
            }*/
        
    }
}
