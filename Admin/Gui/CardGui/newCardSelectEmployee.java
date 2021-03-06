/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.CardGui;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Custom.FileHandler;
import Objects.Employee;
import Runner.MainRunner;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Mason Smith
 */
@SuppressWarnings("serial")
public class newCardSelectEmployee extends javax.swing.JFrame {

	public File employeeDirectory = new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Employees\\");
	
	public String[] employeeList = employeeDirectory.list();
	
	public Employee employee = null;

	
    /**
     * Creates new form newCard
     */
    public newCardSelectEmployee() {
    	setTitle("newCardSelectEmployee");
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
        PanelEmployee = new javax.swing.JPanel();
        PanelEmployeePreview = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Label_Icon = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Label_EmployeeName = new javax.swing.JLabel();
        PanelEmployeeSelect = new javax.swing.JPanel();
        ScrollPane_Employees = new javax.swing.JScrollPane();
        List_Employees = new javax.swing.JList<>();
        List_Employees.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//gets the selected directory for employee
        		File selectedEmployeeDirectory = new File(employeeDirectory.getAbsolutePath() + "\\" + List_Employees.getSelectedValue());
        		
        		//gets the selected file for object location
        		File selectedEmployeeFile = new File(selectedEmployeeDirectory.getAbsolutePath() + "\\" + List_Employees.getSelectedValue() + ".json");
        		
        		//gets the employee object
        		FileHandler fileHandler = new FileHandler();
    			employee = fileHandler.getEmployee(selectedEmployeeFile);
    			
    			//sets preview name
        		
    			//checks if there is a picture then sets it in the preview
    			if(employee.pictureLocaitonPath != null) {
    				Label_Icon.setIcon(new ImageIcon(employee.getPictureLocaitonPath()));
    			}
        	}
        });
        PanelConfirm = new javax.swing.JPanel();
        Button_Select = new javax.swing.JButton();
        Button_Select.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//checks if an employee is selected
        		if(employee != null) {
        			MainRunner.runWriteCard(employee.getName());
        			newCardSelectEmployee.this.dispose();
        		}else {
					JOptionPane.showMessageDialog(getParent(), "No Employee Selected");
        		}
        	}
        });
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu_Back = new javax.swing.JMenu();
        Menu_Back.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		MainRunner.runCardMain();
        		newCardSelectEmployee.this.dispose();
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(960, 540));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 540));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        PanelEmployee.setBackground(new java.awt.Color(114, 137, 218));
        PanelEmployee.setMinimumSize(new java.awt.Dimension(960, 400));
        PanelEmployee.setName(""); // NOI18N
        PanelEmployee.setPreferredSize(new java.awt.Dimension(960, 400));
        PanelEmployee.setLayout(new javax.swing.BoxLayout(PanelEmployee, javax.swing.BoxLayout.LINE_AXIS));

        PanelEmployeePreview.setBackground(new java.awt.Color(114, 137, 218));
        PanelEmployeePreview.setPreferredSize(new java.awt.Dimension(300, 400));
        PanelEmployeePreview.setLayout(new java.awt.GridLayout(0, 1));

        jPanel2.setBackground(new java.awt.Color(114, 137, 218));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 200));
        jPanel2.setLayout(new java.awt.BorderLayout());

        Label_Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Icon.setIcon(new ImageIcon(newCardSelectEmployee.class.getResource("/Resources/user-picture.png"))); // NOI18N
        Label_Icon.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(Label_Icon, java.awt.BorderLayout.CENTER);

        PanelEmployeePreview.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(114, 137, 218));
        jPanel3.setMinimumSize(new java.awt.Dimension(300, 200));
        jPanel3.setLayout(new java.awt.BorderLayout());

        Label_EmployeeName.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        Label_EmployeeName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_EmployeeName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel3.add(Label_EmployeeName, java.awt.BorderLayout.CENTER);

        PanelEmployeePreview.add(jPanel3);

        PanelEmployee.add(PanelEmployeePreview);

        PanelEmployeeSelect.setBackground(new java.awt.Color(114, 137, 218));
        PanelEmployeeSelect.setPreferredSize(new java.awt.Dimension(660, 400));
        PanelEmployeeSelect.setLayout(new java.awt.GridLayout());

        List_Employees.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 48)); // NOI18N
        List_Employees.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = employeeList;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ScrollPane_Employees.setViewportView(List_Employees);

        PanelEmployeeSelect.add(ScrollPane_Employees);

        PanelEmployee.add(PanelEmployeeSelect);

        jPanel1.add(PanelEmployee);

        PanelConfirm.setBackground(new java.awt.Color(114, 137, 218));
        PanelConfirm.setMinimumSize(new java.awt.Dimension(960, 140));
        PanelConfirm.setPreferredSize(new java.awt.Dimension(960, 140));
        PanelConfirm.setLayout(new java.awt.GridBagLayout());

        Button_Select.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        Button_Select.setText("Select");
        Button_Select.setMaximumSize(new java.awt.Dimension(32767, 32767));
        Button_Select.setMinimumSize(new java.awt.Dimension(240, 50));
        Button_Select.setPreferredSize(new java.awt.Dimension(240, 50));
        PanelConfirm.add(Button_Select, new java.awt.GridBagConstraints());

        jPanel1.add(PanelConfirm);

        getContentPane().add(jPanel1);

        Menu_Back.setText("Back");
        Menu_Back.setMinimumSize(new java.awt.Dimension(33, 20));
        Menu_Back.setPreferredSize(new java.awt.Dimension(33, 20));
        jMenuBar1.add(Menu_Back);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Select;
    private javax.swing.JLabel Label_EmployeeName;
    private javax.swing.JLabel Label_Icon;
    private javax.swing.JList<String> List_Employees;
    private javax.swing.JMenu Menu_Back;
    private javax.swing.JPanel PanelConfirm;
    private javax.swing.JPanel PanelEmployee;
    private javax.swing.JPanel PanelEmployeePreview;
    private javax.swing.JPanel PanelEmployeeSelect;
    private javax.swing.JScrollPane ScrollPane_Employees;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
