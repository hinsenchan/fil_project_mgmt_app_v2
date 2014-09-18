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
@Table(name = "media_word")
@NamedQueries({
    @NamedQuery(name = "MediaWord.findAll", query = "SELECT m FROM MediaWord m"),
    @NamedQuery(name = "MediaWord.findByProjectId", query = "SELECT m FROM MediaWord m WHERE m.mediaWordPK.projectId = :projectId"),
    @NamedQuery(name = "MediaWord.findByFilePath", query = "SELECT m FROM MediaWord m WHERE m.mediaWordPK.filePath = :filePath"),
    @NamedQuery(name = "MediaWord.findByTitle", query = "SELECT m FROM MediaWord m WHERE m.title = :title"),
    @NamedQuery(name = "MediaWord.findByDescription", query = "SELECT m FROM MediaWord m WHERE m.description = :description")})
public class MediaWord implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediaWordPK mediaWordPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id", referencedColumnName = "id")
    @MapsId("projectId")
    private Project projects;


    public MediaWord() {
    }

    public MediaWord(MediaWordPK mediaWordPK) {
        this.mediaWordPK = mediaWordPK;
    }

    public MediaWord(MediaWordPK mediaWordPK, String title) {
        this.mediaWordPK = mediaWordPK;
        this.title = title;
    }

    public MediaWord(int projectId, String filePath) {
        this.mediaWordPK = new MediaWordPK(projectId, filePath);
    }

    public MediaWordPK getMediaWordPK() {
        return mediaWordPK;
    }

    public void setMediaWordPK(MediaWordPK mediaWordPK) {
        this.mediaWordPK = mediaWordPK;
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
        hash += (mediaWordPK != null ? mediaWordPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaWord)) {
            return false;
        }
        MediaWord other = (MediaWord) object;
        if ((this.mediaWordPK == null && other.mediaWordPK != null) || (this.mediaWordPK != null && !this.mediaWordPK.equals(other.mediaWordPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaWord[ mediaWordPK=" + mediaWordPK + " ]";
    }
    
}
