/*
2 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.MainGui;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
public class WorkOrderMainGui extends javax.swing.JFrame {

    /**
     * Creates new form WorkOrderMainGui
     */
    public WorkOrderMainGui() {
    	setTitle("WorkOrder");
        initComponents();
        setUpHintText();
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
        PanelWorkOrderBack = new javax.swing.JPanel();
        PanelWorkOrderBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		MainRunner.runAdminMainGui();
        		//finds current frame out of listed frames and disposes of it
        		for(int i = 0; i < Frame.getFrames().length; i++) {
        			if(Frame.getFrames()[i].getTitle().equals("WorkOrder")) {
        				Frame.getFrames()[i].dispose();
        			}
        		}
        	}
        });
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setIcon(new ImageIcon(WorkOrderMainGui.class.getResource("/Resources/back-button-icon.png")));
        PanelWorkOrderCreate = new javax.swing.JPanel();
        PanelWorkOrderCreate.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	    int response = JOptionPane.showConfirmDialog(null, "Is this a multi Part Job?", "Parts",
        	            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        	        if (response == JOptionPane.NO_OPTION) {
        	        	MainRunner.runNewWorkOrderOnePart();
                		//finds current frame out of listed frames and disposes of it
                		for(int i = 0; i < Frame.getFrames().length; i++) {
                			if(Frame.getFrames()[i].getTitle().equals("WorkOrder")) {
                				Frame.getFrames()[i].dispose();
                			}
                		}
        	        } else if (response == JOptionPane.YES_OPTION) {
        	        	MainRunner.runWorkOrderMultiParSelect();
                		//finds current frame out of listed frames and disposes of it
                		for(int i = 0; i < Frame.getFrames().length; i++) {
                			if(Frame.getFrames()[i].getTitle().equals("WorkOrder")) {
                				Frame.getFrames()[i].dispose();
                			}
                		}
        	        } else if (response == JOptionPane.CLOSED_OPTION) {
        	        	
        	        }
        	        
        	}
        });
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 24));
        jLabel1.setVerticalTextPosition(jLabel1.TOP);
        jLabel1.setHorizontalTextPosition(jLabel1.CENTER);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setIcon(new ImageIcon(WorkOrderMainGui.class.getResource("/Resources/add-new-workorder-icon.png")));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 24));
        jLabel2.setVerticalTextPosition(jLabel2.TOP);
        jLabel2.setHorizontalTextPosition(jLabel2.CENTER);
        PanelWorkOrderEdit = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setIcon(new ImageIcon(WorkOrderMainGui.class.getResource("/Resources/edit-workorder-icon.png")));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 24));
        jLabel3.setVerticalTextPosition(jLabel3.TOP);
        jLabel3.setHorizontalTextPosition(jLabel3.CENTER);
        PanelWorkOrderView = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setIcon(new ImageIcon(WorkOrderMainGui.class.getResource("/Resources/view-workorder-icon.png")));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 24));
        jLabel4.setVerticalTextPosition(jLabel4.TOP);
        jLabel4.setHorizontalTextPosition(jLabel4.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 540));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        PanelWorkOrderBack.setBackground(new java.awt.Color(255, 255, 255));
        PanelWorkOrderBack.setLayout(new java.awt.GridLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelWorkOrderBack.add(jLabel1);

        jPanel1.add(PanelWorkOrderBack);

        PanelWorkOrderCreate.setBackground(new java.awt.Color(153, 170, 181));
        PanelWorkOrderCreate.setLayout(new java.awt.GridLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelWorkOrderCreate.add(jLabel2);

        jPanel1.add(PanelWorkOrderCreate);

        PanelWorkOrderEdit.setBackground(new java.awt.Color(255, 255, 255));
        PanelWorkOrderEdit.setLayout(new java.awt.GridLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelWorkOrderEdit.add(jLabel3);

        jPanel1.add(PanelWorkOrderEdit);

        PanelWorkOrderView.setBackground(new java.awt.Color(153, 170, 181));
        PanelWorkOrderView.setLayout(new java.awt.GridLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelWorkOrderView.add(jLabel4);

        jPanel1.add(PanelWorkOrderView);

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

    public void setUpHintText() {
    	if(MainRunner.hinttext.getHintText() == true) {           
            jLabel1.setText("Back");
            jLabel2.setText("Add Work Order");
            jLabel3.setText("Edit Work Order");
            jLabel4.setText("View Work Order");

    	}else {
    		jLabel1.setText("");
            jLabel2.setText("");
            jLabel3.setText("");
            jLabel4.setText("");
            
    	}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelWorkOrderBack;
    private javax.swing.JPanel PanelWorkOrderCreate;
    private javax.swing.JPanel PanelWorkOrderEdit;
    private javax.swing.JPanel PanelWorkOrderView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
