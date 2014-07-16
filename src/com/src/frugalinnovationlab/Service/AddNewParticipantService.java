/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.Participants;
import javax.persistence.EntityManager;

/**
 *
 * @author Jaishreeganesh
 */
public class AddNewParticipantService {
    
    private EntityManager manager;

    public AddNewParticipantService(EntityManager manager) {
        this.manager = manager;
    }
    
    
    
    public boolean addParticipant(String[] array) {
        boolean success = false;
        String title = array[0];
        String firstName = array[1];
        String middleName = array[2];
        String lastName = array[3];
        String position = array[4];
        
        Participants participants = new Participants(title, firstName, middleName, lastName, position);
        manager.persist(participants);
        success = true;
        
        return success;
    }
    
}
