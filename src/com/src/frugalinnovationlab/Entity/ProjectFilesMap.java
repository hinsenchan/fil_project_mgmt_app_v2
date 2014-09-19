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
@Table(name = "project_files_map")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectFilesMap.findAll", query = "SELECT p FROM ProjectFilesMap p"),
    @NamedQuery(name = "ProjectFilesMap.findByProjectid", query = "SELECT p FROM ProjectFilesMap p WHERE p.projectFilesMapPK.projectid = :projectid"),
    @NamedQuery(name = "ProjectFilesMap.findByFiletypeid", query = "SELECT p FROM ProjectFilesMap p WHERE p.projectFilesMapPK.filetypeid = :filetypeid"),
    @NamedQuery(name = "ProjectFilesMap.findByFilename", query = "SELECT p FROM ProjectFilesMap p WHERE p.projectFilesMapPK.filename = :filename"),
    @NamedQuery(name = "ProjectFilesMap.findByFilepath", query = "SELECT p FROM ProjectFilesMap p WHERE p.projectFilesMapPK.filepath = :filepath")})
public class ProjectFilesMap implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectFilesMapPK projectFilesMapPK;
    @JoinColumn(name = "filetypeid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Filetypes filetypes;
    @JoinColumn(name = "projectid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public ProjectFilesMap() {
    }

    public ProjectFilesMap(ProjectFilesMapPK projectFilesMapPK) {
        this.projectFilesMapPK = projectFilesMapPK;
    }

    public ProjectFilesMap(int projectid, int filetypeid, String filename, String filepath) {
        this.projectFilesMapPK = new ProjectFilesMapPK(projectid, filetypeid, filename, filepath);
    }

    public ProjectFilesMapPK getProjectFilesMapPK() {
        return projectFilesMapPK;
    }

    public void setProjectFilesMapPK(ProjectFilesMapPK projectFilesMapPK) {
        this.projectFilesMapPK = projectFilesMapPK;
    }

    public Filetypes getFiletypes() {
        return filetypes;
    }

    public void setFiletypes(Filetypes filetypes) {
        this.filetypes = filetypes;
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
        hash += (projectFilesMapPK != null ? projectFilesMapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectFilesMap)) {
            return false;
        }
        ProjectFilesMap other = (ProjectFilesMap) object;
        if ((this.projectFilesMapPK == null && other.projectFilesMapPK != null) || (this.projectFilesMapPK != null && !this.projectFilesMapPK.equals(other.projectFilesMapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.ProjectFilesMap[ projectFilesMapPK=" + projectFilesMapPK + " ]";
    }
    
}
