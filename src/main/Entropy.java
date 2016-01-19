package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.NoSuchAlgorithmException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import hash.B64;

//Simple project by Jacky Tai
//www.taijacky.com
//The goal is to have a frame take random mouse click data and making a 20 lengthed string

public class Entropy {
	
	public static int width = 500; //Width of Entropy Frame
	public static int height = width; //Same as Entropy Frame

	public static B64 _b64; //No need to import SHA256 because it's called in B64
	
	public static JFrame entropy; //Panel that collects mouse points
	public static JLabel help;
	public static JPanel entropyPanel; //Goes on Entropy
	public static JProgressBar progressBar; //Shows progress of clicks
	public static JFrame entropyPrnt; //Panel that holds JTextArea
	public static JTextArea entropyOutput; //Where generated string prints out
	public static Border border;
	
	public static String mousedata = ""; //Collect all points up until 200 coordinates
	public static String mouseTMP = ""; //Used to swap and replace with mousedata
	
	public static int _ogX; //Takes original X
	public static int _ogY; //Takes original Y
	public static int _nX; //To make sure _nX != _ogX
	public static int _nY; //To make sure _nY != _ogY
	
	public static void main(String[] args) {
		
		entropy = new JFrame("Entropy Data Gatherer"); //For detecting mouse movement
		help = new JLabel("Click anywhere on this window until the progress bar reaches 100%."); //Help label
		entropyPrnt = new JFrame("Generated String"); //For displaying string
		//DON'T make visable yet! Show it at the end. It's currently "Null"
		entropyOutput = new JTextArea(""); //What the string is goign to be..
		entropyPanel = new JPanel();
		progressBar = new JProgressBar();
	        border = BorderFactory.createTitledBorder("Status...");
		progressBar.setValue(0);
	        progressBar.setStringPainted(true);
      	        progressBar.setBorder(border);
	        progressBar.setPreferredSize( new Dimension (500, 75));
	        entropyPanel.add(progressBar, BorderLayout.NORTH);
	        entropyPanel.add(help);
		entropy.setSize(width, height);
		entropy.setVisible(true);
		entropy.setResizable(false);
		entropy.setLocationRelativeTo(null);
		entropy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		entropy.add(entropyPanel);
		entropyPrnt.setSize(370, 75);
		entropyPrnt.setResizable(false);
		entropyPrnt.setLocationRelativeTo(null);
		entropyPrnt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		entropyOutput.setLineWrap(true);
		entropyOutput.setEditable(false);
		entropyOutput.setFont(entropyOutput.getFont().deriveFont(25.0f));
		entropyPrnt.add(entropyOutput); //add JTextArea
		
		//Assign what moving mouse does
		entropyPanel.addMouseListener(new MouseAdapter() {
			
			int status = 0; //Progress bar
			
			@Override
			public void mousePressed(MouseEvent e) {
				status = status + 4;
				progressBar.setValue(status); //Update progresBar!
				PointerInfo pointInfo = MouseInfo.getPointerInfo();
				Point point = pointInfo.getLocation();
				_ogX = (int) point.getX(); //Get Point X
				_ogY = (int) point.getY(); //Get Point Y
				mousedata = "" + _ogX + _ogY;
				mouseTMP = mouseTMP + mousedata; //Adds (X,Y) to string!
				if (status == 100) { //Check if it's at 100%
					entropy.setVisible(false);
					try {
						String randomStr = B64.Base64(mouseTMP).substring(0, 20);
						entropyOutput.setText(randomStr);
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					entropyPrnt.setVisible(true);
				}	
			}
		});	
	}
}
