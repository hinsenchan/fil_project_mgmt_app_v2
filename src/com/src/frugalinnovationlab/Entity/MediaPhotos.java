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
@Table(name = "media_photos")
@NamedQueries({
    @NamedQuery(name = "MediaPhotos.findAll", query = "SELECT m FROM MediaPhotos m"),
    @NamedQuery(name = "MediaPhotos.findByProjectId", query = "SELECT m FROM MediaPhotos m WHERE m.mediaPhotosPK.projectId = :projectId"),
    @NamedQuery(name = "MediaPhotos.findByFilePath", query = "SELECT m FROM MediaPhotos m WHERE m.mediaPhotosPK.filePath = :filePath"),
    @NamedQuery(name = "MediaPhotos.findByTitle", query = "SELECT m FROM MediaPhotos m WHERE m.title = :title"),
    @NamedQuery(name = "MediaPhotos.findByDescription", query = "SELECT m FROM MediaPhotos m WHERE m.description = :description")})
public class MediaPhotos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediaPhotosPK mediaPhotosPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id", referencedColumnName = "id")
    @MapsId("projectId")
    private Project projects;


    public MediaPhotos() {
    }

    public MediaPhotos(MediaPhotosPK mediaPhotosPK) {
        this.mediaPhotosPK = mediaPhotosPK;
    }

    public MediaPhotos(MediaPhotosPK mediaPhotosPK, String title) {
        this.mediaPhotosPK = mediaPhotosPK;
        this.title = title;
    }

    public MediaPhotos(int projectId, String filePath) {
        this.mediaPhotosPK = new MediaPhotosPK(projectId, filePath);
    }

    public MediaPhotosPK getMediaPhotosPK() {
        return mediaPhotosPK;
    }

    public void setMediaPhotosPK(MediaPhotosPK mediaPhotosPK) {
        this.mediaPhotosPK = mediaPhotosPK;
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
        hash += (mediaPhotosPK != null ? mediaPhotosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaPhotos)) {
            return false;
        }
        MediaPhotos other = (MediaPhotos) object;
        if ((this.mediaPhotosPK == null && other.mediaPhotosPK != null) || (this.mediaPhotosPK != null && !this.mediaPhotosPK.equals(other.mediaPhotosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaPhotos[ mediaPhotosPK=" + mediaPhotosPK + " ]";
    }
    
}
