package my.time.agenda;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import my.time.helper.DateTimeInterval;

/**
 * This class represents the content of a block of time
 * @author andre
 * @param <E> an object whoose represents a task
 */
public class TimeObj<E> implements Cloneable, Serializable{
    enum timeStatus {NOT_ALLOCATED, ALLOCATED, DO_NOT_ALLOCATE};
    private boolean consumed = false;
    private DateTimeInterval duration;
    
    private E task;
    private timeStatus status;

    /**
     * Constructor of the class
     * @param initDate the block start date 
     * @param endDate the block end date
     * @param task the task in the block
     * @param status the status of the block 
     */
    public TimeObj(LocalDateTime initDate, LocalDateTime endDate, E task, timeStatus status) {
        duration = new DateTimeInterval(initDate, endDate);
        this.task = task;
        this.status = status;
    }
    
    /**
     * Constructor of the class
     * @param initDate the block start date the block start date
     * @param endDate the block end date block end date
     * @param status the status of the block
     */
    public TimeObj(LocalDateTime initDate, LocalDateTime endDate, timeStatus status) {
        duration = new DateTimeInterval(initDate, endDate);
        this.status = status;
    }
    
    /**
     * Constructor of the class
     * @param initDate the block start date
     * @param endDate the block end date
     * @param status the status of the block
     * @param consumed marks if the block was already consumed
     */
    public TimeObj(LocalDateTime initDate, LocalDateTime endDate, timeStatus status, boolean consumed) {
        duration = new DateTimeInterval(initDate, endDate);
        this.status = status;
        this.consumed = consumed;
    }
    
    /**
     * Constructor of the class
     * @param initDate the block start date
     * @param endDate the block end date
     * @param status the status of the block
     * @param task the task in the block
     * @param consumed marks if the block was already consumed
     */
    public TimeObj(LocalDateTime initDate, LocalDateTime endDate, timeStatus status, E task, boolean consumed) {
        duration = new DateTimeInterval(initDate, endDate);
        this.status = status;
        this.consumed = consumed;
        this.task = task;
    }

    /**
     * Constructor of the class
     * @param task the task in the block
     * @param status the status of the block
     * @param consumed marks if the block was already consumed
     */
    public TimeObj(E task, timeStatus status, boolean consumed) {
        this.task = task;
        this.status = status;
        this.consumed = consumed;
    }
    
    /**
     * Constructor of the class
     * @param task the task in the block
     * @param status the status of the block 
     */
    public TimeObj(E task, timeStatus status) {
        this.task = task;
        this.status = status;
    }
    
    /**
     * Returns the sum of two status (only returns free if both blocks are free)
     * @param first
     * @param second
     * @return 
     */
    public static timeStatus sum(timeStatus first, timeStatus second){
        if(first == second){
            return first;
        }
        if(first == timeStatus.DO_NOT_ALLOCATE || second ==timeStatus.DO_NOT_ALLOCATE){
            return timeStatus.DO_NOT_ALLOCATE;
        }
        else if(first == timeStatus.ALLOCATED || second ==timeStatus.ALLOCATED){
            return timeStatus.ALLOCATED;
        }
        return timeStatus.DO_NOT_ALLOCATE;
    }

    /**
     * Sets the init date
     * @param initDate the block start date 
     */
    public void setInitDate(LocalDateTime initDate) {
        this.duration.setFrom(initDate);
    }

    /**
     * Sets the end date
     * @param endDate the block end date 
     */
    public void setEndDate(LocalDateTime endDate) {
        this.duration.setTo(endDate);
    }
    
    /**
     * Gets the interval in a duration object
     * @return 
     */
    public DateTimeInterval getDuration() {
        return duration;
    }

    /**
     * Sets the time using a duration object
     * @param duration 
     */
    public void setDuration(DateTimeInterval duration) {
        this.duration = duration;
    }

    
    /**
     * Gets the block init date
     * @return 
     */
    public LocalDateTime getInitDate() {
        return this.duration.getFrom();
    }

    /**
     * Gets the block end date
     * @return 
     */
    public LocalDateTime getEndDate() {
        return this.duration.getTo();
    }

    /**
     * Gets the task referenced by the block
     * @return 
     */
    public E getTask() {
        return task;
    }

    /**
     * Sets the task referenced by the block
     * @param task the task in the block 
     */
    public void setTask(E task) {
        this.task = task;
    }

    /**
     * Gets the status of the block
     * @return 
     */
    public timeStatus getStatus() {
        return status;
    }
    
    /**
     * Compares if the block is in the given status
     * @param sts
     * @return <code>true</code> only if the given and the object status are equal
     */
    public boolean hasStatus(timeStatus sts){
        return sts == this.status;
    }

    /**
     * Sets the status of the block
     * @param status the status of the block 
     */
    public void setStatus(timeStatus status) {
        this.status = status;
    }

    /**
     * Gets a boolean representing if the block was consumed
     * @return 
     */
    public boolean isConsumed() {
        return consumed;
    }

    /**
     * Sets the consumation of the block
     * @param consume 
     */
    public void setConsumed(boolean consume) {
        this.consumed = consume;
    }
    
    
    /**
     * Generates a hash code of the object
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.duration.getFrom());
        hash = 71 * hash + Objects.hashCode(this.duration.getTo());
        hash = 71 * hash + Objects.hashCode(this.task);
        hash = 71 * hash + Objects.hashCode(this.status);
        return hash;
    }

    /**
     * Compares two time objects
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimeObj<?> other = (TimeObj<?>) obj;
        if (!Objects.equals(this.task, other.task)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return this.task.equals(other.task);
    }

    /**
     * Clones the object
     * @return 
     */
    public TimeObj<E> getClone() {
        try {
            return (TimeObj<E>) this.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Returs a string representing the object
     * @return a string representing the object
     */
    @Override
    public String toString() {
        String statusInfo = this.task == null ? "null" : this.task.toString();
        String consumed = this.consumed ? "[X]" : "[_]";
        
        return String.format("TimeObj{value: %s, tconsumed: %s, status: %s}", statusInfo, consumed, getSmallName(this.status));
        
    }

    /**
     * Returns a shorthand name for the given status
     * @param status the status of the block
     * @return a string with a short name for the status
     */
    static String getSmallName(TimeObj.timeStatus status){
        switch(status){
            case ALLOCATED:
                return "ALLOCATED";
            case DO_NOT_ALLOCATE:
                return "BLOCKED";
            case NOT_ALLOCATED:
                return "FREE";
            default:
                return "";
        }   
    }
    
}
