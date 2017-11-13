package glazing;

import agenda.neow.nowork.NoWorkPattern;
import agenda.neow.util.WeekDays;
import control.Controller;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.exceptions.FileCouldNotBeCreatetException;
import visit.Vehicle;
import persons.Client;
import persons.Driver;
import persons.LegalPerson;
import persons.PhysicalPerson;
import view.jframes.MainJFrame;
import visit.Project;
import agenda.neow.agenda.Agenda;
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
        
        clis[0] = new PhysicalPerson(1, "Rua 3", "Adamastor", "ada@mastor", "123-456");
        clis[1] = new PhysicalPerson(2, "Rua 2", "Maria Antonieta", "ada@mastor", "123-456");
        clis[2] = new LegalPerson(3, "Unk", "Unk", "Rua 3", "Mastor Ado", "ada@mastor", "123-456");
        
        
        //TODO: atualizar (criar agendas dos funcionários)
        
        
        NoWorkPattern nwp = new NoWorkPattern();
        
        
        nwp.appendPatternEveryDayWithFromTo(LocalTime.of(18, 0), LocalTime.of(6, 0));
        nwp.appendPatternEveryDayWithFromTo(LocalTime.of(0, 1), LocalTime.of(23, 59), WeekDays.WeekDaysEnum.SUNDAY);
        
        
        
        Agenda agd = new Agenda(nwp);
        
        drvs[0] = new Driver(2, 123, 125, "Josué", "josu@e.josue", "Rua3", agd);
        drvs[1] = new Driver(2, 123, 125, "Josefa", "josu@efa", "Rua3", agd);
        drvs[2] = new Driver(2, 123, 125, "Cleusa", "cleu@sa", "Rua88", agd);
        
        vehs[0] = new Vehicle(2, 3, "abc123", "Carro 5",agd);
        vehs[1] = new Vehicle(3, 1, "def456", "Moto", agd);
        vehs[2] = new Vehicle(3, 5, "ght886", "Caminhão",agd);
        
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

    }
}
