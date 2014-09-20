/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.view;

import javax.swing.JMenuBar;

/**
 *
 * @author hinsenchan
 */
public abstract class WelcomeAbstract extends javax.swing.JFrame{
    public abstract javax.swing.JPanel getContentPanel();    
    public abstract String getLastComponent();    
    public abstract void setLastComponent(String lastComponent);    
    public abstract ViewParticipantDetails getViewParticipantDetails();    
    public abstract void setViewParticipantDetails(ViewParticipantDetails viewParticipantDetails);    
    public abstract ViewProjectParticipants getViewProjectParticipants();    
    public abstract void setViewProjectParticipants(ViewProjectParticipants viewProjectParticipants);
    public abstract ViewGeneralProjectInformation getViewGeneralProjectInformation();    
    public abstract void setViewGeneralProjectInformation(ViewGeneralProjectInformation viewGeneralProjectInformation);
    public abstract ViewProjectPanel getViewProjectPanel();
    public abstract void setViewProjectPanel(ViewProjectPanel viewProjectPanel);
    public abstract String getSelectedProject();
    public abstract void setSelectedProject(String selectedProject);    
    public abstract JMenuBar createMenuBar ();    
    public abstract AdvancedSearchPanel getAdvancedSearchPanel();
    public abstract void setAdvancedSearchPanel(AdvancedSearchPanel advancedSearchPanel);
    public abstract SearchPanel getSearchPanel();
    public abstract void setSearchPanel(SearchPanel searchPanel);
    public abstract EditProjectPanel getEditProjectPanel();
    public abstract void setEditProjectPanel(EditProjectPanel editProjectPanel);
    public abstract EditMediaPanel getEditMediaPanel();
    public abstract void setEditMediaPanel(EditMediaPanel editMediaPanel);
    public abstract ViewMediaPanel getViewMediaPanel();
    public abstract void setViewMediaPanel(ViewMediaPanel viewMediaPanel);
    public abstract ViewAllUsersPanel getViewAllUsersPanel();
    public abstract void setViewAllUsersPanel(ViewAllUsersPanel viewAllUsersPanel);
    public abstract AddNewUserPanel getAddNewUserPanel();
    public abstract void setAddNewUserPanel(AddNewUserPanel addNewUserPanel);
}
