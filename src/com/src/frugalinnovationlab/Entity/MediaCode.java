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
@Table(name = "media_code")
@NamedQueries({
    @NamedQuery(name = "MediaCode.findAll", query = "SELECT m FROM MediaCode m"),
    @NamedQuery(name = "MediaCode.findByProjectId", query = "SELECT m FROM MediaCode m WHERE m.mediaCodePK.projectId = :projectId"),
    @NamedQuery(name = "MediaCode.findByFilePath", query = "SELECT m FROM MediaCode m WHERE m.mediaCodePK.filePath = :filePath"),
    @NamedQuery(name = "MediaCode.findByTitle", query = "SELECT m FROM MediaCode m WHERE m.title = :title"),
    @NamedQuery(name = "MediaCode.findByDescription", query = "SELECT m FROM MediaCode m WHERE m.description = :description")})
public class MediaCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediaCodePK mediaCodePK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id", referencedColumnName = "id")
    @MapsId("projectId")
    private Project projects;


    public MediaCode() {
    }

    public MediaCode(MediaCodePK mediaCodePK) {
        this.mediaCodePK = mediaCodePK;
    }

    public MediaCode(MediaCodePK mediaCodePK, String title) {
        this.mediaCodePK = mediaCodePK;
        this.title = title;
    }

    public MediaCode(int projectId, String filePath) {
        this.mediaCodePK = new MediaCodePK(projectId, filePath);
    }

    public MediaCodePK getMediaCodePK() {
        return mediaCodePK;
    }

    public void setMediaCodePK(MediaCodePK mediaCodePK) {
        this.mediaCodePK = mediaCodePK;
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
        hash += (mediaCodePK != null ? mediaCodePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaCode)) {
            return false;
        }
        MediaCode other = (MediaCode) object;
        if ((this.mediaCodePK == null && other.mediaCodePK != null) || (this.mediaCodePK != null && !this.mediaCodePK.equals(other.mediaCodePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaCode[ mediaCodePK=" + mediaCodePK + " ]";
    }
    
}
