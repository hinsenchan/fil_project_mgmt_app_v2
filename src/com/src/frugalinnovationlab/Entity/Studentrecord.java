/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sony
 */
@Entity
@Table(name = "Studentrecord")
@NamedQueries({
    @NamedQuery(name = "Studentrecord.findAll", query = "SELECT s FROM Studentrecord s"),
    @NamedQuery(name = "Studentrecord.findById", query = "SELECT s FROM Studentrecord s WHERE s.id = :id"),
    @NamedQuery(name = "Studentrecord.findByFirstName", query = "SELECT s FROM Studentrecord s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Studentrecord.findByLastName", query = "SELECT s FROM Studentrecord s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Studentrecord.findByEmail", query = "SELECT s FROM Studentrecord s WHERE s.email = :email"),
    @NamedQuery(name = "Studentrecord.findByDeptId", query = "SELECT s FROM Studentrecord s WHERE s.deptId = :deptId")})
public class Studentrecord implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "dept_id")
    private String deptId;

    public Studentrecord() {
    }

    public Studentrecord(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
        if (!(object instanceof Studentrecord)) {
            return false;
        }
        Studentrecord other = (Studentrecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.Studentrecord[ id=" + id + " ]";
    }
    
}
