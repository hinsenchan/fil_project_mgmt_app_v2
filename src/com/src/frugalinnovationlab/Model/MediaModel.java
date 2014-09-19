/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectFilesMap;
import com.src.frugalinnovationlab.Service.EditProjectParticipantsService;
import com.src.frugalinnovationlab.Service.MediaService;
import com.src.frugalinnovationlab.helper.Constants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hinsenchan
 */
public class MediaModel {
    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private MediaService mediaService;    
    
    public MediaModel() {
        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();        
        mediaService = new MediaService(manager);
    }
    
    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = mediaService.fetchProjects();
        return projectList;
    }    
    
    public List<ProjectFilesMap> fetchProjectFilesMapByProject(int projectId) {
        List<ProjectFilesMap> projectFilesMapList = mediaService.fetchProjectFilesMapByProject(projectId);
        return projectFilesMapList;
    }    
}
