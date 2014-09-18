/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Model.ForgotPasswordModel;
import com.src.frugalinnovationlab.view.ForgotPassword;

/**
 *
 * @author Jaishreeganesh
 */
public class ForgotPasswordController {
    private ForgotPassword gui;
    private ForgotPasswordModel forgotPasswordModel;

    public ForgotPasswordController(ForgotPassword gui) {
        this.gui = gui;
        forgotPasswordModel = new ForgotPasswordModel();
    }
    
    public boolean checkCredentials(String username, String emailaddress, String password){
        boolean success = false;
        success = forgotPasswordModel.checkCredentials(username, emailaddress, password);
        return success;
    }
}
