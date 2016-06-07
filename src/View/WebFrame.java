package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author tryHARD
 * TCSS 360
 */

/**
 * Main Frame that contains all panels.
 *
 */
public class WebFrame extends JFrame {

	/* Setting up size of frame */
	public static final Dimension SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final double RATIO = 0.7;
	
	public static final int DEFAULT_WIDTH = (int) (SIZE.getWidth() * RATIO);
	
	public static final int DEFAULT_HEIGHT = (int) (SIZE.getHeight() * RATIO);
		
	private JPanel contentPane;
	
	private JPanel myMainPanel;
	
	/* Next Panel */
	private JPanel nextPanel;
	
	/* Previous Panel */
	private JPanel previousPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebFrame frame = new WebFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WebFrame() {
		contentPane = new MainPane(null);
	
		setUpFrame();
	}
	
	private void setUpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		setContentPane(contentPane);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void nextPane() {
		setContentPane(nextPanel);
	}

}
