/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Users;
import com.src.frugalinnovationlab.Service.ManageAccountInfoService;
import com.src.frugalinnovationlab.helper.Constants;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jaishreeganesh
 */
public class ManageAccountInfoModel {

    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private ManageAccountInfoService manageAccountInfoService;
    

    public ManageAccountInfoModel() {
        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        manageAccountInfoService = new ManageAccountInfoService(manager);

    }
    
    public Users getLogInUserDetails(String username){
        Users user =  manageAccountInfoService.getLogInUserDetails(username);
        return user;        
    }
    
    public boolean updateUserDetails(String[] array) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = manageAccountInfoService.updateUserDetails(array);
        usertransaction.commit();
        return success;
    }
}
