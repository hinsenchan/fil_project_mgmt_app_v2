/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.view;

import com.src.frugalinnovationlab.Entity.Users;
import com.src.frugalinnovationlab.helper.Constants;
import java.awt.event.KeyEvent;
import java.util.prefs.Preferences;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.text.DefaultEditorKit;
import javax.swing.tree.TreePath;

/**
 *
 * @author diptik
 */
public class Welcome extends WelcomeAbstract {

    private AddNewUserPanel addNewUserPanel = new AddNewUserPanel(this);
    private ViewAllUsersPanel viewAllUsersPanel = new ViewAllUsersPanel(this);
    final AddNewProjectPanel addNewProjectPanel = new AddNewProjectPanel();
    private SearchPanel searchPanel = new SearchPanel(this);
    final EditParticipantPanel editParticipantPanel = new EditParticipantPanel();
    private AdvancedSearchPanel advancedSearchPanel = new AdvancedSearchPanel(this);
    Users user;
    ManageAccountInfoPanel manageAccountInfoPanel = new ManageAccountInfoPanel();
    private EditProjectPanel editProjectPanel = new EditProjectPanel(this);
    EditGeneralProjectInformation editGeneralProjectInformation;
    private EditMediaPanel editMediaPanel = new EditMediaPanel(this);
    final EditProjectParticipants editProjectParticipants = new EditProjectParticipants();
    private ViewGeneralProjectInformation viewGeneralProjectInformation = new ViewGeneralProjectInformation(this);
    private ViewProjectParticipants viewProjectParticipants = new ViewProjectParticipants(this);
    private ViewParticipantDetails viewParticipantDetails = new ViewParticipantDetails(this);
    private ViewProjectPanel viewProjectPanel = new ViewProjectPanel(this);
    private ViewMediaPanel viewMediaPanel = new ViewMediaPanel (this);
    Preferences prefs = Preferences.userNodeForPackage(com.src.frugalinnovationlab.Service.LoginService.class);
    String userType = "";
    private String selectedProject = "";
    /**
     * Creates new form Welcome
     */
    static String lastComponent = "";

    public Welcome() {
        this.setJMenuBar(createMenuBar());
        initComponents();
        welcome.setText("Welcome ".concat(prefs.get(Constants.FULL_NAME, "Guest")));
        userType = Constants.USER_TYPE;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeMainPanel = new javax.swing.JPanel();
        menuTreePanel = new javax.swing.JPanel();
        menuTreeScrollPane = new javax.swing.JScrollPane();
        optionsMenuTree = new javax.swing.JTree();
        contentPanel = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        logoLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        headerPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        manageAccountButton = new javax.swing.JButton();
        logoLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuTreePanel.setBackground(new java.awt.Color(153, 51, 0));

        optionsMenuTree.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 0, 0), 4));
        optionsMenuTree.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Frugal Lab");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Project");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("New Project");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Edit Participant");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Edit Projects");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("General Info");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Participants");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Multimedia");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("View Projects");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("General Info");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Participants");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Multimedia");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Users");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Add New User");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("View All Users");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Explore");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Search");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Advanced Search");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        optionsMenuTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        optionsMenuTree.setToolTipText("Explore");
        optionsMenuTree.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                optionsMenuTreeTreeExpanded(evt);
            }
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
            }
        });
        optionsMenuTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionsMenuTreeMouseClicked(evt);
            }
        });
        menuTreeScrollPane.setViewportView(optionsMenuTree);

        javax.swing.GroupLayout menuTreePanelLayout = new javax.swing.GroupLayout(menuTreePanel);
        menuTreePanel.setLayout(menuTreePanelLayout);
        menuTreePanelLayout.setHorizontalGroup(
            menuTreePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTreePanelLayout.createSequentialGroup()
                .addComponent(menuTreeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menuTreePanelLayout.setVerticalGroup(
            menuTreePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuTreeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 170, 153), 4));
        contentPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contentPanel.setInheritsPopupMenu(true);
        contentPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        contentPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        contentPanel.removeAll();
        contentPanel.setRequestFocusEnabled(false);

        welcome.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        welcome.setText("Welcome.");

        logoLabel2.setBackground(new java.awt.Color(255, 255, 255));
        logoLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/scu-mission.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rsz_1family.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcome)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addGap(308, 308, 308)
                    .addComponent(logoLabel2)
                    .addContainerGap(308, Short.MAX_VALUE)))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(welcome)
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addComponent(logoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(148, Short.MAX_VALUE)))
        );

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));
        headerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 0, 0), 4));

        logoLabel.setBackground(new java.awt.Color(255, 255, 255));
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Frugal_Blk_BriteRed_72dpi.jpg"))); // NOI18N

        logoutButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/signoutbutton.png"))); // NOI18N
        logoutButton.setToolTipText("");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        manageAccountButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        manageAccountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/manageaccountbutton.png"))); // NOI18N
        manageAccountButton.setToolTipText("");
        manageAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAccountButtonActionPerformed(evt);
            }
        });

        logoLabel1.setBackground(new java.awt.Color(255, 255, 255));
        logoLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Squares.jpg"))); // NOI18N

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(logoLabel)
                .addGap(18, 18, 18)
                .addComponent(logoLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addComponent(manageAccountButton)
                        .addGap(16, 16, 16))))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel1)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manageAccountButton))
                    .addComponent(logoLabel)))
        );

        javax.swing.GroupLayout welcomeMainPanelLayout = new javax.swing.GroupLayout(welcomeMainPanel);
        welcomeMainPanel.setLayout(welcomeMainPanelLayout);
        welcomeMainPanelLayout.setHorizontalGroup(
            welcomeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomeMainPanelLayout.createSequentialGroup()
                .addComponent(menuTreePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        welcomeMainPanelLayout.setVerticalGroup(
            welcomeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomeMainPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(welcomeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuTreePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomeMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomeMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void optionsMenuTreeTreeExpanded(javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_optionsMenuTreeTreeExpanded
        // TODO add your handling code here:
    }//GEN-LAST:event_optionsMenuTreeTreeExpanded

    private void optionsMenuTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsMenuTreeMouseClicked
        // TODO add your handling code here:
        getContentPanel().setLayout(new java.awt.BorderLayout());
        TreePath path = optionsMenuTree.getPathForLocation(evt.getX(), evt.getY());
        if (path != null) {
            getContentPanel().removeAll();
            // Check the last added component and remove it
            if (!lastComponent.equals("")) {
                if (lastComponent.equals("New Project")) {
                    getContentPanel().remove(addNewProjectPanel);
                } else if (lastComponent.equals("Edit Participant")) {
                    getContentPanel().remove(editParticipantPanel);
                } else if (lastComponent.equals("Add New User")) {
                    getContentPanel().remove(getAddNewUserPanel());
                } else if (lastComponent.equals("View All Users")) {
                    getContentPanel().remove(viewAllUsersPanel);
                } else if (lastComponent.equals("Advanced Search")) {
                    getContentPanel().remove(advancedSearchPanel);
                } else if (lastComponent.equals("Search")) {
                    getContentPanel().remove(getSearchPanel());
                } else if (lastComponent.equals("Edit Projects Multimedia")) {
                    getContentPanel().remove(getEditMediaPanel());                  
                } else if (lastComponent.equals("Edit Projects Participants")) {
                    getContentPanel().remove(editProjectParticipants);
                } else if (lastComponent.equals("Edit Projects General Info")) {
                    getContentPanel().remove(editGeneralProjectInformation);
                } else if (lastComponent.equals("View Projects General Info")) {
                    getContentPanel().remove(getViewGeneralProjectInformation());
                } else if (lastComponent.equals("View Projects Participants")) {
                    getContentPanel().remove(viewProjectParticipants);
                } else if (lastComponent.equals("View Participant Details")) {
                    getContentPanel().remove(viewParticipantDetails);
                } else if (lastComponent.equals("View Projects Multimedia")) {
                    getContentPanel().remove(getViewMediaPanel());                    
                } else if (lastComponent.equals("View Projects")) {
                    getContentPanel().remove(getViewProjectPanel());                                        
                } else if (lastComponent.equals("Edit Projects")) {
                    getContentPanel().remove(getEditProjectPanel());                    
                }                                
                
            }
            // Add the new component on the frame
            // Depending on the Selected Tree Node
            if (path.toString().contains("New Project")) {
                getContentPanel().add(new AddNewProjectPanel());
                lastComponent = "New Project";
            } else if (path.toString().contains("Edit Participant")) {
                getContentPanel().add(new EditParticipantPanel());
                lastComponent = "Edit Participant";
            } else if (path.toString().contains("Add New User")) {
                addNewUserPanel = new AddNewUserPanel(this);
                getContentPanel().add(addNewUserPanel);
                lastComponent = "Add New User";
            } else if (path.toString().contains("View All Users")) {
                viewAllUsersPanel = new ViewAllUsersPanel(this);
                getContentPanel().add(viewAllUsersPanel);
                lastComponent = "View All Users";
            } else if (path.toString().contains("Advanced Search")) {
                advancedSearchPanel = new AdvancedSearchPanel(this);
                getContentPanel().add(advancedSearchPanel);
                lastComponent = "Advanced Search";
            } else if (path.toString().contains("Search")) {
                setSearchPanel(new SearchPanel(this));
                getContentPanel().add(getSearchPanel());
                lastComponent = "Search";
            } else if (path.toString().contains("Edit Projects") && path.toString().contains("Multimedia")) {
                setEditMediaPanel(new EditMediaPanel(this));
                getContentPanel().add(getEditMediaPanel());
                lastComponent = "Edit Projects Multimedia";
            } else if (path.toString().contains("Edit Projects") && path.toString().contains("Participants")) {
                getContentPanel().add(new EditProjectParticipants());
                lastComponent = "Edit Projects Participants";
            } else if (path.toString().contains("Edit Projects") && path.toString().contains("General Info")) {
                editGeneralProjectInformation = new EditGeneralProjectInformation();
                getContentPanel().add(editGeneralProjectInformation);
                lastComponent = "Edit Projects General Info";
            } else if (path.toString().contains("View Projects") && path.toString().contains("General Info")) {
                viewGeneralProjectInformation = new ViewGeneralProjectInformation(this);
                viewGeneralProjectInformation.refreshSelectedProject();
                getContentPanel().add(viewGeneralProjectInformation);
                lastComponent = "View Projects General Info";
            } else if (path.toString().contains("View Projects") && path.toString().contains("Participants")) {
                viewProjectParticipants = new ViewProjectParticipants(this);
                viewProjectParticipants.refreshSelectedProject();
                getContentPanel().add(viewProjectParticipants);
                lastComponent = "View Projects Participants";
            } else if (path.toString().contains("View Projects") && path.toString().contains("Multimedia")) {
                setViewMediaPanel(new ViewMediaPanel(this));
                viewGeneralProjectInformation.refreshSelectedProject();
                viewProjectParticipants.refreshSelectedProject();
                getContentPanel().add(getViewMediaPanel());
                lastComponent = "View Projects Multimedia";                
            } else if (path.toString().contains("View Projects")) {   
                viewProjectPanel = new ViewProjectPanel(this);                
                getContentPanel().add(viewProjectPanel);
                lastComponent = "View Projects";                
            } else if (path.toString().contains("Edit Projects")) {   
                setEditProjectPanel(new EditProjectPanel(this));                
                getContentPanel().add(getEditProjectPanel());
                lastComponent = "Edit Projects";                                
            }            
            
            getContentPanel().revalidate();
            getContentPanel().repaint();
        }
    }//GEN-LAST:event_optionsMenuTreeMouseClicked

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        prefs.remove(Constants.USER_NAME);
        prefs.remove(Constants.PERSISTENCE_UNIT_NAME);
        prefs.remove(Constants.FULL_NAME);
        prefs.remove(Constants.USER_TYPE);
        new Login().setVisible(true);
        dispose();

    }//GEN-LAST:event_logoutButtonActionPerformed

    private void manageAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountButtonActionPerformed
        getContentPanel().setLayout(new java.awt.BorderLayout());
        getContentPanel().removeAll();
        manageAccountInfoPanel = new ManageAccountInfoPanel(user);
        getContentPanel().add(manageAccountInfoPanel);
        getContentPanel().revalidate();
        getContentPanel().repaint();
    }//GEN-LAST:event_manageAccountButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel logoLabel1;
    private javax.swing.JLabel logoLabel2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageAccountButton;
    private javax.swing.JPanel menuTreePanel;
    private javax.swing.JScrollPane menuTreeScrollPane;
    private javax.swing.JTree optionsMenuTree;
    private javax.swing.JLabel welcome;
    private javax.swing.JPanel welcomeMainPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the contentPanel
     */
    public javax.swing.JPanel getContentPanel() {
        return contentPanel;
    }
    
    public String getLastComponent() {
        return lastComponent;
    }
    
    public void setLastComponent(String lastComponent) {
        this.lastComponent = lastComponent;
    }
    
    public ViewParticipantDetails getViewParticipantDetails() {
        return viewParticipantDetails;
    }
    
    public void setViewParticipantDetails(ViewParticipantDetails viewParticipantDetails) {
        this.viewParticipantDetails = viewParticipantDetails;
    }
    
    public ViewProjectParticipants getViewProjectParticipants() {
        return viewProjectParticipants;
    }
    
    public void setViewProjectParticipants(ViewProjectParticipants viewProjectParticipants) {
        this.viewProjectParticipants = viewProjectParticipants;
    }

    public ViewGeneralProjectInformation getViewGeneralProjectInformation() {
        return viewGeneralProjectInformation;
    }
    
    public void setViewGeneralProjectInformation(ViewGeneralProjectInformation viewGeneralProjectInformation) {
        this.viewGeneralProjectInformation = viewGeneralProjectInformation;
    }    

    /**
     * @return the viewProjectPanel
     */
    public ViewProjectPanel getViewProjectPanel() {
        return viewProjectPanel;
    }

    /**
     * @param viewProjectPanel the viewProjectPanel to set
     */
    public void setViewProjectPanel(ViewProjectPanel viewProjectPanel) {
        this.viewProjectPanel = viewProjectPanel;
    }

    /**
     * @return the selectedProject
     */
    public String getSelectedProject() {
        return selectedProject;
    }

    /**
     * @param selectedProject the selectedProject to set
     */
    public void setSelectedProject(String selectedProject) {
        this.selectedProject = selectedProject;
    }
    
    public JMenuBar createMenuBar () {
        JMenuItem menuItem = null;
        JMenuBar menuBar = new JMenuBar();
        JMenu mainMenu = new JMenu("Edit");
        mainMenu.setMnemonic(KeyEvent.VK_E);

        menuItem = new JMenuItem(DefaultEditorKit.selectAllAction);
        menuItem.setText("Select All CTRL-A");
        menuItem.setMnemonic(KeyEvent.VK_A);
        mainMenu.add(menuItem);        
        
        menuItem = new JMenuItem(new DefaultEditorKit.CutAction());
        menuItem.setText("Cut CTRL-X");
        menuItem.setMnemonic(KeyEvent.VK_CUT);
        //menuItem.setMnemonic(KeyEvent.VK_T);
        mainMenu.add(menuItem);            

        menuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        menuItem.setText("Copy CTRL-C");
        menuItem.setMnemonic(KeyEvent.VK_C);
        mainMenu.add(menuItem);

        menuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
        menuItem.setText("Paste CTRL-V");
        menuItem.setMnemonic(KeyEvent.VK_P);
        mainMenu.add(menuItem);

        menuBar.add(mainMenu);
        return menuBar;
    }

    /**
     * @return the advancedSearchPanel
     */
    public AdvancedSearchPanel getAdvancedSearchPanel() {
        return advancedSearchPanel;
    }

    /**
     * @param advancedSearchPanel the advancedSearchPanel to set
     */
    public void setAdvancedSearchPanel(AdvancedSearchPanel advancedSearchPanel) {
        this.advancedSearchPanel = advancedSearchPanel;
    }

    /**
     * @return the searchPanel
     */
    public SearchPanel getSearchPanel() {
        return searchPanel;
    }

    /**
     * @param searchPanel the searchPanel to set
     */
    public void setSearchPanel(SearchPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    /**
     * @return the editProjectPanel
     */
    public EditProjectPanel getEditProjectPanel() {
        return editProjectPanel;
    }

    /**
     * @param editProjectPanel the editProjectPanel to set
     */
    public void setEditProjectPanel(EditProjectPanel editProjectPanel) {
        this.editProjectPanel = editProjectPanel;
    }

    /**
     * @return the editMediaPanel
     */
    public EditMediaPanel getEditMediaPanel() {
        return editMediaPanel;
    }

    /**
     * @param editMediaPanel the editMediaPanel to set
     */
    public void setEditMediaPanel(EditMediaPanel editMediaPanel) {
        this.editMediaPanel = editMediaPanel;
    }

    /**
     * @return the viewMediaPanel
     */
    public ViewMediaPanel getViewMediaPanel() {
        return viewMediaPanel;
    }

    /**
     * @param viewMediaPanel the viewMediaPanel to set
     */
    public void setViewMediaPanel(ViewMediaPanel viewMediaPanel) {
        this.viewMediaPanel = viewMediaPanel;
    }

    public ViewAllUsersPanel getViewAllUsersPanel() {
        return viewAllUsersPanel;
    }

    public void setViewAllUsersPanel(ViewAllUsersPanel viewAllUsersPanel) {
        this.viewAllUsersPanel = viewAllUsersPanel;
    }

    /**
     * @return the addNewUserPanel
     */
    public AddNewUserPanel getAddNewUserPanel() {
        return addNewUserPanel;
    }

    /**
     * @param addNewUserPanel the addNewUserPanel to set
     */
    public void setAddNewUserPanel(AddNewUserPanel addNewUserPanel) {
        this.addNewUserPanel = addNewUserPanel;
    }
    
    
    
}
