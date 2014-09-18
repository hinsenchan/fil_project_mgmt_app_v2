/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sony
 */
@Entity
@Table(name = "media_adobe")
@NamedQueries({
    @NamedQuery(name = "MediaAdobe.findAll", query = "SELECT m FROM MediaAdobe m"),
    @NamedQuery(name = "MediaAdobe.findByProjectId", query = "SELECT m FROM MediaAdobe m WHERE m.mediaAdobePK.projectId = :projectId"),
    @NamedQuery(name = "MediaAdobe.findByFilePath", query = "SELECT m FROM MediaAdobe m WHERE m.mediaAdobePK.filePath = :filePath"),
    @NamedQuery(name = "MediaAdobe.findByTitle", query = "SELECT m FROM MediaAdobe m WHERE m.title = :title"),
    @NamedQuery(name = "MediaAdobe.findByDescription", query = "SELECT m FROM MediaAdobe m WHERE m.description = :description"),
    @NamedQuery(name = "MediaAdobe.findByFileType", query = "SELECT m FROM MediaAdobe m WHERE m.fileType = :fileType")})
public class MediaAdobe implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediaAdobePK mediaAdobePK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "file_type")
    private String fileType;
    
    @ManyToOne
    @JoinColumn(name="project_id", referencedColumnName = "id")
    @MapsId("projectId")
    private Project projects;

    public MediaAdobe() {
    }

    public MediaAdobe(MediaAdobePK mediaAdobePK) {
        this.mediaAdobePK = mediaAdobePK;
    }

    public MediaAdobe(MediaAdobePK mediaAdobePK, String title, String fileType) {
        this.mediaAdobePK = mediaAdobePK;
        this.title = title;
        this.fileType = fileType;
    }

    public MediaAdobe(int projectId, String filePath, String title, String fileType) {
        
        this.mediaAdobePK = new MediaAdobePK(projectId, filePath);
        this.title = title;
        this.fileType = fileType;
    }
    
    public MediaAdobe(int projectId, String filePath) {
        this.mediaAdobePK = new MediaAdobePK(projectId, filePath);
    }

    public MediaAdobePK getMediaAdobePK() {
        return mediaAdobePK;
    }

    public void setMediaAdobePK(MediaAdobePK mediaAdobePK) {
        this.mediaAdobePK = mediaAdobePK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Project getProjects() {
        return projects;
    }

    public void setProjects(Project projects) {
        this.projects = projects;
    }

        

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediaAdobePK != null ? mediaAdobePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaAdobe)) {
            return false;
        }
        MediaAdobe other = (MediaAdobe) object;
        if ((this.mediaAdobePK == null && other.mediaAdobePK != null) || (this.mediaAdobePK != null && !this.mediaAdobePK.equals(other.mediaAdobePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaAdobe[ mediaAdobePK=" + mediaAdobePK + " ]";
    }
    
}
