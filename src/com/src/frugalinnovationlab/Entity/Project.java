/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sony
 */
@Entity
@Table(name = "project")
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findById", query = "SELECT p FROM Project p WHERE p.id = :id"),
    @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name"),
    @NamedQuery(name = "Project.findByShortdesc", query = "SELECT p FROM Project p WHERE p.shortdesc = :shortdesc"),
    @NamedQuery(name = "Project.findByDescription", query = "SELECT p FROM Project p WHERE p.description = :description"),
    @NamedQuery(name = "Project.findByStartDate", query = "SELECT p FROM Project p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Project.findByEndDate", query = "SELECT p FROM Project p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Project.findByScope", query = "SELECT p FROM Project p WHERE p.scope = :scope"),
    @NamedQuery(name = "Project.findByDisplay", query = "SELECT p FROM Project p WHERE p.display = :display"),
    @NamedQuery(name = "Project.findByOutcome", query = "SELECT p FROM Project p WHERE p.outcome = :outcome")})
public class Project implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<ProjectFilesMap> projectFilesMapSet;
    @Column(name = "archive")
    private String archive;
    @Column(name = "location")
    private String location;
    @JoinTable(name = "project_tag_map", joinColumns = {
        @JoinColumn(name = "projectid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "tagname", referencedColumnName = "tagname")})
    @ManyToMany
    private Set<Tags> tagsSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<ProjectParticipants> projectParticipantsSet;
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "shortdesc")
    private String shortdesc;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "scope")
    private String scope;
    @Basic(optional = false)
    @Column(name = "display")
    private boolean display;
    @Column(name = "outcome")
    private String outcome;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_status_map",
    joinColumns = {
        @JoinColumn(name = "project_id", referencedColumnName = "id")},
    inverseJoinColumns = {
        @JoinColumn(name = "status_name", referencedColumnName = "status")})
    private Set<ProjectStatus> projectStatusSet;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_category_map",
    joinColumns = {
        @JoinColumn(name = "project_id", referencedColumnName = "id")},
    inverseJoinColumns = {
        @JoinColumn(name = "category_name", referencedColumnName = "name")})
    private Set<ProjectCategory> projectCategories;
    @OneToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_participants",
    joinColumns = {
        @JoinColumn(name = "project_id", referencedColumnName = "id")},
    inverseJoinColumns = {
        @JoinColumn(name = "participant_id", referencedColumnName = "id")})
    private Set<Participants> participantsList;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_participants",
    joinColumns = {
        @JoinColumn(name = "project_id", referencedColumnName = "id")},
    inverseJoinColumns = {
        @JoinColumn(name = "designation", referencedColumnName = "id")})
    private Set<ParticipantDesignation> designationList;

    public Project() {
    }

    public Project(Integer id) {
        this.id = id;
    }

    public Project(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Project(Integer id, String name, String shortdesc, Date startDate, Date endDate, String scope, boolean display) {
        this.id = id;
        this.name = name;
        this.shortdesc = shortdesc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.scope = scope;
        this.display = display;
    }

    public Project(Integer id, String name, String shortdesc, Date startDate, Date endDate,
            String scope, String outcome, boolean display, String description, String location) {
        this.id = id;
        this.name = name;
        this.shortdesc = shortdesc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.scope = scope;
        this.display = display;
        this.outcome = outcome;
        this.description = description;
        this.location = location;
    }
    
    public Project(Integer id, String name, String shortdesc, Date startDate, Date endDate,
            String scope, String outcome, boolean display, String description, String location, String archive) {
        this.id = id;
        this.name = name;
        this.shortdesc = shortdesc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.scope = scope;
        this.display = display;
        this.outcome = outcome;
        this.description = description;
        this.location = location;
        this.archive = archive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean getDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Set<ProjectStatus> getProjectStatusSet() {
        return projectStatusSet;
    }

    public void setProjectStatusSet(Set<ProjectStatus> projectStatusSet) {
        this.projectStatusSet = projectStatusSet;
    }

    public Set<ProjectCategory> getProjectCategories() {
        return projectCategories;
    }

    public void setProjectCategories(Set<ProjectCategory> projectCategories) {
        this.projectCategories = projectCategories;
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
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.Project[ id=" + id + " ]";
    }

    public Set<Participants> getParticipantsList() {
        return participantsList;
    }

    public void setParticipantsList(Set<Participants> participantsList) {
        this.participantsList = participantsList;
    }

    public Set<ParticipantDesignation> getDesignationList() {
        return designationList;
    }

    public void setDesignationList(Set<ParticipantDesignation> designationList) {
        this.designationList = designationList;
    }

    public Set<ProjectParticipants> getProjectParticipantsSet() {
        return projectParticipantsSet;
    }

    public void setProjectParticipantsSet(Set<ProjectParticipants> projectParticipantsSet) {
        this.projectParticipantsSet = projectParticipantsSet;
    }

    public int getViewColumns() {

        return 9;
    }

    public String viewColumnName(int i) throws Exception {
        String colName = null;
        if (i == 0) {
            colName = "Project Name";
        } else if (i == 1) {
            colName = "Description";
        } else if (i == 2) {
            colName = "Long Description";
        } else if (i == 3) {
            colName = "Start Date";
        } else if (i == 4) {
            colName = "End Date";
        } else if (i == 5) {
            colName = "Status";
        } else if (i == 6) {
            colName = "Outcome";
        } else if (i == 7) {
            colName = "Scope";
        } else if (i == 8) {
            colName = "Archived";
        } else {
            throw new Exception("Access to invalid column number in courselist table");
        }

        return colName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Tags> getTagsSet() {
        return tagsSet;
    }

    public void setTagsSet(Set<Tags> tagsSet) {
        this.tagsSet = tagsSet;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    @XmlTransient
    public Set<ProjectFilesMap> getProjectFilesMapSet() {
        return projectFilesMapSet;
    }

    public void setProjectFilesMapSet(Set<ProjectFilesMap> projectFilesMapSet) {
        this.projectFilesMapSet = projectFilesMapSet;
    }
}
