/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Users;

import com.src.frugalinnovationlab.Service.ViewSpecificUserService;
import com.src.frugalinnovationlab.helper.Constants;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Sony
 */
public class ViewSpecificUserModel {
    
  //  private static final String PERSISTENCE_UNIT_NAME = "FrugalInnovationLabPU";  // Used in persistence.xml
	  
    
                    
                    private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;
                    private Users users;
                    private ViewSpecificUserService viewuserservice;
                  
                    
                public  ViewSpecificUserModel()
                            
                    {
                     
                      factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    users = new Users();
	    viewuserservice = new ViewSpecificUserService(manager);
          
            
      }
                    
                  public EntityManager getEntityManager() {
	      return manager;
	 }
                  
                  
                  public boolean EditUser(String[] array) 
                           
                   {
                      
                    boolean flag = false;
                   
                   try
                       
                   {
                      
                       EntityTransaction usertransaction = manager.getTransaction();
                       usertransaction.begin();
                       
                       BigInteger phonenumber = new BigInteger((String) array[4]);
                       
                       
                      viewuserservice.EditUser((String) array[0], (String) array[1], (String) array[2], (String) array[3], (String) array[6], (BigInteger) phonenumber, (String) array[5]);
                      
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
    
                  
                    public boolean DeleteUser(String username) 
                           
                   {
                      
                   boolean flag = false;
                   
                   try
                       
                   {
                      
                       EntityTransaction usertransaction = manager.getTransaction();
                       usertransaction.begin();
                   
                       
                       viewuserservice.Deleteuser(username);
                    
                        usertransaction.commit();
                        
                        flag = true;
                
                   }
            
                   catch(Exception ex)
                   
                   {
                       
                       flag = false;
                       System.out.println(ex.getMessage());
                       
                   }
                   
                      System.out.println(flag + "In Model");
                     return flag;
                  
                   }
}
