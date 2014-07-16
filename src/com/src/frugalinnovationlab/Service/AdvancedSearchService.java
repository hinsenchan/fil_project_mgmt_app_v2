/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sony
 */
public class AdvancedSearchService {
    
     private EntityManager manager;
     
     public AdvancedSearchService(EntityManager manager) {
        this.manager = manager;
    }
     
     
     public List<Project> fetchProjects() {
        TypedQuery<Project> query = manager.createQuery("SELECT NEW com.src.frugalinnovationlab.Entity.Project"
                + "(p.id, p.name) "
                + "FROM Project p", Project.class);
        List<Project> result = query.getResultList();
        return result;
    }
    
     public List<ProjectStatus> fetchProjectStatus() {
        TypedQuery<ProjectStatus> query = manager.createQuery("SELECT NEW "
                + "com.src.frugalinnovationlab.Entity.ProjectStatus(p.status, p.statusDescription) "
                + "FROM ProjectStatus p", ProjectStatus.class);
        List<ProjectStatus> result = query.getResultList();
        return result;
    }
     
}
