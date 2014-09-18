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
@Table(name = "media_video")
@NamedQueries({
    @NamedQuery(name = "MediaVideo.findAll", query = "SELECT m FROM MediaVideo m"),
    @NamedQuery(name = "MediaVideo.findByProjectId", query = "SELECT m FROM MediaVideo m WHERE m.mediaVideoPK.projectId = :projectId"),
    @NamedQuery(name = "MediaVideo.findByFilePath", query = "SELECT m FROM MediaVideo m WHERE m.mediaVideoPK.filePath = :filePath"),
    @NamedQuery(name = "MediaVideo.findByFileType", query = "SELECT m FROM MediaVideo m WHERE m.fileType = :fileType"),
    @NamedQuery(name = "MediaVideo.findByDuration", query = "SELECT m FROM MediaVideo m WHERE m.duration = :duration"),
    @NamedQuery(name = "MediaVideo.findByTitle", query = "SELECT m FROM MediaVideo m WHERE m.title = :title"),
    @NamedQuery(name = "MediaVideo.findByDescription", query = "SELECT m FROM MediaVideo m WHERE m.description = :description")})
public class MediaVideo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediaVideoPK mediaVideoPK;
    @Column(name = "file_type")
    private String fileType;
    @Column(name = "duration")
    private String duration;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    //@JoinColumn(name = "project_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id", referencedColumnName = "id")
    @MapsId("projectId")
    private Project projects;

    public MediaVideo() {
    }

    public MediaVideo(MediaVideoPK mediaVideoPK) {
        this.mediaVideoPK = mediaVideoPK;
    }

    public MediaVideo(MediaVideoPK mediaVideoPK, String title) {
        this.mediaVideoPK = mediaVideoPK;
        this.title = title;
    }

    public MediaVideo(int projectId, String filePath) {
        this.mediaVideoPK = new MediaVideoPK(projectId, filePath);
    }

    public MediaVideoPK getMediaVideoPK() {
        return mediaVideoPK;
    }

    public void setMediaVideoPK(MediaVideoPK mediaVideoPK) {
        this.mediaVideoPK = mediaVideoPK;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
        hash += (mediaVideoPK != null ? mediaVideoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaVideo)) {
            return false;
        }
        MediaVideo other = (MediaVideo) object;
        if ((this.mediaVideoPK == null && other.mediaVideoPK != null) || (this.mediaVideoPK != null && !this.mediaVideoPK.equals(other.mediaVideoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaVideo[ mediaVideoPK=" + mediaVideoPK + " ]";
    }
    
}
