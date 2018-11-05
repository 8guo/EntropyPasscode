package ui;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.BorderLayout;

/*
 * UI for gathering user entropy
 */

public class ClickFrame extends JFrame {
	
	private static final long serialVersionUID = 4684159929412371370L;
	
	private Border border;
	private JLabel label;
	private JProgressBar progBar;
	
	public ClickFrame() {
		new JFrame();
		setTitle("Entropy Data Gatherer");
		setMinimumSize(new Dimension(500, 250));
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Click anywhere on this window until the progress bar fills up");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
        border = BorderFactory.createTitledBorder("Status...");
		
		progBar = new JProgressBar();
		progBar.setMaximum(20);
		progBar.setValue(0);
		progBar.setStringPainted(true);
		progBar.setBorder(border);
		progBar.setPreferredSize(new Dimension(1000, 75));
		
		getContentPane().add(label);
		getContentPane().add(progBar, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void setProg(int status) {progBar.setValue(status);}
	
}
