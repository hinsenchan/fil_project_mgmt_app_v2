/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Entity.Users;
import com.src.frugalinnovationlab.Model.ManageAccountInfoModel;
import com.src.frugalinnovationlab.view.ManageAccountInfoPanel;

/**
 *
 * @author Jaishreeganesh
 */
public class ManageAccountInfoController {

    
    public ManageAccountInfoModel manageAccountInfoModel;
    public ManageAccountInfoPanel gui;

    public ManageAccountInfoController(ManageAccountInfoPanel gui) {
        this.gui = gui;
        manageAccountInfoModel = new ManageAccountInfoModel();
    }
    
    public Users getLogInUserDetails(String username){
        Users user =  manageAccountInfoModel.getLogInUserDetails(username);
        return user;        
    }
    
    public boolean updateUserDetails(String[] array){
        boolean success = false;
        success = manageAccountInfoModel.updateUserDetails(array);
        return success;
    }
   
}