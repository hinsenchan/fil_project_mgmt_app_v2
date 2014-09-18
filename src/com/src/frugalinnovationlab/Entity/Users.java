/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.CascadeType;


/**
 *
 * @author Sony
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByFirstname", query = "SELECT u FROM Users u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Users.findByLastname", query = "SELECT u FROM Users u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Users.findByEmailaddress", query = "SELECT u FROM Users u WHERE u.emailaddress = :emailaddress"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByContactnumber", query = "SELECT u FROM Users u WHERE u.contactnumber = :contactnumber"),
    @NamedQuery(name = "Users.findByActive", query = "SELECT u FROM Users u WHERE u.active = :active")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "emailaddress")
    private String emailaddress;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "contactnumber")
    private BigInteger contactnumber;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
  
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles_map", joinColumns = {
        @JoinColumn(name = "username", referencedColumnName = "username")}, inverseJoinColumns = {
        @JoinColumn(name = "role_name", referencedColumnName = "name")})
    
    private Set<UserRoles> userRolesSet;

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }

    public Users( String firstname, String lastname, String Email, String username, String password,  BigInteger Contact, boolean active) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.emailaddress = Email;
        this.contactnumber = Contact;
        this.active = active;
    }
    
    
     public Users( String firstname, String lastname, String Email, String username,  BigInteger Contact) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddress = Email;
        this.contactnumber = Contact;
       
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(BigInteger contactnumber) {
        this.contactnumber = contactnumber;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<UserRoles> getUserRolesSet() {
        return userRolesSet;
    }

    public void setUserRolesSet(Set<UserRoles> userRolesSet) {
        this.userRolesSet = userRolesSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    
    public int getNumberOfColumns() {
       return 6;
   }  
 
  public int getViewColumns()
         
  {
     
      return 8;
  }
   
 
   public void setColumnData(int i, Object value) throws Exception {
     
                      if (i == 0)
           firstname = (String) value;
       else if (i == 1)
           lastname = (String) value;
       else if (i == 2)
           emailaddress = (String) value;
       else if (i == 3)
           username = (String) value;
       else if (i == 4)
          password = (String) value;
          
                   else if (i == 5)
          contactnumber = new BigInteger((String) value);
                  
                     else if (i == 6)
         
                            active = true;
                        
                            else
          
                             throw new Exception("Error: invalid column index in Users table");          
                                 
         
   }
  
  
 
   
    public String viewColumnName(int i) throws Exception {
       String colName = null;
       if (i == 0)
           colName = "User Name";
       else if (i == 1)
           colName = "First Name";
       else if (i == 2)
           colName = "Last Name";
       else if (i == 3)
           colName = "E-mail";
       else if (i == 4)
           colName = "Contact Number";
          
                else if (i == 5)
           colName = "User Role";
           
              else if (i == 6)
        colName = "Password";
              
              else if (i ==7)
        colName = "Status";
      
                  
          
           else
           throw new Exception("Access to invalid column number in courselist table");
      
       return colName;
   }
    
    @Override
    public String toString() {
        return "com.src.frugalinnovationlab.Entity.Users[ username=" + username + " ]";
    }
    
 
    
    
}
