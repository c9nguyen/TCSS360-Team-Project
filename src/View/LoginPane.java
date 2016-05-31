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

public class LoginPane extends JPanel {

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
	public LoginPane() {
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
		SpringLayout sl_centerPane = new SpringLayout();
		centerPane.setLayout(sl_centerPane);
	
		JPanel idPane = new JPanel();
		sl_centerPane.putConstraint(SpringLayout.NORTH, idPane, 10, SpringLayout.NORTH, centerPane);
		sl_centerPane.putConstraint(SpringLayout.WEST, idPane, 107, SpringLayout.WEST, centerPane);
		sl_centerPane.putConstraint(SpringLayout.SOUTH, idPane, -46, SpringLayout.SOUTH, centerPane);
		sl_centerPane.putConstraint(SpringLayout.EAST, idPane, -107, SpringLayout.EAST, centerPane);
		SpringLayout sl_idPane = new SpringLayout();
		idPane.setLayout(sl_idPane);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idPane.add(lblNewLabel);
		
		idTxtField = new JTextField();
		sl_idPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, idTxtField);
		sl_idPane.putConstraint(SpringLayout.WEST, idTxtField, 87, SpringLayout.WEST, idPane);
		sl_idPane.putConstraint(SpringLayout.EAST, idTxtField, -24, SpringLayout.EAST, idPane);
		sl_idPane.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, idTxtField);
		sl_idPane.putConstraint(SpringLayout.NORTH, idTxtField, 15, SpringLayout.NORTH, idPane);
		idPane.add(idTxtField);
		idTxtField.setColumns(10);
		centerPane.add(idPane);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_idPane.putConstraint(SpringLayout.EAST, lblPassword, -155, SpringLayout.EAST, idPane);
		idPane.add(lblPassword);
		
		passTxtField = new JTextField();
		sl_idPane.putConstraint(SpringLayout.SOUTH, lblPassword, 0, SpringLayout.SOUTH, passTxtField);
		sl_idPane.putConstraint(SpringLayout.NORTH, passTxtField, 15, SpringLayout.SOUTH, idTxtField);
		sl_idPane.putConstraint(SpringLayout.WEST, passTxtField, 87, SpringLayout.WEST, idPane);
		sl_idPane.putConstraint(SpringLayout.EAST, passTxtField, -24, SpringLayout.EAST, idPane);
		idPane.add(passTxtField);
		passTxtField.setColumns(10);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_idPane.putConstraint(SpringLayout.NORTH, loginBtn, 15, SpringLayout.SOUTH, lblPassword);
		sl_idPane.putConstraint(SpringLayout.WEST, loginBtn, 73, SpringLayout.WEST, idPane);
		sl_idPane.putConstraint(SpringLayout.EAST, loginBtn, -74, SpringLayout.EAST, idPane);
		idPane.add(loginBtn);
		
		reportLabel = new JLabel("");
		sl_idPane.putConstraint(SpringLayout.WEST, reportLabel, 118, SpringLayout.WEST, idPane);
		sl_idPane.putConstraint(SpringLayout.SOUTH, reportLabel, -10, SpringLayout.SOUTH, idPane);
		idPane.add(reportLabel);
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
