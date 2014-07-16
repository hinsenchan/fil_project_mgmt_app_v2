/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import com.src.frugalinnovationlab.Service.AdvancedSearchService;
import com.src.frugalinnovationlab.helper.Constants;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sony
 */
public class AdvancedSearchModel {
    
      private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private AdvancedSearchService advancedsearchservice;
    
    public AdvancedSearchModel()
            
    {
     
        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        advancedsearchservice = new AdvancedSearchService(manager);
        
    }
    
     public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = advancedsearchservice.fetchProjects();
        return projectList;
    }
     
      public List<ProjectStatus> getProjectStatusFromDatabase() {
        List<ProjectStatus> projectStatusList = advancedsearchservice.fetchProjectStatus();
        return projectStatusList;
    }
    
}
