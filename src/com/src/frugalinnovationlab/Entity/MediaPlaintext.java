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
@Table(name = "media_plaintext")
@NamedQueries({
    @NamedQuery(name = "MediaPlaintext.findAll", query = "SELECT m FROM MediaPlaintext m"),
    @NamedQuery(name = "MediaPlaintext.findByProjectId", query = "SELECT m FROM MediaPlaintext m WHERE m.mediaPlaintextPK.projectId = :projectId"),
    @NamedQuery(name = "MediaPlaintext.findByFilePath", query = "SELECT m FROM MediaPlaintext m WHERE m.mediaPlaintextPK.filePath = :filePath"),
    @NamedQuery(name = "MediaPlaintext.findByTitle", query = "SELECT m FROM MediaPlaintext m WHERE m.title = :title"),
    @NamedQuery(name = "MediaPlaintext.findByDescription", query = "SELECT m FROM MediaPlaintext m WHERE m.description = :description")})
public class MediaPlaintext implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediaPlaintextPK mediaPlaintextPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id", referencedColumnName = "id")
    @MapsId("projectId")
    private Project projects;

    public MediaPlaintext() {
    }

    public MediaPlaintext(MediaPlaintextPK mediaPlaintextPK) {
        this.mediaPlaintextPK = mediaPlaintextPK;
    }

    public MediaPlaintext(MediaPlaintextPK mediaPlaintextPK, String title) {
        this.mediaPlaintextPK = mediaPlaintextPK;
        this.title = title;
    }

    public MediaPlaintext(int projectId, String filePath) {
        this.mediaPlaintextPK = new MediaPlaintextPK(projectId, filePath);
    }

    public MediaPlaintextPK getMediaPlaintextPK() {
        return mediaPlaintextPK;
    }

    public void setMediaPlaintextPK(MediaPlaintextPK mediaPlaintextPK) {
        this.mediaPlaintextPK = mediaPlaintextPK;
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
        hash += (mediaPlaintextPK != null ? mediaPlaintextPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaPlaintext)) {
            return false;
        }
        MediaPlaintext other = (MediaPlaintext) object;
        if ((this.mediaPlaintextPK == null && other.mediaPlaintextPK != null) || (this.mediaPlaintextPK != null && !this.mediaPlaintextPK.equals(other.mediaPlaintextPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaPlaintext[ mediaPlaintextPK=" + mediaPlaintextPK + " ]";
    }
    
}
