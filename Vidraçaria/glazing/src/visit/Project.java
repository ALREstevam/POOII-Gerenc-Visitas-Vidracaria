package visit;

import java.io.Serializable;
import java.util.List;
import persons.Client;

public class Project implements Serializable, Cloneable{

    private String title;
    private String description;
    private List<String> files;
    private Client client;

    public Project(String title, String description, List<String> files, Client client) {
        this.title = title;
        this.description = description;
        this.files = files;
        this.client = client;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
   
    

}
