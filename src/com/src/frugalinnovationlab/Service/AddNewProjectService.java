/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Service;

import com.src.frugalinnovationlab.Entity.Filetypes;
import com.src.frugalinnovationlab.Entity.MediaAdobe;
import com.src.frugalinnovationlab.Entity.MediaCad;
import com.src.frugalinnovationlab.Entity.MediaCode;
import com.src.frugalinnovationlab.Entity.MediaHyperlink;
import com.src.frugalinnovationlab.Entity.MediaPdf;
import com.src.frugalinnovationlab.Entity.MediaPhotos;
import com.src.frugalinnovationlab.Entity.MediaPlaintext;
import com.src.frugalinnovationlab.Entity.MediaSpreadsheet;
import com.src.frugalinnovationlab.Entity.MediaVideo;
import com.src.frugalinnovationlab.Entity.MediaWord;
import com.src.frugalinnovationlab.Entity.ParticipantDesignation;
import com.src.frugalinnovationlab.Entity.Participants;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectCategory;
import com.src.frugalinnovationlab.Entity.ProjectFilesMap;
import com.src.frugalinnovationlab.Entity.ProjectParticipants;
import com.src.frugalinnovationlab.Entity.ProjectParticipantsPK;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import com.src.frugalinnovationlab.Entity.Tags;
import com.src.frugalinnovationlab.Wrappers.AssignParticipantsToProject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AddNewProjectService {

    private EntityManager manager;

    public AddNewProjectService(EntityManager manager) {
        this.manager = manager;
    }

    public List<ProjectStatus> fetchProjectStatus() {
        TypedQuery<ProjectStatus> query = manager.createQuery("SELECT NEW "
                + "com.src.frugalinnovationlab.Entity.ProjectStatus(p.status, p.statusDescription) "
                + "FROM ProjectStatus p", ProjectStatus.class);
        List<ProjectStatus> result = query.getResultList();
        return result;
    }

    public List<ProjectStatus> fetchAllParticipants() {
        TypedQuery<ProjectStatus> query = manager.createQuery("SELECT NEW "
                + "com.src.frugalinnovationlab.Entity.ProjectStatus(p.status, p.statusDescription) "
                + "FROM ProjectStatus p", ProjectStatus.class);
        List<ProjectStatus> result = query.getResultList();
        return result;
    }

    public List<ProjectCategory> fetchProjectCategories() {
        TypedQuery<ProjectCategory> query = manager.createQuery("SELECT NEW "
                + "com.src.frugalinnovationlab.Entity.ProjectCategory(c.name) "
                + "FROM ProjectCategory c", ProjectCategory.class);
        List<ProjectCategory> result = query.getResultList();
        return result;
    }

    public boolean addProject(String[] array, List<String> categoriesList, ArrayList<AssignParticipantsToProject> participantsList,
            List<MediaVideo> videoList, List<MediaPlaintext> plainTextList, List<MediaAdobe> adobeFileList,
            List<MediaCad> cadFileList, List<MediaCode> codeFileList, List<MediaHyperlink> hyperLinkList,
            List<MediaPdf> pdfList, List<MediaPhotos> photosList, List<MediaSpreadsheet> spreadSheetList,
            List<MediaWord> wordList, List<String> selectedTagsList) {
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
            int projectId = Integer.parseInt(array[9]);
            projectId = this.generateProjectId();
            HashSet<ProjectCategory> projectCategorySet = new HashSet<ProjectCategory>();
            HashSet<Tags> projectTagsSet = new HashSet<Tags>();

            ProjectStatus projectStatus1 = manager.find(ProjectStatus.class, status);//new ProjectStatus();
            projectStatus1.setStatus(projectStatus1.getStatus());

            Project project1 = new Project(projectId, projectName, shortDesc, startDate, endDate, scope,
                    outcome, true, longDesc, location);

            HashSet<ProjectStatus> projectStatusSet = new HashSet<ProjectStatus>();
            projectStatusSet.add(projectStatus1);


            project1.setProjectStatusSet(projectStatusSet);
            project1.setProjectCategories(projectCategorySet);
            project1.setTagsSet(projectTagsSet);
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

            HashSet<MediaVideo> videoSet = new HashSet<MediaVideo>();
            for (int i = 0; i < videoList.size(); i++) {
                MediaVideo mediaVideo = videoList.get(i);
                videoSet.add(mediaVideo);
                //manager.persist(mediaVideo);
                mediaVideo.setProjects(project1);
            }
            project1.setVideos(videoSet);

            HashSet<MediaPlaintext> plainTextSet = new HashSet<MediaPlaintext>();
            for (int i = 0; i < plainTextList.size(); i++) {
                MediaPlaintext mediaPlaintext = plainTextList.get(i);
                plainTextSet.add(mediaPlaintext);
                //manager.persist(mediaVideo);
                mediaPlaintext.setProjects(project1);
            }
            project1.setPlainTexts(plainTextSet);

            HashSet<MediaAdobe> adobeSet = new HashSet<MediaAdobe>();
            for (int i = 0; i < adobeFileList.size(); i++) {
                MediaAdobe mediaAdobe = adobeFileList.get(i);
                adobeSet.add(mediaAdobe);
                mediaAdobe.setProjects(project1);
            }
            project1.setAdobes(adobeSet);

            HashSet<MediaCad> cadSet = new HashSet<MediaCad>();
            for (int i = 0; i < cadFileList.size(); i++) {
                MediaCad mediaCad = cadFileList.get(i);
                cadSet.add(mediaCad);
                mediaCad.setProjects(project1);
            }
            project1.setCads(cadSet);

            HashSet<MediaCode> codeSet = new HashSet<MediaCode>();
            for (int i = 0; i < codeFileList.size(); i++) {
                MediaCode mediaCode = codeFileList.get(i);
                codeSet.add(mediaCode);
                mediaCode.setProjects(project1);
            }
            project1.setCodes(codeSet);

            HashSet<MediaHyperlink> hyperLinkSet = new HashSet<MediaHyperlink>();
            for (int i = 0; i < hyperLinkList.size(); i++) {
                MediaHyperlink mediaHyperLink = hyperLinkList.get(i);
                hyperLinkSet.add(mediaHyperLink);
                mediaHyperLink.setProjects(project1);
            }
            project1.setHyperLinks(hyperLinkSet);

            HashSet<MediaPdf> pdfSet = new HashSet<MediaPdf>();
            for (int i = 0; i < pdfList.size(); i++) {
                MediaPdf mediaPdf = pdfList.get(i);
                pdfSet.add(mediaPdf);
                mediaPdf.setProjects(project1);
            }
            project1.setPdfs(pdfSet);

            HashSet<MediaPhotos> photoSet = new HashSet<MediaPhotos>();
            for (int i = 0; i < photosList.size(); i++) {
                MediaPhotos mediaPhotos = photosList.get(i);
                photoSet.add(mediaPhotos);
                mediaPhotos.setProjects(project1);
            }
            project1.setPhotos(photoSet);

            HashSet<MediaSpreadsheet> spreadSheetSet = new HashSet<MediaSpreadsheet>();
            for (int i = 0; i < spreadSheetList.size(); i++) {
                MediaSpreadsheet mediaSpreadSheet = spreadSheetList.get(i);
                spreadSheetSet.add(mediaSpreadSheet);
                mediaSpreadSheet.setProjects(project1);
            }
            project1.setSpreadSheets(spreadSheetSet);

            HashSet<MediaWord> wordSet = new HashSet<MediaWord>();
            for (int i = 0; i < wordList.size(); i++) {
                MediaWord mediaWord = wordList.get(i);
                wordSet.add(mediaWord);
                mediaWord.setProjects(project1);
            }
            project1.setWords(wordSet);



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

    public List<Tags> fetchTags() {
        TypedQuery<Tags> query = manager.createQuery("SELECT NEW "
                + "com.src.frugalinnovationlab.Entity.Tags(p.tagname) "
                + "FROM Tags p", Tags.class);
        List<Tags> result = query.getResultList();
        return result;
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

    public boolean addNewTags(List<Tags> currentList, String[] array) {
        boolean success = false;

        for (int i = 0; i < array.length; i++) {
            if (!currentList.contains(array[i].trim())) {
                String tagName = array[i].trim();
                Tags tags = new Tags(tagName);
                manager.persist(tags);
                success = true;
            }
        }
        return success;
    }

    public List<Filetypes> fetchFileTypes() {
        TypedQuery<Filetypes> query = manager.createQuery("SELECT NEW "
                + "com.src.frugalinnovationlab.Entity.Filetypes(f.id, f.type) "
                + "FROM Filetypes f group by f.type", Filetypes.class);
        List<Filetypes> result = query.getResultList();
        return result;
    }

    public boolean addProject(String[] array, List<String> categoriesList, ArrayList<AssignParticipantsToProject> participantsList,
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
                    outcome, true, longDesc, location, "no");

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
    }

    public List<Project> fetchProjects() {
        TypedQuery<Project> query = manager.createQuery("SELECT NEW com.src.frugalinnovationlab.Entity.Project"
                + "(p.id, p.name) "
                + "FROM Project p", Project.class);
        List<Project> result = query.getResultList();
        return result;
    }

    public int generateProjectId() {
        Random random = new Random();
        int randProjId;
        boolean isUnique;
        List<Project> existingProjs = this.fetchProjects();

        do {
            isUnique = true;
            randProjId = 1000000 + random.nextInt(1000000);
            for (int i = 0; i < existingProjs.size(); i++) {
                if (existingProjs.get(i).getId() == randProjId) {
                    isUnique = false;
                    break;
                }
            }
        } while (!isUnique);
        return randProjId;
    }

    public boolean deletetags(List<String> deleteTagsList) {
        boolean success = false;
        for (int i = 0; i < deleteTagsList.size(); i++) {
            String tagName = deleteTagsList.get(i);
            Query query = manager.createQuery("DELETE FROM Tags t where t.tagname = :tagname");
            query.setParameter("tagname", tagName);
            int count = query.executeUpdate();
            System.out.println("delete tag : " + count);
        }
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
        for (int i = 0; i < result.size(); i++) {
            System.out.println("sort id : " + result.get(i).getId());
        }
        return result;
    }
}
