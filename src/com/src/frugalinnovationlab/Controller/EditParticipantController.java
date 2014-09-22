/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Entity.Participants;
import com.src.frugalinnovationlab.Model.EditParticipantModel;
import com.src.frugalinnovationlab.view.EditParticipantPanel;
import java.util.List;

/**
 *
 * @author Jaishreeganesh
 */
public class EditParticipantController {

    private EditParticipantPanel gui;
    private EditParticipantModel editParticipantModel;

    public EditParticipantController(EditParticipantPanel gui) {
        this.gui = gui;
        editParticipantModel = new EditParticipantModel();
    }
    
    public boolean addParticipant(String[] array){
        boolean success = true;
        success = editParticipantModel.addParticipant(array);
        return success;
    }
    
    public List<Participants> getParticipantsFromDatabase() {
        List<Participants> participantList = editParticipantModel.getParticipantsFromDatabase();
        return participantList;
    }
    
    public List<Participants> fetchParticipantsById(String participantId) {
        List<Participants> participantsList = editParticipantModel.fetchParticipantsById(participantId);
        return participantsList;
    }
}
