/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.Users;
import com.src.frugalinnovationlab.Entity.UserRoles;


import javax.persistence.EntityManager;

import javax.persistence.*;
import java.util.*;
import java.math.*;

/**
 *
 * @author Sony
 */
public class AddNewUserService {
    
    
    private EntityManager manager;
    
      public AddNewUserService(EntityManager manager)
      
      {
		
          this.manager = manager;
	
      }
    
      
      
      
    public List<Users> readAll()
            
    {
        
        TypedQuery <Users> query = manager.createQuery("SELECT u from Users u", Users.class);
        
        List<Users> result = query.getResultList();
        
        return result;
    }
       
    
    
     public boolean  addUser(String Fname, String Lname, String Email, String Uname, String Pword, BigInteger cnumber, String role)
     {
         
         boolean flag = false;
         
         try
         {
                        UserRoles userrole = manager.find(UserRoles.class, role);
         
                        Users user = new Users(Fname,Lname,Email,Uname,Pword,cnumber,true);
                    
                         HashSet<Users> userset = new HashSet<Users>();
                         
                         userset.add(user);
                         userrole.setUsersSet(userset);
                         
                         Set<UserRoles> Rolesset = new HashSet<UserRoles>();
                         
                         Rolesset.add(userrole);
                         
                         user.setUserRolesSet(Rolesset);
                        manager.persist(userrole);
                       
                        if(manager.contains(user))
                            
                        {
                            flag = true;
                            
                        }
                        
         }
         
         catch(Exception ex)
             
         {
             
             flag = false;
             System.out.println("Erros in Adding new User");
     
         }
    
     
         return flag;
     
     }
    
    
    
}
