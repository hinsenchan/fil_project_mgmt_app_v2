/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.Controller;

import com.src.frugalinnovationlab.Model.EditProjectParticipantsModel;
import com.src.frugalinnovationlab.view.ViewParticipantDetails;
import com.src.frugalinnovationlab.view.WelcomeAbstract;
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
    private WelcomeAbstract mainApplication;

    public ViewParticipantDetailsController(ViewParticipantDetails gui) {
        this.gui = gui;
        editProjectParticipantsModel = new EditProjectParticipantsModel();
        mainApplication = gui.getMainApplication();
    }

    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
        int firstIndex = selectModel.getMinSelectionIndex();

        if (firstIndex > -1) {
            mainApplication.getViewProjectParticipants().setIsSelectAll(false);
            setSelectedProject(firstIndex);
            showViewGeneralProjectInformation();
        }
    }

    public void setSelectedProject(int index) {
        final int projectNameCol = 0;
        //System.out.println("index:" + index);
        mainApplication.setSelectedProject(gui.getTable().getValueAt(index, projectNameCol).toString());
    }

    public void showViewGeneralProjectInformation() {
        if (mainApplication.getLastComponent().equals("View Participant Details")) {
            mainApplication.getContentPanel().removeAll();

            //mainApplication.getContentPanel().remove(mainApplication.getViewParticipantDetails());
            mainApplication.getContentPanel().add(mainApplication.getViewGeneralProjectInformation());

            mainApplication.setLastComponent("View Projects General Info");
            mainApplication.getViewProjectParticipants().refreshSelectedProject();
            mainApplication.getViewMediaPanel().refreshSelectedProject();
            mainApplication.getViewGeneralProjectInformation().refreshSelectedProject();
            mainApplication.getContentPanel().revalidate();
            mainApplication.getContentPanel().repaint();
        }
    }

    public void showViewProjectParticipants() {
        mainApplication.getContentPanel().remove(mainApplication.getViewParticipantDetails());
        mainApplication.getContentPanel().add(mainApplication.getViewProjectParticipants());
        mainApplication.setLastComponent("View Projects Participants");

        mainApplication.getViewGeneralProjectInformation().refreshSelectedProject();
        mainApplication.getViewProjectParticipants().refreshSelectedProject();
        mainApplication.getViewMediaPanel().refreshSelectedProject();
        mainApplication.getContentPanel().revalidate();
        mainApplication.getContentPanel().repaint();
    }
}
