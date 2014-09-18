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
@Table(name = "media_hyperlink")
@NamedQueries({
    @NamedQuery(name = "MediaHyperlink.findAll", query = "SELECT m FROM MediaHyperlink m"),
    @NamedQuery(name = "MediaHyperlink.findByProjectId", query = "SELECT m FROM MediaHyperlink m WHERE m.mediaHyperlinkPK.projectId = :projectId"),
    @NamedQuery(name = "MediaHyperlink.findByLink", query = "SELECT m FROM MediaHyperlink m WHERE m.mediaHyperlinkPK.link = :link"),
    @NamedQuery(name = "MediaHyperlink.findByTitle", query = "SELECT m FROM MediaHyperlink m WHERE m.title = :title"),
    @NamedQuery(name = "MediaHyperlink.findByOpenInWindow", query = "SELECT m FROM MediaHyperlink m WHERE m.openInWindow = :openInWindow"),
    @NamedQuery(name = "MediaHyperlink.findByDescription", query = "SELECT m FROM MediaHyperlink m WHERE m.description = :description")})
public class MediaHyperlink implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediaHyperlinkPK mediaHyperlinkPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "open_in_window")
    private String openInWindow;
    @Column(name = "description")
    private String description;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id", referencedColumnName = "id")
    @MapsId("projectId")
    private Project projects;


    public MediaHyperlink() {
    }

    public MediaHyperlink(MediaHyperlinkPK mediaHyperlinkPK) {
        this.mediaHyperlinkPK = mediaHyperlinkPK;
    }

    public MediaHyperlink(MediaHyperlinkPK mediaHyperlinkPK, String title, String openInWindow) {
        this.mediaHyperlinkPK = mediaHyperlinkPK;
        this.title = title;
        this.openInWindow = openInWindow;
    }

    public MediaHyperlink(int projectId, String link) {
        this.mediaHyperlinkPK = new MediaHyperlinkPK(projectId, link);
    }

    public MediaHyperlinkPK getMediaHyperlinkPK() {
        return mediaHyperlinkPK;
    }

    public void setMediaHyperlinkPK(MediaHyperlinkPK mediaHyperlinkPK) {
        this.mediaHyperlinkPK = mediaHyperlinkPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOpenInWindow() {
        return openInWindow;
    }

    public void setOpenInWindow(String openInWindow) {
        this.openInWindow = openInWindow;
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
        hash += (mediaHyperlinkPK != null ? mediaHyperlinkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaHyperlink)) {
            return false;
        }
        MediaHyperlink other = (MediaHyperlink) object;
        if ((this.mediaHyperlinkPK == null && other.mediaHyperlinkPK != null) || (this.mediaHyperlinkPK != null && !this.mediaHyperlinkPK.equals(other.mediaHyperlinkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaHyperlink[ mediaHyperlinkPK=" + mediaHyperlinkPK + " ]";
    }
    
}
