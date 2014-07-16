/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jaishreeganesh
 */
@Embeddable
public class ProjectParticipantsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "project_id")
    private int projectId;
    @Basic(optional = false)
    @Column(name = "participant_id")
    private int participantId;
    @Basic(optional = false)
    @Column(name = "designation")
    private int designation;

    public ProjectParticipantsPK() {
    }

    public ProjectParticipantsPK(int projectId, int participantId, int designation) {
        this.projectId = projectId;
        this.participantId = participantId;
        this.designation = designation;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public int getDesignation() {
        return designation;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projectId;
        hash += (int) participantId;
        hash += (int) designation;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectParticipantsPK)) {
            return false;
        }
        ProjectParticipantsPK other = (ProjectParticipantsPK) object;
        if (this.projectId != other.projectId) {
            return false;
        }
        if (this.participantId != other.participantId) {
            return false;
        }
        if (this.designation != other.designation) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.ProjectParticipantsPK[ projectId=" + projectId + ", participantId=" + participantId + ", designation=" + designation + " ]";
    }
    
}
