package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.BackPanelListener;
import Model.Category;
import Model.Submission;

/**
 * Contestant uses this panel to submit their entry.
 * @author tryHARD
 *
 */
public class UserPane extends AbstractPanel {
	/* Input name of the submission */
	private JTextField nameTxtField;
	
	/* The panel of resubmit buttons */
	private JPanel resubmitPane;
	
	/* The panel of submit button */
	private JPanel btnSubmitPane;
	
	/* The submit button */
	private JButton btnSubmit;
	
	/* The label of submission file */
	private JLabel lblFile;

	/* East Panel contains submission information */
	private JPanel eastPane;
	
	/* Name of the submission */
	private JLabel lblSubmissionName;
	
	/* Category of the submission */
	private JLabel lblSubmissionCatergory;
	
	/* List of categories */
	private JComboBox<String> categoryBox;

	/* SUbmission File */
	private File myFile;
	
	/* File name of the submission */
	private JLabel lblUploadFile;

	/**
	 * Create the panel.
	 */
	public UserPane(WebFrame theFrame, AbstractPanel caller) {
		super(theFrame, caller);
		super.nextPanel = null;

		setLayout(new BorderLayout(0, 0));

		setupHeader();
		setupWest();
		setupEast();
		loadSubmission();
	}

	/**
	 * Setting up the header.
	 */
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
	
	private void setupWest() {
		JPanel westPane = new JPanel();
		add(westPane, BorderLayout.WEST);
		westPane.setLayout(new BorderLayout(0, 0));

		JPanel editorPane = new JPanel();
		westPane.add(editorPane);
		editorPane.setLayout(new GridLayout(0, 1, 0, 0));

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

		String[] category = {Category.CHAIR.getName(), Category.LAMP.getName()};
		categoryBox = new JComboBox<String>(category);
		categoryPane.add(categoryBox);

		JPanel uploadPane = new JPanel();
		editorPane.add(uploadPane);

		btnSubmitPane = new JPanel();
		editorPane.add(btnSubmitPane);
		btnSubmitPane.setMaximumSize(namePane.getPreferredSize());
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myFile != null) {
					if (checkSubmit())
						submit();
				}
			}
		});
		btnSubmit.setEnabled(false);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmitPane.add(btnSubmit);

		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				FileFilter filter = new FileNameExtensionFilter("JPG File", "JPG", "PNG File", "PNG");
				fc.setFileFilter(filter);

				int returnVal = fc.showOpenDialog(myFrame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					myFile = fc.getSelectedFile();
					lblUploadFile.setText(myFile.getPath());
					btnSubmit.setEnabled(true);
					myFrame.revalidate();
			
				} else if (returnVal != JFileChooser.CANCEL_OPTION){
					JOptionPane.showMessageDialog(myFrame, "Invalid file");
				}
			}
		});
		btnUpload.setFont(new Font("Tahoma", Font.PLAIN, 20));
		uploadPane.add(btnUpload);

		JPanel fileLblPane = new JPanel();
		editorPane.add(fileLblPane);

		lblUploadFile = new JLabel("");
		fileLblPane.add(lblUploadFile);

		resubmitPane = new JPanel();

		editorPane.add(resubmitPane);

		JButton btnResubmit = new JButton("Resubmit");
		btnResubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnResubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myFile != null) {
					if (checkSubmit()) {

						if (JOptionPane.showConfirmDialog(myFrame, "Are you sure you want to resubmit?",
								"Withdraw",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE) == 
								JOptionPane.YES_OPTION) {
							File oldFile = new File("images/" + myFrame.getDataManager().getID());
							delete(oldFile);
							try {
								myFrame.getDataManager().removeSubmission();
								loadSubmission();
								submit();
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(myFrame, "Unable to find the file");
							}
						
						}
					}
				}
			}
		});
		resubmitPane.add(btnResubmit);

		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
					if (JOptionPane.showConfirmDialog(myFrame, "Are you sure you want to withdraw?",
							"Withdraw",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE) == 
							JOptionPane.YES_OPTION) {
						File oldFile = new File("images/" + myFrame.getDataManager().getID());
						delete(oldFile);						
						try {
							myFrame.getDataManager().removeSubmission();
							loadSubmission();
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(myFrame, "Unable to find the file");
						}
					
					}


			}
		});
		resubmitPane.add(btnWithdraw);



		namePane.setMaximumSize(namePane.getPreferredSize());
		uploadPane.setMaximumSize(namePane.getPreferredSize());
		resubmitPane.setMaximumSize(resubmitPane.getPreferredSize());
		categoryPane.setMaximumSize(namePane.getPreferredSize());

		JPanel westfiller = new JPanel();
		westPane.add(westfiller, BorderLayout.WEST);
	}
	
	/**
	 * Setting up east panel.
	 */
	private void setupEast() {
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

	}

	/**
	 * Load the submission of the account.
	 */
	public void loadSubmission() {
		try {
			boolean submission = myFrame.getDataManager().containsSubmission();
			if (submission) {
				Submission mysubmit = myFrame.getDataManager().getSubmission();
				myFile = new File("images/" + myFrame.getDataManager().getID() + "/" + mysubmit.getImage().getName());
				
				btnSubmitPane.setVisible(false);
				resubmitPane.setVisible(true);				
				eastPane.setVisible(true);

				lblSubmissionName.setText("Name: \n" + mysubmit.getName());
				lblSubmissionCatergory.setText("Category: \n" + mysubmit.getCategory());
				lblFile.setText("File: " + mysubmit.getImage().getName());
				lblFile.setToolTipText("Click to see the submission.");
				lblFile.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						//System.out.println(myFile.getPath());
						BufferedImage image;
						try {
							image = ImageIO.read(myFile);
							View view = new View(image);
							view.setVisible(true);
						} catch (Exception ex) {
							
						}
			
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						lblFile.setForeground(Color.BLUE);
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						lblFile.setForeground(Color.BLACK);
					}
					
				});
			} else {

				btnSubmitPane.setVisible(true);
				resubmitPane.setVisible(false);
				
				lblSubmissionName.setText("");
				lblSubmissionCatergory.setText("");
				lblFile.setText("File: ");
				if (lblFile.getMouseListeners().length > 0) {
					for (MouseListener ml : lblFile.getMouseListeners()) {
						lblFile.removeMouseListener(ml);
					}
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * Set up the resubmit if there is already a submission.
	 * @param on
	 */
	public void setResubmit(boolean on) {
		if (on) {
			resubmitPane.setVisible(true);
			btnSubmitPane.setVisible(false);
		} else {
			resubmitPane.setVisible(false);
			btnSubmitPane.setVisible(true);
		}
	}

	/**
	 * Check if all submission information is valid.
	 * @return
	 */
	public boolean checkSubmit() {
		if (nameTxtField.getText().length() > 0) {			
			return true;
		} else {
			JOptionPane.showMessageDialog(myFrame, "Please enter submission name");
			return false;
		}
	}

	/**
	 * Submit the submission with checking.
	 */
	public void submit() {
		File newFile = new File("images/" + myFrame.getDataManager().getID());
		newFile.mkdir();		//Create directory
		newFile = new File(newFile.getPath() + "/" + myFile.getName());

		try {
			Files.copy(myFile.toPath(), newFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
			Submission newSubmission = new Submission(myFrame.getDataManager().getID(),
					nameTxtField.getText(),
					categoryBox.getSelectedItem().toString(),
					myFile);
			myFrame.getDataManager().addSubmission(newSubmission);
			loadSubmission();

			//Reset input
			nameTxtField.setText("");
			categoryBox.setSelectedIndex(0);
			lblUploadFile.setText("");
			btnSubmit.setEnabled(false);
			//lblFile
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Delete the file.
	 * @param theFile
	 */
	public void delete(File theFile) {
		if (theFile.isDirectory()) {
			String[] allFile = theFile.list();
			for (String file : allFile) {
				delete(new File(theFile, file));
			}
			theFile.delete();
		} else {
			theFile.delete();
		}
	}
}
