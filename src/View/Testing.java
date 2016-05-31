package View;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class Testing extends JPanel {

	/**
	 * Create the panel.
	 */
	public Testing() {
		setLayout(new BorderLayout(0, 0));
		setupHeader();
		setupDescription();
		setupSouthPane();


	}
	
	public void setupHeader() {
		JLabel headerLbl = new JLabel("Name of the event");
		headerLbl.setFont(new Font("Verdana", Font.PLAIN, 23));
		headerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(headerLbl, BorderLayout.NORTH);
	}
	
	public void setupDescription() {
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		

		
		
		JTextArea txtDescription = new JTextArea();
		txtDescription.setEditable(false);
		txtDescription.setLineWrap(true);
		txtDescription.setText("Add description for the Event here");
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

}
