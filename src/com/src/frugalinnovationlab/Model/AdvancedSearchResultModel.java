/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.SearchResult;
import com.src.frugalinnovationlab.Service.AdvancedSearchResultService;
import com.src.frugalinnovationlab.helper.Constants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sony
 */
public class AdvancedSearchResultModel   extends AbstractTableModel  {
    
    
     List<SearchResult> ProjectResulList;
                    private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;
                    private Project projects;
                    
                    private AdvancedSearchResultService resultservice;
                    int numrows, numcols;
                    
    public    AdvancedSearchResultModel(String[] array, List<String> Category)
            
    {
        
        resultservice = new AdvancedSearchResultService(manager);
        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        resultservice = new AdvancedSearchResultService(manager);
         ProjectResulList = resultservice.readAll(array,Category);
        
         projects = new Project();
          numrows = ProjectResulList.size();
         numcols = projects.getViewColumns();
          
        
        
    }
    
     public AdvancedSearchResultModel(List<SearchResult> list, EntityManager em)  {
	    ProjectResulList = list;
	    projects = new Project();
                        manager = em;  
                resultservice = new AdvancedSearchResultService(manager);
                
	
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
          
           public List<SearchResult> getList()
         
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
                      

         @Override
         public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
		   SearchResult element = ProjectResulList.get(row);
                   element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }


                    
    
}
