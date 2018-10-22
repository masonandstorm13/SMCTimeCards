/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Runner.MainRunner;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;

import javax.swing.JMenu;

/**
 *
 * @author Mason Smith
 */
@SuppressWarnings("serial")
public class WorkOrderMultiPartSelect extends javax.swing.JFrame {

	private int count = 0;
	
	public String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
    /**
     * Creates new form workOrderMutliPartSelect
     */
    public WorkOrderMultiPartSelect() {
    	setTitle("MultiPartSelect");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ButtonSubmit = new java.awt.Button();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuAdd = new javax.swing.JMenu();
        MenuRemove = new javax.swing.JMenu();
        MenuRemove.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		String[] tempAlphabet = new String[26];
        		for(int i = 0; i< jPanel6.getComponentCount(); i++) {
        			tempAlphabet[i] = alphabet[i];
        		}
                Object selectedObject = JOptionPane.showInputDialog(getParent(), "Select Part To Remove", "Part Remover", JOptionPane.PLAIN_MESSAGE, null, tempAlphabet, tempAlphabet[0]);
                
                //checks if cancel was selected
                if(selectedObject != null) {
                	for(int i = 0; i< tempAlphabet.length; i++) {
            			if(selectedObject.toString().equals(alphabet[i])) {
            				removePart(i);
            			}
            		}
                }
             }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 400));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 300));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(800, 300));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(800, 300));

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.PAGE_AXIS));
        jPanel6.setName("Main Part Holder");

        

        jPanel6.add(createPanel(count));

        jScrollPane2.setViewportView(jPanel6);

        jPanel1.add(jScrollPane2);

        getContentPane().add(jPanel1);

        jPanel2.setMinimumSize(new java.awt.Dimension(800, 80));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 80));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        ButtonSubmit.setLabel("Submit");
        ButtonSubmit.setMinimumSize(new java.awt.Dimension(125, 30));
        ButtonSubmit.setPreferredSize(new java.awt.Dimension(125, 30));
        jPanel2.add(ButtonSubmit, new java.awt.GridBagConstraints());
        ButtonSubmit.getAccessibleContext().setAccessibleName("button_Submit");

        getContentPane().add(jPanel2);

        jMenuBar1.setMinimumSize(new java.awt.Dimension(800, 20));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(800, 20));
        
        MenuBack = new JMenu("Back");
        MenuBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		MainRunner.runWorkOrderMain();
        		//finds current frame out of listed frames and disposes of it
        		for(int i = 0; i < Frame.getFrames().length; i++) {
        			if(Frame.getFrames()[i].getTitle().equals("MultiPartSelect")) {
        				Frame.getFrames()[i].dispose();
        			}
        		}
        	}
        });
        jMenuBar1.add(MenuBack);

        MenuAdd.setText("Add");
        jMenuBar1.add(MenuAdd);

        MenuRemove.setText("Remove");
        jMenuBar1.add(MenuRemove);

        setJMenuBar(jMenuBar1);
        
        MenuAdd.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(count < 26) {
        			jPanel6.add(createPanel(count));
        			jScrollPane2.validate();
        			JScrollBar vertical = jScrollPane2.getVerticalScrollBar();
        			vertical.setValue( vertical.getMaximum() );
        		}else if(count >= 26) {
        			JOptionPane.showMessageDialog(getParent(),"Maximum Parts Reached");  
        		}
        	}
        });
        
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public javax.swing.JPanel createPanel(int letterCorrelation){
    	
    	javax.swing.JPanel PanelDefault = new JPanel();
        javax.swing.JPanel PanelDescription = new JPanel();
        javax.swing.JPanel PanelPart = new JPanel();
        javax.swing.JScrollPane ScrollPaneDescription = new JScrollPane();
        javax.swing.JTextArea TextAreaDescription = new JTextArea();
        javax.swing.JTextField TextFieldPart = new JTextField();
        
        PanelDefault.setName(String.valueOf(letterCorrelation));

        java.awt.Color color = new java.awt.Color(((int)(Math.random() * ((225 - 0) + 1)) + 0),((int)(Math.random() * ((225 - 0) + 1)) + 0),((int)(Math.random() * ((225 - 0) + 1)) + 0));
        PanelDefault.setMinimumSize(new java.awt.Dimension(800, 100));
        PanelDefault.setBorder(BorderFactory.createLineBorder(Color.black));
        PanelDefault.setPreferredSize(new java.awt.Dimension(800, 100));
        PanelDefault.setLayout(new java.awt.GridLayout());

        PanelPart.setLayout(new java.awt.GridBagLayout());

        TextFieldPart.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        TextFieldPart.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldPart.setText(alphabet[count]);
        TextFieldPart.setEditable(false);
        TextFieldPart.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TextFieldPart.setName("Letter Holder");
        TextFieldPart.setPreferredSize(new java.awt.Dimension(240, 30));
        PanelPart.add(TextFieldPart, new java.awt.GridBagConstraints());

        PanelDefault.add(PanelPart);

        PanelDescription.setLayout(new javax.swing.BoxLayout(PanelDescription, javax.swing.BoxLayout.LINE_AXIS));

        ScrollPaneDescription.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        TextAreaDescription.setColumns(20);
        TextAreaDescription.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        TextAreaDescription.setRows(5);
        TextAreaDescription.setToolTipText("Description");
        ScrollPaneDescription.setViewportView(TextAreaDescription);
        PanelDescription.add(ScrollPaneDescription);
        PanelDefault.add(PanelDescription);
        
        
        jScrollPane2.revalidate();
        jPanel6.revalidate();
        
                        
        count++;
        
        return PanelDefault;
        
    }

    public void removePart(int letterCorrelation) {
    	System.out.println("First Total Count: " + jPanel6.getComponentCount());
    		//finds the correct selected part
    		for (int j = 0; j<jPanel6.getComponentCount(); j++) {
        		System.out.println(jPanel6.getComponent(j).getName());
    			if (jPanel6.getComponent(j).getName().equals(String.valueOf(letterCorrelation))) {
    				jPanel6.remove(jPanel6.getComponent(j));
    			}
    		}   		
    	//reloads the panel after deletion
    	jScrollPane2.revalidate();
        jPanel6.revalidate();
        jPanel6.repaint();
        correctPartPossition(letterCorrelation);
    }
    
    //corrects the text in the edit text as well as corrected the names of all jFrames
    public void correctPartPossition(int letterCorrelation) {
    	String [] alph = alphabet;
    	System.out.println("Second Total Count: " + jPanel6.getComponentCount());
    	for(int j = letterCorrelation; j<jPanel6.getComponentCount(); j++) {
    		//rest all the names so they equal there position in the current array 
    		jPanel6.getComponent(j).setName(String.valueOf(j));
    		
    		//iterates through panels to edit text to set the letter value for each affected area 
    		Component mainPanel = jPanel6.getComponent(j);
    		if(mainPanel instanceof Container){
    			Component panelDescription = ((Container) mainPanel).getComponent(0);
    			if(panelDescription instanceof Container) {
    				Component editTextLetter = ((Container) panelDescription).getComponent(0);
    				if(editTextLetter instanceof javax.swing.JTextField) {
        				((javax.swing.JTextField) editTextLetter).setText(alph[j]);
        			}
    			}
    		}
    	}    	  
    	count--;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button ButtonSubmit;
    private javax.swing.JMenu MenuAdd;
    private javax.swing.JMenu MenuRemove;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private JMenu MenuBack;
    // End of variables declaration//GEN-END:variables
}
