package visit;

import agenda.neow.util.TimeUtil;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persons.Driver;
import persons.Client;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

/**
 * This is the Visit class. 
 * This class is responsible for the data regarding the technical visit
 * made to the client.  
 * @author Pedro
 */
public class Visit implements Serializable, Descriptible, Arrayable{

    private LocalDateTime start;
    private LocalDateTime finish;
    private int status;
    private String description;
    private String name;
    private Project project;
    private List<Driver> visitor;
    private Client client;
    private Vehicle vehicle;

    /**
     * This is the constructor of the Visit class. This constructor
     * has six parameters
     * @param start
     * @param finish
     * @param name
     * @param visitor
     * @param client
     * @param vehicle
     */
    public Visit(LocalDateTime start, LocalDateTime finish, String name, List<Driver> visitor, Client client, Vehicle vehicle) {
        this.start = start;
        this.finish = finish;
        this.name = name;
        this.visitor = visitor;
        this.client = client;
        this.vehicle = vehicle;
    }

    /**
     * This method set the Visit's name
     * @param name
     */
    public Visit(String name) {
        this.name = name;
    }
    
    /**
     *
     * @return
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     *
     * @param start
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getFinish() {
        return finish;
    }

    /**
     *
     * @param finish
     */
    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    /**
     *
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public Project getProject() {
        return project;
    }

    /**
     *
     * @param project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     *
     * @return
     */
    public List<Driver> getVisitor() {
        return visitor;
    }

    /**
     *
     * @param visitor
     */
    public void setVisitor(List<Driver> visitor) {
        this.visitor = visitor;
    }

    /**
     *
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     *
     * @return
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     *
     * @param vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String describe() {
        String cli = (this.getClient().getName() == null)? "null" : this.client.getName();
        String proj = (this.project == null || this.getProject().getTitle() == null) ? "null" : this.project.getTitle();
        String rsp = "";
        rsp = this.name + sep 
                + TimeUtil.toCompleteString(this.start) + sep
                + TimeUtil.toCompleteString(this.finish) + sep
                + proj + sep 
                + proj;
        return rsp;
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        Object[] rsp = new Object[4];

        int rspCount = 0;
        for (String s : order) {
                
                switch (s) {
                case "name:":
                    rsp[rspCount] = this.getName();
                    break;
                case "cliente:":
                    rsp[rspCount] = this.getClient();
                    break;
                case "vehicle":
                    rsp[rspCount] = this.getVehicle();
                    break;
                case "start data":
                    rsp[rspCount] = this.getStart().toCompleteString(start);
                    break;
                case "finish data":
                    rsp[rspCount] = this.toCompleteString(finish);
                    break;
                default:
                    rsp[rspCount] = "";
                    break;
            }
            rspCount++;
        }
        return rsp;
    }
     
    @Override
    public Object setValue(String variable, Object value) {
       switch (variable) {
            case "name":
                this.setName((String) value);
                break;
            case "cliente":
                this.client((String) value);
                break;
            case "vehicle":
                this.vehicle((String) value);
                break;    
            case "start data":
                this.start.
                break;
            case "finish data":
                this.finish.toCompleteString(finish);
                break;

            default:
                break;
        }
        return this;
    }
}