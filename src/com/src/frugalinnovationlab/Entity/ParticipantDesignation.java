/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jaishreeganesh
 */
@Entity
@Table(name = "participant_designation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParticipantDesignation.findAll", query = "SELECT p FROM ParticipantDesignation p"),
    @NamedQuery(name = "ParticipantDesignation.findById", query = "SELECT p FROM ParticipantDesignation p WHERE p.id = :id"),
    @NamedQuery(name = "ParticipantDesignation.findByName", query = "SELECT p FROM ParticipantDesignation p WHERE p.name = :name")})
public class ParticipantDesignation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participantDesignation")
    private Set<ProjectParticipants> projectParticipantsSet;

    public ParticipantDesignation() {
    }

    public ParticipantDesignation(Integer id) {
        this.id = id;
    }

    public ParticipantDesignation(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<ProjectParticipants> getProjectParticipantsSet() {
        return projectParticipantsSet;
    }

    public void setProjectParticipantsSet(Set<ProjectParticipants> projectParticipantsSet) {
        this.projectParticipantsSet = projectParticipantsSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipantDesignation)) {
            return false;
        }
        ParticipantDesignation other = (ParticipantDesignation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.ParticipantDesignation[ id=" + id + " ]";
    }
    
}
