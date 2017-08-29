/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glazing;


/**
 *
 * @author andre
 */
public class Project {
    //ATTRIBUTES
    private int projectId;
    private String projectName;
    private String projectDescription;
    private String[] filePaths;
    private Employee[] responsible;

    //CONSTRUCTORS
    public Project(String projectName, Employee[] responsible) {
        this.projectName = projectName;
        this.responsible  = responsible;
    }

    public Project(String projectName, String projectDescription, String[] filePaths, Employee[] responsible) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.filePaths = filePaths;
        this.responsible = responsible;
    }

    public Project(String projectName, String projectDescription) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }
    
    //GETTERS AND SETTERS
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String[] getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(String[] filePaths) {
        this.filePaths = filePaths;
    }

    public Employee[] getResponsible() {
        return responsible;
    }

    public void setResponsible(Employee[] responsible) {
        this.responsible = responsible;
    }
}
