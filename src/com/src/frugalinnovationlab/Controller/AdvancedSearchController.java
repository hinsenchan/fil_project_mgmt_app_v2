/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Controller;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import com.src.frugalinnovationlab.view.AdvancedSearchPanel;
import com.src.frugalinnovationlab.Model.AdvancedSearchModel;
import java.util.List;

/**
 *
 * @author Sony
 */
public class AdvancedSearchController {
    
    private AdvancedSearchPanel gui;
    private  AdvancedSearchModel advancedsearchmodel;
    
    
    public AdvancedSearchController(AdvancedSearchPanel gui)
    
    {
        this.gui = gui;
        advancedsearchmodel = new AdvancedSearchModel();
        
    }
    
    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = advancedsearchmodel.getProjectsFromDatabase();
        return projectList;
    }
    
    public List<ProjectStatus> getProjectStatusFromDatabase() {
        List<ProjectStatus> projectStatusList = advancedsearchmodel.getProjectStatusFromDatabase();
        return projectStatusList;
    }
}
