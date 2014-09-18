/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jaishreeganesh
 */
@Entity
@Table(name = "projectfiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projectfiles.findAll", query = "SELECT p FROM Projectfiles p"),
    @NamedQuery(name = "Projectfiles.findById", query = "SELECT p FROM Projectfiles p WHERE p.id = :id"),
    @NamedQuery(name = "Projectfiles.findByFilename", query = "SELECT p FROM Projectfiles p WHERE p.filename = :filename"),
    @NamedQuery(name = "Projectfiles.findByFilepath", query = "SELECT p FROM Projectfiles p WHERE p.filepath = :filepath")})
public class Projectfiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
    @Column(name = "filepath")
    private String filepath;
    
    @JoinColumn(name = "projectid", referencedColumnName = "id")
    @ManyToOne(cascade=CascadeType.ALL)
    private Project projectid;
    @JoinColumn(name = "filetypeid", referencedColumnName = "id")
    @ManyToOne(cascade=CascadeType.ALL)
    private Filetypes filetypeid;

    public Projectfiles() {
    }

    public Projectfiles(Integer id) {
        this.id = id;
    }

    public Projectfiles(Integer id, String filepath) {
        this.id = id;
        this.filepath = filepath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Project getProjectid() {
        return projectid;
    }

    public void setProjectid(Project projectid) {
        this.projectid = projectid;
    }

    public Filetypes getFiletypeid() {
        return filetypeid;
    }

    public void setFiletypeid(Filetypes filetypeid) {
        this.filetypeid = filetypeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectfiles)) {
            return false;
        }
        Projectfiles other = (Projectfiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.Projectfiles[ id=" + id + " ]";
    }
    
}
