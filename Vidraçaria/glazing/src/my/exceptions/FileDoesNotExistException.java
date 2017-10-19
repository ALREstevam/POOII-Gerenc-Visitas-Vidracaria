/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author andre
 */
public class FileDoesNotExistException extends FileNotFoundException{
    public FileDoesNotExistException() {
        super("The file does not exists.");
    }
    
    public FileDoesNotExistException(String message){
        super(message);
    }
}