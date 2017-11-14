package visit;

import java.io.Serializable;
import java.util.List;
import persons.Client;
import view.comboboxModel.Descriptible;
import view.tableModel.Arrayable;

public class Project implements Serializable, Descriptible, Arrayable{

    private String title;
    private String description;
    private String file;
    private Client client;

    public Project(String title, String description, String file, Client client) {
        this.title = title;
        this.description = description;
        this.file = file;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
