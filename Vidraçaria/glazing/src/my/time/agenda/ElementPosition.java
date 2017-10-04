/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.time.agenda;

import java.io.Serializable;

/**
 * This class holds a position of some element in some list
 * @author andre
 */
public class ElementPosition implements Comparable<ElementPosition>, Serializable{
    private Integer position;
    private Integer value;

    /**
     * Constructor for the class
     * @param position the first position in the 
     * @param value how many blocks from the first are used
     */
    public ElementPosition(Integer position, Integer value) {
        this.position = position;
        this.value = value;
    }

    /**
     * Returns the position
     * @return the position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Sets the position
     * @param position 
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * Gets the amount of blocks used
     * @return amount of blocks used
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Sets the amount of blocks used
     * @param value 
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Returs a string representing the interval object
     * @return a string representing the object
     */
    @Override
    public String toString() {
        return "Position{" + "position:" + position + ", value:" + value + "}";
    }
    
    public void set(Integer position, Integer value){
        this.position = position;
        this.value = value;
    }

    /**
     * Compare two positions
     * @param otherPosition
     * @return 
     */
    @Override
    public int compareTo(ElementPosition otherPosition) {
        if(this.value > otherPosition.getValue()){
            return 1;
        }else if(this.value < otherPosition.getValue()){
            return -1;
        }else{
            if(this.value > otherPosition.getValue()){
                return 1;
            }else{
                return -1;
            }
        }
    }
}