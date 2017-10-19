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
/**
 *
 * @author andre
 */
public class Glazing {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Administrator adm1 = new Administrator("Anyone", 0, 0, "Adamastor1", "e@mail.com", "EmptyStr");
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
        }
    }
}
