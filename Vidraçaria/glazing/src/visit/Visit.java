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

    public Visit(LocalDateTime start, LocalDateTime finish, String name, List<Driver> visitor, Client client, Vehicle vehicle) {
        this.start = start;
        this.finish = finish;
        this.name = name;
        this.visitor = visitor;
        this.client = client;
        this.vehicle = vehicle;
    }

    public Visit(String name) {
        this.name = name;
    }
    
    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Driver> getVisitor() {
        return visitor;
    }

    public void setVisitor(List<Driver> visitor) {
        this.visitor = visitor;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

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
                case "título:":
                    rsp[rspCount] = this.getTitle();
                    break;
                case "descrição:":
                    rsp[rspCount] = this.getDescription();
                    break;
                case "arquivo:":
                    rsp[rspCount] = this.getFile();
                    break;
                case "cliente:":
                    rsp[rspCount] = this.client.getName();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
