/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import com.src.frugalinnovationlab.Model.EditGeneralProjectInformationModel;
import com.src.frugalinnovationlab.view.EditGeneralProjectInformation;
import java.util.List;

/**
 *
 * @author Jaishreeganesh
 */
public class EditGeneralProjectInformationController {
    private EditGeneralProjectInformation gui;
    private EditGeneralProjectInformationModel editGeneralProjectInformationModel;

    public EditGeneralProjectInformationController(EditGeneralProjectInformation gui) {
        this.gui = gui;
        editGeneralProjectInformationModel = new EditGeneralProjectInformationModel();
    }
    
    public List<ProjectStatus> getProjectStatusFromDatabase() {
        List<ProjectStatus> projectStatusList = editGeneralProjectInformationModel.getProjectStatusFromDatabase();
        return projectStatusList;
    }
    
    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = editGeneralProjectInformationModel.getProjectsFromDatabase();
        return projectList;
    }
    
    public List<Project> fetchProjectGeneralInformation(String id) {
        List<Project> projectDetailsList = editGeneralProjectInformationModel.fetchProjectGeneralInformation(id);
        return projectDetailsList;
    }
    
    public boolean editProject(String[] array, List<String> categoriesList){
        boolean success = false;
        success = editGeneralProjectInformationModel.editProject(array, categoriesList);
        return success;
    }
}
