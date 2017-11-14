package visit;

import java.io.Serializable;
import java.util.List;
import persons.Client;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

/**
 * This is the Project class. 
 * This class represents a project made according to the request of a particular
 * client
 * @author Pedro
 */
public class Project implements Serializable, Descriptible, Arrayable{

    private String title;
    private String description;
    private String file;
    private Client client;

    /**
     * This is the constructor of the Project class. This constructor
     * has four parameters
     * @param title
     * @param description
     * @param file
     * @param client
     */
    public Project(String title, String description, String file, Client client) {
        this.title = title;
        this.description = description;
        this.file = file;
        this.client = client;
    }

    /**
     * This method get the Project's title
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method set the Project's title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method get the Project's description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method set the Project's description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method get the Project's file
     * @return String
     */
    public String getFile() {
        return file;
    }

    /**
     * This method set the Project's file
     * @param file
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * This method get the Project's client.
     * Returns an object of the client type
     * @return Client
     */
    public Client getClient() {
        return client;
    }

    /**
     * This method set the Project's client
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String describe() {
        return this.title + sep + this.client.getName() + sep + this.description;
    }

    @Override
    public Object[] attributesToArray(String[] order) {
        Object[] rsp = new Object[4];

        int rspCount = 0;
        for (String s : order) {
            switch (s) {
                case "título:":
                    rsp[rspCount] = this.getTitle();
                    break;
                case "descrição:":
                    rsp[rspCount] = this.getDescription();
                    break;
                case "arquivo:":
                    rsp[rspCount] = this.getFile();
                    break;
                case "cliente:":
                    rsp[rspCount] = this.client.getName();
                    break;
                default:
                    rsp[rspCount] = "";
                    break;
            }
            rspCount++;
        }
        return rsp;
    }

    @Override
    public Object setValue(String variable, Object value) {
        switch (variable) {
            case "titulo":
                this.setTitle((String) value);
                break;
            case "descricao":
                this.setDescription((String) value);
                break;
            case "arquivo":
                this.setFile((String) value);
                break;
            case "cliente":
                break;
            default:
                break;
        }
        return this;
    }
}
