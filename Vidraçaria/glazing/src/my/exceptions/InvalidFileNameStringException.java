/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.exceptions;

/**
 *
 * @author andre
 */
public class InvalidFileNameStringException extends IllegalArgumentException{

    public InvalidFileNameStringException() {
        super("Invalid name given.");
    }
    
    public InvalidFileNameStringException(String message) {
        super(message);
    }
}
