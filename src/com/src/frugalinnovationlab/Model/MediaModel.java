/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Filetypes;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectFilesMap;
import com.src.frugalinnovationlab.Service.MediaService;
import com.src.frugalinnovationlab.helper.Constants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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

    public Project getProjectByIdFromDatabase(int projectId) {
        Project project = mediaService.fetchProjectById(projectId);
        return project;
    }

    public List<Filetypes> getFileTypesFromDatabase() {
        List<Filetypes> fileTypeList = mediaService.fetchFileTypes();
        return fileTypeList;
    }

    public boolean updateProjectWithProjectFilesMap(
            int selectedProjectId, List<ProjectFilesMap> projectFilesMapList) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        mediaService.removeProjectMedia(selectedProjectId, projectFilesMapList);
        usertransaction.commit();
        usertransaction.begin();
        success = mediaService.updateProjectWithProjectFilesMap(
                selectedProjectId, projectFilesMapList);
        usertransaction.commit();
        return success;
    }

    public List<ProjectFilesMap> fetchProjectFilesMapByProject(int projectId) {
        List<ProjectFilesMap> projectFilesMapList = mediaService.fetchProjectFilesMapByProject(projectId);
        return projectFilesMapList;
    }
}
