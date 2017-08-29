/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glazing;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author andre
 */
public class Visit {

    public visitStates getState() {
        return state;
    }

    public void setState(visitStates state) {
        this.state = state;
    }
    //ATTRIBUTES
    public enum visitStates{
        scheduled, occurring, postponed, canceled, done
    }
    
    private Client client;
    private Employee[] employee;
    private Vehicle vehicle;
    private String subject;
    private String comments;
    private Project project;
    
    private LocalDateTime date;
    private Duration expectedVisitDuration;
    private Duration occurredVisitDuration;
    
    private visitStates state;
    
    

    //CONSTRUCTOR
    public Visit(Client client, Employee[] employee, Vehicle vehicle, LocalDateTime date, Duration expectedVisitDuration) {
        this.client = client;
        this.employee = employee;
        this.vehicle = vehicle;
        this.date = date;
        this.expectedVisitDuration = expectedVisitDuration;
        this.state = visitStates.scheduled;
    }

    //GETTERS AND SETTERS
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee[] getEmployee() {
        return employee;
    }

    public void setEmployee(Employee[] employee) {
        this.employee = employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Duration getExpectedVisitDuration() {
        return expectedVisitDuration;
    }

    public void setExpectedVisitDuration(Duration expectedVisitDuration) {
        this.expectedVisitDuration = expectedVisitDuration;
    }

    public Duration getOccurredVisitDuration() {
        return occurredVisitDuration;
    }

    public void setOccurredVisitDuration(Duration occurredVisitDuration) {
        this.occurredVisitDuration = occurredVisitDuration;
    }
    
    
}
