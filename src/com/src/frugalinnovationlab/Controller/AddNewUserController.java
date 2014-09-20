/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.view.AddNewUserPanel;
import com.src.frugalinnovationlab.Model.AddNewUserModel;

/**
 *
 * @author Sony
 */
public class AddNewUserController {

    private AddNewUserPanel gui;
    private AddNewUserModel addnewusermodel;

    public AddNewUserController(AddNewUserPanel gui) {
        this.gui = gui;
        addnewusermodel = new AddNewUserModel();

    }

    public boolean addUser(String[] array) {

        boolean flag = false;
        try {
            if (addnewusermodel.addUser(array)) {
                flag = true;
            }
        } catch (Exception ex) {
            System.out.println("exception in add user controller : "+ex.getMessage());
        }
        return flag;
    }
}