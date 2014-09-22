/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Entity.ParticipantDesignation;
import com.src.frugalinnovationlab.Entity.Participants;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectParticipants;
import com.src.frugalinnovationlab.Model.EditProjectParticipantsModel;
import com.src.frugalinnovationlab.view.ViewProjectParticipants;
import com.src.frugalinnovationlab.view.WelcomeAbstract;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jaishreeganesh
 */
public class ViewProjectParticipantsController implements ListSelectionListener {
    private ViewProjectParticipants gui;
    private EditProjectParticipantsModel editProjectParticipantsModel;
    private WelcomeAbstract mainApplication;
    private ListSelectionModel selectModel;

    public ViewProjectParticipantsController(ViewProjectParticipants gui) {
        this.gui = gui;
        editProjectParticipantsModel = new EditProjectParticipantsModel();
        mainApplication = gui.getMainApplication();
    }
    
    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = editProjectParticipantsModel.getProjectsFromDatabase();
        return projectList;
    }
    
    public List<ParticipantDesignation> getParticipantsDesignationFromDatabase() {
        List<ParticipantDesignation> participantDesignationList = editProjectParticipantsModel.getProjectDesignationsFromDatabase();
        return participantDesignationList;
    }
    
    public List<Participants> getParticipantsFromDatabase() {
        List<Participants> participantList = editProjectParticipantsModel.getParticipantsFromDatabase();
        return participantList;
    }
    
    public List<ProjectParticipants> fetchParticipantsByProject(String projectId) {
        List<ProjectParticipants> participantsList = editProjectParticipantsModel.fetchParticipantsByProject(projectId);
        return participantsList;
    }
    
    public boolean editProjectParticipants(String projectId, List<ProjectParticipants> participantsList){
        boolean success = false;
        success = editProjectParticipantsModel.editProjectParticipants(projectId, participantsList);
        return success;
    }
    
    public void valueChanged(ListSelectionEvent e) { 
        selectModel = (ListSelectionModel) e.getSource();        
	int firstIndex = selectModel.getMinSelectionIndex(); 
        if (firstIndex > -1) {
            showViewParticipantDetails(firstIndex);
        }
    }
    
    public void showViewParticipantDetails(int index) {
        String id = gui.getTable().getValueAt(index, 0).toString();
        String name = gui.getTable().getValueAt(index, 1).toString();
        String email = gui.getTable().getValueAt(index, 2).toString();
        String phone = gui.getTable().getValueAt(index, 3).toString();
        String organization = gui.getTable().getValueAt(index, 4).toString();        
        mainApplication.getViewParticipantDetails().getNameTextField().setText(name);
        mainApplication.getViewParticipantDetails().getEmailTextField().setText(email);
        mainApplication.getViewParticipantDetails().getPhoneTextField().setText(phone);
        mainApplication.getViewParticipantDetails().getOrganizationTextField().setText(organization);
        
        List<Project> result = editProjectParticipantsModel.fetchActiveProjectsByParticipant(id);
        DefaultTableModel model = (DefaultTableModel) mainApplication.getViewParticipantDetails().getTable().getModel();        
        
        for (int i=model.getRowCount()-1; i>=0; i--) {
            model.removeRow(i);
        }
        
        for (int i = 0; i < result.size(); i++) {
            Project values = (Project) result.get(i);
            String projectName = String.valueOf(values.getName());
            String projectShortDescription = String.valueOf(values.getShortdesc());

            Object[] row = {projectName, projectShortDescription};            
            model.addRow(row);
        }                
               
        mainApplication.getContentPanel().remove(mainApplication.getViewProjectParticipants());
        mainApplication.getContentPanel().add(mainApplication.getViewParticipantDetails());
        mainApplication.setLastComponent("View Participant Details");
        mainApplication.getContentPanel().revalidate();
        mainApplication.getContentPanel().repaint();
    }
}
