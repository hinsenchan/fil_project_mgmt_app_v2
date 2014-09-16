/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Model.ViewAllProjectsModel;
import com.src.frugalinnovationlab.view.ViewGeneralProjectInformation;
import com.src.frugalinnovationlab.view.ViewParticipantDetails;
import com.src.frugalinnovationlab.view.ViewProjectPanel;
import com.src.frugalinnovationlab.view.Welcome;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Sony
 */
public class ViewProjectController implements ListSelectionListener, TableModelListener {

    private ViewProjectPanel gui;
    private ViewAllProjectsModel viewallprojectsmodel;
    private Welcome mainApplication;

    public ViewProjectController(ViewProjectPanel gui) {
        this.gui = gui;
        viewallprojectsmodel = new ViewAllProjectsModel();
        viewallprojectsmodel.addTableModelListener(this);
        mainApplication = gui.getMainApplication();
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        try {
            int firstIndex = e.getFirstRow();
            viewallprojectsmodel = new ViewAllProjectsModel(
                    viewallprojectsmodel.getList(), viewallprojectsmodel.getEntityManager());
            viewallprojectsmodel.addTableModelListener(this);
            // update the JTable with the data
            gui.updateTable();
            mainApplication.getViewGeneralProjectInformation().getChooseProjectComboBox().setSelectedIndex(firstIndex);
        } catch (Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
        }
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

    public TableModel getTableModel() {
        return viewallprojectsmodel;
    }
    
    public boolean deleteProject(String projectName){
        boolean success = false;
        success = viewallprojectsmodel.deleteProject(projectName);
        return success;
    }
    
    public void showViewGeneralProjectInformation(int index) {
        mainApplication.getContentPanel().remove(mainApplication.getViewProjectPanel());   
        mainApplication.getContentPanel().add(mainApplication.getViewGeneralProjectInformation());                       
        mainApplication.setLastComponent("View Project General Info");        
        mainApplication.getViewGeneralProjectInformation().refreshSelectedProject();
        mainApplication.getViewProjectParticipants().refreshSelectedProject();
        mainApplication.getContentPanel().revalidate();
        mainApplication.getContentPanel().repaint();
    }    
}
