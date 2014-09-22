/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectCategory;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jaishreeganesh
 */
public class EditGeneralProjectInformationService {

    private EntityManager manager;

    public EditGeneralProjectInformationService(EntityManager manager) {
        this.manager = manager;
    }

    public List<ProjectStatus> fetchProjectStatus() {
        TypedQuery<ProjectStatus> query = manager.createQuery("SELECT NEW "
                + "com.src.frugalinnovationlab.Entity.ProjectStatus(p.status, p.statusDescription) "
                + "FROM ProjectStatus p", ProjectStatus.class);
        List<ProjectStatus> result = query.getResultList();
        return result;
    }

    public List<Project> fetchProjects() {
        TypedQuery<Project> query = manager.createQuery("SELECT NEW com.src.frugalinnovationlab.Entity.Project"
                + "(p.id, p.name) "
                + "FROM Project p where p.archive = 'no' order by p.name", Project.class);
        List<Project> result = query.getResultList();
        return result;
    }

    public List<Project> fetchProjectGeneralInformation(String id) {
        int projectId = Integer.parseInt(id);
        // String org_query = "SELECT p.NAME, p.SHORTDESC FROM project p JOIN project_status_map pm ON p.id = pm.project_id"
        //         + " JOIN project_status ps ON pm.status_name = ps.status WHERE (( p.id = ? ))";
        TypedQuery<Project> query = manager.createQuery("SELECT p"
                //+ "(p.id, p.name) "                
                + " FROM Project p where p.id=:id", Project.class);

        query.setParameter("id", projectId);
        List<Project> result = query.getResultList();
        //List<Project> result = manager.createNativeQuery(org_query, Project.class).setParameter(1, projectId).getResultList();
        return result;
    }

    public boolean editProject(String[] array, List<String> categoriesList) {
        boolean success = false;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            String projectName = array[0];
            String shortDesc = array[1];
            String longDesc = array[2];
            String status = array[3];
            String location = array[4];
            Date startDate = formatter.parse(array[5]);
            Date endDate = formatter.parse(array[6]);
            String scope = array[7];
            String outcome = array[8];
            int projectId = Integer.parseInt(array[9]);
            Project project = manager.find(Project.class, projectId);
            project.setName(projectName);
            project.setShortdesc(shortDesc);
            project.setDescription(longDesc);
            project.setLocation(location);

            project.setStartDate(startDate);
            project.setEndDate(endDate);
            project.setScope(scope);
            project.setOutcome(outcome);
            
            Set<ProjectCategory> projectCategories = new HashSet<ProjectCategory>();
            ProjectCategory projectCategory = new ProjectCategory();
            for (int i = 0; i < categoriesList.size(); i++) {
                String string = categoriesList.get(i);
                projectCategory = new ProjectCategory(string);
                if (project.getProjectCategories().contains(projectCategory)) {
                    boolean removed = project.getProjectCategories().remove(projectCategory);
                }
                projectCategories.add(projectCategory);
            }
            for (ProjectCategory projectCategory1 : projectCategories) {
                //System.out.println("here : " +projectCategory1.getName());
            }
            project.setProjectCategories(projectCategories);

            Set<ProjectStatus> projectStatuses = new HashSet<ProjectStatus>();
            ProjectStatus projectStatus = new ProjectStatus(status);

            project.getProjectStatusSet().remove(projectStatus);
            projectStatuses.add(projectStatus);

            project.setProjectStatusSet(projectStatuses);
            //projectCategory.getProjects().add(project);
            manager.merge(project);
            manager.persist(project);



            success = true;
        } catch (ParseException ex) {
            success = false;
            Logger.getLogger(EditGeneralProjectInformationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
