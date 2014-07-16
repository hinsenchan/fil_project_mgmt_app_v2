/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jaishreeganesh
 */
public class ForgotPasswordService {

    private EntityManager manager;

    public ForgotPasswordService(EntityManager manager) {
        this.manager = manager;
    }
    public boolean checkCredentials(String username, String emailaddress, String password) {
        boolean success = false;
        String naiveQuery = "SELECT u FROM Users u where u.username = :username";
        Query query = manager.createQuery(naiveQuery);
        query.setParameter("username", username);
        
        List<Users> users = query.getResultList();
        if(users.size() > 0) {
            System.out.println("email :" +users.get(0).getEmailaddress());
            if(!users.get(0).getEmailaddress().equalsIgnoreCase(emailaddress)){
                return false;
            } else {
                users.get(0).setPassword(password);
                success = true;
            }
        } else {
            return false;
        }
        return success;
    }
}
