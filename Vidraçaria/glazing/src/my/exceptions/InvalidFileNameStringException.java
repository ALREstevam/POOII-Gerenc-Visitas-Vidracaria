/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.exceptions;

/**
 * Class regarding the InvalidFileNameStringException exception that
 * is derived from IllegalArgumentException
 * @author andre
 */
public class InvalidFileNameStringException extends IllegalArgumentException{
 /**
 * Constructor of class
 */
    public InvalidFileNameStringException() {
        super("Invalid name given.");
    }
 /**
 * Another constructor of class
 */   
    public InvalidFileNameStringException(String message) {
        super(message);
    }
}
