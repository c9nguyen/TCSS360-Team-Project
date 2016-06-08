package View;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;

import Controller.BackPanelListener;
import Model.Submission;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.Font;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPane extends AbstractPanel {
	private JTextField nameTxtField;
	private JPanel resubmitPane;
	private JPanel btnSubmitPane;
	private JLabel lblFile;
	private JButton btnWithdraw;
	private JButton btnResubmit;
	private JButton btnSubmit;
	private JPanel eastPane;
	private JLabel lblSubmissionName;
	private JLabel lblSubmissionCatergory;

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




		btnSubmitPane = new JPanel();
		editorPane.add(btnSubmitPane);
		btnSubmitPane.setMaximumSize(namePane.getPreferredSize());

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSubmit.setEnabled(false);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmitPane.add(btnSubmit);

		resubmitPane = new JPanel();
		editorPane.add(resubmitPane);

		btnResubmit = new JButton("Resubmit");
		btnResubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resubmitPane.add(btnResubmit);

		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resubmitPane.add(btnWithdraw);
		
	

		namePane.setMaximumSize(namePane.getPreferredSize());
		uploadPane.setMaximumSize(namePane.getPreferredSize());
		resubmitPane.setMaximumSize(resubmitPane.getPreferredSize());
		categoryPane.setMaximumSize(namePane.getPreferredSize());
		
		JPanel westfiller = new JPanel();
		westPane.add(westfiller, BorderLayout.WEST);
		
		eastPane = new JPanel();
		eastPane.setVisible(false);
		add(eastPane, BorderLayout.EAST);
		eastPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		eastPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		lblSubmissionName = new JLabel("Name:");
		panel.add(lblSubmissionName);
		lblSubmissionName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblSubmissionCatergory = new JLabel("Category:");
		panel.add(lblSubmissionCatergory);
		lblSubmissionCatergory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel westfilter = new JPanel();
		eastPane.add(westfilter, BorderLayout.WEST);
		westfilter.setPreferredSize(new Dimension(200, 200));
		
		JPanel eastfilter = new JPanel();
		eastfilter.setPreferredSize(new Dimension(100, 100));
		eastPane.add(eastfilter, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new BackPanelListener(myFrame));
		panel_1.add(btnBack);
		
		loadSubmission();
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
		headerPane.setPreferredSize(new Dimension(100, 200));

		lblFile = new JLabel("File: ");
		lblFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFile.setHorizontalAlignment(SwingConstants.CENTER);
		headerPane.add(lblFile, BorderLayout.WEST);

		JPanel westfiller = new JPanel();
		northPane.add(westfiller, BorderLayout.WEST);

		JPanel eastfiller = new JPanel();
		northPane.add(eastfiller, BorderLayout.EAST);
	}
	
	public void loadSubmission() {
		try {
			boolean submission = myFrame.getDataManager().containsSubmission();
			if (submission) {
				Submission mysubmit = myFrame.getDataManager().getSubmission();
				
				btnSubmitPane.setVisible(false);
				resubmitPane.setVisible(true);				
				eastPane.setVisible(true);
				
				lblSubmissionName.setText("Name: \n" + mysubmit.getName());
				lblSubmissionCatergory.setText("Category: \n" + mysubmit.getCategory());
				lblFile.setText("File: " + mysubmit.getImage().getName());
			} else {
				
				btnSubmitPane.setVisible(true);
				resubmitPane.setVisible(false);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void setResubmit(boolean on) {
		if (on) {
			resubmitPane.setVisible(true);
			btnSubmitPane.setVisible(false);
		} else {
			resubmitPane.setVisible(false);
			btnSubmitPane.setVisible(true);
		}
	}
}
