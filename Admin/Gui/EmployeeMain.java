/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import javax.swing.ImageIcon;

import Runner.MainRunner;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Mason Smith
 */
@SuppressWarnings("serial")
public class EmployeeMain extends javax.swing.JFrame {

    /**
     * Creates new form WorkOrderMainGui
     */
    public EmployeeMain() {
    	setTitle("Employee");
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
    	
    	//sets the location of frame to middle of screen
    	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    	this.setLocation(gd.getDisplayMode().getWidth()/4-this.getSize().width/2, gd.getDisplayMode().getHeight()/4-this.getSize().height/2);

        jPanel1 = new javax.swing.JPanel();
        PanelEmployeeBack = new javax.swing.JPanel();
        PanelEmployeeBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		MainRunner.runAdminMainGui();
        		//finds current frame out of listed frames and disposes of it
        		for(int i = 0; i < Frame.getFrames().length; i++) {
        			if(Frame.getFrames()[i].getTitle().equals("Employee")) {
        				Frame.getFrames()[i].dispose();
        			}
        		}
        	}
        });
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setIcon(new ImageIcon(EmployeeMain.class.getResource("/Resources/back-button-icon.png")));
        PanelEmployeeCreate = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setIcon(new ImageIcon(EmployeeMain.class.getResource("/Resources/add-employee-icon.png")));
        PanelEmployeeEdit = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setIcon(new ImageIcon(EmployeeMain.class.getResource("/Resources/edit-employee-icon.png")));
        PanelEmployeeView = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setIcon(new ImageIcon(EmployeeMain.class.getResource("/Resources/view-employee-icon.png")));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 540));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        PanelEmployeeBack.setBackground(new java.awt.Color(255, 255, 255));
        PanelEmployeeBack.setLayout(new java.awt.GridLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelEmployeeBack.add(jLabel1);

        jPanel1.add(PanelEmployeeBack);

        PanelEmployeeCreate.setBackground(new java.awt.Color(153, 170, 181));
        PanelEmployeeCreate.setLayout(new java.awt.GridLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelEmployeeCreate.add(jLabel2);

        jPanel1.add(PanelEmployeeCreate);

        PanelEmployeeEdit.setBackground(new java.awt.Color(255, 255, 255));
        PanelEmployeeEdit.setLayout(new java.awt.GridLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelEmployeeEdit.add(jLabel3);

        jPanel1.add(PanelEmployeeEdit);

        PanelEmployeeView.setBackground(new java.awt.Color(153, 170, 181));
        PanelEmployeeView.setLayout(new java.awt.GridLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelEmployeeView.add(jLabel4);

        jPanel1.add(PanelEmployeeView);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEmployeeBack;
    private javax.swing.JPanel PanelEmployeeCreate;
    private javax.swing.JPanel PanelEmployeeEdit;
    private javax.swing.JPanel PanelEmployeeView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
