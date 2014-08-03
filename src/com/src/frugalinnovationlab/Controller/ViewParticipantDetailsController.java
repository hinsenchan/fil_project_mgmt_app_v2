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
import com.src.frugalinnovationlab.view.ViewGeneralProjectInformation;
import com.src.frugalinnovationlab.view.ViewParticipantDetails;
import com.src.frugalinnovationlab.view.ViewProjectParticipants;
import com.src.frugalinnovationlab.view.Welcome;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Jaishreeganesh
 */
public class ViewParticipantDetailsController implements ListSelectionListener {
    private ViewParticipantDetails gui;
    private EditProjectParticipantsModel editProjectParticipantsModel;
    private Welcome mainApplication;

    public ViewParticipantDetailsController(ViewParticipantDetails gui) {
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
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	int firstIndex = selectModel.getMinSelectionIndex(); 
        showViewGeneralProjectInformation();
    }
    
    public void showViewGeneralProjectInformation() {
        mainApplication.setViewGeneralProjectInformation(new ViewGeneralProjectInformation(mainApplication));
        mainApplication.getContentPanel().remove(mainApplication.getViewParticipantDetails());
        mainApplication.getContentPanel().add(mainApplication.getViewGeneralProjectInformation());
        mainApplication.setLastComponent("View Project General Info");
        mainApplication.getContentPanel().revalidate();
    }    
    
    public void showViewProjectParticipants() {
        mainApplication.setViewProjectParticipants(new ViewProjectParticipants(mainApplication));
        mainApplication.getContentPanel().remove(mainApplication.getViewParticipantDetails());
        mainApplication.getContentPanel().add(mainApplication.getViewProjectParticipants());
        mainApplication.setLastComponent("View Project Participants");
        mainApplication.getContentPanel().revalidate();
    }      
}
