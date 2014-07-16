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
@Table(name = "media_pdf")
@NamedQueries({
    @NamedQuery(name = "MediaPdf.findAll", query = "SELECT m FROM MediaPdf m"),
    @NamedQuery(name = "MediaPdf.findByProjectId", query = "SELECT m FROM MediaPdf m WHERE m.mediaPdfPK.projectId = :projectId"),
    @NamedQuery(name = "MediaPdf.findByFilePath", query = "SELECT m FROM MediaPdf m WHERE m.mediaPdfPK.filePath = :filePath"),
    @NamedQuery(name = "MediaPdf.findByTitle", query = "SELECT m FROM MediaPdf m WHERE m.title = :title"),
    @NamedQuery(name = "MediaPdf.findByDescription", query = "SELECT m FROM MediaPdf m WHERE m.description = :description")})
public class MediaPdf implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediaPdfPK mediaPdfPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id", referencedColumnName = "id")
    @MapsId("projectId")
    private Project projects;


    public MediaPdf() {
    }

    public MediaPdf(MediaPdfPK mediaPdfPK) {
        this.mediaPdfPK = mediaPdfPK;
    }

    public MediaPdf(MediaPdfPK mediaPdfPK, String title) {
        this.mediaPdfPK = mediaPdfPK;
        this.title = title;
    }

    public MediaPdf(int projectId, String filePath) {
        this.mediaPdfPK = new MediaPdfPK(projectId, filePath);
    }

    public MediaPdfPK getMediaPdfPK() {
        return mediaPdfPK;
    }

    public void setMediaPdfPK(MediaPdfPK mediaPdfPK) {
        this.mediaPdfPK = mediaPdfPK;
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
        hash += (mediaPdfPK != null ? mediaPdfPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaPdf)) {
            return false;
        }
        MediaPdf other = (MediaPdf) object;
        if ((this.mediaPdfPK == null && other.mediaPdfPK != null) || (this.mediaPdfPK != null && !this.mediaPdfPK.equals(other.mediaPdfPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaPdf[ mediaPdfPK=" + mediaPdfPK + " ]";
    }
    
}
