/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Service.ForgotPasswordService;
import com.src.frugalinnovationlab.helper.Constants;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jaishreeganesh
 */
public class ForgotPasswordModel {

    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private ForgotPasswordService forgotPasswordService;

    public ForgotPasswordModel() {
        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        forgotPasswordService = new ForgotPasswordService(manager);

    }
    
    public boolean checkCredentials(String username, String emailaddress, String password) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        
        success = forgotPasswordService.checkCredentials(username, emailaddress, password);
        usertransaction.commit();
        return success;
    }
}
