/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.src.frugalinnovationlab.view;

import com.src.frugalinnovationlab.Controller.MediaController;
import com.src.frugalinnovationlab.Entity.Filetypes;
import com.src.frugalinnovationlab.Entity.Project;
import com.src.frugalinnovationlab.Entity.ProjectFilesMap;
import com.src.frugalinnovationlab.Entity.ProjectFilesMapPK;
import com.src.frugalinnovationlab.Wrappers.ComboItem;
import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hinsenchan
 */
public class EditMediaPanel extends javax.swing.JPanel {
    private Welcome mainApplication;
    private MediaController mediaController;
    private int selectedProjectId;
    private DefaultTableModel model = new DefaultTableModel();
    private List<Project> projectList;
    private List<Filetypes> fileTypeList;
    private HashMap<Integer, String> fileTypeHashMap = new HashMap<Integer, String>();
    private HashMap<String, Integer> fileTypeHashMapReverse = new HashMap<String, Integer>();
    private List<ProjectFilesMap> projectFilesMapList = new ArrayList<ProjectFilesMap>();
    
    /**
     * Creates new form EditMediaPanel
     */
    public EditMediaPanel(Welcome mainApplication) {        
        this.mainApplication = mainApplication;  
        mediaController = new MediaController(this);
        projectList = mediaController.getProjectsFromDatabase();
        updateFileList();
        initComponents();
        jTable.getSelectionModel().addListSelectionListener(mediaController);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        selectFileTextField = new javax.swing.JTextField();
        updateProjectButton = new javax.swing.JButton();
        selectFileLabel = new javax.swing.JLabel();
        editProjectLabel = new javax.swing.JLabel();
        chooseAFileButton = new javax.swing.JButton();
        fileNameTextField = new javax.swing.JTextField();
        fileTypeLabel = new javax.swing.JLabel();
        fileNameLabel = new javax.swing.JLabel();
        fileTypeComboBox = new javax.swing.JComboBox();
        addMediaButton = new javax.swing.JButton();
        jTableScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        projectNameLabel = new javax.swing.JLabel();
        chooseProjectComboBox = new javax.swing.JComboBox();
        removeMediaButton = new javax.swing.JButton();
        viewMediaButton = new javax.swing.JButton();

        mainScrollPane.setBorder(null);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        selectFileTextField.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        updateProjectButton.setForeground(new java.awt.Color(0, 95, 45));
        updateProjectButton.setText("Update Project");
        updateProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProjectButtonActionPerformed(evt);
            }
        });

        selectFileLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        selectFileLabel.setText("Select File");

        editProjectLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        editProjectLabel.setText("Edit Project Multimedia");

        chooseAFileButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        chooseAFileButton.setForeground(new java.awt.Color(0, 95, 45));
        chooseAFileButton.setText("Choose a file");
        chooseAFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseAFileButtonActionPerformed(evt);
            }
        });

        fileNameTextField.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        fileTypeLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        fileTypeLabel.setText("File Type");

        fileNameLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        fileNameLabel.setText("File Name");

        fileTypeComboBox.addItem("Select File Type");
        for (int i = 0; i < fileTypeList.size(); i++) {
            fileTypeComboBox.addItem(new ComboItem(fileTypeList.get(i).getType(), Integer.toString(fileTypeList.get(i).getId())));
        }

        addMediaButton.setText("Add Media");
        addMediaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMediaButtonActionPerformed(evt);
            }
        });

        jTable.setAutoCreateRowSorter(true);
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File Type", "File Name", "File Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableScrollPane.setViewportView(jTable);

        projectNameLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        projectNameLabel.setText("Project Name");

        chooseProjectComboBox.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        chooseProjectComboBox.setForeground(new java.awt.Color(0, 95, 45));
        chooseProjectComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose a project..." }));
        for (int i = 0; i < projectList.size(); i++) {
            chooseProjectComboBox.addItem(new ComboItem(projectList.get(i).getName(),
                String.valueOf(projectList.get(i).getId())));
    }
    chooseProjectComboBox.setMaximumSize(new java.awt.Dimension(200, 200));
    chooseProjectComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chooseProjectComboBoxActionPerformed(evt);
        }
    });

    removeMediaButton.setText("Remove Media");
    removeMediaButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            removeMediaButtonActionPerformed(evt);
        }
    });

    viewMediaButton.setForeground(new java.awt.Color(0, 95, 45));
    viewMediaButton.setText("View Media");
    viewMediaButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            viewMediaButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
    mainPanel.setLayout(mainPanelLayout);
    mainPanelLayout.setHorizontalGroup(
        mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(mainPanelLayout.createSequentialGroup()
            .addGap(41, 41, 41)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileNameLabel)
                            .addComponent(projectNameLabel)
                            .addComponent(fileTypeLabel))
                        .addGap(30, 30, 30)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(selectFileTextField)
                                    .addComponent(chooseProjectComboBox, 0, 350, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooseAFileButton))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(fileTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                        .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                        .addComponent(addMediaButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeMediaButton))))
                    .addComponent(editProjectLabel))
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addComponent(viewMediaButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateProjectButton)))
            .addContainerGap(84, Short.MAX_VALUE))
    );
    mainPanelLayout.setVerticalGroup(
        mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(mainPanelLayout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(editProjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(chooseProjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(projectNameLabel))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(selectFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(chooseAFileButton)
                .addComponent(selectFileLabel))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(fileTypeLabel)
                .addComponent(fileTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(17, 17, 17)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(fileNameLabel)
                .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(addMediaButton)
                .addComponent(removeMediaButton))
            .addGap(26, 26, 26)
            .addComponent(jTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(updateProjectButton)
                .addComponent(viewMediaButton))
            .addGap(22, 22, 22))
    );

    mainScrollPane.setViewportView(mainPanel);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 725, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 600, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void updateProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProjectButtonActionPerformed
        if (selectedProjectId != -1) {
            final int TYPE = 0;
            final int NAME = 1;
            final int LOCATION = 2;
            
            projectFilesMapList.clear();
            
            for (int i=0; i<jTable.getRowCount(); i++) {
                String fileTypeName = jTable.getModel().getValueAt(i, TYPE).toString();
                int fileTypeId = fileTypeHashMapReverse.get(fileTypeName);
                
                String fileName = jTable.getModel().getValueAt(i, NAME).toString();
                String fileLocation = jTable.getModel().getValueAt(i, LOCATION).toString();
                ProjectFilesMap projectFilesMap = new ProjectFilesMap(
                        selectedProjectId, fileTypeId, fileName, fileLocation);
                projectFilesMapList.add(projectFilesMap);
                
                //System.out.println(fileTypeName);
                //System.out.println(fileTypeId);
                //System.out.println(fileName);
                //System.out.println(fileLocation);
            }
            System.out.println(projectFilesMapList.size());
            System.out.println(projectFilesMapList.toString());
            if (mediaController.updateProjectWithProjectFilesMap(selectedProjectId, projectFilesMapList)) {
                JOptionPane.showMessageDialog(this, "Project Updated Successfully");
            }
            else {
                JOptionPane.showMessageDialog(this, "Project Update Failed");
            }
        }
    }//GEN-LAST:event_updateProjectButtonActionPerformed

    private void chooseAFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseAFileButtonActionPerformed
        selectFileTextField.setText("");
        JFileChooser chooser = new JFileChooser("File Dialog");
        chooser.setMultiSelectionEnabled(false);
        chooser.showOpenDialog(this);
        File f = chooser.getSelectedFile();        
        selectFileTextField.setText(f.getAbsolutePath());
    }//GEN-LAST:event_chooseAFileButtonActionPerformed

    private void addMediaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMediaButtonActionPerformed
        String location = selectFileTextField.getText();
        Object typeItem = fileTypeComboBox.getSelectedItem();
        String typeValue = ((ComboItem) typeItem).getValue();
        String name = fileNameTextField.getText();
        //System.out.println("type : " +typeItem+ " - " +typeValue);
        //System.out.println("location : " +location+ " - " +name);
        Object[] row = {typeItem, name, location};
        model = (DefaultTableModel) jTable.getModel();
        model.addRow(row);

        selectFileTextField.setText("");
        fileNameTextField.setText("");
        fileTypeComboBox.setSelectedItem("Select File Type");
    }//GEN-LAST:event_addMediaButtonActionPerformed

    private void chooseProjectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseProjectComboBoxActionPerformed
        Object projectItem = chooseProjectComboBox.getSelectedItem();
        //System.out.println("object item : " +projectItem);

        if (!projectItem.toString().equals("Choose a project...")) {
            int projectId = Integer.parseInt(((ComboItem) projectItem).getValue());
            //String projectId = String.valueOf(((ComboItem) projectItem).getValue());
            String projectName = String.valueOf(((ComboItem) projectItem).getKey());
            //System.out.println("project id : " + projectId);
            
            selectedProjectId = projectId;

            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
                        
            List result = mediaController.fetchProjectFilesMapByProject(projectId);
            //projectFilesMapList.clear();

            for (int i = 0; i < result.size(); i++) {
                ProjectFilesMap projectFile = (ProjectFilesMap)result.get(i);
                //projectFilesMapList.add(projectFile);
                ProjectFilesMapPK projectFileDetails = projectFile.getProjectFilesMapPK();

                int fileTypeId = projectFileDetails.getFiletypeid();
                String fileType = fileTypeHashMap.get(fileTypeId);
                String fileName = projectFileDetails.getFilename();
                String filePath = projectFileDetails.getFilepath();
                
                Object[] row = {fileType, fileName, filePath};
                
                model = (DefaultTableModel) jTable.getModel();
                model.addRow(row);
            }            
        } else {
            selectedProjectId = -1;
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }                        
        }        
    }//GEN-LAST:event_chooseProjectComboBoxActionPerformed

    private void removeMediaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMediaButtonActionPerformed
        int[] selectedFiles = jTable.getSelectedRows();
        model = (DefaultTableModel) jTable.getModel();
        for (int i=selectedFiles.length-1; i>=0; i--) {
            model.removeRow(selectedFiles[i]);    
        }        
    }//GEN-LAST:event_removeMediaButtonActionPerformed

    private void viewMediaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMediaButtonActionPerformed
        final int LOCATION = 2;
        int selectedFile = jTable.getSelectedRow();
        String fileLocation = (String) jTable.getValueAt(selectedFile, LOCATION);
        if (!fileLocation.isEmpty()) {
            try {
                File file = new File(fileLocation);
            
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Unable to open file or directory.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_viewMediaButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMediaButton;
    private javax.swing.JButton chooseAFileButton;
    private javax.swing.JComboBox chooseProjectComboBox;
    private javax.swing.JLabel editProjectLabel;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JComboBox fileTypeComboBox;
    private javax.swing.JLabel fileTypeLabel;
    private javax.swing.JTable jTable;
    private javax.swing.JScrollPane jTableScrollPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JButton removeMediaButton;
    private javax.swing.JLabel selectFileLabel;
    private javax.swing.JTextField selectFileTextField;
    private javax.swing.JButton updateProjectButton;
    private javax.swing.JButton viewMediaButton;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the mainApplication
     */
    public Welcome getMainApplication() {
        return mainApplication;
    }

    /**
     * @param mainApplication the mainApplication to set
     */
    public void setMainApplication(Welcome mainApplication) {
        this.mainApplication = mainApplication;
    }

    /**
     * @return the jTable
     */
    public javax.swing.JTable getjTable() {
        return jTable;
    }

    /**
     * @param jTable the jTable to set
     */
    public void setjTable(javax.swing.JTable jTable) {
        this.jTable = jTable;
    }
    
    public void updateFileList() {
        fileTypeList = mediaController.getFileTypesFromDatabase(); 
        fileTypeHashMap.clear();
        fileTypeHashMapReverse.clear();
        for (int i=0; i<fileTypeList.size(); i++) {
            int id = fileTypeList.get(i).getId();
            String type = fileTypeList.get(i).getType();
            fileTypeHashMap.put(id, type);
            fileTypeHashMapReverse.put(type, id);
        }        
    }
}
