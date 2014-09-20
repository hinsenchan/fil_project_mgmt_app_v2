/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.*;
import java.math.BigInteger;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sony
 */
public class ViewAllUsersService {

    private EntityManager manager;

    public ViewAllUsersService(EntityManager manager) {

        this.manager = manager;

    }

    public List<UserandRole> readAll() {

        //TypedQuery <UserandRole> query = manager.createQuery("SELECT   NEW   com.src.frugalinnovationlab.Entity.UserandRole(u.username, u.firstname, u.lastname, u.emailaddress, u.contactnumber, r.name, u.password)  from Users u LEFT OUTER JOIN  u.userRolesSet  r order by u.username ",    UserandRole.class);


        TypedQuery<UserandRole> query = manager.createQuery("SELECT   NEW   com.src.frugalinnovationlab.Entity.UserandRole(u.username, u.firstname, u.lastname, u.emailaddress, u.contactnumber, r.name, u.password)  from Users u LEFT OUTER JOIN  u.userRolesSet  r order by u.username ", UserandRole.class);

        List<UserandRole> result = query.getResultList();


        return result;


    }

    public boolean Deleteuser(String username) {
        boolean flag = false;
        try {
            System.out.println("user name : " +username);
            Query query = manager.createQuery("DELETE FROM Users u where u.username = :uname");
            query.setParameter("uname", username);
            int count = query.executeUpdate();
            System.out.println("delete user : " + count);
            flag = true;
        } catch (Exception ex) {
            flag = false;
            System.out.println("Erros in deleting new User");
        }

        System.out.println(flag + "In Service");
        return flag;

    }
}
