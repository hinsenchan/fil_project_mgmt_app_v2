/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.Users;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jaishreeganesh
 */
public class ManageAccountInfoService {

    private EntityManager manager;
    
    public ManageAccountInfoService(EntityManager manager) {
        this.manager = manager;
    }
    
    public Users getLogInUserDetails(String username){
        Users user;
        TypedQuery<Users> query = manager.createQuery("SELECT u from Users u where u.username = :username", Users.class);
        query.setParameter("username", username);
        user = query.getSingleResult();
        System.out.println("user fname : " +user.getFirstname());
        return user;        
    }
    
    public boolean updateUserDetails(String array[]){
        boolean success = false;
        String firstname = array[0];
        String lastname = array[1];
        String email = array[2];
        String contactnumber = array[3];
        String username = array[4];
        String password = array[5];
        BigInteger phone = new BigInteger(contactnumber);
        Users user = manager.find(Users.class, username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmailaddress(email);
        user.setContactnumber(phone);
        user.setPassword(password);
        
        manager.persist(user);
        success = true;
        return success;
    }
}
