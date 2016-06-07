package View;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LoginPane extends AbstractPanel {

	private static final long serialVersionUID = 1L;
	
	/* Reporting the id is wrong */
	public final int WRONG_ID = 0;
	/* Reporting the password is wrong */
	public final int WRONG_PASS = 1;
	/* Reporting the id is wrong */
	public final int EMPTY_ID = 2;
	/* Reporting the password is wrong */
	public final int EMPTY_PASS = 3;
	
	/* text field for id */
	private JTextField idTxtField;
	/* text field for password */
	private JTextField passTxtField;
	/* label for reporting */
	private JLabel reportLabel;

	/**
	 * Create the panel.
	 */
	public LoginPane(AbstractPanel caller) {
		super(caller);
		super.nextPanel = null;
		
		setLayout(new BorderLayout(0, 0));
		
		setupHeader();	
		setupLogin();
	}
	
	/**
	 * Setting the header.
	 * Includes a login label.
	 * A description.
	 */
	private void setupHeader() {
		JPanel headerPane = new JPanel();
		add(headerPane, BorderLayout.NORTH);
		headerPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		loginLabel.setHorizontalAlignment(SwingConstants.LEFT);
		headerPane.add(loginLabel);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		headerPane.add(lblDescription);
	}
	
	/**
	 * Setting up the login panel at the center.
	 * Includes 2 text labels and 2 text fields for id and pass, and login button.
	 * 
	 */
	private void setupLogin() {
		JPanel centerPane = new JPanel();
		add(centerPane, BorderLayout.CENTER);
	
		JPanel idPane = new JPanel();
		idPane.setBackground(Color.DARK_GRAY);
		idPane.setPreferredSize(new Dimension(400, 300));
		idPane.setMinimumSize(new Dimension(400, 300));
		idPane.setMinimumSize(new Dimension(400, 300));

		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		idTxtField = new JTextField();
		idTxtField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		passTxtField = new JTextField();
		passTxtField.setColumns(10);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		reportLabel = new JLabel("");
		centerPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		GroupLayout gl_idPane = new GroupLayout(idPane);
		gl_idPane.setHorizontalGroup(
			gl_idPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_idPane.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_idPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPassword)
						.addComponent(lblNewLabel))
					.addGap(30)
					.addGroup(gl_idPane.createParallelGroup(Alignment.LEADING)
						.addComponent(idTxtField, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
						.addComponent(passTxtField, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
					.addGap(15))
				.addGroup(gl_idPane.createSequentialGroup()
					.addGap(156)
					.addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(155, Short.MAX_VALUE))
		);
		gl_idPane.setVerticalGroup(
			gl_idPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_idPane.createSequentialGroup()
					.addGap(92)
					.addGroup(gl_idPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(idTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(16)
					.addGroup(gl_idPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(passTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(26)
					.addComponent(loginBtn)
					.addContainerGap(91, Short.MAX_VALUE))
		);
		idPane.setLayout(gl_idPane);
		centerPane.add(idPane);

		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
//		panel.setPreferredSize(idPane.getPreferredSize());
//		panel.setMinimumSize(idPane.getMinimumSize());
//		panel.setMinimumSize(idPane.getMaximumSize());
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.WEST);
//		panel_1.setPreferredSize(idPane.getPreferredSize());
//		panel_1.setMinimumSize(idPane.getMinimumSize());
//		panel_1.setMinimumSize(idPane.getMaximumSize());
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.EAST);
//		panel_2.setPreferredSize(idPane.getPreferredSize());
//		panel_2.setMinimumSize(idPane.getMinimumSize());
//		panel_2.setMinimumSize(idPane.getMaximumSize());
		
	}
	
	/**
	 * Setting label text to report the issue.
	 * @param error is the code of error.
	 */
	public void reportError(int error) {
		switch(error) {
		case WRONG_ID:
			reportLabel.setText("ID is invalid");
			break;
		case WRONG_PASS:
			reportLabel.setText("Password is invalid");
			break;
		case EMPTY_ID:
			reportLabel.setText("Please enter ID");
			break;
		case EMPTY_PASS:
			reportLabel.setText("Please enter password");
			break;
		default:
			reportLabel.setText("");
			break;
		}
	
	}
	
	/**
	 * Getting the input ID.
	 * Reporting error if there is no input.
	 * @return input ID.
	 */
	public String getID() {
		String id = idTxtField.getText();
		if (id.length() == 0) {
			reportError(EMPTY_ID);
			id = null;
		} else {
			id = idTxtField.getText();
		}
		
		return id;
	}
	
	/**
	 * Getting the input password.
	 * Reporting error if there is no input.
	 * @return input password.
	 */
	public String getPass() {
		String pass = passTxtField.getText();
		if (pass.length() == 0) {
			reportError(EMPTY_PASS);
			pass = null;
		} else {
			pass = passTxtField.getText();
		}
		
		return pass;
	}
	
}
