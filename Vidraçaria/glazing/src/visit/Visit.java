package visit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persons.Driver;
import persons.Client;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

public class Visit implements Serializable, Descriptible, Arrayable{

    private Date start;
    private Date finish;
    private int status;
    private String description;
    private String name;
    private Project project;
    private List<Driver> visitor;
    private Client client;
    private Vehicle vehicle;

    public Visit(Date start, Date finish, String name, List<Driver> visitor, Client client, Vehicle vehicle) {
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
    
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
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
        return this.name + sep + this.start + sep + this.finish + this.client.getName() + sep + this.project.getTitle() + sep + this.status;
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        //Object[] rsp = Object[];
        return null;
    }
}
