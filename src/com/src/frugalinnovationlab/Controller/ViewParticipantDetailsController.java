/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Entity.ParticipantDesignation;
import com.src.frugalinnovationlab.Entity.Participants;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectParticipants;
import com.src.frugalinnovationlab.Model.EditProjectParticipantsModel;
import com.src.frugalinnovationlab.view.ViewGeneralProjectInformation;
import com.src.frugalinnovationlab.view.ViewParticipantDetails;
import com.src.frugalinnovationlab.view.Welcome;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Jaishreeganesh
 */
public class ViewParticipantDetailsController implements ListSelectionListener {
    private ViewParticipantDetails gui;
    private EditProjectParticipantsModel editProjectParticipantsModel;
    private Welcome mainApplication;

    public ViewParticipantDetailsController(ViewParticipantDetails gui) {
        this.gui = gui;
        editProjectParticipantsModel = new EditProjectParticipantsModel();
        mainApplication = gui.getMainApplication();
    }
    
    public List<Project> getProjectsFromDatabase() {
        List<Project> projectList = editProjectParticipantsModel.getProjectsFromDatabase();
        return projectList;
    }
    
    public List<ParticipantDesignation> getParticipantsDesignationFromDatabase() {
        List<ParticipantDesignation> participantDesignationList = editProjectParticipantsModel.getProjectDesignationsFromDatabase();
        return participantDesignationList;
    }
    
    public List<Participants> getParticipantsFromDatabase() {
        List<Participants> participantList = editProjectParticipantsModel.getParticipantsFromDatabase();
        return participantList;
    }
    
    public List<ProjectParticipants> fetchParticipantsByProject(String projectId) {
        List<ProjectParticipants> participantsList = editProjectParticipantsModel.fetchParticipantsByProject(projectId);
        return participantsList;
    }
    
    public boolean editProjectParticipants(String projectId, List<ProjectParticipants> participantsList){
        boolean success = false;
        success = editProjectParticipantsModel.editProjectParticipants(projectId, participantsList);
        return success;
    }
    
    public void valueChanged(ListSelectionEvent e) { 
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
	int firstIndex = selectModel.getMinSelectionIndex(); 
        
        showViewGeneralProjectInformation();
        //showViewGeneralProjectInformation(firstIndex);
        //setViewGeneralProjectInformationComboBox(firstIndex);
        
        //System.out.println(gui.getTable().getModel().getValueAt(0, firstIndex));
        //System.out.println(mainApplication.getViewGeneralProjectInformation().getChooseProjectComboBox().getItemAt(0).toString());
        
        
    }
    
    public void setViewGeneralProjectInformationComboBox() {
    //public void setViewGeneralProjectInformationComboBox(int index) {
        JComboBox comboBox = mainApplication.getViewGeneralProjectInformation().getChooseProjectComboBox();
        /*
        String selectedProject = (String)(gui.getTable().getModel().getValueAt(0, index));
        for (int i=0; i<comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).toString().equals(selectedProject)) {                
                try {
                    System.out.println(comboBox.getItemAt(i).toString());
                    System.out.println(i);
                    System.out.println(comboBox.getItemCount());
                    //comboBox.setSelectedIndex(i+1);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                finally {
                    break;
                }
            }
        }
                */
        //System.out.println("dfadfadfdafa");
    }
    
    public void showViewGeneralProjectInformation() {
    //public void showViewGeneralProjectInformation(int index) {
        mainApplication.setViewGeneralProjectInformation(new ViewGeneralProjectInformation(mainApplication));
        //setViewGeneralProjectInformationComboBox(index);
        mainApplication.getContentPanel().remove(mainApplication.getViewParticipantDetails());
        mainApplication.getContentPanel().add(mainApplication.getViewGeneralProjectInformation());
        mainApplication.setLastComponent("View Project General Info");        
        mainApplication.getContentPanel().revalidate();
    }             
}
