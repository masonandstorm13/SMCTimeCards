/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.CardGui;
import javax.swing.ImageIcon;

import Runner.MainRunner;
import NFC.Acr122Manager;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Mason Smith
 */
@SuppressWarnings("serial")
public class writeCard extends javax.swing.JFrame {
	
	public String dataCardValue;
	public TimerTask timerTask;
    /**
     * Creates new form writeCard
     */
    public writeCard(String cardValue) {
    	//sets up values for nfc card defaults
		final String sector = "01" ;
    	final String block = "00";   	
    	String keyTmp = "FFFFFFFFFFFF" ;
    	String dataTmp = cardValue;
    	
    	dataCardValue = cardValue;
    	setTitle("writeCard");
    	initComponents();
    	//sets up timer
    	Timer timer = new Timer();
    	//starts timer task for checking if frame is active then runs the write card method
    	timerTask = new TimerTask() {
    		public void run() {
    			if(writeCard.this.isActive() == true) {
    				try {    					
            			Acr122Manager.writeToCards(sector,block,keyTmp,dataTmp);
            		} catch (IOException exeption) {
            			// TODO Auto-generated catch block
            			exeption.printStackTrace();
            		}
    			}else {
    				
    			}
    		}
    	};
    	
    	timer.schedule(timerTask, 500);
    	
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	//sets the location of frame to middle of screen
    	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    	this.setLocation(gd.getDisplayMode().getWidth()/4-this.getSize().width/2, gd.getDisplayMode().getHeight()/4-this.getSize().height/2);
    	
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuBack = new javax.swing.JMenu();
        MenuBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		timerTask.cancel();
        		if(Acr122Manager.getDevice() != null) {
        			try {
    					Acr122Manager.getDevice().close();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
        		}
        		MainRunner.runNewCardSelectEmployee();
        		writeCard.this.dispose();
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 560));
        setPreferredSize(new java.awt.Dimension(960, 560));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setMinimumSize(new java.awt.Dimension(960, 540));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 540));
        jPanel1.setLayout(new java.awt.GridLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new ImageIcon(writeCard.class.getResource("/Resources/loading-gif-png.gif"))); // NOI18N
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);

        MenuBack.setText("Back");
        MenuBack.setMinimumSize(new java.awt.Dimension(27, 20));
        MenuBack.setPreferredSize(new java.awt.Dimension(50, 20));
        jMenuBar1.add(MenuBack);

        setJMenuBar(jMenuBar1);

        pack();

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
