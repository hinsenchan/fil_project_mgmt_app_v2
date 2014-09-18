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
@Table(name = "media_spreadsheet")
@NamedQueries({
    @NamedQuery(name = "MediaSpreadsheet.findAll", query = "SELECT m FROM MediaSpreadsheet m"),
    @NamedQuery(name = "MediaSpreadsheet.findByProjectId", query = "SELECT m FROM MediaSpreadsheet m WHERE m.mediaSpreadsheetPK.projectId = :projectId"),
    @NamedQuery(name = "MediaSpreadsheet.findByFilePath", query = "SELECT m FROM MediaSpreadsheet m WHERE m.mediaSpreadsheetPK.filePath = :filePath"),
    @NamedQuery(name = "MediaSpreadsheet.findByTitle", query = "SELECT m FROM MediaSpreadsheet m WHERE m.title = :title"),
    @NamedQuery(name = "MediaSpreadsheet.findByDescription", query = "SELECT m FROM MediaSpreadsheet m WHERE m.description = :description")})
public class MediaSpreadsheet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediaSpreadsheetPK mediaSpreadsheetPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id", referencedColumnName = "id")
    @MapsId("projectId")
    private Project projects;


    public MediaSpreadsheet() {
    }

    public MediaSpreadsheet(MediaSpreadsheetPK mediaSpreadsheetPK) {
        this.mediaSpreadsheetPK = mediaSpreadsheetPK;
    }

    public MediaSpreadsheet(MediaSpreadsheetPK mediaSpreadsheetPK, String title) {
        this.mediaSpreadsheetPK = mediaSpreadsheetPK;
        this.title = title;
    }

    public MediaSpreadsheet(int projectId, String filePath) {
        this.mediaSpreadsheetPK = new MediaSpreadsheetPK(projectId, filePath);
    }

    public MediaSpreadsheetPK getMediaSpreadsheetPK() {
        return mediaSpreadsheetPK;
    }

    public void setMediaSpreadsheetPK(MediaSpreadsheetPK mediaSpreadsheetPK) {
        this.mediaSpreadsheetPK = mediaSpreadsheetPK;
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

    public Project getProjects() {
        return projects;
    }

    public void setProjects(Project projects) {
        this.projects = projects;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediaSpreadsheetPK != null ? mediaSpreadsheetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaSpreadsheet)) {
            return false;
        }
        MediaSpreadsheet other = (MediaSpreadsheet) object;
        if ((this.mediaSpreadsheetPK == null && other.mediaSpreadsheetPK != null) || (this.mediaSpreadsheetPK != null && !this.mediaSpreadsheetPK.equals(other.mediaSpreadsheetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaSpreadsheet[ mediaSpreadsheetPK=" + mediaSpreadsheetPK + " ]";
    }
    
}
