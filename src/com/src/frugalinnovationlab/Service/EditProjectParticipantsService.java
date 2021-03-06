/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.ParticipantDesignation;
import com.src.frugalinnovationlab.Entity.Participants;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectParticipants;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
                + "FROM Project p where p.archive = 'no' order by p.name", Project.class);
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
                + "FROM Participants p order by p.lastname", Participants.class);
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

    public List<Project> fetchProjectsByParticipant(String participanttId) {
        int pid = Integer.parseInt(participanttId);

        TypedQuery<Project> query = manager.createQuery("SELECT DISTINCT NEW com.src.frugalinnovationlab.Entity.Project"
                + "(p.id, p.name, p.shortdesc,p.startDate,p.endDate,p.scope,p.display) FROM Project p "
                + "LEFT OUTER JOIN p.participantsList pl WHERE pl.id = :pid", Project.class);
        query.setParameter("pid", pid);

        List<Project> result = query.getResultList();

        return result;
    }

    public List<Project> fetchActiveProjectsByParticipant(String participanttId) {
        int pid = Integer.parseInt(participanttId);

        TypedQuery<Project> query = manager.createQuery("SELECT DISTINCT NEW com.src.frugalinnovationlab.Entity.Project"
                + "(p.id, p.name, p.shortdesc,p.startDate,p.endDate,p.scope,p.display) FROM Project p "
                + "LEFT OUTER JOIN p.participantsList pl WHERE pl.id = :pid AND p.archive = 'no'", Project.class);
        query.setParameter("pid", pid);
        List<Project> result = query.getResultList();
        return result;
    }

    public boolean removeProjectParticipants(String projectId, List<ProjectParticipants> participantsList) {
        int pid = Integer.parseInt(projectId);
        String naiveQuery = "DELETE FROM ProjectParticipants pp where "
                + "pp.projectParticipantsPK.projectId= :pid";
        Query query = manager.createQuery(naiveQuery);
        query.setParameter("pid", pid);
        int i = query.executeUpdate();
        return true;
    }

    public boolean editProjectParticipants(String projectId, List<ProjectParticipants> participantsList) {
        boolean success = false;
        try {
            int id = Integer.parseInt(projectId);
            Project project = manager.find(Project.class, id);
            Set<ProjectParticipants> ppSet = project.getProjectParticipantsSet();
            Set<ProjectParticipants> projectParticipantsSet = new HashSet<ProjectParticipants>();
            ProjectParticipants projectParticipants = new ProjectParticipants();
            for (int i = 0; i < participantsList.size(); i++) {
                ProjectParticipants assignParticipantsToProject = participantsList.get(i);
                projectParticipants = new ProjectParticipants(id,
                        assignParticipantsToProject.getProjectParticipantsPK().getParticipantId(),
                        assignParticipantsToProject.getProjectParticipantsPK().getDesignation());
                projectParticipantsSet.add(projectParticipants);
            }
            project.setProjectParticipantsSet(projectParticipantsSet);
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
        int id = Integer.parseInt(array[8]);

        Participants participants = new Participants(id, title, firstName, middleName,
                lastName, position, email, phone, organization);
        manager.persist(participants);
        success = true;

        return success;
    }

    public List<Participants> getParticipantsSortByID() {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

        CriteriaQuery<Participants> criteriaQuery = criteriaBuilder.createQuery(Participants.class);
        Root participantsRoot = criteriaQuery.from(Participants.class);
        criteriaQuery.select(criteriaBuilder.construct(Participants.class, participantsRoot.get("id")));
        criteriaQuery.orderBy(criteriaBuilder.asc(participantsRoot.get("id")));
        TypedQuery<Participants> query = manager.createQuery(criteriaQuery);
        List<Participants> result = query.getResultList();
        
        return result;
    }
}
