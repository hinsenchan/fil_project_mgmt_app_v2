/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Entity;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Sony
 */
public class SearchResult {
    
     private String projectname;
      private String desc;
     private Date startdate;
     private Date enddate;
     private String status;
     private String outcome;
     private String scope;
     private String longdesc;
     private String category;
     private String role;
     private String media;
     

     
     
     public SearchResult(String pname, String desc, Date stdate, Date enddate, String pstatus)
     {
         
        this.projectname = pname;
        this.startdate = stdate;
        this.enddate = enddate;
        this.status = pstatus;
        this.desc = desc;
       
       // this.media = media;
         
         
     }
     
      public SearchResult(String pname, String desc, Date stdate, Date enddate)
     {
         
        this.projectname = pname;
        this.startdate = stdate;
        this.enddate = enddate;
    
        this.desc = desc;
       
       // this.media = media;
         
         
     }
     
     public String getProjectName() {
        return projectname;
    }

  

    public String getShortdesc() {
        return desc;
    }

    
    public Date getStartDate() {
        return startdate;
    }

   
    public Date getEndDate() {
        return enddate;
    }
    
   
    
    public String getStatus()
            
            {
                return status;
                
            }
    
    
      public String getOutcome()
            
            {
                return outcome;
                
            }
      
        public String getScope()
            
            {
                return scope;
                
            }
        
        
        public String getLDescription()
                
        {
            return longdesc;
            
        }
       
    
    
      public String viewColumnData(int i) throws Exception
    {

     
            if (i == 0)
           return getProjectName();
       
               else if (i == 1)
           return getShortdesc();
               
                 else if (i == 2)
           return getLDescription();
               
               
             else if (i == 3)
           
                 return  new SimpleDateFormat("MM/dd/yyyy").format(getStartDate());
                  
               else if (i == 4)
           
                   return  new SimpleDateFormat("MM/dd/yyyy").format(getEndDate());
              
            
            else if (i == 5)
           return getStatus();
            
               else if (i == 6)
           return getOutcome();
               
                  else if (i == 7)
           return getScope();
            
         
             
            
       else
           throw new Exception("Error: invalid column index in courselist table");   
   }
  
      
      
        public void setColumnData(int i, Object value) throws Exception
    {

     
            if (i == 0)
         
            projectname = (String) value;
            
       
               else if (i == 1)
           desc =  (String) value;
               
                 else if (i == 2)
          
                     longdesc = (String) value;
               
               
             else if (i == 3)
           
                 startdate = new SimpleDateFormat("mm/dd/yyyy").parse((String) value);
                  
               else if (i == 4)
           
                  enddate = new SimpleDateFormat("mm/dd/yyyy").parse((String) value);
              
            
            else if (i == 5)
           
                status =  (String) value;
            
               else if (i == 6)

                   outcome =  (String) value;
                   
                  else if (i == 7)

                      scope =  (String) value;
             
            
       else
           throw new Exception("Error: invalid column index in  table");   
   }
     
}

