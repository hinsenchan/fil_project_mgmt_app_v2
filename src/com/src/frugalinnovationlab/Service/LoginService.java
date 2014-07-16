/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.helper.Constants;
import javax.persistence.*;
import java.util.*;
import java.util.prefs.Preferences;

/**
 *
 * @author Sony
 */
public class LoginService {

    private EntityManager manager;
    
    public LoginService(EntityManager manager) {
        this.manager = manager;
    }

    public String Login(String username, String password) {
        String flag = "false";
        try {
            TypedQuery<Object[]> query = manager.createQuery("SELECT u.username, u.password,  r.name, u.firstname, u.lastname from Users u JOIN u.userRolesSet r where u.username = :uname", Object[].class);
            query.setParameter("uname", username);
            List<Object[]> result = query.getResultList();
            if (result.size() < 1) {
                return "false";
            }
            for (Object[] data : result) // System.out.println("username =" +data[0] + " password =  " + data[1] + "role =" + data[2]);
            {
                System.out.println("now here ");
                if (data[2].toString().equals("Administrator")) {
                    if (username.equalsIgnoreCase(data[0].toString()) && password.equals(data[1].toString())) {
                        flag = "Atrue";
                        System.out.println("Its Admin");
                    }
                } else if (data[2].toString().equals("Viewer")) {
                    if (username.equalsIgnoreCase(data[0].toString()) && password.equals(data[1].toString())) {
                        System.out.println("Its Viewer");
                        flag = "Vtrue";
                    }
                }
                Preferences prefs = Preferences.userNodeForPackage(com.src.frugalinnovationlab.Service.LoginService.class);
                prefs.put(Constants.USER_NAME, username);
                prefs.put(Constants.FULL_NAME, data[3].toString().concat(" ").concat(data[4].toString()));
                prefs.put(Constants.USER_TYPE, data[2].toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            //JOptionPane.showMessageDialog(null, "Invalid User ID and Password Combination");
        }
        return flag;
    }
}
