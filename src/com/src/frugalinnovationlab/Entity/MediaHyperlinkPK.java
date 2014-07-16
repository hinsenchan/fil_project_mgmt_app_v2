/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Sony
 */
@Embeddable
public class MediaHyperlinkPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "project_id")
    private int projectId;
    @Basic(optional = false)
    @Column(name = "link")
    private String link;

    public MediaHyperlinkPK() {
    }

    public MediaHyperlinkPK(int projectId, String link) {
        this.projectId = projectId;
        this.link = link;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projectId;
        hash += (link != null ? link.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaHyperlinkPK)) {
            return false;
        }
        MediaHyperlinkPK other = (MediaHyperlinkPK) object;
        if (this.projectId != other.projectId) {
            return false;
        }
        if ((this.link == null && other.link != null) || (this.link != null && !this.link.equals(other.link))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaHyperlinkPK[ projectId=" + projectId + ", link=" + link + " ]";
    }
    
}
