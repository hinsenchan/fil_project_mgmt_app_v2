/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.ParticipantDesignation;
import com.src.frugalinnovationlab.Entity.Participants;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectParticipants;
import com.src.frugalinnovationlab.Service.EditProjectParticipantsService;
import com.src.frugalinnovationlab.helper.Constants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jaishreeganesh
 */
public class EditProjectParticipantsModel {
    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private EditProjectParticipantsService editProjectParticipantsService;
    

    public EditProjectParticipantsModel() {
        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();        
        editProjectParticipantsService = new EditProjectParticipantsService(manager);
    }
    
    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = editProjectParticipantsService.fetchProjects();
        return projectList;
    }
    
    public List<ParticipantDesignation> getProjectDesignationsFromDatabase() {
        List<ParticipantDesignation> projectDesignationList = editProjectParticipantsService.fetchParticipantDesignations();
        return projectDesignationList;
    }
    
    public List<Participants> getParticipantsFromDatabase() {
        List<Participants> participantsList = editProjectParticipantsService.fetchParticipants();
        return participantsList;
    }
    
    public List<ProjectParticipants> fetchParticipantsByProject(String projectId) {
        List<ProjectParticipants> participantsList = editProjectParticipantsService.fetchParticipantsByProject(projectId);
        return participantsList;
    }

    public List<Project> fetchProjectsByParticipant(String participantId) {
        List<Project> participantsList = editProjectParticipantsService.fetchProjectsByParticipant(participantId);
        return participantsList;
    }    
    
    public boolean editProjectParticipants(String projectId, List<ProjectParticipants> participantsList){
        boolean success = true;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        editProjectParticipantsService.removeProjectParticipants(projectId, participantsList);
        usertransaction.commit();
        usertransaction.begin();
        success = editProjectParticipantsService.editProjectParticipants(projectId, participantsList);
        usertransaction.commit();
        return success;
    }
    
    public boolean addParticipant(String[] array) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editProjectParticipantsService.addParticipant(array);
        usertransaction.commit();
        return success;
    }
    
    public List<Participants> getParticipantsSortByID() {
        List<Participants> participantsList = editProjectParticipantsService.getParticipantsSortByID();
        return participantsList;
    }
}
