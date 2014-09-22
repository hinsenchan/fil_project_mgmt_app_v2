/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.view.Login;
import com.src.frugalinnovationlab.Model.LoginModel;

/**
 *
 * @author Sony
 */
public class LoginController {

    private Login gui;
    private LoginModel loginmodel;

    public LoginController(Login gui) {
        this.gui = gui;
        loginmodel = new LoginModel();
    }

    public String submitLogin(String[] array) {
        String flag = "false";
        loginmodel.submit(array);
        if ((loginmodel.submit(array)).equals("Atrue")) {
            flag = "Atrue";
        }
        if ((loginmodel.submit(array)).equals("Vtrue")) {
            flag = "Vtrue";
        }
        return flag;
    }
}
