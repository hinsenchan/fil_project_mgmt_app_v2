/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.ParticipantDesignation;
import com.src.frugalinnovationlab.Entity.Participants;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectParticipants;
import com.src.frugalinnovationlab.Wrappers.AssignParticipantsToProject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jaishreeganesh
 */
public class EditProjectParticipantsService {

    private EntityManager manager;

    public EditProjectParticipantsService(EntityManager manager) {
        this.manager = manager;
    }

    public List<Project> fetchProjects() {
        TypedQuery<Project> query = manager.createQuery("SELECT NEW com.src.frugalinnovationlab.Entity.Project"
                + "(p.id, p.name) "
                + "FROM Project p", Project.class);
        List<Project> result = query.getResultList();
        return result;
    }

    public List<ParticipantDesignation> fetchParticipantDesignations() {
        TypedQuery<ParticipantDesignation> query = manager.createQuery("SELECT NEW "
                + "com.src.frugalinnovationlab.Entity.ParticipantDesignation(p.id , p.name) "
                + "FROM ParticipantDesignation p", ParticipantDesignation.class);
        List<ParticipantDesignation> result = query.getResultList();
        return result;
    }

    public List<Participants> fetchParticipants() {
        TypedQuery<Participants> query = manager.createQuery("SELECT NEW "
                + "com.src.frugalinnovationlab.Entity.Participants(p.id , p.nameTitle, p.firstname"
                + ", p.middlename, p.lastname, p.position, p.email, p.phone, p.organization) "
                + "FROM Participants p", Participants.class);
        List<Participants> result = query.getResultList();
        return result;
    }

    public List<ProjectParticipants> fetchParticipantsByProject(String projectId) {
        int pid = Integer.parseInt(projectId);

        String naiveQuery = "SELECT p.nameTitle, p.firstname, p.lastname, p.id, "
                + " pd.id, pd.name, p.email, p.phone, p.organization FROM ProjectParticipants pp LEFT OUTER JOIN pp.participants p"
                + " LEFT OUTER JOIN pp.participantDesignation pd"
                + " where pp.projectParticipantsPK.projectId = :pid";

        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);

        List<ProjectParticipants> result = query.getResultList();

        return result;
    }
    /*
    public List<ProjectParticipants> fetchParticipantsByProject(String projectId) {
        int pid = Integer.parseInt(projectId);

        String naiveQuery = "SELECT p.nameTitle, p.firstname, p.lastname, p.id,"
                + " pd.id, pd.name FROM ProjectParticipants pp LEFT OUTER JOIN pp.participants p"
                + " LEFT OUTER JOIN pp.participantDesignation pd"
                + " where pp.projectParticipantsPK.projectId = :pid";

        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);

        List<ProjectParticipants> result = query.getResultList();

        return result;
    }    
    */
    public List<Project> fetchProjectsByParticipant(String participanttId) {
        int pid = Integer.parseInt(participanttId);

        TypedQuery<Project> query = manager.createQuery("SELECT DISTINCT NEW com.src.frugalinnovationlab.Entity.Project"
                + "(p.id, p.name, p.shortdesc,p.startDate,p.endDate,p.scope,p.display) FROM Project p "
                + "LEFT OUTER JOIN p.participantsList pl WHERE pl.id = :pid"
                , Project.class);
        query.setParameter("pid", pid);
        
        List<Project> result = query.getResultList();

        return result;
    }    

    public boolean removeProjectParticipants(String projectId, List<ProjectParticipants> participantsList) {
        int pid = Integer.parseInt(projectId);
        //Project project = manager.find(Project.class, pid);
        String naiveQuery = "DELETE FROM ProjectParticipants pp where "
                + "pp.projectParticipantsPK.projectId= :pid";

        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);
        int i = query.executeUpdate();
        //System.out.println("i = " +i);
        return true;
    }

    public boolean editProjectParticipants(String projectId, List<ProjectParticipants> participantsList) {
        boolean success = false;

        try {
            int id = Integer.parseInt(projectId);
            Project project = manager.find(Project.class, id);

            Set<ProjectParticipants> ppSet = project.getProjectParticipantsSet();
            for (ProjectParticipants projectParticipants : ppSet) {
                //  System.out.println("id for set : " + projectParticipants.getProject().getId());
            }

            Set<ProjectParticipants> projectParticipantsSet = new HashSet<ProjectParticipants>();
            ProjectParticipants projectParticipants = new ProjectParticipants();



            for (int i = 0; i < participantsList.size(); i++) {
                ProjectParticipants assignParticipantsToProject = participantsList.get(i);
                //   System.out.println("here proj is : " + id);
                //   System.out.println("here id is : " + assignParticipantsToProject.getParticipantDesignation().getId());
                //   System.out.println("here part is : " + assignParticipantsToProject.getParticipants().getId());
                projectParticipants = new ProjectParticipants(id,
                        assignParticipantsToProject.getProjectParticipantsPK().getParticipantId(),
                        assignParticipantsToProject.getProjectParticipantsPK().getDesignation());

                //System.out.println("participant name : " + projectParticipants.getProjectParticipantsPK().getParticipantId());
                // System.out.println("removed : " + removed);
                projectParticipantsSet.add(projectParticipants);

            }
            project.setProjectParticipantsSet(projectParticipantsSet);

         //   manager.merge(project);
            manager.persist(project);
            success = true;
        } catch (Exception ex) {
            success = false;
        }
        return success;
    }
    
    public boolean addParticipant(String[] array) {
        boolean success = false;
        String title = array[0];
        String firstName = array[1];
        String middleName = array[2];
        String lastName = array[3];
        String position = array[4];
        String email = array[5];
        String phone = array[6];
        String organization = array[7];
        
        Participants participants = new Participants(title, firstName, middleName, 
                lastName, position, email, phone, organization);
        manager.persist(participants);
        success = true;
        
        return success;
    }
}
