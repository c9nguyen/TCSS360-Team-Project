package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	
	public static final double WIDTH_RATIO = 0.6;
	
	public static final double HEIGHT_RATIO = 0.7;
	
	public static final int DEFAULT_WIDTH = (int) (SIZE.getWidth() * WIDTH_RATIO);
	
	public static final int DEFAULT_HEIGHT = (int) (SIZE.getHeight() * HEIGHT_RATIO);
		
	private AbstractPanel contentPane;
	
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
	
	private void setUpFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		setContentPane(contentPane);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void goNext() {
		contentPane = contentPane.nextPanel;
		setContentPane(contentPane);
		revalidate();
	}
	
	public void goBack() {
		contentPane = contentPane.backPanel;
		setContentPane(contentPane);
		revalidate();
	}

	public DataManager getDataManager() {
		return myDataManageer;
	}
}
