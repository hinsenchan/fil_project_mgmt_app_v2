/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Participants;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import com.src.frugalinnovationlab.Service.EditParticipantService;
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
public class EditParticipantModel {

    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private ProjectStatus projectStatus;
    private EditParticipantService editParticipantService;

    public EditParticipantModel() {
        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        projectStatus = new ProjectStatus();
        editParticipantService = new EditParticipantService(manager);
    }    
    
    public boolean addParticipant(String[] array) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editParticipantService.addParticipant(array);
        usertransaction.commit();
        return success;
    }
    
    public List<Participants> getParticipantsFromDatabase() {
        List<Participants> participantsList = editParticipantService.fetchParticipants();
        return participantsList;
    }
    
    public List<Participants> fetchParticipantsById(String participantId) {
        List<Participants> participantsList = editParticipantService.fetchParticipantsById(participantId);
        return participantsList;
    }
}
