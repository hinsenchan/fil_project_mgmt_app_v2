/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Model;

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
import com.src.frugalinnovationlab.Entity.ProjectCategory;
import com.src.frugalinnovationlab.Entity.ProjectFilesMap;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import com.src.frugalinnovationlab.Entity.Tags;
import com.src.frugalinnovationlab.Service.AddNewProjectService;
import com.src.frugalinnovationlab.Wrappers.AssignParticipantsToProject;
import com.src.frugalinnovationlab.helper.Constants;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Jaishreeganesh
 */
public class AddNewProjectModel {

    private static EntityManagerFactory factory;  // JPA  
    private EntityManager manager;
    private ProjectStatus projectStatus;
    private AddNewProjectService addNewProjectService;

    public AddNewProjectModel() {

        factory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        projectStatus = new ProjectStatus();
        addNewProjectService = new AddNewProjectService(manager);

    }

    public List<ProjectStatus> getProjectStatusFromDatabase() {
        List<ProjectStatus> projectStatusList = addNewProjectService.fetchProjectStatus();
        return projectStatusList;
    }

    public List<ProjectCategory> getProjectCategoriesFromDatabase() {
        List<ProjectCategory> projectCategoryList = addNewProjectService.fetchProjectCategories();
        return projectCategoryList;
    }
    
    public List<ParticipantDesignation> getProjectDesignationsFromDatabase() {
        List<ParticipantDesignation> projectDesignationList = addNewProjectService.fetchParticipantDesignations();
        return projectDesignationList;
    }
    
    public List<Participants> getParticipantsFromDatabase() {
        List<Participants> participantsList = addNewProjectService.fetchParticipants();
        return participantsList;
    }
    
    public List<Tags> getTagsFromDatabase() {
        List<Tags> tagsList = addNewProjectService.fetchTags();
        return tagsList;
    }

    public boolean addProject(String[] array, List<String> categoriesList, ArrayList<AssignParticipantsToProject> participantsList,
            List<MediaVideo> videoList, List<MediaPlaintext> plainTextList, List<MediaAdobe> adobeFileList, 
            List<MediaCad> cadFileList, List<MediaCode> codeFileList, List<MediaHyperlink> hyperLinkList,
            List<MediaPdf> pdfList, List<MediaPhotos> photosList, List<MediaSpreadsheet> spreadSheetList,
            List<MediaWord> wordList, List<String> selectedTagsList) {
        boolean success = true;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = addNewProjectService.addProject(array, categoriesList, participantsList, videoList, plainTextList
                , adobeFileList, cadFileList, codeFileList, hyperLinkList, pdfList, photosList, 
                spreadSheetList, wordList, selectedTagsList);
        usertransaction.commit();
        return success;
    }
    
    public boolean addParticipant(String[] array) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = addNewProjectService.addParticipant(array);
        usertransaction.commit();
        return success;
    }
    
    public boolean addNewTags(List<Tags> currentList, String[] array) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin(); 
        success = addNewProjectService.addNewTags(currentList, array);
        usertransaction.commit();
        return success;
    }
    
    public List<Filetypes> fetchFileTypes() {
        List<Filetypes> fileTypeList = addNewProjectService.fetchFileTypes();
        return fileTypeList;
    }
    
    public boolean addProject(String[] array, List<String> categoriesList, ArrayList<AssignParticipantsToProject> participantsList,
            List<ProjectFilesMap> projectFiles, List<String> selectedTagsList) {
        boolean success = true;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin();
        success = addNewProjectService.addProject(array, categoriesList, participantsList, projectFiles, selectedTagsList);
        usertransaction.commit();
        return success;
    }
    
    public boolean deletetags(List<String> deleteTagList) {
        boolean success = false;
        EntityTransaction usertransaction = manager.getTransaction();
        usertransaction.begin(); 
        success = addNewProjectService.deletetags(deleteTagList);
        usertransaction.commit();
        return success;
    }
    
    public List<Participants> getParticipantsSortByID() {
        List<Participants> participantsList = addNewProjectService.getParticipantsSortByID();
        return participantsList;
    }
}
