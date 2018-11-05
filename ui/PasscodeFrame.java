package ui;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

/*
 * UI for selecting passcode generation settings and display
 */

public class PasscodeFrame extends JFrame {
	
	private static final long serialVersionUID = -1147427425630242007L;
	
	private JTextField passField = new JTextField();
	public final JButton btnGenerate = new JButton("Generate");
	public final JButton btnCopy = new JButton("Copy");
	public final JCheckBox chckbxLowercaseLetters = new JCheckBox("Lowercase Letters");
	public final JCheckBox chckbxUppercaseLetters = new JCheckBox("Uppercase Letters");
	public final JCheckBox chckbxNumbers = new JCheckBox("Numbers");
	public final JCheckBox chckbxSymbols = new JCheckBox("Symbols");
	
	public PasscodeFrame() {
		new JFrame();
		setTitle("Generate Passcode");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(385, 125);
		setResizable(false);
		setLocationRelativeTo(null);
		
		passField.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(passField, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGenerate))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxLowercaseLetters, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxUppercaseLetters))
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chckbxNumbers)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCopy, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
								.addComponent(chckbxSymbols))))
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGenerate))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxLowercaseLetters)
						.addComponent(chckbxNumbers)
						.addComponent(btnCopy))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxUppercaseLetters)
						.addComponent(chckbxSymbols))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public void setPasscode(String t) {passField.setText(t);}
	
}
