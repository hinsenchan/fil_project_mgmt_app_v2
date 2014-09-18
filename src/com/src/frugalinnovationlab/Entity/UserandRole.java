/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Entity;
import java.math.*;


/**
 *
 * @author Sony
 */
public class UserandRole 

{
    
  
  
          private String username;
        private  String rolename;
        private String firstname;
        private String lastname;
        private String email;
        private BigInteger contact;
         private String password;
      boolean active;
                
        

  public UserandRole(String uname, String fname, String lname, String email,  BigInteger contact, String rname, String pword, boolean status) 
  
  {
      this.username = uname;
      this.rolename = rname;
      this.firstname = fname;
      this.lastname = lname;
      this.email = email;
      this.contact = contact;
      this.password = pword;
      this.active = status;
      
  }

  public String getUserName() { 
      return username;
  }
  
  public String getRoleName() {
      return rolename;
  }
  
  public String getFirstName() { 
      return firstname;
  }
  
  public String getLastName() { 
      return lastname;
  }
  
  public String getEmail() { 
      return email;
  }
  
  public BigInteger getContact() { 
      return contact;
  }
  
  public String getPassword() { 
      return password;
  }
  
  
   public String getActive() { 
      
       String activerole;
       if(active == true)
       
       {
           
           activerole = "Active";
           
           
       }
       
       else
           
           activerole = "In Active";
           
           
       return activerole;
  }
  
    
   public String viewColumnData(int i) throws Exception
    {

     
            if (i == 0)
           return getUserName();
       
               else if (i == 1)
           return getFirstName();
               
             else if (i == 2)
           return getLastName();
                  
               else if (i == 3)
           return getEmail();
                     
                else if (i == 4)
          
                    
                    return getContact().toString() ;
               
            
            else if (i == 5)
           return getRoleName();
            
            else if (i == 6)
           return getPassword();
            
            else if (i == 7)
           return getActive();
       
             
            
       else
           throw new Exception("Error: invalid column index in  table");   
   }
  
   
   public void setColumnData(int i, Object value) throws Exception {
     
       
        if (i == 0)
           username = (String) value;
               else       if (i == 1)
           firstname = (String) value;
       else if (i == 2)
           lastname = (String) value;
       else if (i == 3)
           email = (String) value;
       
         else if (i == 4)
          contact = new BigInteger((String) value);
                  
       
       else if (i == 5)
          rolename = (String) value;
       
        else if (i == 6)
          rolename = (String) value;
          
                 
                     else if (i == 7)
         
                            active = true;
                        
                            else
          
                             throw new Exception("Error: invalid column index in Users table");          
                                 
         
   }
    
   
}
