/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Users;
import com.src.frugalinnovationlab.Service.AddNewUserService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;
import java.util.*;
import javax.swing.table.*;
import java.math.*;


/**
 *
 * @author Sony
 */
public class AddNewUserModel {
    
    
    private static final String PERSISTENCE_UNIT_NAME = "FrugalInnovationLabPU";  // Used in persistence.xml
	  
    
                    List<Users> userResulList;
                    private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;
                    private Users users;
                    private AddNewUserService addnewuserservice;
                    int numcols, numrows;
                    
                    
                   public  AddNewUserModel()
                            
                    {
                     
                      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    users = new Users();
	    addnewuserservice = new AddNewUserService(manager);
            
      }
                        
           
	 public EntityManager getEntityManager() {
	      return manager;
	 }
                   public boolean  addUser(String[] array) 
                           
                   {
                      
                       
                   boolean flag = false;
                   
                   try
                       
                   {
                      
                       EntityTransaction usertransaction = manager.getTransaction();
                       usertransaction.begin();
                       
                       BigInteger phonenumber = new BigInteger((String) array[5]);
                       
                       addnewuserservice.addUser((String) array[0], (String) array[1], (String) array[2], (String) array[3], (String) array[4],  (BigInteger) phonenumber, (String) array[7] );
                         
                       usertransaction.commit();
                    
                        flag = true;
         
                   }    
                   
                   
                   
                   catch(Exception ex)
                   
                   {
                       
                       flag = false;
                       System.out.println(ex.getMessage());
                       
                   }
                   
                     
                     return flag;
                   }    
    
}

