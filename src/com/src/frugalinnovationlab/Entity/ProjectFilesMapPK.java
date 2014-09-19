/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jaishreeganesh
 */
@Embeddable
public class ProjectFilesMapPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "projectid")
    private int projectid;
    @Basic(optional = false)
    @Column(name = "filetypeid")
    private int filetypeid;
    @Basic(optional = false)
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
    @Column(name = "filepath")
    private String filepath;

    public ProjectFilesMapPK() {
    }

    public ProjectFilesMapPK(int projectid, int filetypeid, String filename, String filepath) {
        this.projectid = projectid;
        this.filetypeid = filetypeid;
        this.filename = filename;
        this.filepath = filepath;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public int getFiletypeid() {
        return filetypeid;
    }

    public void setFiletypeid(int filetypeid) {
        this.filetypeid = filetypeid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projectid;
        hash += (int) filetypeid;
        hash += (filename != null ? filename.hashCode() : 0);
        hash += (filepath != null ? filepath.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectFilesMapPK)) {
            return false;
        }
        ProjectFilesMapPK other = (ProjectFilesMapPK) object;
        if (this.projectid != other.projectid) {
            return false;
        }
        if (this.filetypeid != other.filetypeid) {
            return false;
        }
        if ((this.filename == null && other.filename != null) || (this.filename != null && !this.filename.equals(other.filename))) {
            return false;
        }
        if ((this.filepath == null && other.filepath != null) || (this.filepath != null && !this.filepath.equals(other.filepath))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.ProjectFilesMapPK[ projectid=" + projectid + ", filetypeid=" + filetypeid + ", filename=" + filename + ", filepath=" + filepath + " ]";
    }
    
}
