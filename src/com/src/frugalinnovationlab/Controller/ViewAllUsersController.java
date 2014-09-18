/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Controller;
import javax.swing.ListSelectionModel;
import com.src.frugalinnovationlab.view.ViewAllUsersPanel;
import com.src.frugalinnovationlab.Model.ViewAllUsersModel;
import javax.swing.table.TableModel;
import javax.swing.event.*;
import com.src.frugalinnovationlab.view.ViewSpecificUserPanel;

/**
 *
 * @author Sony
 */
public class ViewAllUsersController  implements ListSelectionListener, TableModelListener {
    
    
      private ViewAllUsersPanel gui;
    private ViewAllUsersModel viewallusermodel;
    private ViewSpecificUserPanel updategui;
    
    
    
     public ViewAllUsersController(ViewAllUsersPanel gui)
            
    {
        this.gui = gui;
        viewallusermodel = new ViewAllUsersModel();
        viewallusermodel.addTableModelListener(this);
        updategui = new ViewSpecificUserPanel();
    }
     
     @Override
     public void tableChanged(TableModelEvent e)
             
     {
         
         try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	        viewallusermodel = new ViewAllUsersModel(viewallusermodel.getList(), viewallusermodel.getEntityManager());
                
	        viewallusermodel.addTableModelListener(this);
	        // update the JTable with the data
	    	gui.updateTable();
                        
               
			
	} 
         
                        catch(Exception exp) 
                        
                        {
		exp.getMessage();
		exp.printStackTrace();
	}
         
     }
     
     
     @Override
     public void valueChanged(ListSelectionEvent e) {
		
                                    ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();
                
     }
     
     public TableModel getTableModel() 
     
     {

         return viewallusermodel;
         
         
     }
    
     
     
       public  boolean  DeleteUser(String[] array)
            
    {
        
         boolean flag = false;
        
        try
            
        {
        
        
        
            if(viewallusermodel.DeleteUser(array))
   
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
