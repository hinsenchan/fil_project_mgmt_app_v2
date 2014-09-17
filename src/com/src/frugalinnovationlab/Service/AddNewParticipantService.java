/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.Participants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
        String email = array[5];
        String phone = array[6];
        String organization = array[7];
        int participantId = Integer.parseInt(array[8]);
        Participants participants = manager.find(Participants.class, participantId);
        
        participants.setNameTitle(title);
        participants.setFirstname(firstName);
        participants.setMiddlename(middleName);
        participants.setLastname(lastName);
        participants.setPosition(position);
        participants.setEmail(email);
        participants.setPhone(phone);
        participants.setOrganization(organization);
        
        manager.persist(participants);
        success = true;
        
        return success;
    }
    
    public List<Participants> fetchParticipants() {
        TypedQuery<Participants> query = manager.createQuery("SELECT NEW "
                + "com.src.frugalinnovationlab.Entity.Participants(p.id , p.nameTitle, p.firstname"
                + ", p.middlename, p.lastname, p.position, p.email, p.phone, p.organization) "
                + "FROM Participants p", Participants.class);
        List<Participants> result = query.getResultList();
        return result;
    }
    
    public List<Participants> fetchParticipantsById(String participantId) {
        int pid = Integer.parseInt(participantId);

        String naiveQuery = "SELECT p.nameTitle, p.firstname, p.lastname, p.id,"
                + " p.middlename, p.email, p.phone, p.organization, p.position "
                + "FROM Participants p"
                + " where p.id = :pid";

        Query query = manager.createQuery(naiveQuery, Participants.class);
        query.setParameter("pid", pid);
        List<Participants> result = query.getResultList();
        
        return result;
    }
    
}
