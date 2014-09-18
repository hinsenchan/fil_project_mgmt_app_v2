/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Wrappers;

/**
 *
 * @author Jaishreeganesh
 */
public class AssignParticipantsToProject {

    private String participantId;
    private String roleId;

    public AssignParticipantsToProject(String participantId, String roleId) {
        this.participantId = participantId;
        this.roleId = roleId;
    }

    
    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
   
    
}
