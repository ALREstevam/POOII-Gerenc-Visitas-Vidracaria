/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.comboboxModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import visit.Project;

/**
 *
 * @author andre
 */
public class ProjectComboBoxModel {
    private DefaultComboBoxModel getComboBoxModel(List<Project> projs){
        List<String> projsInfo = new ArrayList<>(projs.size());
        
        for(Project proj : projs){
            projsInfo.add(proj.getTitle() + " | " + proj.getDescription() + " | Client: " + proj.getClient().getName());
        }
        return new DefaultComboBoxModel(projsInfo.toArray());
    }
}
