/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.WorkOrderGui;

import java.io.File;

import javax.swing.JOptionPane;

import Custom.FileHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.Frame;
import java.awt.event.ItemEvent;

/**
 *
 * @author Mason Smith
 */
@SuppressWarnings("serial")
public class customerSelect extends javax.swing.JFrame {

	public File CustomerLocation = new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Customers");
    /**
     * Creates new form customerSelect
     */
    public customerSelect() {
    	setTitle("CustomerSelect");
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
    	
    	//sets up the strings from customer directory
    	String[] customerList = CustomerLocation.list();   	
    	
    	
    	//removes the .json from the end of name
    	for(int i = 0; i < customerList.length; i++) {
    		if(i != customerList.length -1) {
    			customerList[i] = customerList[i].substring(0, customerList[i].length()-5);
    		}else {
    			customerList[i] = customerList[i].substring(customerList[i].indexOf("-") +1, customerList[i].length()-5);
    		}
    	}
    	
        jPanel1 = new javax.swing.JPanel();
        ComboBoxCustomerSelect = new javax.swing.JComboBox<>();
        ComboBoxCustomerSelect.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent event) {
        		if(event.getStateChange() == ItemEvent.SELECTED) {
        			workOrderRun.workOrderSuper.setCustomer(ComboBoxCustomerSelect.getSelectedItem().toString());
        			if(ComboBoxCustomerSelect.getSelectedIndex() != customerList.length-1) {        			
        				TextFieldCustomerName.setText(ComboBoxCustomerSelect.getSelectedItem().toString());
        			}else {
        				TextFieldCustomerName.setText("");
        			}
        		}
        	}
        });
        jPanel2 = new javax.swing.JPanel();
        TextFieldCustomerName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        ButtonSubmit = new javax.swing.JButton();
        ButtonSubmit.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		//sets up file handler
        		FileHandler fileHandler = new FileHandler();
        		File CustomerFullLocation = null;
        		//checks if there is a value for customer
        		if(!TextFieldCustomerName.getText().replaceAll(" ", "").equals("")) {
        			if(ComboBoxCustomerSelect.getSelectedIndex() == ComboBoxCustomerSelect.getItemCount()-1) {
            				CustomerFullLocation = new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Customers\\" + "zzz-WalkIn" + ".JSON");
            				
            				workOrderRun.selectedCustomer = fileHandler.getCustomer(CustomerFullLocation);
            				workOrderRun.workOrderSuper.setCustomer("Walk In " + TextFieldCustomerName.getText());      		
        			}else {
        				CustomerFullLocation = new File("\\\\192.168.0.125\\ServiceMachineTimeCardSystem\\Customers\\" + TextFieldCustomerName.getText() + ".JSON");
        				
        				workOrderRun.selectedCustomer = fileHandler.getCustomer(CustomerFullLocation);
        				workOrderRun.workOrderSuper.setCustomer(TextFieldCustomerName.getText());  
        			}
        			//finds current frame out of listed frames and disposes of it
            		for(int i = 0; i < Frame.getFrames().length; i++) {
            			if(Frame.getFrames()[i].getTitle().equals("CustomerSelect")) {
            				Frame.getFrames()[i].dispose();
            			}
            		}
        		}else {
        			//runs if walk in is selected and there is nothing in the exit text for customer name
        			Object[] options = {"OK"};
        			JOptionPane.showOptionDialog(null, "No Customer Name", "error", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        			TextFieldCustomerName.setText("");
        		}
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 500));
        setPreferredSize(new java.awt.Dimension(480, 500));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setMinimumSize(new java.awt.Dimension(460, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 100));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        ComboBoxCustomerSelect.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        ComboBoxCustomerSelect.setModel(new javax.swing.DefaultComboBoxModel<>(customerList));
        ComboBoxCustomerSelect.setSelectedIndex(ComboBoxCustomerSelect.getItemCount()-1);
        ComboBoxCustomerSelect.setMinimumSize(new java.awt.Dimension(460, 100));
        ComboBoxCustomerSelect.setPreferredSize(new java.awt.Dimension(460, 100));
        jPanel1.add(ComboBoxCustomerSelect);

        getContentPane().add(jPanel1);

        jPanel2.setMinimumSize(new java.awt.Dimension(460, 205));
        jPanel2.setPreferredSize(new java.awt.Dimension(460, 205));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        TextFieldCustomerName.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        TextFieldCustomerName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldCustomerName.setMinimumSize(new java.awt.Dimension(460, 205));
        TextFieldCustomerName.setPreferredSize(new java.awt.Dimension(460, 205));
        jPanel2.add(TextFieldCustomerName);

        getContentPane().add(jPanel2);

        jPanel3.setMinimumSize(new java.awt.Dimension(460, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(460, 100));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        ButtonSubmit.setText("Submit");
        ButtonSubmit.setMinimumSize(new java.awt.Dimension(250, 50));
        ButtonSubmit.setPreferredSize(new java.awt.Dimension(250, 45));
        jPanel3.add(ButtonSubmit, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel3);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSubmit;
    private javax.swing.JComboBox<String> ComboBoxCustomerSelect;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField TextFieldCustomerName;
    // End of variables declaration//GEN-END:variables
}
