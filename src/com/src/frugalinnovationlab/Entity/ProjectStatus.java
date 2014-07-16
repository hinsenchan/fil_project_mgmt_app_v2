/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sony
 */
@Entity
@Table(name = "project_status")
@NamedQueries({
    @NamedQuery(name = "ProjectStatus.findAll", query = "SELECT p FROM ProjectStatus p"),
    @NamedQuery(name = "ProjectStatus.findByStatus", query = "SELECT p FROM ProjectStatus p WHERE p.status = :status"),
    @NamedQuery(name = "ProjectStatus.findByStatusDescription", query = "SELECT p FROM ProjectStatus p WHERE p.statusDescription = :statusDescription")})
public class ProjectStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "status_description")
    private String statusDescription;
    
    @ManyToMany(cascade=CascadeType.ALL, mappedBy = "projectStatusSet")     
    private Set<Project> projectSet;

    public ProjectStatus() {
    }

    public ProjectStatus(String status, String statusDescription) {
        this.status = status;
        this.statusDescription = statusDescription;
    }
    
    public ProjectStatus(String status) {
        this.status = status;        
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public Set<Project> getProjectSet() {
        return projectSet;
    }

    public void setProjectSet(Set<Project> projectSet) {
        this.projectSet = projectSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (status != null ? status.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectStatus)) {
            return false;
        }
        ProjectStatus other = (ProjectStatus) object;
        if ((this.status == null && other.status != null) || (this.status != null && !this.status.equals(other.status))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.ProjectStatus[ status=" + status + " ]";
    }
    
}
