/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opentrafficsimulation.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import com.opentrafficsimulation.gui.utility.AssetUtility;

/**
 *
 * @author macromania
 */
public class MainFrame extends javax.swing.JFrame {

    
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() { 
        
        
        
        // TODO: Load image
        /*try {
            String filename = this.getClass().getResource("/assets/IconImage.jpg").getFile().replaceFirst("/", "");
            ImageIcon imgThisImg = new ImageIcon(filename);
            jLabelLogo.setIcon(imgThisImg);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jPanelMainBottom = new javax.swing.JPanel();
        jLabelInstruction = new javax.swing.JLabel();
        jButtonCreateMap = new javax.swing.JButton();
        jPanelMainUpper = new javax.swing.JPanel();
        jLabelConceptText = new javax.swing.JLabel();
        jSeparatorMain = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to Open Traffic Simulation"); // NOI18N
        setBackground(new java.awt.Color(227, 225, 225));
        setIconImage(new AssetUtility().getLogo());
        setPreferredSize(new java.awt.Dimension(770, 400));
        setResizable(false);

        jLabelTitle.setBackground(new java.awt.Color(227, 225, 225));
        jLabelTitle.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(30, 15, 42));
        jLabelTitle.setText("Welcome to Open Traffic Simulation");

        jLabelInstruction.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelInstruction.setText("<html>\n<body>\n<p style=\"width:500px;\">\nTo start creating a traffic simulation environment, first you need to create a map. Afterwards, you can continue adding traffic lights, different kinds of vehicles.\n</p>\n</body>\n</html>");
        jLabelInstruction.setToolTipText("");

        jButtonCreateMap.setText("Create Map");
        jButtonCreateMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateMapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainBottomLayout = new javax.swing.GroupLayout(jPanelMainBottom);
        jPanelMainBottom.setLayout(jPanelMainBottomLayout);
        jPanelMainBottomLayout.setHorizontalGroup(
            jPanelMainBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInstruction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCreateMap, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanelMainBottomLayout.setVerticalGroup(
            jPanelMainBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInstruction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButtonCreateMap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jLabelConceptText.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabelConceptText.setText("<html>\n<body>\n<p style=\"width:500px; color:#6e6e6e\">\nThe project, Open Traffic Simulation, is an open-source software for traffic simulation licensed under the GPL. It has SUMO as simulation server and a Java based GUI program to create and to modify customized simulations. Also, it has a background service for data storage and reporting system used integration with MySQL. A signaling control interface for modifying traffic lights on running simulation is another smart feature of the project.\n</p>\n</body>\n</html>");

        javax.swing.GroupLayout jPanelMainUpperLayout = new javax.swing.GroupLayout(jPanelMainUpper);
        jPanelMainUpper.setLayout(jPanelMainUpperLayout);
        jPanelMainUpperLayout.setHorizontalGroup(
            jPanelMainUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelConceptText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMainUpperLayout.setVerticalGroup(
            jPanelMainUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelConceptText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMainBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabelTitle))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparatorMain, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelMainUpper, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabelTitle)
                .addGap(18, 18, 18)
                .addComponent(jPanelMainUpper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparatorMain, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMainBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreateMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateMapActionPerformed
            this.setVisible(false);
            CreateMapFrame.getInstance().setVisible(true);
    }//GEN-LAST:event_jButtonCreateMapActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateMap;
    private javax.swing.JLabel jLabelConceptText;
    private javax.swing.JLabel jLabelInstruction;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelMainBottom;
    private javax.swing.JPanel jPanelMainUpper;
    private javax.swing.JSeparator jSeparatorMain;
    // End of variables declaration//GEN-END:variables
}