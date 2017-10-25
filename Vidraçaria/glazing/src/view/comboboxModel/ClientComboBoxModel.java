/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.comboboxModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import persons.Client;
/**
 *
 * @author andre
 */
public class ClientComboBoxModel {
    private DefaultComboBoxModel getComboBoxModel(List<Client> clients){
        List<String> clientsInfo = new ArrayList<>(clients.size());
        
        for(Client cli : clients){
            clientsInfo.add(cli.getName() +" | "+ cli.getEmail());
        }
        return new DefaultComboBoxModel(clientsInfo.toArray());
    }
}
