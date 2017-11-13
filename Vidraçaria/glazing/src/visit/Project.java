package visit;

import java.io.Serializable;
import java.util.List;
import persons.Client;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

public class Project implements Serializable, Descriptible, Arrayable{

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

    @Override
    public String describe() {
        return this.title + sep + this.client.getName() + sep + this.description;
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValue(String variable, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
