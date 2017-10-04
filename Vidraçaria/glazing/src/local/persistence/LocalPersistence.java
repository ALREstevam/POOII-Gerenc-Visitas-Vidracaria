/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.persistence;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class LocalPersistence<E> implements ObjectKeeper<E>{
    private static final Logger LOG = Logger.getLogger(LocalPersistence.class.getName());
    public final Path serializedFile;
    public final String filename;
    
    public LocalPersistence(Class classOf, String objectName) {
        this.filename = toFilename(classOf, objectName);
        LOG.setLevel(Level.INFO);
        serializedFile = FileSystems.getDefault().getPath(this.filename);
    }
    
    @Override
    public void persist(E elem, String filename) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(serializedFile));
            os.writeObject(elem);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "persist ", ex);
        }
    }

    @Override
    public E load() {
        if (Files.exists(serializedFile)) {
            LOG.log(Level.INFO, "Using ", serializedFile.toString());
            return loadSerialized();
        }
        LOG.log(Level.INFO, "File not found ", serializedFile.toString());
        return null;
    }

    private String toFilename(E elem, String objectName) {
        String editedName = "["+elem.getClass()+"]_["+objectName+"]";
        editedName = editedName.replaceAll("[. ]", "-");
        editedName = editedName.replaceAll("[^A-Za-z0-9-\\[\\]]", "_");
        editedName += ".dat";
        return editedName;
    }
    
    private String toFilename(Class classOf, String objectName){
        String editedName = "["+classOf+"]_["+objectName+"]";
        editedName = editedName.replaceAll("[. ]", "-");
        editedName = editedName.replaceAll("[^A-Za-z0-9-\\[\\]]", "_");
        editedName += ".dat";
        return editedName;
    }
    
    private E loadSerialized() {
        ObjectInputStream is;
        E dados = null;
        try {
            is = new ObjectInputStream(Files.newInputStream(serializedFile));
            dados = (E) is.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            LOG.log(Level.SEVERE, "loadSerialized ", ex);
        }
        return dados;
    }
}