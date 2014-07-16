/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Service;

import javax.persistence.EntityManager;
import com.src.frugalinnovationlab.Entity.SearchResult;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Query;

import java.util.List;
import java.util.Locale;

/**
 *
 * @author Sony
 */
public class AdvancedSearchResultService {
    
    private EntityManager manager;
    List<SearchResult> result;
    
    
    public AdvancedSearchResultService(EntityManager manager)
                 
         {
             
                       this.manager = manager;

             
         }
    
    
     public List<SearchResult> readAll(String[] data,  List<String> categoryList) 
            
    {
        
       
            
        
            // SimpleDateFormat formatter = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

          
          
      String pname;
      String outcome;
      String status;
      String bioeng;
      String electrical;
      String civil;
      String mechanical;
      String computer;
      String role;
     String scope;
    
     String multimedia;
     String projectId;
         
         pname = data[0];
        outcome = data[1];
        status = data[2];
        bioeng = data[3];
        electrical = data[4];
        civil = data[5];
        mechanical = data[6];
        computer = data[7];
        role = data[8];
        scope = data[9];
          String startDate  = data[10];
             String    endDate = data[11];
        multimedia = data[12];
        projectId = data[13];
        
     //  Date startDate = formatter.parse(data[10]);
         //  Date endDate = formatter.parse(data[11]);
            
            //System.out.println(endDate);
         
        String naiveQuery;
        Query query = null;
         
       
     
  
   if (!status.equals("")) {
            naiveQuery = "SELECT NEW com.src.frugalinnovationlab.Entity.SearchResult(p.name, p.shortdesc,  p.startDate,  p.endDate, ps.status)"
                    + " FROM Project p LEFT OUTER JOIN p.projectStatusSet ps "
                    + "where p.id = :pid and ps.status = :status";

            query = manager.createQuery(naiveQuery);
            query.setParameter("status", status);
           query.setParameter("pid", Integer.parseInt(projectId));
        } else if (categoryList.size() > 0){
            naiveQuery = "SELECT NEW com.src.frugalinnovationlab.Entity.SearchResult(p.name, p.shortdesc, p.startDate, p.endDate)"
                    + " FROM Project p LEFT OUTER JOIN p.projectCategories pc "
                    + "where p.id = :pid and pc.projectCategories IN :categories";

            query = manager.createQuery(naiveQuery);
            query.setParameter("categories", categoryList);
           query.setParameter("pid", Integer.parseInt(projectId));
           
        } else if(!startDate.equals("") && !endDate.equals("")){
            naiveQuery = "SELECT NEW com.src.frugalinnovationlab.Entity.SearchResult(p.name, p.shortdesc, p.startDate, p.endDate)"
                    + " FROM Project p "
                    + "where p.id = :pid and p.startDate BETWEEN :startDate AND :endDate )";

            query = manager.createQuery(naiveQuery);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
           query.setParameter("pid", Integer.parseInt(projectId));
        }
       
   
        result = query.getResultList();
        
     
     
     return result;
     
}
}
    

