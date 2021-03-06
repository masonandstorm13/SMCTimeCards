/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.MainGui;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Custom.FileHandler;
import Objects.Customer;
import Runner.MainRunner;

import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Mason Smith
 */
@SuppressWarnings("serial")
public class ExtraMain extends javax.swing.JFrame {

	public FileHandler filehandler = new FileHandler();
	private File customerDirectory = new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Customers\\");
    /**
     * Creates new form ExtraMain
     */
    public ExtraMain() {
    	if(!customerDirectory.exists()) {
    		customerDirectory.mkdirs();
    	}
    	setTitle("Extra");
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
    	
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        PanelExtraBack = new javax.swing.JPanel();
        PanelExtraBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		MainRunner.runAdminMainGui();
        		//finds current frame out of listed frames and disposes of it
        		for(int i = 0; i < Frame.getFrames().length; i++) {
        			if(Frame.getFrames()[i].getTitle().equals("Extra")) {
        				Frame.getFrames()[i].dispose();
        			}
        		}
        	}
        });
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));
        PanelAddCustomer = new javax.swing.JPanel();
        PanelAddCustomer.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String name = JOptionPane.showInputDialog(null, "Customer Name");
        		//checks if cancel was selected
        		if(name != null) {
        			if(name.replaceAll(" ", "").equals("")) {
            			Object[] options = {"OK"};
            			JOptionPane.showOptionDialog(null, "No Customer Name Found \nPlease Retry", "error", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            		}else {
            			//sets up the new customer
            			Customer newCustomer = new Customer();
            			newCustomer.setName(name);
            			
            			//sets up customer file location
            			File CustomerLocation = new File(customerDirectory + "\\" + name + ".JSON");        			
            			//checks if customer exist already
            			if(CustomerLocation.exists()) {
            				JOptionPane.showMessageDialog(getParent(), "Customer Already Exist");
            			}else {
            				//writes customer object to file location
            				FileHandler fileHandler = new FileHandler();
            				fileHandler.writeFile(CustomerLocation, newCustomer);
            			}
            		}
        		}
        	}
        });
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		MainRunner.runNewMachine();
        		//finds current frame out of listed frames and disposes of it
        		for(int i = 0; i < Frame.getFrames().length; i++) {
        			if(Frame.getFrames()[i].getTitle().equals("Extra")) {
        				Frame.getFrames()[i].dispose();
        			}
        		}
        	}
        });
        jLabel3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		MainRunner.runEditMachine();
        		//finds current frame out of listed frames and disposes of it
        		for(int i = 0; i < Frame.getFrames().length; i++) {
        			if(Frame.getFrames()[i].getTitle().equals("Extra")) {
        				Frame.getFrames()[i].dispose();
        			}
        		}
        	}
        });
        jLabel4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));
        panelTextHint = new JPanel();
        panelTextHint.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		//sets up the text and then saves the boolean item
        		if(MainRunner.hinttext.getHintText() == true) {
        			MainRunner.hinttext.setHintText(false);
        			setUpHintText();
        			filehandler.writeFile(new File("C:/Users/" + System.getProperty("user.name") + "/SmcTimeCardSystem/firstRun.JSON"), MainRunner.hinttext);
        		}else {
        			MainRunner.hinttext.setHintText(true);
        			setUpHintText();
        			filehandler.writeFile(new File("C:/Users/" + System.getProperty("user.name") + "/SmcTimeCardSystem/firstRun.JSON"), MainRunner.hinttext);

        		}
        	}
        });
        labelTextHint = new JLabel();
        labelTextHint.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 24));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 540));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.setToolTipText("");
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(960, 540));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(960, 540));

        jPanel1.setMinimumSize(new Dimension(1440, 540));
        jPanel1.setPreferredSize(new Dimension(1440, 540));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        PanelExtraBack.setBackground(new java.awt.Color(255, 255, 255));
        PanelExtraBack.setMinimumSize(new java.awt.Dimension(240, 540));
        PanelExtraBack.setPreferredSize(new java.awt.Dimension(240, 540));
        PanelExtraBack.setLayout(new GridLayout(0, 1, 0, 0));

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setIcon(new ImageIcon(ExtraMain.class.getResource("/Resources/back-button-icon.png")));
        jLabel1.setVerticalTextPosition(jLabel1.TOP);
        jLabel1.setHorizontalTextPosition(jLabel1.CENTER);
        PanelExtraBack.add(jLabel1);

        jPanel1.add(PanelExtraBack);

        PanelAddCustomer.setBackground(new java.awt.Color(153, 170, 181));
        PanelAddCustomer.setMinimumSize(new java.awt.Dimension(240, 540));
        PanelAddCustomer.setPreferredSize(new java.awt.Dimension(240, 540));
        PanelAddCustomer.setLayout(new GridLayout(0, 1, 0, 0));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new ImageIcon(ExtraMain.class.getResource("/Resources/edit-employee-icon.png"))); // NOI18N
        jLabel2.setVerticalTextPosition(jLabel2.TOP);
        jLabel2.setHorizontalTextPosition(jLabel2.CENTER);
        PanelAddCustomer.add(jLabel2);

        jPanel1.add(PanelAddCustomer);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMinimumSize(new java.awt.Dimension(240, 540));
        jPanel4.setPreferredSize(new java.awt.Dimension(240, 540));
        jPanel4.setLayout(new GridLayout(0, 1, 0, 0));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new ImageIcon(ExtraMain.class.getResource("/Resources/add-machine-icon.png"))); // NOI18N
        jLabel3.setVerticalTextPosition(jLabel3.TOP);
        jLabel3.setHorizontalTextPosition(jLabel3.CENTER);
        jPanel4.add(jLabel3);

        jPanel1.add(jPanel4);

        jPanel9.setBackground(new java.awt.Color(153, 170, 181));
        jPanel9.setMinimumSize(new java.awt.Dimension(240, 540));
        jPanel9.setPreferredSize(new java.awt.Dimension(240, 540));
        jPanel9.setLayout(new GridLayout(0, 1, 0, 0));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new ImageIcon(ExtraMain.class.getResource("/Resources/edit-machine-icon.png"))); // NOI18N
        jLabel4.setVerticalTextPosition(jLabel4.TOP);
        jLabel4.setHorizontalTextPosition(jLabel4.CENTER);
        jPanel9.add(jLabel4);

        jPanel1.add(jPanel9);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMinimumSize(new java.awt.Dimension(240, 540));
        jPanel12.setPreferredSize(new java.awt.Dimension(240, 540));
        jPanel12.setLayout(new GridLayout(0, 1, 0, 0));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new ImageIcon(ExtraMain.class.getResource("/Resources/view-machine-icon.png"))); // NOI18N
        jLabel5.setVerticalTextPosition(jLabel4.TOP);
        jLabel5.setHorizontalTextPosition(jLabel4.CENTER);
        jPanel12.add(jLabel5);

        jPanel1.add(jPanel12);
        
       
        panelTextHint.setBackground(new java.awt.Color(153, 170, 181));
        panelTextHint.setMinimumSize(new java.awt.Dimension(240, 540));
        panelTextHint.setPreferredSize(new java.awt.Dimension(240, 540));
        panelTextHint.setLayout(new GridLayout(0, 1, 0, 0));
           
        labelTextHint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTextHint.setVerticalTextPosition(jLabel4.TOP);
        labelTextHint.setText("Text Hints");
        labelTextHint.setHorizontalTextPosition(jLabel4.CENTER);
        panelTextHint.add(labelTextHint);
        
        jPanel1.add(panelTextHint);

        jScrollPane2.setViewportView(jPanel1);
        
        

        getContentPane().add(jScrollPane2);

        setUpHintText();
        
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void setUpHintText() {
    	if(MainRunner.hinttext.getHintText() == true) {           
            jLabel1.setText("Back");
            jLabel2.setText("Add Customer");
            jLabel3.setText("Add Machine");
            jLabel4.setText("Edit Machine");
            jLabel5.setText("View Machines");

            labelTextHint.setIcon(new ImageIcon(ExtraMain.class.getResource("/Resources/checkBox-check-icon.png"))); // NOI18N
    	}else {
            jLabel1.setText("");
            jLabel2.setText("");
            jLabel3.setText("");
            jLabel4.setText("");
            jLabel5.setText("");
            
            labelTextHint.setIcon(new ImageIcon(ExtraMain.class.getResource("/Resources/checkBox-empty-icon.png"))); // NOI18N
    	}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel PanelExtraBack;
    private javax.swing.JPanel PanelAddCustomer;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private JPanel panelTextHint;
    private JLabel labelTextHint;
    // End of variables declaration//GEN-END:variables
}
