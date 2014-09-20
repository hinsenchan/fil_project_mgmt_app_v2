/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.frugalinnovationlab.view;

import com.src.frugalinnovationlab.Controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author diptik
 */
public class ViewAllUsersPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAllUsersPanel
     */
    private JTable jtable1;
    private Welcome mainApplication;
    private ViewAllUsersController viewalluserscontroller;

    public ViewAllUsersPanel(Welcome welcome) {
        initComponents();
        this.mainApplication = welcome;
        viewalluserscontroller = new ViewAllUsersController(this);
        addJTable();
        //updateTable();
    }

    public void addJTable() {
        // add the data and column names to a JTable  

        jtable1 = new JTable(viewalluserscontroller.getTableModel());
        jtable1.getColumnModel().getColumn(6).setMinWidth(0);
        jtable1.getColumnModel().getColumn(6).setMaxWidth(0);

        final JScrollPane scrollpane = new JScrollPane(jtable1, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollpane, BorderLayout.CENTER);

        final int rows = 14;

        Dimension d = jtable1.getPreferredSize();
        scrollpane.setPreferredSize(new Dimension(d.width, jtable1.getRowHeight() * rows));

        JPanel navigation = new JPanel(new FlowLayout(FlowLayout.CENTER));


        JButton next = new JButton(">");
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int height = jtable1.getRowHeight() * (rows - 2);

                JScrollBar bar = scrollpane.getVerticalScrollBar();
                bar.setValue(bar.getValue() + height);
            }
        });
        JButton previous = new JButton("<");
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int height = jtable1.getRowHeight() * (rows - 2);

                JScrollBar bar = scrollpane.getVerticalScrollBar();
                bar.setValue(bar.getValue() - height);
            }
        });

        navigation.add(previous);
        navigation.add(next);


        tablePanel.add(navigation, BorderLayout.SOUTH);
    }

    public void updateTable() {
        jtable1.setModel(viewalluserscontroller.getTableModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        welcome = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 170, 153), 4));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contentPanel.setInheritsPopupMenu(true);
        contentPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        contentPanel.setRequestFocusEnabled(false);

        deleteButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(95, 10, 36));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        welcome.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        welcome.setText("View All Users");

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 395, Short.MAX_VALUE))
                            .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton)))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addContainerGap(342, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selrow = jtable1.getSelectedRow();
        String username = (String) jtable1.getModel().getValueAt(selrow, 0);
        System.out.println("username is : " + username);
        int n = JOptionPane.showConfirmDialog(contentPanel, "Are you sure you want to delete the user" + " " + username + " " + "", "Delete User", JOptionPane.YES_NO_OPTION);
        System.out.println(n + "value for dialog box");
        if (n == 0) {
            boolean flag = viewalluserscontroller.DeleteUser(username);
            if (flag == true) {
                addJTable();
                mainApplication.getContentPanel().remove(mainApplication.getViewAllUsersPanel());
                mainApplication.setViewAllUsersPanel(new ViewAllUsersPanel(mainApplication));
                mainApplication.getContentPanel().add(mainApplication.getViewAllUsersPanel());
                mainApplication.getContentPanel().revalidate();
                mainApplication.getContentPanel().repaint();                
                JOptionPane.showMessageDialog(contentPanel, " User Details for User" + "  " + username + " " + "has deleted  succesfully");


            } else {
                JOptionPane optionPane = new JOptionPane("Error in Deleting information for User. Please verify the information again", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error !");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
    public Welcome getMainApplication() {
        return mainApplication;
    }
}
