package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * A view dialog used to view the submission.
 * @author tryHARD
 *
 */
public class View extends JDialog {

	private final JPanel contentPanel;

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

	/**
	 * Panel class contains the image.
	 * @author tryHARD
	 *
	 */
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
