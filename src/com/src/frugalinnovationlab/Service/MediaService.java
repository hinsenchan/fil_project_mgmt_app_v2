/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.Filetypes;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectFilesMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author hinsenchan
 */
public class MediaService {

    private EntityManager manager;

    public MediaService(EntityManager manager) {
        this.manager = manager;
    }

    public List<Project> fetchProjects() {
        TypedQuery<Project> query = manager.createQuery("SELECT NEW com.src.frugalinnovationlab.Entity.Project"
                + "(p.id, p.name) "
                + "FROM Project p where p.archive = 'no' order by p.name", Project.class);
        List<Project> result = query.getResultList();
        return result;
    }

    public Project fetchProjectById(int projectId) {
        String naiveQuery = "SELECT p"
                + " FROM Project p"
                + " where p.id = :pid";

        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", projectId);
        Project result = (Project) query.getSingleResult();
        return result;
    }

    public List<Filetypes> fetchFileTypes() {
        TypedQuery<Filetypes> query = manager.createQuery("SELECT NEW com.src.frugalinnovationlab.Entity.Filetypes"
                + "(ft.id, ft.type) "
                + "FROM Filetypes ft", Filetypes.class);
        List<Filetypes> result = query.getResultList();
        return result;
    }

    public boolean removeProjectMedia(int selectedProjectId, List<ProjectFilesMap> projectFilesMapList) {

        //Project project = manager.find(Project.class, pid);
        String naiveQuery = "DELETE FROM ProjectFilesMap pp where "
                + "pp.project.id= :pid";

        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", selectedProjectId);
        int i = query.executeUpdate();
        //System.out.println("i = " +i);
        return true;
    }

    public boolean updateProjectWithProjectFilesMap(
            int selectedProjectId, List<ProjectFilesMap> projectFilesMapList) {
        boolean isSuccessful = false;


        Project project = manager.find(Project.class, selectedProjectId);
        Set<ProjectFilesMap> projectFilesMapSet = new HashSet<ProjectFilesMap>();

        for (int i = 0; i < projectFilesMapList.size(); i++) {
            ProjectFilesMap pfm = projectFilesMapList.get(i);
            System.out.println("ms name is : " + pfm.getProjectFilesMapPK().getFilename());
            projectFilesMapSet.add(pfm);
        }
        project.setProjectFilesMapSet(projectFilesMapSet);
        manager.persist(project);
        isSuccessful = true;

        if (isSuccessful) {
            return true;
        }
        return false;
    }

    public List<ProjectFilesMap> fetchProjectFilesMapByProject(int projectId) {
        String naiveQuery = "SELECT pfm"
                + " FROM ProjectFilesMap pfm"
                + " where pfm.projectFilesMapPK.projectid = :pid";

        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", projectId);
        List<ProjectFilesMap> result = query.getResultList();
        return result;
    }

    public boolean editProjectMedia(List<ProjectFilesMap> projectfiles, int projectId) {
        Project selectedProject = manager.find(Project.class, projectId);
        System.out.println(selectedProject.getName());
        return true;
    }
}
