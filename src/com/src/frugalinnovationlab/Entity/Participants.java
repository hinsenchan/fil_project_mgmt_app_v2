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
@Table(name = "participants")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participants.findAll", query = "SELECT p FROM Participants p"),
    @NamedQuery(name = "Participants.findById", query = "SELECT p FROM Participants p WHERE p.id = :id"),
    @NamedQuery(name = "Participants.findByNameTitle", query = "SELECT p FROM Participants p WHERE p.nameTitle = :nameTitle"),
    @NamedQuery(name = "Participants.findByFirstname", query = "SELECT p FROM Participants p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Participants.findByMiddlename", query = "SELECT p FROM Participants p WHERE p.middlename = :middlename"),
    @NamedQuery(name = "Participants.findByLastname", query = "SELECT p FROM Participants p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Participants.findByPhone", query = "SELECT p FROM Participants p WHERE p.phone = :phone"),
    @NamedQuery(name = "Participants.findByEmail", query = "SELECT p FROM Participants p WHERE p.email = :email"),
    @NamedQuery(name = "Participants.findByOrganization", query = "SELECT p FROM Participants p WHERE p.organization = :organization"),
    @NamedQuery(name = "Participants.findByPosition", query = "SELECT p FROM Participants p WHERE p.position = :position")})
public class Participants implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name_title")
    private String nameTitle;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "middlename")
    private String middlename;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "organization")
    private String organization;    
    @Basic(optional = false)
    @Column(name = "position")
    private String position;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participants")
    private Set<ProjectParticipants> projectParticipantsSet;

    public Participants() {
    }

    public Participants(Integer id) {
        this.id = id;
    }

    public Participants(Integer id, String nameTitle, String firstname, String middlename, 
            String lastname, String position, String email, String phone, String organization) {
        this.id = id;
        this.nameTitle = nameTitle;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.organization = organization;        
    }
    
    public Participants(String nameTitle, String firstname, String middlename, 
            String lastname, String position, String email, String phone, String organization) {
     
        this.nameTitle = nameTitle;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.organization = organization;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
        if (!(object instanceof Participants)) {
            return false;
        }
        Participants other = (Participants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.Participants[ id=" + id + " ]";
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
}
