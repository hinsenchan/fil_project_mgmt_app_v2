/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectView;
import com.src.frugalinnovationlab.Service.EditAllProjectsService;
import com.src.frugalinnovationlab.Service.ViewAllProjectsService;
import com.src.frugalinnovationlab.helper.Constants;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Sony
 */
public class EditAllProjectsModel extends AbstractTableModel {

    //private static final String PERSISTENCE_UNIT_NAME = "FrugalInnovationLabPU";  // Used in persistence.xml
    List<ProjectView> ProjectResulList;
    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private Project projects;
    private EditAllProjectsService editallprojectservice;
    int numrows, numcols;

    public EditAllProjectsModel() {

        editallprojectservice = new EditAllProjectsService(manager);
        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        editallprojectservice = new EditAllProjectsService(manager);
        ProjectResulList = editallprojectservice.readAll();
        projects = new Project();
        numrows = ProjectResulList.size();
        numcols = projects.getViewColumns();


    }

    public EditAllProjectsModel(List<ProjectView> list, EntityManager em) {
        ProjectResulList = list;
        projects = new Project();
        manager = em;
        editallprojectservice = new EditAllProjectsService(manager);

    }

    @Override
    public Object getValueAt(int row, int col) {

        try {


            return ProjectResulList.get(row).viewColumnData(col);




        } catch (Exception e) {
            e.getMessage();
            return null;
        }

    }

    @Override
    public int getRowCount() {

        return numrows;


    }

    // returns a count of the number of columns
    @Override
    public int getColumnCount() {


        return numcols;

    }

    public EntityManager getEntityManager() {
        return manager;

    }

    public List<ProjectView> getList() {

        return ProjectResulList;

    }

    @Override
    public String getColumnName(int col) {
        try {

            return projects.viewColumnName(col);
        } catch (Exception err) {
            return err.toString();
        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int col) {
        //data[rowIndex][columnIndex] = (String) aValue;
        try {
            ProjectView element = ProjectResulList.get(row);
            element.setColumnData(col, aValue);
            fireTableCellUpdated(row, col);
        } catch (Exception err) {
            err.toString();
        }
    }
    
    public boolean deleteProject(String projectName){
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editallprojectservice.deleteProject(projectName);
        usertransaction.commit();
        return success;
    }
}
