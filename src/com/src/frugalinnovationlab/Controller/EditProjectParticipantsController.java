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
import com.src.frugalinnovationlab.view.EditProjectParticipants;
import java.util.List;

/**
 *
 * @author Jaishreeganesh
 */
public class EditProjectParticipantsController {
    private EditProjectParticipants gui;
    private EditProjectParticipantsModel editProjectParticipantsModel;

    public EditProjectParticipantsController(EditProjectParticipants gui) {
        this.gui = gui;
        editProjectParticipantsModel = new EditProjectParticipantsModel();
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
    
    public boolean addParticipant(String[] array){
        boolean success = true;
        success = editProjectParticipantsModel.addParticipant(array);
        return success;
    }
    
    public List<Participants> getParticipantsSortByID() {
        List<Participants> participantList = editProjectParticipantsModel.getParticipantsSortByID();
        return participantList;
    }
}
