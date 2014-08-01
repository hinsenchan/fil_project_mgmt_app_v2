/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

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
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import com.src.frugalinnovationlab.Model.AddNewProjectModel;
import com.src.frugalinnovationlab.Wrappers.AssignParticipantsToProject;
import com.src.frugalinnovationlab.view.AddNewProjectPanel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaishreeganesh
 */
public class AddNewProjectController {

    private AddNewProjectPanel gui;
    private AddNewProjectModel addNewProjectModel;

    public AddNewProjectController(AddNewProjectPanel gui) {
        this.gui = gui;
        addNewProjectModel = new AddNewProjectModel();
    }
    
    public List<ProjectStatus> getProjectStatusFromDatabase() {
        List<ProjectStatus> projectStatusList = addNewProjectModel.getProjectStatusFromDatabase();
        return projectStatusList;
    }
    
    public List<ProjectCategory> getProjectCategoriesFromDatabase() {
        List<ProjectCategory> projectCategoryList = addNewProjectModel.getProjectCategoriesFromDatabase();
        return projectCategoryList;
    }
    
    public List<ParticipantDesignation> getParticipantsDesignationFromDatabase() {
        List<ParticipantDesignation> participantDesignationList = addNewProjectModel.getProjectDesignationsFromDatabase();
        return participantDesignationList;
    }
    
    public List<Participants> getParticipantsFromDatabase() {
        List<Participants> participantList = addNewProjectModel.getParticipantsFromDatabase();
        return participantList;
    }
    
    public boolean addProject(String[] array, List<String> categoriesList, ArrayList<AssignParticipantsToProject> participantsList,
            List<MediaVideo> videoList, List<MediaPlaintext> plainTextList, List<MediaAdobe> adobeFileList, 
            List<MediaCad> cadFileList, List<MediaCode> codeFileList, List<MediaHyperlink> hyperLinkList,
            List<MediaPdf> pdfList, List<MediaPhotos> photosList, List<MediaSpreadsheet> spreadSheetList,
            List<MediaWord> wordList){
        boolean success = true;
        success = addNewProjectModel.addProject(array, categoriesList, participantsList, videoList, plainTextList
                , adobeFileList, cadFileList, codeFileList, hyperLinkList, pdfList, photosList, spreadSheetList, wordList);
        return success;
    }
    
    public boolean addParticipant(String[] array){
        boolean success = true;
        success = addNewProjectModel.addParticipant(array);
        return success;
    }
}
