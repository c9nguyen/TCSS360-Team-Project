package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import Controller.BackPanelListener;
import Model.DataManager;

/**
 * Loging Panel where user can log in by using ID and Password
 * @author tryHARD
 *
 */
public class LoginPane extends AbstractPanel {

	private static final long serialVersionUID = 1L;
	
	/* Reset the report */
	public final int NONE = 0;
	/* Reporting the id input is invalid */
	public final int INVALID_ID = 1;
	/* Reporting the id or password is wrong */
	public final int WRONG = 2;
	/* Reporting the id is wrong */
	public final int EMPTY_ID = 3;
	/* Reporting the password is wrong */
	public final int EMPTY_PASS = 4;
	
	/* text field for id */
	private JTextField idTxtField;
	/* text field for password */
	private JTextField passTxtField;
	/* label for reporting */

	private JLabel reportLbl;

	/**
	 * Create the panel.
	 */
	public LoginPane(WebFrame theFrame, AbstractPanel caller) {
		super(theFrame, caller);
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
		idPane.setBackground(Color.ORANGE);
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
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				
				if (!checkEmpty()) {
					return;
				}
				
				try {
					id = Integer.parseInt(idTxtField.getText());
				} catch (Exception ex) {
					reportError(INVALID_ID);
					return;
				}
				
				String password = passTxtField.getText();			
				DataManager checkingData = 	myFrame.getDataManager();			
				checkingData.setID(id);
				
				// Check if user or admin
				if (checkingData.isUser(password)) {				
					reportError(NONE);
					gotoUser();				
				} else if (checkingData.isAdmin(password)) {
					reportError(NONE);
					gotoAdmin();
				} else {
					checkingData.setID(0);
					reportError(WRONG);
				}
				
			}
		});
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
	
		centerPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		reportLbl = new JLabel("");
		reportLbl.setHorizontalAlignment(SwingConstants.CENTER);
		reportLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_idPane = new GroupLayout(idPane);
		gl_idPane.setHorizontalGroup(
			gl_idPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_idPane.createSequentialGroup()
					.addGap(156)
					.addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(155, Short.MAX_VALUE))
				.addGroup(gl_idPane.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_idPane.createParallelGroup(Alignment.LEADING)
						.addComponent(reportLbl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
						.addGroup(gl_idPane.createSequentialGroup()
							.addGroup(gl_idPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword)
								.addComponent(lblNewLabel))
							.addGap(30)
							.addGroup(gl_idPane.createParallelGroup(Alignment.LEADING)
								.addComponent(idTxtField, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
								.addComponent(passTxtField, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))))
					.addGap(15))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reportLbl, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		idPane.setLayout(gl_idPane);
		centerPane.add(idPane);

		
		JPanel southPane = new JPanel();
		FlowLayout flowLayout = (FlowLayout) southPane.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(southPane, BorderLayout.SOUTH);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new BackPanelListener(myFrame));
		southPane.add(btnBack);
//		panel.setPreferredSize(idPane.getPreferredSize());
//		panel.setMinimumSize(idPane.getMinimumSize());
//		panel.setMinimumSize(idPane.getMaximumSize());
		
		JPanel westfilter = new JPanel();
		add(westfilter, BorderLayout.WEST);
//		panel_1.setPreferredSize(idPane.getPreferredSize());
//		panel_1.setMinimumSize(idPane.getMinimumSize());
//		panel_1.setMinimumSize(idPane.getMaximumSize());
		
		JPanel eastfilter = new JPanel();
		add(eastfilter, BorderLayout.EAST);
//		panel_2.setPreferredSize(idPane.getPreferredSize());
//		panel_2.setMinimumSize(idPane.getMinimumSize());
//		panel_2.setMinimumSize(idPane.getMaximumSize());
		
	}
	
	private boolean checkEmpty() {
		boolean valid = true;
		if (idTxtField.getText().length() == 0) {
			reportError(EMPTY_ID);
			valid = false;
		} else if (passTxtField.getText().length() == 0) {
			reportError(EMPTY_PASS);
			valid = false;
		}
		
	return valid;
	}
	
	private void gotoUser() {
		nextPanel = new UserPane(myFrame, this);
		myFrame.goNext();
	}
	
	private void gotoAdmin() {
		nextPanel = new SubmissionsPane(myFrame, this);
		myFrame.goNext();
	}
	
	/**
	 * Setting label text to report the issue.
	 * @param error is the code of error.
	 */
	public void reportError(int error) {
		switch(error) {
		case NONE:
			reportLbl.setText("");
			break;
		case INVALID_ID:
			reportLbl.setText("Please enter valid library ID");
			break;
		case WRONG:
			reportLbl.setText("ID or password is invalid");
			break;
		case EMPTY_ID:
			reportLbl.setText("Please enter ID");
			break;
		case EMPTY_PASS:
			reportLbl.setText("Please enter password");
			break;
		default:
			reportLbl.setText("");
			break;
		}
	
		myFrame.revalidate();
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
