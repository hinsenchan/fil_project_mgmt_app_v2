/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Controller;
import com.src.frugalinnovationlab.view.ViewSpecificUserPanel;
import com.src.frugalinnovationlab.Model.ViewSpecificUserModel;
/**
 *
 * @author Sony
 */
public class ViewSpecificUserController {
    
    private ViewSpecificUserPanel gui;
    private ViewSpecificUserModel viewusermodel;
    
    
    public ViewSpecificUserController(ViewSpecificUserPanel gui)
            
    {
        this.gui = gui;
        viewusermodel = new ViewSpecificUserModel();
        
    }
    
    
      public  boolean   EditUser(String[] array)
            
    {
         boolean flag = false;
        
        try
            
        {
        
        if(viewusermodel.EditUser(array))
            
             flag = true;
        
        }
        
        catch(Exception ex)
            
        {
            System.out.println(ex.getMessage());
            
        }
        
       
        return flag;
   
    }
      
      
      
       public  boolean  DeleteUser(String uname)
            
    {
        
         boolean flag = false;
        
        try
            
        {
        
        
        
            if(viewusermodel.DeleteUser(uname))
   
                flag = true;      
        
        }
        
        catch(Exception ex)
            
        {
            System.out.println(ex.getMessage());
            
        }
        
        System.out.println(flag + "In Controller");
        return flag;
       
   
    }

}