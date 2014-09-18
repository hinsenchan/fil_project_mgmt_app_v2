/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Entity.Participants;
import com.src.frugalinnovationlab.Model.AddNewParticipantModel;
import com.src.frugalinnovationlab.view.AddNewParticipantPanel;
import java.util.List;

/**
 *
 * @author Jaishreeganesh
 */
public class AddNewParticipantController {

    private AddNewParticipantPanel gui;
    private AddNewParticipantModel addNewParticipantModel;

    public AddNewParticipantController(AddNewParticipantPanel gui) {
        this.gui = gui;
        addNewParticipantModel = new AddNewParticipantModel();
    }
    
    public boolean addParticipant(String[] array){
        boolean success = true;
        success = addNewParticipantModel.addParticipant(array);
        return success;
    }
    
    public List<Participants> getParticipantsFromDatabase() {
        List<Participants> participantList = addNewParticipantModel.getParticipantsFromDatabase();
        return participantList;
    }
    
    public List<Participants> fetchParticipantsById(String participantId) {
        List<Participants> participantsList = addNewParticipantModel.fetchParticipantsById(participantId);
        return participantsList;
    }
}
