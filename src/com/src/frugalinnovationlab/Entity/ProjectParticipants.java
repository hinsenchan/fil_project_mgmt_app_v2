/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jaishreeganesh
 */
@Entity
@Table(name = "project_participants")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectParticipants.findAll", query = "SELECT p FROM ProjectParticipants p"),
    @NamedQuery(name = "ProjectParticipants.findByProjectId", query = "SELECT p FROM ProjectParticipants p WHERE p.projectParticipantsPK.projectId = :projectId"),
    @NamedQuery(name = "ProjectParticipants.findByParticipantId", query = "SELECT p FROM ProjectParticipants p WHERE p.projectParticipantsPK.participantId = :participantId"),
    @NamedQuery(name = "ProjectParticipants.findByDesignation", query = "SELECT p FROM ProjectParticipants p WHERE p.projectParticipantsPK.designation = :designation")})
public class ProjectParticipants implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectParticipantsPK projectParticipantsPK;
    @JoinColumn(name = "designation", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ParticipantDesignation participantDesignation;
    @JoinColumn(name = "participant_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Participants participants;
    @JoinColumn(name = "project_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public ProjectParticipants() {
    }

    public ProjectParticipants(ProjectParticipantsPK projectParticipantsPK) {
        this.projectParticipantsPK = projectParticipantsPK;
    }

    public ProjectParticipants(int projectId, int participantId, int designation) {
        this.projectParticipantsPK = new ProjectParticipantsPK(projectId, participantId, designation);
    }

    public ProjectParticipantsPK getProjectParticipantsPK() {
        return projectParticipantsPK;
    }

    public void setProjectParticipantsPK(ProjectParticipantsPK projectParticipantsPK) {
        this.projectParticipantsPK = projectParticipantsPK;
    }

    public ParticipantDesignation getParticipantDesignation() {
        return participantDesignation;
    }

    public void setParticipantDesignation(ParticipantDesignation participantDesignation) {
        this.participantDesignation = participantDesignation;
    }

    public Participants getParticipants() {
        return participants;
    }

    public void setParticipants(Participants participants) {
        this.participants = participants;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectParticipantsPK != null ? projectParticipantsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectParticipants)) {
            return false;
        }
        ProjectParticipants other = (ProjectParticipants) object;
        if ((this.projectParticipantsPK == null && other.projectParticipantsPK != null) || (this.projectParticipantsPK != null && !this.projectParticipantsPK.equals(other.projectParticipantsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.ProjectParticipants[ projectParticipantsPK=" + projectParticipantsPK + " ]";
    }
    
}
