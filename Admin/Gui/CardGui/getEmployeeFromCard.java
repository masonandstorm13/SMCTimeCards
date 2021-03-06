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
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Mason Smith
 */
@SuppressWarnings("serial")
public class getEmployeeFromCard extends javax.swing.JFrame {
	
	public static String cardValue;
	static CardTerminal terminal;
	private static Thread cardThread;
    /**
     * Creates new form writeCard
     * @throws CardException 
     * @throws UnsupportedEncodingException 
     */
    public getEmployeeFromCard() throws UnsupportedEncodingException, CardException { 
    	setVisible(true);

    	setTitle("readCard");
    	initComponents();
    	
    	readCard();
    }
    
    
    public static void readCard() throws CardException, UnsupportedEncodingException {
    	TerminalFactory factory = TerminalFactory.getDefault();
        List<CardTerminal> terminals = factory.terminals().list();
        terminal = terminals.get(0);
        nfcLibrary nfcLibrary = new nfcLibrary(terminal, "T=1", (byte) 0x00, (byte) 0x04, null, 0);
        cardThread = new Thread(nfcLibrary);
        cardThread.start();
    }

    
    public static void hereIsYourValue(String value) throws CardException, UnsupportedEncodingException {
    	System.out.println("re Run");
    	if(value.length() > 2) {
    		JOptionPane.showMessageDialog(null, "Employee: " + value, 
    	            "Card Value", JOptionPane.CLOSED_OPTION);
        	MainRunner.runCardMain();
    		for(Frame frame : getEmployeeFromCard.getFrames()) {
    			frame.dispose();
    		}
        }else {
        	readCard();
        }
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
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuBack = new javax.swing.JMenu();
        MenuBack.addMouseListener(new MouseAdapter() {
        	@SuppressWarnings("deprecation")
			@Override
        	public void mouseClicked(MouseEvent arg0) {
        		MainRunner.runCardMain();
        		getEmployeeFromCard.this.dispose();
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
        jLabel1.setIcon(new ImageIcon(getEmployeeFromCard.class.getResource("/Resources/loading-gif-png.gif"))); // NOI18N
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
