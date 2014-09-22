/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Controller;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import com.src.frugalinnovationlab.view.SearchPanel;
import com.src.frugalinnovationlab.Model.SearchProjectModel;
import com.src.frugalinnovationlab.view.WelcomeAbstract;

/**
 *
 * @author Sony
 */
public class SearchProjectController implements ListSelectionListener, TableModelListener {    
    private SearchPanel gui;
    private SearchProjectModel searchprojectmodel;       
    private WelcomeAbstract mainApplication;
    
    public SearchProjectController(SearchPanel gui) {
        this.gui = gui;
        mainApplication = gui.getMainApplication();
        //searchprojectmodel.addTableModelListener(this);       
    }
     
     @Override
     public void tableChanged(TableModelEvent e) {         
        try {
            int firstIndex =  e.getFirstRow();	    	
	    searchprojectmodel = new SearchProjectModel(
                    searchprojectmodel.getList(), searchprojectmodel.getEntityManager());                
	    searchprojectmodel.addTableModelListener(this);
	    // update the JTable with the data
            gui.updateTable();                                       			
	}          
        catch(Exception exp) {
            exp.getMessage();          
	}                 
     }     
     
     public TableModel getTableModel(String Searchtext) {        
        searchprojectmodel = new SearchProjectModel(Searchtext);
        searchprojectmodel.addTableModelListener(this);

        return searchprojectmodel; 
     }
     
    @Override
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
        int firstIndex = selectModel.getMinSelectionIndex();
        setSelectedProject(firstIndex);
        if (firstIndex > -1) {
            showViewGeneralProjectInformation(firstIndex+1);
        }
    }    
    
    public void setSelectedProject(int index) {
        final int projectNameCol = 0;        
        mainApplication.setSelectedProject((String)(gui.getJTable().getValueAt(index, projectNameCol)));
    }
    
    public void showViewGeneralProjectInformation(int index) {
        mainApplication.getContentPanel().remove(mainApplication.getSearchPanel());   
        mainApplication.getContentPanel().add(mainApplication.getViewGeneralProjectInformation());                       
        mainApplication.setLastComponent("View Projects General Info");        
        mainApplication.getViewGeneralProjectInformation().refreshSelectedProject();
        mainApplication.getViewProjectParticipants().refreshSelectedProject();
        mainApplication.getContentPanel().revalidate();
        mainApplication.getContentPanel().repaint();
    }       
}
