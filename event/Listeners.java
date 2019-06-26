package event;

import launcher.Main;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

public class Listeners {

    public Listeners() {
        startFrameListener();
        gatherFrameListener();
        generateFrameListener();
    }

    public void startFrameListener() {
        // Start
        Main._startFrame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main._startFrame.canSee(false);
                Main._gatherFrame.canSee(true);
            }
        });
        // Check Entropy
        Main._startFrame.entropyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        // Help
        Main._startFrame.helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(null, "For instructions regarding this program, please refer to the GitHub. (https://github.com/8guo/EntropyPasscode)", "Help", JOptionPane.PLAIN_MESSAGE); }
        });
    }

    public void gatherFrameListener() {
        // TODO - Collect the coords and add it to array list
        Main._gatherFrame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                // A little time to read
                if (Main._gatherFrame.getProgress() == 0) { try { Thread.sleep(500);} catch (InterruptedException ex){ex.printStackTrace();} }

                if (Main._gatherFrame.getProgress() < Main._gatherFrame.maxProgress()) {
                    try {
                        Main._cord2Seed.addCord(MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
                        Main._gatherFrame.incProgress();
                        Main._gatherFrame.paintCollected();
                        Thread.sleep(10); //25??
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }

                } else {
                    Main._cord2Seed.create();
                    Main._gatherFrame.canSee(false);
                    Main._generateFrame.canSee(true);
                }
            }
        });
    }


    public void generateFrameListener() {
        // TODO

        Main._generateFrame.generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main._generateFrame.setPasscodeText(Main._genPass.makePasscode());
            }
        });

        Main._generateFrame.copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Main._genPass.copyToClipboard(); }
        });

        Main._generateFrame.homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.clearAll();
            }
        });

        Main._generateFrame.lengthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main._genPass.setLength(Main._generateFrame.getLength());
            }
        });

    }

}
