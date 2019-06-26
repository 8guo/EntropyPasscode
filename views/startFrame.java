package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class startFrame extends JFrame {

    public startFrame() { initComponents(); canSee(true);}

    private void initComponents() {
        startButton = new JButton();
        helpButton = new JButton();
        entropyButton = new JButton();

        setResizable(false);
        setTitle("Entropy Password");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        startButton.setText("Start");
        helpButton.setText("Help");
        entropyButton.setText("Check Entropy");
        entropyButton.setEnabled(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(startButton)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(entropyButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(helpButton)
                    .addContainerGap(7, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(startButton)
                        .addComponent(entropyButton)
                        .addComponent(helpButton))
                    .addContainerGap(5, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(null);
    }

    public void canSee(boolean tf) { setVisible(tf); }
    public JButton startButton;
    public JButton helpButton;
    public JButton entropyButton;

}
