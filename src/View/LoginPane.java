package View;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;

public class LoginPane extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public LoginPane() {
		setLayout(new BorderLayout(0, 0));
		
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
		
		textField = new JTextField();
		sl_idPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, textField);
		sl_idPane.putConstraint(SpringLayout.WEST, textField, 87, SpringLayout.WEST, idPane);
		sl_idPane.putConstraint(SpringLayout.EAST, textField, -24, SpringLayout.EAST, idPane);
		sl_idPane.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, textField);
		sl_idPane.putConstraint(SpringLayout.NORTH, textField, 15, SpringLayout.NORTH, idPane);
		idPane.add(textField);
		textField.setColumns(10);
		centerPane.add(idPane);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_idPane.putConstraint(SpringLayout.EAST, lblPassword, -155, SpringLayout.EAST, idPane);
		idPane.add(lblPassword);
		
		textField_1 = new JTextField();
		sl_idPane.putConstraint(SpringLayout.SOUTH, lblPassword, 0, SpringLayout.SOUTH, textField_1);
		sl_idPane.putConstraint(SpringLayout.NORTH, textField_1, 15, SpringLayout.SOUTH, textField);
		sl_idPane.putConstraint(SpringLayout.WEST, textField_1, 87, SpringLayout.WEST, idPane);
		sl_idPane.putConstraint(SpringLayout.EAST, textField_1, -24, SpringLayout.EAST, idPane);
		idPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sl_idPane.putConstraint(SpringLayout.NORTH, loginBtn, 15, SpringLayout.SOUTH, lblPassword);
		sl_idPane.putConstraint(SpringLayout.WEST, loginBtn, 73, SpringLayout.WEST, idPane);
		sl_idPane.putConstraint(SpringLayout.EAST, loginBtn, -74, SpringLayout.EAST, idPane);
		idPane.add(loginBtn);
		
		JPanel headerPane = new JPanel();
		add(headerPane, BorderLayout.NORTH);
		headerPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		headerPane.add(lblNewLabel_1);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		headerPane.add(lblDescription);

	}
}
