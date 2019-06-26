package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class generateFrame extends JFrame {

    public generateFrame() { initComponents(); canSee(false); }

    private void initComponents() {
        passcodeTextField = new JTextField();
        generateButton = new JButton();
        copyButton = new JButton();
        lowercaseCheckBox = new JCheckBox();
        uppercaseCheckBox = new JCheckBox();
        numbersCheckBox = new JCheckBox();
        symbolsCheckBox = new JCheckBox();
        lengthButton = new JButton();
        lengthTextField = new JTextField();
        homeButton = new JButton();

        setTitle("Generate Passcode");
        setResizable(false);
        setFocusable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        passcodeTextField.setEditable(false);
        generateButton.setText("Generate");
        copyButton.setText("Copy");
        lowercaseCheckBox.setText("Lowercase Letters");
        uppercaseCheckBox.setText("Uppercase Letters");
        numbersCheckBox.setText("Numbers");
        symbolsCheckBox.setText("Symbols");
        lengthButton.setText("Set Length");
        homeButton.setText("Home");

        resetProgress();

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(lowercaseCheckBox)
                                .addComponent(uppercaseCheckBox))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(symbolsCheckBox, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addComponent(numbersCheckBox, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                        .addComponent(passcodeTextField, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(generateButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(copyButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1)
                                    .addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(lengthTextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lengthButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(33, 33, 33))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(generateButton, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(passcodeTextField, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(lowercaseCheckBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addComponent(copyButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addComponent(symbolsCheckBox, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lengthTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lengthButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                            .addComponent(numbersCheckBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(uppercaseCheckBox, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6))
        );
        setSize(410, 155);
        setLocationRelativeTo(null);
    }

    public void alert(String message) {
        JOptionPane.showMessageDialog(null, message, "Alert", JOptionPane.PLAIN_MESSAGE);
    }

    public void setPasscodeText(String passcode) { passcodeTextField.setText(passcode); }
    public String getPasscodeText() { return passcodeTextField.getText(); }
    public String getLength() { return lengthTextField.getText(); }

    public void resetProgress() {
        passcodeTextField.setText("");
        lengthTextField.setText("8");
        lowercaseCheckBox.setSelected(true);
        uppercaseCheckBox.setSelected(true);
        numbersCheckBox.setSelected(true);
        symbolsCheckBox.setSelected(true);
    }

    public void canSee(boolean tf) { setVisible(tf); }

    private JTextField passcodeTextField;
    private JTextField lengthTextField;
    public JCheckBox lowercaseCheckBox;
    public JCheckBox uppercaseCheckBox;
    public JCheckBox numbersCheckBox;
    public JCheckBox symbolsCheckBox;
    public JButton generateButton;
    public JButton copyButton;
    public JButton lengthButton;
    public JButton homeButton;
}