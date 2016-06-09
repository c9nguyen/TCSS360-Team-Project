package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class View extends JDialog {

	private final JPanel contentPanel;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			View dialog = new View();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public View(BufferedImage img) {
		setModal(true);
		contentPanel = new SubmissionImage(img);
		setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
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
