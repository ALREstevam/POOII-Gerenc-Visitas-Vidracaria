package glazing;

import control.Controller;
import java.util.LinkedList;
import java.util.List;
import visit.Vehicle;
import visit.Visit;
import timeHlp.Agenda;

/**
 *
 * @author andre
 */
public class Glazing {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller ctrl = new Controller();
        
        Vehicle v1 = new Vehicle(0, "ABC");
        Vehicle v2 = new Vehicle(0, "DEF");
        
        Visit visA = new Visit("vis A");
        Visit visB = new Visit("vis B");
        Visit visC = new Visit("vis C");
        Visit visD = new Visit("vis D");
        
        System.out.println(v1.getAgenda().insert(visA, 3,  5));
        System.out.println(v1.getAgenda().insert(visB, 15, 2));
        
        System.out.println(v2.getAgenda().insert(visC, 8,  4));
        System.out.println(v2.getAgenda().insert(visD, 24, 3));
        System.out.println(v2.getAgenda().insert(visA, 5,  7));
        
        System.out.println(v1.getAgenda());
        System.out.println(v2.getAgenda());
        
        List<Agenda> tmr = new LinkedList<>();
        tmr.add(v1.getAgenda());
        tmr.add(v2.getAgenda());
        
        
        int addin = Agenda.findFirstMatchFit(tmr, 4);
        System.out.println(addin);
        
        addin = Agenda.findBestMatchFit(tmr, 4);
        System.out.println(addin);
    }
}
