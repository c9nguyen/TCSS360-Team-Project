package View;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JButton;

public class UserPane extends AbstractPanel {
	private JTextField nameTxtField;
	private JPanel resubmitPane;
	private JPanel btnPane;

	/**
	 * Create the panel.
	 */
	public UserPane(WebFrame theFrame, AbstractPanel caller) {
		super(theFrame, caller);
		super.nextPanel = null;
		
		setLayout(new BorderLayout(0, 0));

		setupHeader();

		JPanel westPane = new JPanel();
		add(westPane, BorderLayout.WEST);
		westPane.setLayout(new BorderLayout(0, 0));

		JPanel editorPane = new JPanel();
		westPane.add(editorPane);
		editorPane.setLayout(new BoxLayout(editorPane, BoxLayout.Y_AXIS));

		JPanel namePane = new JPanel();
		editorPane.add(namePane);


		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		namePane.add(nameLbl);

		nameTxtField = new JTextField();
		nameTxtField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		namePane.add(nameTxtField);
		nameTxtField.setColumns(10);

		JPanel categoryPane = new JPanel();
		FlowLayout fl_categoryPane = (FlowLayout) categoryPane.getLayout();
		fl_categoryPane.setAlignment(FlowLayout.LEFT);
		editorPane.add(categoryPane);

		JLabel categoryLbl = new JLabel("Categories");
		categoryLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		categoryLbl.setHorizontalAlignment(SwingConstants.CENTER);
		categoryPane.add(categoryLbl);

		//		String[] category = {"Chair", "Table"};
		//		JComboBox<String> categoryBox = new JComboBox<String>(category);
		//		panel_4.add(categoryBox);

		JPanel uploadPane = new JPanel();
		editorPane.add(uploadPane);



		JButton btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Tahoma", Font.PLAIN, 20));
		uploadPane.add(btnUpload);




		btnPane = new JPanel();
		editorPane.add(btnPane);
		btnPane.setMaximumSize(namePane.getPreferredSize());

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPane.add(btnNewButton);

		resubmitPane = new JPanel();
		editorPane.add(resubmitPane);

		JButton btnNewButton_1 = new JButton("Resubmit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resubmitPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Withdraw");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resubmitPane.add(btnNewButton_2);
		
	

		namePane.setMaximumSize(namePane.getPreferredSize());
		uploadPane.setMaximumSize(namePane.getPreferredSize());
		resubmitPane.setMaximumSize(resubmitPane.getPreferredSize());
		categoryPane.setMaximumSize(namePane.getPreferredSize());

		resubmitPane.setVisible(false);
		
		JPanel westfiller = new JPanel();
		westPane.add(westfiller, BorderLayout.WEST);
	}

	private void setupHeader() {

		JPanel northPane = new JPanel();
		add(northPane, BorderLayout.NORTH);
		northPane.setLayout(new BorderLayout(0, 0));
		JPanel headerPane = new JPanel();
		northPane.add(headerPane);
		headerPane.setBorder(new TitledBorder(null, "Submission", TitledBorder.LEADING, 
				TitledBorder.TOP, new Font("Arial", Font.PLAIN, 20), null));
		headerPane.setLayout(new BorderLayout(0, 0));
		headerPane.setPreferredSize(new Dimension(100, 100));

		JLabel lblFile = new JLabel("File: ");
		lblFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFile.setHorizontalAlignment(SwingConstants.CENTER);
		headerPane.add(lblFile, BorderLayout.WEST);

		JPanel westfiller = new JPanel();
		northPane.add(westfiller, BorderLayout.WEST);

		JPanel eastfiller = new JPanel();
		northPane.add(eastfiller, BorderLayout.EAST);
	}
	
	public void setResubmit(boolean on) {
		if (on) {
			resubmitPane.setVisible(true);
			btnPane.setVisible(false);
		} else {
			resubmitPane.setVisible(false);
			btnPane.setVisible(true);
		}
	}
}
