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
@Table(name = "media_cad")
@NamedQueries({
    @NamedQuery(name = "MediaCad.findAll", query = "SELECT m FROM MediaCad m"),
    @NamedQuery(name = "MediaCad.findByProjectId", query = "SELECT m FROM MediaCad m WHERE m.mediaCadPK.projectId = :projectId"),
    @NamedQuery(name = "MediaCad.findByFilePath", query = "SELECT m FROM MediaCad m WHERE m.mediaCadPK.filePath = :filePath"),
    @NamedQuery(name = "MediaCad.findByTitle", query = "SELECT m FROM MediaCad m WHERE m.title = :title"),
    @NamedQuery(name = "MediaCad.findByDescription", query = "SELECT m FROM MediaCad m WHERE m.description = :description")})
public class MediaCad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediaCadPK mediaCadPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id", referencedColumnName = "id")
    @MapsId("projectId")
    private Project projects;

    public MediaCad() {
    }

    public MediaCad(MediaCadPK mediaCadPK) {
        this.mediaCadPK = mediaCadPK;
    }

    public MediaCad(MediaCadPK mediaCadPK, String title) {
        this.mediaCadPK = mediaCadPK;
        this.title = title;
    }

    public MediaCad(int projectId, String filePath) {
        this.mediaCadPK = new MediaCadPK(projectId, filePath);
    }

    public MediaCadPK getMediaCadPK() {
        return mediaCadPK;
    }

    public void setMediaCadPK(MediaCadPK mediaCadPK) {
        this.mediaCadPK = mediaCadPK;
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
        hash += (mediaCadPK != null ? mediaCadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaCad)) {
            return false;
        }
        MediaCad other = (MediaCad) object;
        if ((this.mediaCadPK == null && other.mediaCadPK != null) || (this.mediaCadPK != null && !this.mediaCadPK.equals(other.mediaCadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaCad[ mediaCadPK=" + mediaCadPK + " ]";
    }
    
}
