/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Entity.Filetypes;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectFilesMap;
import com.src.frugalinnovationlab.Model.MediaModel;
import com.src.frugalinnovationlab.view.EditMediaPanel;
import com.src.frugalinnovationlab.view.ViewMediaPanel;
import com.src.frugalinnovationlab.view.Welcome;
import java.util.List;
import java.util.Set;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author hinsenchan
 */
public class MediaController implements ListSelectionListener {
    private ViewMediaPanel viewMediaPanel;
    private EditMediaPanel editMediaPanel;
    private MediaModel mediaModel;
    private Welcome mainApplication;
    private ListSelectionModel selectModel;    
    
    public MediaController(ViewMediaPanel viewMediaPanel) {
        this.viewMediaPanel = viewMediaPanel;
        mainApplication = viewMediaPanel.getMainApplication();
        mediaModel = new MediaModel();        
    }
    
    public MediaController(EditMediaPanel editMediaPanel) {
        this.editMediaPanel = editMediaPanel;
        mainApplication = editMediaPanel.getMainApplication();
        mediaModel = new MediaModel();
    }
    
    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = mediaModel.getProjectsFromDatabase();
        return projectList;
    }    
    
    public Project getProjectByIdFromDatabase(int projectId) {
        Project project = mediaModel.getProjectByIdFromDatabase(projectId);
        return project;
    }    
    
    public List<Filetypes> getFileTypesFromDatabase() {
        List<Filetypes> fileTypeList = mediaModel.getFileTypesFromDatabase();
        return fileTypeList;
    }    
    
    public boolean updateProjectWithProjectFilesMap(
            int selectedProjectId, Set<ProjectFilesMap> projectFilesMapList) {
        if (mediaModel.updateProjectWithProjectFilesMap(
            selectedProjectId, projectFilesMapList)) {
            return true;
        }
        return false;
    }
    
    public List<ProjectFilesMap> fetchProjectFilesMapByProject(int projectId) {
        List<ProjectFilesMap> projectFilesMapList = mediaModel.fetchProjectFilesMapByProject(projectId);
        return projectFilesMapList;
    }
    
    public void valueChanged(ListSelectionEvent e) { 
        selectModel = (ListSelectionModel) e.getSource();        
	int firstIndex = selectModel.getMinSelectionIndex(); 
        if (firstIndex > -1) {
            //showViewParticipantDetails(firstIndex);
        }
    }
}
