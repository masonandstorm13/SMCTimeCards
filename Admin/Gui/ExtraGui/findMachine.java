/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.ExtraGui;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;

import Custom.FileHandler;
import Objects.Employee;
import Objects.Machine;
import Runner.MainRunner;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;

/**
 *
 * @author Mason Smith
 */
@SuppressWarnings("serial")
public class findMachine extends javax.swing.JFrame {

	public File machineDirectory = new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Machines\\");
	
	public String[] machineList = machineDirectory.list();
	
	public Machine machine = null;
	
	public Integer selectedIndex = null;
	
	public File selectedMachineDirectory = null;
    /**
     * Creates new form findEmployee
     */
    public findMachine() {
    	setTitle("findMachine");
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
    	
        PanelPreview = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Label_ProfilePicture = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Label_Name = new javax.swing.JLabel();
        PanelSelect = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ScrollPane_Employees = new javax.swing.JScrollPane();
        ScrollPane_Employees.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        List_Machines = new javax.swing.JList<>();
        List_Machines.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//gets the selected directory for employee
        		selectedMachineDirectory = new File(machineDirectory.getAbsolutePath() + "\\" + List_Machines.getSelectedValue());
        		
        		//gets the selected file for object location
        		File selectedMachineFile = new File(selectedMachineDirectory.getAbsolutePath() + "\\" + List_Machines.getSelectedValue() + ".json");
        		
        		//gets the employee object
        		FileHandler fileHandler = new FileHandler();
    			machine = fileHandler.getMachine(selectedMachineFile);
    			
    			//sets preview name
    			Label_Name.setText(machine.getName());
    			
    			File selectedMachineImage = new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Machines" + "\\" + machine.getCode() + "\\" + "MachinePicture " +machine.getCode() + ".jpg");
        		    			
    			//checks if there is a picture then sets it in the preview
    			if(selectedMachineImage.exists() == true) {
    				Label_ProfilePicture.setIcon(new ImageIcon(selectedMachineImage.getPath()));
    			}else {
    				Label_ProfilePicture.setIcon(new ImageIcon(findMachine.class.getResource("/Resources/user-picture.png"))); // NOI18N
    			}
    			
    			selectedIndex = List_Machines.getSelectedIndex();
        	}
        });
        jPanel2 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnEdit.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		if(machine == null) {
        			JOptionPane.showMessageDialog(getParent(), "You Must Select A Machine");
        		}else {
        			editMachine editMachine = new editMachine(machine);
        			editMachine.setVisible(true);
        			findMachine.this.dispose();
        		}
        	}
        });
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuBack = new javax.swing.JMenu();
        MenuBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		MainRunner.runExtraMain();
        		findMachine.this.dispose();
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 560));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        PanelPreview.setMinimumSize(new java.awt.Dimension(320, 540));
        PanelPreview.setPreferredSize(new java.awt.Dimension(320, 540));
        PanelPreview.setLayout(new javax.swing.BoxLayout(PanelPreview, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setBackground(new java.awt.Color(114, 137, 218));
        jPanel3.setMinimumSize(new java.awt.Dimension(320, 270));
        jPanel3.setPreferredSize(new java.awt.Dimension(320, 270));
        jPanel3.setLayout(new java.awt.GridLayout());

        Label_ProfilePicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_ProfilePicture.setIcon(new ImageIcon(findMachine.class.getResource("/Resources/user-picture.png"))); // NOI18N
        Label_ProfilePicture.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(Label_ProfilePicture);

        PanelPreview.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(114, 137, 218));
        jPanel4.setMinimumSize(new java.awt.Dimension(320, 270));
        jPanel4.setPreferredSize(new java.awt.Dimension(320, 270));
        jPanel4.setLayout(new java.awt.GridLayout());

        Label_Name.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        Label_Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Name.setVerticalAlignment(javax.swing.SwingConstants.TOP);
		Label_Name.setText("Machine Icon");
        jPanel4.add(Label_Name);

        PanelPreview.add(jPanel4);

        getContentPane().add(PanelPreview);

        PanelSelect.setMinimumSize(new java.awt.Dimension(640, 540));
        PanelSelect.setPreferredSize(new java.awt.Dimension(640, 540));
        PanelSelect.setLayout(new javax.swing.BoxLayout(PanelSelect, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setMinimumSize(new java.awt.Dimension(640, 405));
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 405));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        List_Machines.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 48)); // NOI18N
        List_Machines.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = machineList;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ScrollPane_Employees.setViewportView(List_Machines);

        jPanel1.add(ScrollPane_Employees);

        PanelSelect.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(114, 137, 218));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jPanel2.setMinimumSize(new java.awt.Dimension(640, 135));
        jPanel2.setPreferredSize(new java.awt.Dimension(640, 135));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnEdit.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setMaximumSize(new java.awt.Dimension(32767, 32767));
        btnEdit.setMinimumSize(new java.awt.Dimension(240, 50));
        btnEdit.setPreferredSize(new java.awt.Dimension(240, 50));
        GridBagConstraints gbc_btnEdit = new GridBagConstraints();
        gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
        gbc_btnEdit.gridx = 0;
        gbc_btnEdit.gridy = 0;
        jPanel2.add(btnEdit, gbc_btnEdit);

        PanelSelect.add(jPanel2);
        
        btnDelete = new JButton();
        btnDelete.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		if(machine != null) {
        			Object[] options = {"Yes", "No"};
            		int n = JOptionPane.showOptionDialog(getParent(),
            						"Are you sure you want to delete " + machine.getCode() +"\nThis will cause any work order containing the machine to fail",
            						"Delete",
            						JOptionPane.YES_NO_CANCEL_OPTION,
            						JOptionPane.QUESTION_MESSAGE,
            						null,
            						options,
            						options[1]);
            		if(n == 0) {
            			//goes through directory and deletes all files
            			String[]entries = selectedMachineDirectory.list();
            			for(String s: entries){
            			    File currentFile = new File(selectedMachineDirectory.getPath(),s);
            			    System.gc();
            			    currentFile.delete();
            			}            		
            			//checks if file directory is valid and tries to delete
            			if(selectedMachineDirectory != null && selectedMachineDirectory.exists()) {
            				System.out.println("This is a test pring");
            				if(selectedMachineDirectory.delete()) {           					
            					if(selectedIndex != null) {
            						//creates a new array for the list model
            						List<String> newModelList = new LinkedList<String>(Arrays.asList(machineList));
            						newModelList.remove(List_Machines.getSelectedIndex());
            						//creates a new string array to be used in model
            						String[] newModelArray = newModelList.toArray(new String[newModelList.size()]);
            						//rest the JList model with the new values
            						List_Machines.setModel(new javax.swing.AbstractListModel<String>() {
            				            String[] strings = newModelArray;
            				            public int getSize() { return strings.length; }
            				            public String getElementAt(int i) { return strings[i]; }
            				        });
            						
            						List_Machines.setSelectedIndex(-1);
            						
            						//sets the preview image back to default
            						Label_ProfilePicture.setIcon(new ImageIcon(findMachine.class.getResource("/Resources/user-picture.png"))); // NOI18N
            						Label_Name.setText("Machine Icon");
            					}           					
            				}else {
            					//something did not work
            					JOptionPane.showMessageDialog(getParent(), "Something Went Wrong Deleting The Machine Please Retry");
            				}
            			}
            		}else if(n == 1) {
            			//if no options is selected
            		}
        		}else {
					JOptionPane.showMessageDialog(getParent(), "No Machine Slected");
        		}
        		
        		
        	}
        });
        btnDelete.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setMaximumSize(new java.awt.Dimension(32767, 32767));
        btnDelete.setMinimumSize(new java.awt.Dimension(240, 50));
        btnDelete.setPreferredSize(new java.awt.Dimension(240, 50));
        GridBagConstraints gbc_btnDelete = new GridBagConstraints();
        gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
        gbc_btnDelete.gridx = 1;
        gbc_btnDelete.gridy = 0;
        jPanel2.add(btnDelete, gbc_btnDelete);

        getContentPane().add(PanelSelect);

        jMenuBar1.setMinimumSize(new java.awt.Dimension(56, 20));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(56, 20));
        jMenuBar1.setRequestFocusEnabled(false);

        MenuBack.setText("Back");
        jMenuBar1.add(MenuBack);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel Label_Name;
    private javax.swing.JLabel Label_ProfilePicture;
    private javax.swing.JList<String> List_Machines;
    private javax.swing.JMenu MenuBack;
    private javax.swing.JPanel PanelPreview;
    private javax.swing.JPanel PanelSelect;
    private javax.swing.JScrollPane ScrollPane_Employees;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private JButton btnDelete;
    // End of variables declaration//GEN-END:variables
}
