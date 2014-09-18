/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.UserRoles;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import com.src.frugalinnovationlab.Entity.Users;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Sony
 */
public class ViewSpecificUserService {
    
    
     private EntityManager manager;
    
      public ViewSpecificUserService(EntityManager manager)
      
      {
		
          this.manager = manager;
	
      }
    
      public boolean EditUser(String Fname, String Lname, String Email, String Uname, String Pword, BigInteger cnumber, String role)
      
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
                        manager.merge(userrole);
                        
                        return true;
                
                }
         
         catch(Exception ex)
             
         {
             
             flag = false;
             System.out.println("Erros in Adding new User");
     
         }
    
     
         return flag;
                       
            }
            

                       
            

  public boolean  Deleteuser(String username) {
    	
                //Users  users = manager.find(Users.class, username);
       boolean flag = false;
         
         try
         {
      
             Query q = manager.createQuery("Update Users set active = 0  where username = :username", Users.class);   
             
             q.setParameter("username", username);
             
             int count = q.executeUpdate();
             
             if (count  > 0)

             {
                 
                System.out.println(count);
                 flag = true;
                 
             }
               
         }
         catch(Exception ex)
             
         {
             
             flag = false;
             System.out.println("Erros in deleting new User");
     
         }
    
      System.out.println(flag + "In Service");
         return flag;
                       
            }
  
  }







