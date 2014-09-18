/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectView;
import com.src.frugalinnovationlab.Service.SearchProjectService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Sony
 */
public class SearchProjectModel  extends AbstractTableModel


{
      private static final String PERSISTENCE_UNIT_NAME = "FrugalInnovationLabPU";  // Used in persistence.xml
    
                     List<ProjectView> ProjectResulList;
                    private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;
                    private Project projects;
                    
                    private SearchProjectService searchprojectservice;
                    int numrows, numcols;


                    
        public SearchProjectModel(String searchvalue)
            
    {
        
        searchprojectservice = new SearchProjectService(manager);
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        searchprojectservice = new SearchProjectService(manager);
         ProjectResulList = searchprojectservice.readAll(searchvalue);
         projects = new Project();
          numrows = ProjectResulList.size();
         numcols = projects.getViewColumns();
          
        
    }
    
    
     public SearchProjectModel(List<ProjectView> list, EntityManager em)  {
	    ProjectResulList = list;
	    projects = new Project();
                        manager = em;  
                searchprojectservice = new SearchProjectService(manager);
	
       }

     


@Override
                      public Object getValueAt(int row, int col)
              
                         {
          
                             try {
		 
                                 
                                 return ProjectResulList.get(row).viewColumnData(col);
                          
                        
		
          
                 } 
          
          catch (Exception e) 
          
          {
            e.getMessage();
          return null;
      }
                       
         }
                      
                      
                     
         @Override
      public int getRowCount()
           
           {
		
          return numrows;
	
      
      }
	

      // returns a count of the number of columns
      @Override
	 public int getColumnCount() {
		
             
             return numcols;
	
         }
         
          public EntityManager getEntityManager() 
         
                    {
	      return manager;
         
                    }
          
           public List<ProjectView> getList()
         
                {
		 
              return ProjectResulList;
     
                }
           
           @Override
	 public String getColumnName(int col) 
         
         {
		   try {
		
                       return projects.viewColumnName(col);
	} 
                   
                   catch (Exception err) {
	             return err.toString();
	       }             
	 }
                      




}
