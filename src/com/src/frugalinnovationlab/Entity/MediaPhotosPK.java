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
public class MediaPhotosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "project_id")
    private int projectId;
    @Basic(optional = false)
    @Column(name = "file_path")
    private String filePath;

    public MediaPhotosPK() {
    }

    public MediaPhotosPK(int projectId, String filePath) {
        this.projectId = projectId;
        this.filePath = filePath;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projectId;
        hash += (filePath != null ? filePath.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaPhotosPK)) {
            return false;
        }
        MediaPhotosPK other = (MediaPhotosPK) object;
        if (this.projectId != other.projectId) {
            return false;
        }
        if ((this.filePath == null && other.filePath != null) || (this.filePath != null && !this.filePath.equals(other.filePath))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaPhotosPK[ projectId=" + projectId + ", filePath=" + filePath + " ]";
    }
    
}
