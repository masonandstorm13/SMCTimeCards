/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.EmployeeGui;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import Custom.FileHandler;
import Custom.StringByteConvert;
import Objects.Employee;
import Runner.MainRunner;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mason Smith
 */
@SuppressWarnings("serial")
public class newEmployee extends javax.swing.JFrame {

	public File profilePicture = new File("");
	public File employeeDirectory = new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Employees\\");
	public BufferedImage resizedImage = null;
	
	//gets the selected file for object location
	public File cardFileLocation = new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Cards\\Cards.JSON");
    /**
     * Creates new form newEmployee
     */
    public newEmployee() {
    	setTitle("newEmployee");
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

        PanelPicture = new javax.swing.JPanel();
        PanelPicture.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & GIF Images", "jpg", "gif", "png");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                	try {
                		//gets selected image and resizes it to 150,150
                		FileHandler fileHandler = new FileHandler();
                		profilePicture = chooser.getSelectedFile();
						Image image = ImageIO.read(chooser.getSelectedFile());
						resizedImage = fileHandler.resizeImage(image, 150, 150);
						Label_ProfilePicture.setIcon(new ImageIcon(resizedImage)); // NOI18N						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(getParent(), e.getMessage());
					}
                                        
                    
                }
        	}
        });
        Label_ProfilePicture = new javax.swing.JLabel();
        PanelEdit = new javax.swing.JPanel();
        PanelName = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        TextField_Name = new javax.swing.JTextField();
        PanelCharge = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        TextField_Charge = new javax.swing.JTextField();
        PanelHourly = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        TextField_Hourly = new javax.swing.JTextField();
        PanelSave = new javax.swing.JPanel();
        button_Save = new java.awt.Button();
        button_Save.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		boolean canSave = true;
        		//check if all values are filled
        		if((TextField_Name.getText().trim().equals(""))) {
        			JOptionPane.showMessageDialog(getParent(), "Name Text Required");
        			canSave =false;
        		}else if(TextField_Charge.getText().trim().equals("")) {
        			JOptionPane.showMessageDialog(getParent(), "Charge Text Required");
        			canSave =false;
        		}else if(TextField_Hourly.getText().trim().equals("")) {
        			JOptionPane.showMessageDialog(getParent(), "Hourly Text Required");
        			canSave =false;

        		}else {
        			Double hourly = null;
        			Double charge = null;
        			//checks if string is a valid double and then sets values or returns error
        			try {
        				hourly = Double.valueOf(TextField_Hourly.getText());
        			} catch (NumberFormatException message) {
        				JOptionPane.showMessageDialog(getParent(), "Hourly Must Be A Number");
        				canSave = false;
        			}
        			try {
        				charge = Double.valueOf(TextField_Charge.getText());
        			} catch (NumberFormatException message) {
        				JOptionPane.showMessageDialog(getParent(), "Charge Must Be A Number");
        				canSave = false;
        			}
        			
        			//checks if directory exist and if not creates it
        			File newEmployeeDirectory = new File(employeeDirectory.getAbsoluteFile() + "\\" + TextField_Name.getText());
        			if(!newEmployeeDirectory.exists()) {
        				newEmployeeDirectory.mkdir();
        			}else {
        				JOptionPane.showMessageDialog(newEmployee.this, "Employee Allready Exist");
        				canSave = false;
        			}
        			
        			//checks for values, then forms object and writes to nas 
        			if(canSave == true) {
        				//copy and past profile picture to nas if file is selected      				
        					File dest = null;
        					if(resizedImage != null) {
        						dest = new File(newEmployeeDirectory.getAbsolutePath() + "\\" + TextField_Name.getText() + "ProfilePicture." + "jpg");
        					}
        					//creates an employee path
                			File newEmployeeLocation = new File(newEmployeeDirectory.getAbsolutePath() + "\\" + TextField_Name.getText() + ".json");
                			//checks if the employee already exist
                			if(newEmployeeLocation.exists() == false) {
                				try {
                					FileHandler fileHandler = new FileHandler();
                					if(resizedImage != null) {
                						ImageIO.write(resizedImage, "jpg", dest);
                					}               					
                					byte[] cardValue = TextField_Name.getText().getBytes("US-ASCII");
        					    	Employee newEmployee = new Employee();
        					    	newEmployee.name = TextField_Name.getText();
        					    	newEmployee.charge = charge;
                    				newEmployee.hourlyPay = hourly;
                    				if(resizedImage != null) {
                    					newEmployee.pictureLocaitonPath = dest.getAbsolutePath();
                    				}else {
                    					newEmployee.pictureLocaitonPath = null;
                    				}
                    			
                    				//writes files
                    				fileHandler.writeFile(newEmployeeLocation, newEmployee);
                				} catch (IOException c) {
        							canSave = false;
        					    	c.printStackTrace();
        						}
                			}
        				}
        			}    
        		if(canSave == true) {
        			newEmployee.this.dispose();
            		MainRunner.runEmployeeMain();
        		}
        	}
        });
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu_Back = new javax.swing.JMenu();
        Menu_Back.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		MainRunner.runEmployeeMain();
        		//finds current frame out of listed frames and disposes of it
        		for(int i = 0; i < Frame.getFrames().length; i++) {
        			if(Frame.getFrames()[i].getTitle().equals("newEmployee")) {
        				Frame.getFrames()[i].dispose();
        			}
        		}
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 560));
        setPreferredSize(new java.awt.Dimension(960, 560));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        PanelPicture.setBackground(new java.awt.Color(114, 137, 218));
        PanelPicture.setMinimumSize(new java.awt.Dimension(320, 540));
        PanelPicture.setPreferredSize(new java.awt.Dimension(320, 540));
        PanelPicture.setRequestFocusEnabled(false);
        PanelPicture.setLayout(new java.awt.GridLayout(1, 0));

        Label_ProfilePicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_ProfilePicture.setIcon(new ImageIcon(newEmployee.class.getResource("/Resources/user-picture.png"))); // NOI18N
        PanelPicture.add(Label_ProfilePicture);

        getContentPane().add(PanelPicture);

        PanelEdit.setBackground(new java.awt.Color(255, 153, 102));
        PanelEdit.setMinimumSize(new java.awt.Dimension(640, 540));
        PanelEdit.setPreferredSize(new java.awt.Dimension(640, 540));
        PanelEdit.setLayout(new java.awt.GridLayout(4, 4));

        PanelName.setMinimumSize(new java.awt.Dimension(640, 135));
        PanelName.setLayout(new javax.swing.BoxLayout(PanelName, javax.swing.BoxLayout.LINE_AXIS));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMinimumSize(new java.awt.Dimension(100, 135));
        jPanel9.setPreferredSize(new java.awt.Dimension(100, 135));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Name:");
        jPanel9.add(jLabel2);

        PanelName.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel10.setMinimumSize(new java.awt.Dimension(540, 135));
        jPanel10.setPreferredSize(new java.awt.Dimension(540, 135));
        jPanel10.setLayout(new java.awt.GridLayout());

        TextField_Name.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 48)); // NOI18N
        TextField_Name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextField_Name.setBorder(null);
        TextField_Name.setMinimumSize(new java.awt.Dimension(540, 135));
        TextField_Name.setPreferredSize(new java.awt.Dimension(540, 135));
        jPanel10.add(TextField_Name);

        PanelName.add(jPanel10);

        PanelEdit.add(PanelName);

        PanelCharge.setMinimumSize(new java.awt.Dimension(640, 135));
        PanelCharge.setLayout(new javax.swing.BoxLayout(PanelCharge, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setBackground(new java.awt.Color(153, 170, 181));
        jPanel7.setMinimumSize(new java.awt.Dimension(100, 135));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 135));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Charge:");
        jPanel7.add(jLabel3);

        PanelCharge.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(153, 170, 181));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel8.setMinimumSize(new java.awt.Dimension(540, 135));
        jPanel8.setPreferredSize(new java.awt.Dimension(540, 135));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        TextField_Charge.setBackground(new java.awt.Color(153, 170, 181));
        TextField_Charge.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 48)); // NOI18N
        TextField_Charge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextField_Charge.setBorder(null);
        jPanel8.add(TextField_Charge);

        PanelCharge.add(jPanel8);

        PanelEdit.add(PanelCharge);

        PanelHourly.setBackground(new java.awt.Color(255, 255, 255));
        PanelHourly.setMinimumSize(new java.awt.Dimension(640, 135));
        PanelHourly.setLayout(new javax.swing.BoxLayout(PanelHourly, javax.swing.BoxLayout.LINE_AXIS));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setMinimumSize(new java.awt.Dimension(100, 135));
        jPanel11.setPreferredSize(new java.awt.Dimension(100, 135));
        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hourly:");
        jPanel11.add(jLabel4);

        PanelHourly.add(jPanel11);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0), java.awt.Color.black, java.awt.Color.black, new java.awt.Color(0, 0, 0)));
        jPanel14.setMinimumSize(new java.awt.Dimension(540, 135));
        jPanel14.setPreferredSize(new java.awt.Dimension(540, 135));
        jPanel14.setLayout(new java.awt.GridLayout(1, 0));

        TextField_Hourly.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 48)); // NOI18N
        TextField_Hourly.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextField_Hourly.setBorder(null);
        jPanel14.add(TextField_Hourly);

        PanelHourly.add(jPanel14);

        PanelEdit.add(PanelHourly);

        PanelSave.setBackground(new java.awt.Color(153, 170, 181));
        PanelSave.setMinimumSize(new java.awt.Dimension(640, 135));
        PanelSave.setLayout(new java.awt.GridBagLayout());

        button_Save.setBackground(new java.awt.Color(255, 255, 255));
        button_Save.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        button_Save.setLabel("Save");
        button_Save.setMinimumSize(new java.awt.Dimension(240, 50));
        button_Save.setPreferredSize(new java.awt.Dimension(240, 50));
        PanelSave.add(button_Save, new java.awt.GridBagConstraints());

        PanelEdit.add(PanelSave);

        getContentPane().add(PanelEdit);

        jMenuBar1.setPreferredSize(new java.awt.Dimension(33, 20));

        Menu_Back.setText("Back");
        jMenuBar1.add(Menu_Back);

        setJMenuBar(jMenuBar1);
        


        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_ProfilePicture;
    private javax.swing.JMenu Menu_Back;
    private javax.swing.JPanel PanelCharge;
    private javax.swing.JPanel PanelEdit;
    private javax.swing.JPanel PanelHourly;
    private javax.swing.JPanel PanelName;
    private javax.swing.JPanel PanelPicture;
    private javax.swing.JPanel PanelSave;
    private javax.swing.JTextField TextField_Charge;
    private javax.swing.JTextField TextField_Hourly;
    private javax.swing.JTextField TextField_Name;
    private java.awt.Button button_Save;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
