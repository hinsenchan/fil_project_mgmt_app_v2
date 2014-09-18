/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.src.frugalinnovationlab.Entity.Users;
import com.src.frugalinnovationlab.Service.LoginService;

/**
 *
 * @author Sony
 */
public class LoginModel {

    private static final String PERSISTENCE_UNIT_NAME = "FrugalInnovationLabPU";  // Used in persistence.xml
    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private Users users;
    private LoginService loginservice;

    public LoginModel() {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        users = new Users();
        loginservice = new LoginService(manager);
    }

    public String submit(String[] array) {
        String flag = "false";
        //System.out.println("Its in Model now");
        loginservice.Login((String) array[0], (String) array[1]);
        if ((loginservice.Login((String) array[0], (String) array[1])).equals("Atrue")) {
            flag = "Atrue";
        }
        if ((loginservice.Login((String) array[0], (String) array[1])).equals("Vtrue")) {
            flag = "Vtrue";
        }
        return flag;
    }
}
