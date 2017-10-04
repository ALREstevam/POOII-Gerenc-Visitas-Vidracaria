package local.persistence;

/**
 * 
 * @author andre
 * @param <E> Any class that implements the interface Serializable
 * @see java.io.Serializable
 */
public interface ObjectKeeper<E>{
    public void persist(E elem, String filename);
    public E load();
}
