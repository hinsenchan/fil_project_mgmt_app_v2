/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Controller;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import com.src.frugalinnovationlab.Entity.ProjectView;
import com.src.frugalinnovationlab.view.AdvancedSearchPanel;
import com.src.frugalinnovationlab.Model.AdvancedSearchModel;
import com.src.frugalinnovationlab.view.Welcome;
import java.util.List;
import java.util.Map;
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
public class AdvancedSearchController implements ListSelectionListener{
    
    private AdvancedSearchPanel gui;
    private AdvancedSearchModel advancedsearchmodel;
    private Welcome mainApplication;
    
    public AdvancedSearchController(AdvancedSearchPanel gui)
    
    {
        this.gui = gui;
        advancedsearchmodel = new AdvancedSearchModel();
        mainApplication = gui.getMainApplication();
    }
    
    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = advancedsearchmodel.getProjectsFromDatabase();
        return projectList;
    }
    
    public List<ProjectStatus> getProjectStatusFromDatabase() {
        List<ProjectStatus> projectStatusList = advancedsearchmodel.getProjectStatusFromDatabase();
        return projectStatusList;
    }
    
    public List<ProjectView> fetchAdvancedResults(Map<String, String> advSearchInputs, Map<String, String> advSearchCatInputs) {
        List<ProjectView> result = advancedsearchmodel.fetchAdvancedResults(advSearchInputs, advSearchCatInputs);        
        return result;
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
        mainApplication.getContentPanel().remove(mainApplication.getAdvancedSearchPanel());   
        mainApplication.getContentPanel().add(mainApplication.getViewGeneralProjectInformation());                       
        mainApplication.setLastComponent("View Projects General Info");        
        mainApplication.getViewGeneralProjectInformation().refreshSelectedProject();
        mainApplication.getViewProjectParticipants().refreshSelectedProject();
        mainApplication.getContentPanel().revalidate();
        mainApplication.getContentPanel().repaint();
    }    
}
