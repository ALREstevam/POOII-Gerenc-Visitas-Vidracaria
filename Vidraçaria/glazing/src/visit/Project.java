package visit;

import java.io.Serializable;
import java.util.List;

public class Project implements Serializable{

    private String title;
    private String description;
    private List<String> files;

    public Project(String title, String description, List<String> files) {
        this.title = title;
        this.description = description;
        this.files = files;
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
   

}
