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
import com.src.frugalinnovationlab.view.ViewParticipantDetails;
import com.src.frugalinnovationlab.view.Welcome;
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
    private Welcome mainApplication;
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
        String name = gui.getTable().getModel().getValueAt(index, 0).toString();

        mainApplication.getViewParticipantDetails().getNameTextField().setText(name);
        List<Project> result = editProjectParticipantsModel.fetchProjectsByParticipant(gui.getParticipantValue());
        DefaultTableModel model = (DefaultTableModel) mainApplication.getViewParticipantDetails().getTable().getModel();        
        
        for (int i = 0; i < result.size(); i++) {
            Project values = (Project) result.get(i);
            String projectName = String.valueOf(values.getName());
            String projectShortDescription = String.valueOf(values.getShortdesc());

            Object[] row = {projectName, projectShortDescription};            
            model.addRow(row);
        }        
        
        //mainApplication.getViewParticipantDetails().getEmailTextField().setText(name);
               
        mainApplication.getContentPanel().remove(mainApplication.getViewProjectParticipants());
        mainApplication.getContentPanel().add(mainApplication.getViewParticipantDetails());
        mainApplication.setLastComponent("View Participant Details");
        mainApplication.getContentPanel().revalidate();
        mainApplication.getContentPanel().repaint();
    }
}
