/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.*;
import com.src.frugalinnovationlab.Service.ViewAllUsersService;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.table.*;
import javax.persistence.*;

/**
 *
 * @author Sony
 */
public class ViewAllUsersModel extends AbstractTableModel {

    private static final String PERSISTENCE_UNIT_NAME = "FrugalInnovationLabPU";  // Used in persistence.xml
    List<UserandRole> userResulList;
    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private Users users;
    private ViewAllUsersService viewallusersservice;
    int numrows, numcols;

    public ViewAllUsersModel() {
        viewallusersservice = new ViewAllUsersService(manager);

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        users = new Users();
        viewallusersservice = new ViewAllUsersService(manager);

        userResulList = viewallusersservice.readAll();
        numrows = userResulList.size();
        numcols = users.getViewColumns();



    }

    public ViewAllUsersModel(List<UserandRole> list, EntityManager em) {
        userResulList = list;
        users = new Users();
        manager = em;
        viewallusersservice = new ViewAllUsersService(manager);

    }

    @Override
    public Object getValueAt(int row, int col) {

        try {




            return userResulList.get(row).viewColumnData(col);




        } catch (Exception e) {
            e.getMessage();
            return null;
        }


    }

    @Override
    public int getRowCount() {

        return numrows;
    }

    // returns a count of the number of columns
    @Override
    public int getColumnCount() {


        return numcols;

    }

    @Override
    public String getColumnName(int col) {
        try {

            return users.viewColumnName(col);
        } catch (Exception err) {
            return err.toString();
        }
    }

    public List<UserandRole> getList() {

        return userResulList;

    }

    public EntityManager getEntityManager() {
        return manager;

    }

    public boolean DeleteUser(String username) {
        boolean flag = false;
        try {
            EntityTransaction usertransaction = manager.getTransaction();
            usertransaction.begin();            
            viewallusersservice.Deleteuser(username);
            usertransaction.commit();
            flag = true;
        } catch (Exception ex) {
            flag = false;
            System.out.println(ex.getMessage());

        }

        System.out.println(flag + "In Model");
        return flag;

    }
}
