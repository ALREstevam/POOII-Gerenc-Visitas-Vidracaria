/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.time.helper;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * This class represents a interval of time holding two dates
 * @author andre
 */
public class DateTimeInterval implements Serializable{
    private LocalDateTime fromDate;
    private LocalDateTime toDate;

    /**
     * Constructor of this class
     * @param from the earliest date
     * @param to the most recent date 
     */
    public DateTimeInterval(LocalDateTime from, LocalDateTime to) {
        if(from.isAfter(to)){
            this.fromDate = to;
            this.toDate = from;
        }else{
            this.fromDate = from;
            this.toDate = to;
        }
    }

    /**
     * @return the earliest date
     */
    public LocalDateTime getFrom() {
        return fromDate;
    }

    /**
     * Sets the earliest date
     * @param from a date
     */
    public void setFrom(LocalDateTime from) {
        this.toDate = from;
    }

    /**
     * @return the most recent date 
     */
    public LocalDateTime getTo() {
        return toDate;
    }

    /**
     * Sets the most recent date 
     * @param to a date
     */
    public void setTo(LocalDateTime to) {
        this.toDate = to;
    }

    /**
     * Counts the difference of time between the dates in minutes
     * @return 
     */
    public long toMinutes(){
        return ChronoUnit.MINUTES.between(this.fromDate, this.toDate);
    }
    
    
    /**
     * Returs a string representing the interval object using brazilian format
     * @return a string representing the object
     */
    @Override
    public String toString() {
        //.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
        String dtFrom = this.fromDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"));
        String dtTo = this.toDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"));
        
        return String.format("TimeInterval{[%s] -> [%s]}", dtFrom, dtTo);
    }
    
    
    
}
