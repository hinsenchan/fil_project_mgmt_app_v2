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
import java.util.Iterator;
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
                + "FROM Project p", Project.class);
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
            System.out.println("ms name is : "+pfm.getProjectFilesMapPK().getFilename());
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

        /*                 
            
         List<ProjectFilesMap> projectfiles, List<String> selectedTagsList) {
         boolean success = true;
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

         //generate new project id
         //int projectId = Integer.parseInt(array[9]);
         int projectId = generateProjectId();

         HashSet<ProjectCategory> projectCategorySet = new HashSet<ProjectCategory>();
         HashSet<Tags> projectTagsSet = new HashSet<Tags>();
         HashSet<ProjectFilesMap> projectfilesSet = new HashSet<ProjectFilesMap>();


         ProjectStatus projectStatus1 = manager.find(ProjectStatus.class, status);//new ProjectStatus();
         projectStatus1.setStatus(projectStatus1.getStatus());

         Project project1 = new Project(projectId, projectName, shortDesc, startDate, endDate, scope,
         outcome, true, longDesc, location);

         HashSet<ProjectStatus> projectStatusSet = new HashSet<ProjectStatus>();
         projectStatusSet.add(projectStatus1);


         project1.setProjectStatusSet(projectStatusSet);
         project1.setProjectCategories(projectCategorySet);
         project1.setTagsSet(projectTagsSet);
         project1.setProjectFilesMapSet(projectfilesSet);

         //project1.setProjectParticipantsList(participantsList);
         Set<Project> projectSet = new HashSet<Project>();
         projectSet.add(project1);
         projectStatus1.setProjectSet(projectSet);
         System.out.println("size is : " + categoriesList.size());
         for (int i = 0; i < categoriesList.size(); i++) {

         System.out.println("category : " + categoriesList.get(i));
         ProjectCategory projectCategory = manager.find(ProjectCategory.class, categoriesList.get(i).trim());
         projectCategory.setName(projectCategory.getName());
         projectCategorySet.add(projectCategory);
         projectCategory.setProjects(projectSet);
         }

         for (int i = 0; i < selectedTagsList.size(); i++) {
         Tags tag = manager.find(Tags.class, selectedTagsList.get(i).trim());
         tag.setTagname(tag.getTagname());
         projectTagsSet.add(tag);
         tag.setProjectSet(projectSet);
         }


         if (projectfiles.size() > 0) {
         for (int i = 0; i < projectfiles.size(); i++) {
         ProjectFilesMap projectfiles1 = projectfiles.get(i);
         projectfiles1.getProjectFilesMapPK().setProjectid(projectId);
         projectfilesSet.add(projectfiles1);
         projectfiles1.setProject(project1);
         }
         }
         //project1.setProjectFilesMapSet(projectfilesSet);


         HashSet<ProjectParticipants> projectParticipantsSet = new HashSet<ProjectParticipants>();
         if (participantsList.size() > 0) {
         for (int i = 0; i < participantsList.size(); i++) {
         AssignParticipantsToProject assigned = participantsList.get(i);
         int participantId = Integer.parseInt(assigned.getParticipantId());
         int roleId = Integer.parseInt(assigned.getRoleId());
         ProjectParticipants projectParticipants = new ProjectParticipants();
         ProjectParticipantsPK projectParticipantsPk = new ProjectParticipantsPK(projectId, participantId, roleId);
         //projectParticipantsPk.setParticipantId(participantId);
         //projectParticipantsPk.setDesignation(roleId);
         projectParticipants.setProjectParticipantsPK(projectParticipantsPk);

         projectParticipantsSet.add(projectParticipants);
         projectParticipants.setProject(project1);

         }
         }
         project1.setProjectParticipantsSet(projectParticipantsSet);

         manager.persist(project1);
         success = true;
         System.out.println("Project Added ");
         } catch (Exception ex) {
         System.out.println("Project Not Added ");
         success = false;
         Logger.getLogger(AddNewProjectService.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Error Adding New Project :" + ex.getMessage());
         }
         return success;
         */
    }
}
