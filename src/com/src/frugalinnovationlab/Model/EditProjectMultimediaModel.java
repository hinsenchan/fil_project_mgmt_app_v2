/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Service.EditProjectMultimediaService;
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
public class EditProjectMultimediaModel {

    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private EditProjectMultimediaService editProjectMultimediaService;

    public EditProjectMultimediaModel() {
        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        editProjectMultimediaService = new EditProjectMultimediaService(manager);
    }

    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = editProjectMultimediaService.fetchProjects();
        return projectList;
    }

}
