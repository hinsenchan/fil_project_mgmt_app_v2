/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.view.AdvancedSearchResult;
import com.src.frugalinnovationlab.Model.AdvancedSearchResultModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.*;
/**
 *
 * @author Sony
 */
public class AdvancedSearchResultController   implements ListSelectionListener, TableModelListener  {
    
    private AdvancedSearchResult gui;
    private  AdvancedSearchResultModel resultmodel;
   
    
    public AdvancedSearchResultController(AdvancedSearchResult gui)
            
    {
        this.gui = gui;
       
       // resultmodel = new AdvancedSearchResultModel(array);
   //resultmodel.addTableModelListener(this);

        
        
    }
    
    @Override
     public void tableChanged(TableModelEvent e)
             
     {
         
          try {
	    	
                            int firstIndex =  e.getFirstRow();
	    	
	        resultmodel = new AdvancedSearchResultModel(resultmodel.getList(), resultmodel.getEntityManager());
                
	        resultmodel.addTableModelListener(this);
                            gui.updateTable();
                            
                            
                        
               
			
	} 
         
                        catch(Exception exp) 
                        
                        {
		exp.getMessage();
		exp.printStackTrace();
	}
        
         
     }
     
      @Override
     public void valueChanged(ListSelectionEvent e)
     
     {
		
                    ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
                    int firstIndex = selectModel.getMinSelectionIndex();                 
                
     }
     
     public TableModel getTableModel(String[] array, List<String> category) 
     
     {

         
         resultmodel = new AdvancedSearchResultModel(array,category);
        resultmodel.addTableModelListener(this);

         return resultmodel;
         
         
     }
    
}
