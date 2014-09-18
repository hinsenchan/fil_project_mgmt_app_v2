/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.view.ViewAllProjectsPanel;
import com.src.frugalinnovationlab.Model.ViewAllProjectsModel;
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
public class ViewAllProjectsController implements ListSelectionListener, TableModelListener {

    private ViewAllProjectsPanel gui;
    private ViewAllProjectsModel viewallprojectsmodel;

    public ViewAllProjectsController(ViewAllProjectsPanel gui) {
        this.gui = gui;
        viewallprojectsmodel = new ViewAllProjectsModel();
        viewallprojectsmodel.addTableModelListener(this);

    }

    @Override
    public void tableChanged(TableModelEvent e) {

        try {

            int firstIndex = e.getFirstRow();

            viewallprojectsmodel = new ViewAllProjectsModel(viewallprojectsmodel.getList(), viewallprojectsmodel.getEntityManager());

            viewallprojectsmodel.addTableModelListener(this);
            // update the JTable with the data
            gui.updateTable();



        } catch (Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
        }


    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
        int firstIndex = selectModel.getMinSelectionIndex();

    }

    public TableModel getTableModel() {

        return viewallprojectsmodel;


    }
    
    public boolean deleteProject(String projectName){
        boolean success = false;
        success = viewallprojectsmodel.deleteProject(projectName);
        return success;
    }
}
