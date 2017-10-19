/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.persistence;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.exceptions.FileCouldNotBeCreatetException;
import my.exceptions.FileDoesNotExistException;

/**
 * This class persists classes wich implements the interface serializable
 * using a given name and the class of the object to generate a filename
 * @author andre
 * @param <E> a type of object to be persisted or loaded
 */
@Deprecated
public final class LocalPersistence<E extends Serializable>{
    private static final Logger LOG = Logger.getLogger(LocalPersistence.class.getName());
    public final Path serializedFile;
    public final String filename;
    
    /**
     * Constructor of the class
     * @param classOf The object class to be saved or loaded
     * @param objectName The name of the object to be loaded, 
     * the programmer must manage those names and ensure that they do not recur.
     */
    public LocalPersistence(Class classOf, String objectName) {
        this.filename = toFilename(classOf, objectName);
        LOG.setLevel(Level.INFO);
        serializedFile = FileSystems.getDefault().getPath(this.filename);
    }
    
    /**
     * Constructor of the class
     * Allows an object to be loaded or saved without mentioning its name 
     * (a default name will be used).
     * Caution: this will only map one file for class type
     * @param classOf 
     */
    public LocalPersistence(Class classOf) {
        this(classOf, "UndefinedName");
    }
    
    /**
     * Constructor of the class
     * Allows an object to be loaded or saved without mentining its name or its 
     * class, must be used only for one file in the hole project
     */
    public LocalPersistence(){
        this(Object.class, "UndefinedName");
    }
    
    public LocalPersistence(E elem, String objectName) throws FileCouldNotBeCreatetException{
        this(elem.getClass(), objectName);
        persist(elem);
    }
    
    /**
     * Persists the given elemnt
     * @param elem
     * @throws my.exceptions.FileCouldNotBeCreatetException
     */
    public void persist(E elem) throws FileCouldNotBeCreatetException{
        try {
            ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(serializedFile));
            os.writeObject(elem);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "persist ", ex);
            throw new FileCouldNotBeCreatetException();
        }
    }
    
    public void persist(E elem, String objName){
    
    }

    /**
     * Loads a element
     * @return 
     * @throws my.exceptions.FileDoesNotExistException 
     */
    public E load() throws FileDoesNotExistException{
        if (Files.exists(serializedFile)) {
            LOG.log(Level.INFO, "Using ", serializedFile.toString());
            return loadSerialized();
        }
        LOG.log(Level.INFO, "File not found ", serializedFile.toString());
        throw new FileDoesNotExistException();
    }
    
    /**
     * Creates a filename based on a class and a given string
     * @param classOf
     * @param objectName
     * @return 
     */
    public static String toFilename(Class classOf, String objectName){
        String editedName = "["+classOf+"]_["+objectName+"]";
        editedName = editedName.replaceAll("[. ]", "-");
        editedName = editedName.replaceAll("[^A-Za-z0-9-\\[\\]]", "_");
        editedName += ".dat";
        return editedName;
    }
    
    
    /**
     * Loads a serialized file to a object of type E
     * @return
     * @throws FileDoesNotExistException 
     */
    private E loadSerialized() throws FileDoesNotExistException {
        ObjectInputStream is;
        E data = null;
        try {
            is = new ObjectInputStream(Files.newInputStream(serializedFile));
            data = (E) is.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            LOG.log(Level.SEVERE, "loadSerialized ", ex);
            throw new FileDoesNotExistException();
        }
        return data;
    }

    /**
     * Returns the serialized file
     * @return 
     */
    public Path getSerializedFile() {
        return serializedFile;
    }

    /**
     * Returns the filename
     * @return 
     */
    public String getFilename() {
        return filename;
    }
}