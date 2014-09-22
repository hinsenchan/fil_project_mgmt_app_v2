/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Entity.Filetypes;
import com.src.frugalinnovationlab.Entity.ParticipantDesignation;
import com.src.frugalinnovationlab.Entity.Participants;
import com.src.frugalinnovationlab.Entity.ProjectCategory;
import com.src.frugalinnovationlab.Entity.ProjectFilesMap;
import com.src.frugalinnovationlab.Entity.ProjectStatus;
import com.src.frugalinnovationlab.Entity.Tags;
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
    
    public List<Tags> getTagsFromDatabase() {
        List<Tags> tagsList = addNewProjectModel.getTagsFromDatabase();
        return tagsList;
    }
    
    public boolean addParticipant(String[] array){
        boolean success = true;
        success = addNewProjectModel.addParticipant(array);
        return success;
    }
    
    public boolean addNewTags(List<Tags> currentList, String[] array) {
        boolean success = true;
        success = addNewProjectModel.addNewTags(currentList, array);
        return success;
    }
    
    public List<Filetypes> fetchFileTypes() {
        List<Filetypes> fileTypeList = addNewProjectModel.fetchFileTypes();
        return fileTypeList;
    }
    
    public boolean addProject(String[] array, List<String> categoriesList, ArrayList<AssignParticipantsToProject> participantsList,
            List<ProjectFilesMap> projectFiles, List<String> selectedTagsList){
        boolean success = true;
        success = addNewProjectModel.addProject(array, categoriesList, participantsList, projectFiles, selectedTagsList);
        return success;
    }
    
    public boolean deleteTags(List<String> deleteTagList) {
        boolean success = false;
        success = addNewProjectModel.deletetags(deleteTagList);
        return success;
    }
    
    public List<Participants> getParticipantsSortByID() {
        List<Participants> participantList = addNewProjectModel.getParticipantsSortByID();
        return participantList;
    }
}
