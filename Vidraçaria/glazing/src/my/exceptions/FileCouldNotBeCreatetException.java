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
public class FileCouldNotBeCreatetException extends FileDoesNotExistException{

    public FileCouldNotBeCreatetException() {
        super("The file could not be created.");
    }
    
    public FileCouldNotBeCreatetException(String message) {
        super(message);
    }
    
    
}
