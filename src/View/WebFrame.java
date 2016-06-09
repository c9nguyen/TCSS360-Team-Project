package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Model.DataManager;

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
	
	/* Ratio of width to screen size */
	public static final double WIDTH_RATIO = 0.6;
	
	/* Ratio of height to screen size */
	public static final double HEIGHT_RATIO = 0.7;
	
	/* Default width */
	public static final int DEFAULT_WIDTH = (int) (SIZE.getWidth() * WIDTH_RATIO);
	
	/* Default height */
	public static final int DEFAULT_HEIGHT = (int) (SIZE.getHeight() * HEIGHT_RATIO);
		
	/* The current pane displayed */
	private AbstractPanel contentPane;
	
	/* The Data manager to control all data */
	private DataManager myDataManageer;

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
		contentPane = new MainPane(this, null);
		myDataManageer = new DataManager();
		setUpFrame();
	}
	
	/**
	 * Setting the Frame.
	 */
	private void setUpFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		setContentPane(contentPane);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	/**
	 * Go to next panel corresponding to current panel
	 */
	public void goNext() {
		contentPane = contentPane.nextPanel;
		setContentPane(contentPane);
		revalidate();
	}
	
	/**
	 * Go to back panel corresponding to current panel
	 */
	public void goBack() {
		contentPane = contentPane.backPanel;
		setContentPane(contentPane);
		revalidate();
	}

	/**
	 * Get the data manager
	 * @return
	 */
	public DataManager getDataManager() {
		return myDataManageer;
	}
}
