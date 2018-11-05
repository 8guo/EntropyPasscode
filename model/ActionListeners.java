package model;

import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cntrl.Main;

public class ActionListeners {
	
	public ActionListeners() {
		addMouseListener();
		addButtonListener();
	}
	
	public void addMouseListener() {
		Main.cFrame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Main.entropy.addCordToArray(MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());				
				Main.entropy.addStatus();
				Main.cFrame.setProg(Main.entropy.getStatus());
				if (Main.entropy.getStatus() == 20) {
					Main.cFrame.setVisible(false);
					try {Thread.sleep(500);} catch (InterruptedException e1) {e1.printStackTrace();}
					Main.pFrame.setVisible(true);
				}
			}
		});
	}
	
	public void addButtonListener() {
		Main.pFrame.btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.entropy.clearAllValues();
				boolean checkForSelection = false;
				if (Main.pFrame.chckbxUppercaseLetters.isSelected()) {
					Main.entropy.addUppers();
					checkForSelection = true;
				} if (Main.pFrame.chckbxLowercaseLetters.isSelected()) {
					Main.entropy.addLowers();
					checkForSelection = true;
				} if (Main.pFrame.chckbxNumbers.isSelected()) {
					Main.entropy.addNums();
					checkForSelection = true;
				} if (Main.pFrame.chckbxSymbols.isSelected()) {
					Main.entropy.addSymbols();
					checkForSelection = true;
				} if (checkForSelection == true) {
					Main.entropy.generatePasscode();
					Main.entropy.generatedTrue();
				} else {Main.pFrame.setPasscode("Error, no selection.");}
			}
		});
		Main.pFrame.btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Main.entropy.getGenerated()) {
					Main.entropy.toClipboard(Main.entropy.getPasscode());
				}
			}
		});
	}
	
}
