/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Model.EditAllProjectsModel;
import com.src.frugalinnovationlab.Model.ViewAllProjectsModel;
import com.src.frugalinnovationlab.view.EditProjectPanel;
import com.src.frugalinnovationlab.view.Welcome;
import com.src.frugalinnovationlab.view.WelcomeAbstract;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Sony
 */
public class EditProjectController implements ListSelectionListener, TableModelListener {

    private EditProjectPanel gui;
    private EditAllProjectsModel editallprojectsmodel;
    private WelcomeAbstract mainApplication;

    public EditProjectController(EditProjectPanel gui) {
        this.gui = gui;
        editallprojectsmodel = new EditAllProjectsModel();
        editallprojectsmodel.addTableModelListener(this);
        mainApplication = gui.getMainApplication();
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        try {
            int firstIndex = e.getFirstRow();
            editallprojectsmodel = new EditAllProjectsModel(
                    editallprojectsmodel.getList(), editallprojectsmodel.getEntityManager());
            editallprojectsmodel.addTableModelListener(this);
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
            //showViewGeneralProjectInformation(firstIndex+1);
        }
    }
    
    public void setSelectedProject(int index) {
        final int projectNameCol = 0;        
        mainApplication.setSelectedProject((String)(gui.getJTable().getValueAt(index, projectNameCol)));
    }

    public TableModel getTableModel() {
        return editallprojectsmodel;
    }
    
    public boolean deleteProject(String projectName){
        boolean success = false;
        success = editallprojectsmodel.deleteProject(projectName);
        return success;
    }
    
    public boolean activateProject(String projectName){
        boolean success = false;
        success = editallprojectsmodel.activateProject(projectName);
        return success;
    }
    
    public void showViewGeneralProjectInformation(int index) {
        mainApplication.getContentPanel().remove(mainApplication.getViewProjectPanel());   
        mainApplication.getContentPanel().add(mainApplication.getViewGeneralProjectInformation());                       
        mainApplication.setLastComponent("View Projects General Info");        
        mainApplication.getViewGeneralProjectInformation().refreshSelectedProject();
        mainApplication.getViewProjectParticipants().refreshSelectedProject();
        mainApplication.getContentPanel().revalidate();
        mainApplication.getContentPanel().repaint();
    }    
}
