/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import com.src.frugalinnovationlab.Service.EditGeneralProjectInformationService;
import com.src.frugalinnovationlab.helper.Constants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jaishreeganesh
 */
public class EditGeneralProjectInformationModel {
    
    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    
    private EditGeneralProjectInformationService editGeneralProjectInformationService;

    public EditGeneralProjectInformationModel() {
        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        editGeneralProjectInformationService = new EditGeneralProjectInformationService(manager);
    }
    
    public List<ProjectStatus> getProjectStatusFromDatabase() {
        List<ProjectStatus> projectStatusList = editGeneralProjectInformationService.fetchProjectStatus();
        return projectStatusList;
    }
    
    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = editGeneralProjectInformationService.fetchProjects();
        return projectList;
    }
    
    public List<Project> fetchProjectGeneralInformation(String id) {
        List<Project> projectDetailsList = editGeneralProjectInformationService.fetchProjectGeneralInformation(id);
        return projectDetailsList;
    }
    
    public boolean editProject(String[] array, List<String> categoriesList){
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = editGeneralProjectInformationService.editProject(array, categoriesList);
        usertransaction.commit();
        return success;
    }
}
