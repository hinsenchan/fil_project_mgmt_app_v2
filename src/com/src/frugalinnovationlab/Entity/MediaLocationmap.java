/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sony
 */
@Entity
@Table(name = "media_locationmap")
@NamedQueries({
    @NamedQuery(name = "MediaLocationmap.findAll", query = "SELECT m FROM MediaLocationmap m"),
    @NamedQuery(name = "MediaLocationmap.findByProjectId", query = "SELECT m FROM MediaLocationmap m WHERE m.mediaLocationmapPK.projectId = :projectId"),
    @NamedQuery(name = "MediaLocationmap.findByAddress", query = "SELECT m FROM MediaLocationmap m WHERE m.mediaLocationmapPK.address = :address"),
    @NamedQuery(name = "MediaLocationmap.findByTitle", query = "SELECT m FROM MediaLocationmap m WHERE m.title = :title"),
    @NamedQuery(name = "MediaLocationmap.findByDescription", query = "SELECT m FROM MediaLocationmap m WHERE m.description = :description"),
    @NamedQuery(name = "MediaLocationmap.findByLattitude", query = "SELECT m FROM MediaLocationmap m WHERE m.lattitude = :lattitude"),
    @NamedQuery(name = "MediaLocationmap.findByLongitude", query = "SELECT m FROM MediaLocationmap m WHERE m.longitude = :longitude"),
    @NamedQuery(name = "MediaLocationmap.findByCountry", query = "SELECT m FROM MediaLocationmap m WHERE m.country = :country"),
    @NamedQuery(name = "MediaLocationmap.findByState", query = "SELECT m FROM MediaLocationmap m WHERE m.state = :state"),
    @NamedQuery(name = "MediaLocationmap.findByCity", query = "SELECT m FROM MediaLocationmap m WHERE m.city = :city"),
    @NamedQuery(name = "MediaLocationmap.findByZipcode", query = "SELECT m FROM MediaLocationmap m WHERE m.zipcode = :zipcode")})
public class MediaLocationmap implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MediaLocationmapPK mediaLocationmapPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "lattitude")
    private String lattitude;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "country")
    private String country;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private BigInteger zipcode;
    @JoinColumn(name = "project_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public MediaLocationmap() {
    }

    public MediaLocationmap(MediaLocationmapPK mediaLocationmapPK) {
        this.mediaLocationmapPK = mediaLocationmapPK;
    }

    public MediaLocationmap(MediaLocationmapPK mediaLocationmapPK, String title) {
        this.mediaLocationmapPK = mediaLocationmapPK;
        this.title = title;
    }

    public MediaLocationmap(int projectId, String address) {
        this.mediaLocationmapPK = new MediaLocationmapPK(projectId, address);
    }

    public MediaLocationmapPK getMediaLocationmapPK() {
        return mediaLocationmapPK;
    }

    public void setMediaLocationmapPK(MediaLocationmapPK mediaLocationmapPK) {
        this.mediaLocationmapPK = mediaLocationmapPK;
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

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigInteger getZipcode() {
        return zipcode;
    }

    public void setZipcode(BigInteger zipcode) {
        this.zipcode = zipcode;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediaLocationmapPK != null ? mediaLocationmapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaLocationmap)) {
            return false;
        }
        MediaLocationmap other = (MediaLocationmap) object;
        if ((this.mediaLocationmapPK == null && other.mediaLocationmapPK != null) || (this.mediaLocationmapPK != null && !this.mediaLocationmapPK.equals(other.mediaLocationmapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.MediaLocationmap[ mediaLocationmapPK=" + mediaLocationmapPK + " ]";
    }
    
}
