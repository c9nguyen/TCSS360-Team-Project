package View;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class MainPane extends AbstractPanel {

	/**
	 * Create the panel.
	 */
	public MainPane(AbstractPanel caller) {
		super(caller);
		super.nextPanel = new LoginPane(this);
		
		setLayout(new BorderLayout(0, 0));
		setupHeader();
//		setupDescription();
		setupSouthPane();
	}
	
	private void setupHeader() {
		JLabel headerLbl = new JLabel("Clark County Libraries");
		headerLbl.setFont(new Font("Verdana", Font.PLAIN, 30));
		
		headerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(headerLbl, BorderLayout.NORTH);
	}
	
	private void setupDescription() {
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel LeftsidePanel = new JPanel();
		LeftsidePanel.setSize(10, 10);
		LeftsidePanel.setBackground(Color.YELLOW);
		add(LeftsidePanel, BorderLayout.WEST);
		
		JPanel RightsidePanel = new JPanel();
		RightsidePanel.setSize(10, 10);
		RightsidePanel.setBackground(Color.YELLOW);
		add(RightsidePanel, BorderLayout.EAST);
		

		
		
		JTextArea txtDescription = new JTextArea();
		txtDescription.setEditable(false);
		txtDescription.setLineWrap(true);
		
//		txtDescription.setBackground(Color.BLUE);
//		txtDescription.setPreferredSize(new java.awt.Dimension(384, 129));
		txtDescription.setSelectedTextColor(Color.BLACK);
		txtDescription.setFont(new Font("Burnt", Font.PLAIN, 30));
		txtDescription.setForeground(Color.BLACK);


		txtDescription.setText("CLARK COUNTY LIBRARY DRAWING CONTEST");
		txtDescription.setColumns(10);
		
		JScrollPane scrollDescription = new JScrollPane(txtDescription);
		centerPanel.add(scrollDescription, BorderLayout.CENTER);
	}
	
	public void setupSouthPane() {
		JPanel southPane = new JPanel();
		add(southPane, BorderLayout.SOUTH);
		
		JButton loginBtn = new JButton("Login");
		southPane.add(loginBtn);
	}
	
	@Override
    public void paintComponent(final Graphics theG) {
        super.paintComponent(theG);
        final Graphics2D g2d = (Graphics2D) theG;
        BufferedImage img = null;
        try {
           
//            img = ImageIO.read(new File("images/design1.png"));
            img = ImageIO.read(new File("images/Drawing.png"));

        } catch (final IOException e) {

            e.printStackTrace();
        }
        g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);

}
}