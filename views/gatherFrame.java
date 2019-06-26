package views;

import java.awt.*;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.GroupLayout;

public class gatherFrame extends JFrame {

    public gatherFrame() { initComponents(); canSee(false);}

    private void initComponents() {

        gatherPanel = new JPanel();
        label1 = new JLabel();
        progressBar = new JProgressBar();

        setTitle("Entropy Gatherer");
        setMinimumSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container gatherFrameContentPane = getContentPane();
        {

            label1.setText("Move your mouse around in this window until the progress bar is full.");
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            progressBar.setMaximum(1000);

            GroupLayout gatherPanelLayout = new GroupLayout(gatherPanel);
            gatherPanel.setLayout(gatherPanelLayout);
            gatherPanelLayout.setHorizontalGroup(
                    gatherPanelLayout.createParallelGroup()
                            .addGroup(gatherPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(gatherPanelLayout.createParallelGroup()
                                            .addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            gatherPanelLayout.setVerticalGroup(
                    gatherPanelLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, gatherPanelLayout.createSequentialGroup()
                                    .addContainerGap(205, Short.MAX_VALUE)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addGap(179, 179, 179)
                                    .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );
        }

        GroupLayout gatherFrameContentPaneLayout = new GroupLayout(gatherFrameContentPane);
        gatherFrameContentPane.setLayout(gatherFrameContentPaneLayout);
        gatherFrameContentPaneLayout.setHorizontalGroup(
                gatherFrameContentPaneLayout.createParallelGroup()
                        .addComponent(gatherPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gatherFrameContentPaneLayout.setVerticalGroup(
                gatherFrameContentPaneLayout.createParallelGroup()
                        .addComponent(gatherPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(null);
    }

    public void paintCollected() {
        label1.setText("Points Collected: " + getProgress());
    }
    public void canSee(boolean tf) { setVisible(tf); }
    public void resetProgress() { progressBar.setValue(0); label1.setText("Move your mouse around in this window until the progress bar is full.");}
    public void incProgress() { progressBar.setValue(getProgress() + 1);}
    public int getProgress() { return progressBar.getValue();}
    public int maxProgress() { return progressBar.getMaximum();}

    public JPanel gatherPanel;
    private JLabel label1;
    private JProgressBar progressBar;
}
