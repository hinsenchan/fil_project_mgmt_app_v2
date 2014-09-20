/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.view;

import com.src.frugalinnovationlab.Entity.Users;
import com.src.frugalinnovationlab.helper.Constants;
import java.util.prefs.Preferences;
import javax.swing.tree.TreePath;

/**
 *
 * @author diptik
 */
public class ViewerWelcome extends javax.swing.JFrame {

    final AddNewUserPanel addNewUserPanel = new AddNewUserPanel();
    //final ViewAllUsersPanel viewAllUsersPanel = new ViewAllUsersPanel(this);
    final AddNewProjectPanel addNewProjectPanel = new AddNewProjectPanel();
    final ViewAllProjectsPanel viewAllProjectsPanel = new ViewAllProjectsPanel();
    //final ViewSpecificUserPanel ViewSpecificUserPanel = new ViewSpecificUserPanel();
    //final SearchPanel searchPanel = new SearchPanel();
    final AddNewParticipantPanel addNewParticipantPanel = new AddNewParticipantPanel();
    //final AdvancedSearchPanel advancedSearchPanel = new AdvancedSearchPanel();
    Users user;
    ManageAccountInfoPanel manageAccountInfoPanel = new ManageAccountInfoPanel();
    final EditGeneralProjectInformation editGeneralProjectInformation = new EditGeneralProjectInformation();
    final EditProjectMultimedia editProjectMultimedia = new EditProjectMultimedia();
    final EditProjectParticipants editProjectParticipants = new EditProjectParticipants();
    Preferences prefs = Preferences.userNodeForPackage(com.src.frugalinnovationlab.Service.LoginService.class);
    String userType = "";
    /**
     * Creates new form Welcome
     */
    static String lastComponent = "";
    

    public ViewerWelcome() {
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
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("View All Projects");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Explore");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Search");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Advanced Search");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        optionsMenuTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        optionsMenuTree.setToolTipText("Explore");
        optionsMenuTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionsMenuTreeMouseClicked(evt);
            }
        });
        optionsMenuTree.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                optionsMenuTreeTreeExpanded(evt);
            }
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
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
        contentPanel.add(addNewUserPanel);
        contentPanel.setRequestFocusEnabled(false);

        welcome.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        welcome.setText("Welcome.");

        logoLabel2.setBackground(new java.awt.Color(255, 255, 255));
        logoLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/scu-mission.png"))); // NOI18N

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(welcome)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
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
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 584, Short.MAX_VALUE))
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
        contentPanel.setLayout(new java.awt.BorderLayout());
        TreePath path = optionsMenuTree.getPathForLocation(evt.getX(), evt.getY());
        System.out.println("path : " + path);
        if (path != null) {
            System.out.println("lastcomponent : " + lastComponent);
            contentPanel.removeAll();
            // Check the last added component and remove it
            if (!lastComponent.equals("")) {
                if (lastComponent.equals("View All Projects")) {
                    contentPanel.remove(viewAllProjectsPanel);
                } else if (lastComponent.equals("Advanced Search")) {
                    //contentPanel.remove(advancedSearchPanel);
                } else if (lastComponent.equals("Search")) {
                    //contentPanel.remove(searchPanel);

                }

            }
            // Add the new component on the frame
            // Depending on the Selected Tree Node
            if (path.toString().contains("View All Projects")) {
                contentPanel.add(new ViewAllProjectsPanel());
                lastComponent = "View All Projects";
            } else if (path.toString().contains("Advanced Search")) {
                //contentPanel.add(new AdvancedSearchPanel());
                lastComponent = "Advanced Search";
            } else if (path.toString().contains("Search")) {
                //contentPanel.add(new SearchPanel());
                lastComponent = "Search";

            }
            contentPanel.revalidate();
            contentPanel.repaint();
        }
    }//GEN-LAST:event_optionsMenuTreeMouseClicked

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        prefs.remove(Constants.USER_NAME);
        prefs.remove(Constants.FULL_NAME);
        prefs.remove(Constants.USER_TYPE);
        new Login().setVisible(true);
        dispose();

    }//GEN-LAST:event_logoutButtonActionPerformed

    private void manageAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountButtonActionPerformed
        contentPanel.setLayout(new java.awt.BorderLayout());
        contentPanel.removeAll();
        manageAccountInfoPanel = new ManageAccountInfoPanel(user);
        contentPanel.add(manageAccountInfoPanel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }//GEN-LAST:event_manageAccountButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewerWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewerWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewerWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewerWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewerWelcome().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel headerPanel;
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
}
