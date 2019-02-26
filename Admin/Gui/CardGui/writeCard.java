/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.CardGui;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Runner.MainRunner;
import NFC.nfcLibrary;

import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Mason Smith
 */
@SuppressWarnings("serial")
public class writeCard extends javax.swing.JFrame {
	
	static CardTerminal terminal;
    /**
     * Creates new form writeCard
     * @throws CardException 
     */
    public writeCard(String cardValue) throws CardException {
    	setVisible(true);
    	setTitle("writeCard");
    	initComponents();
    	
    	
    	writeCardNewCard(cardValue);
    }
    
    public static void writeCardNewCard(String cardValue) throws CardException {
    	byte[] masterByte = new byte[16];
		
		for(int i = 0; i < cardValue.getBytes().length; i++) {
			masterByte[i] = cardValue.getBytes()[i];
		}
    	
    	TerminalFactory factory = TerminalFactory.getDefault();
        List<CardTerminal> terminals = factory.terminals().list();
        terminal = terminals.get(0);
        nfcLibrary nfcLibrary = new nfcLibrary(terminal, "T=1", (byte) 0x00, (byte) 0x04, masterByte, 1);
        new Thread(nfcLibrary).start();
    }
    
    public static void hereIsYourValue(String value, String cardValue) throws CardException {
    	if(value.equals("9000")) {
    		JOptionPane.showMessageDialog(null, "Card Created", 
    	            "Notification", JOptionPane.CLOSED_OPTION);
        	MainRunner.runNewCardSelectEmployee();
    		for(Frame frame : writeCard.getFrames()) {
    			frame.dispose();
    		}
        }else {
        	writeCardNewCard(cardValue);
        }
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
