package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewSubmission extends JFrame {

	private SubmissionImage contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					File myFile = new File("images/1111/P03-01-11_14.12.jpg");
					BufferedImage img = ImageIO.read(myFile);
					ViewSubmission frame = new ViewSubmission(img);
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
	public ViewSubmission(BufferedImage img) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		contentPane = new SubmissionImage(img);
		setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
		setContentPane(contentPane);
		pack();
	}
	
	public class SubmissionImage extends JPanel {
		private BufferedImage image;

		public SubmissionImage(BufferedImage theImage) {
			image = theImage;
		}

		@Override
		public void paintComponent(final Graphics theG) {
			super.paintComponent(theG);
			final Graphics2D g2d = (Graphics2D) theG;
			g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);

		}
	}
}
