package View;

import java.awt.BorderLayout;
import Model.Category;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Model.Category.*;
import Model.Submission;

import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class SubmissionsPane extends AbstractPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2802682035896331012L;
	private JTable table;
	private JTextField textAgeFrom;
	private JTextField textAgeTo;
	private JComboBox<String> categoryBox;
	private ArrayList<Submission> currentList;
	private ArrayList<Submission> tableList;
	private ButtonGroup group;
	private String filterAgeFrom;
	private String filterAgeTo;
	private String filterCat;
	
	/**
	 * Create the panel.
	 */
	public SubmissionsPane(WebFrame theFrame, AbstractPanel caller) {
		super(theFrame, caller);
		super.nextPanel = null;
		
		filterAgeFrom = null;
		filterAgeTo = null;
		filterCat = null;
		
		setUp();
		loadDefaultTableData();
		loadListToTable();
	}

	private void setUp() {
	setLayout(new BorderLayout(0,0));
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Age", "Category"
			}
		));
		centerPanel.add(new JScrollPane(table));
		
		JPanel northPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) northPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(northPanel, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Submissions List");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		northPanel.add(lblTitle);
		
		JPanel eastPanel = new JPanel();
		add(eastPanel, BorderLayout.EAST);
		eastPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblSortBy = new JLabel("Sort by:");
		lblSortBy.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSortBy.setHorizontalAlignment(SwingConstants.CENTER);
		eastPanel.add(lblSortBy);
		
		JPanel panel_1 = new JPanel();
		eastPanel.add(panel_1);
		
		JPanel panel_11 = new JPanel();
		eastPanel.add(panel_11);
		
		JRadioButton rdbtnDefault = new JRadioButton("Default");
		rdbtnDefault.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnDefault.setSelected(true);
		rdbtnDefault.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					currentList = myFrame.getDataManager().getSubmissions();
					loadListToTable();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		eastPanel.add(rdbtnDefault);
		
		JPanel panel = new JPanel();
		eastPanel.add(panel);
		
		JRadioButton ageRadioBtn = new JRadioButton("Age");
		ageRadioBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ageRadioBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					currentList = myFrame.getDataManager().getAgeLists();
					loadListToTable();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		eastPanel.add(ageRadioBtn);
		
		group = new ButtonGroup();
		group.add(rdbtnDefault);
		group.add(ageRadioBtn);

		
		JLabel lblFilter = new JLabel("Filter:");
		lblFilter.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFilter.setHorizontalAlignment(SwingConstants.CENTER);
		eastPanel.add(lblFilter);
		
		JPanel panel_3 = new JPanel();
		eastPanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		eastPanel.add(panel_4);
		
		JLabel lblFrom = new JLabel("Age From:");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(lblFrom);
		
		textAgeFrom = new JTextField();
		textAgeFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textAgeFrom);
		textAgeFrom.setColumns(5);
		
		JPanel panel_5 = new JPanel();
		eastPanel.add(panel_5);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblTo);
		
		textAgeTo = new JTextField();
		textAgeTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(textAgeTo);
		textAgeTo.setColumns(5);
		
		JPanel panel_6 = new JPanel();
		eastPanel.add(panel_6);
		
		JLabel lblCat = new JLabel("Category");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(lblCat);
		
		JPanel panel_7 = new JPanel();
		eastPanel.add(panel_7);
		
		String[] category = {"", Category.CHAIR.getName(), Category.LAMP.getName()};
		categoryBox = new JComboBox<String>(category);
		panel_7.add(categoryBox);
		
		
		JPanel panel_8 = new JPanel();
		eastPanel.add(panel_8);
		
		JButton btnApply = new JButton("Apply Filter");
		btnApply.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnApply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String from = textAgeFrom.getText();
					String to = textAgeTo.getText();
					String cat = categoryBox.getSelectedItem().toString();
					
					//Check if a valid int value
					if (from.length() > 0) {
						Integer.parseInt(from);
					} else {
						from = null;
					}
					
					if (to.length() > 0) {
						Integer.parseInt(to);
					} else {
						to = null;
					}
					
					filterAgeFrom = from;
					filterAgeTo = to;
					filterCat = cat.length() > 0 ? cat : null;
					
					loadListToTable();
				} catch (Exception ex) {
					//ex.printStackTrace();
					JOptionPane.showMessageDialog(myFrame, "Invalid filter input");
				}
			}
			
		});
		panel_8.add(btnApply);
		
		JPanel panel_9 = new JPanel();
		eastPanel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		eastPanel.add(panel_10);
		
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (categoryBox.getSelectedIndex() > -1) {
				
				int index = categoryBox.getSelectedIndex();		
				Submission mysubmit = 	tableList.get(index);

				File myFile = new File("images/" + mysubmit.getID() + "/" + mysubmit.getImage().getName());
				try {
					BufferedImage image = ImageIO.read(myFile);
					View view = new View(image);
					view.setVisible(true);
				} catch (Exception ex) {
					
				}
				} else {
					JOptionPane.showMessageDialog(myFrame, "Please select a submission to view");
				}
	
				
			}
			
		});
		panel_10.add(btnView);


	}

	private void loadDefaultTableData() {
		try {
			currentList = myFrame.getDataManager().getSubmissions();
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	private void filterTable() {
		
	}
	
	private void loadListToTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		tableList = new ArrayList<Submission>();
		
		for (Submission one : currentList) {
			if (filterAgeFrom == null || Integer.parseInt(filterAgeFrom) <= one.getAge()) {
				if (filterAgeTo == null || Integer.parseInt(filterAgeTo) >= one.getAge()) {
					if (filterCat == null || filterCat.equals(one.getCategory())) {
						model.addRow(new Object[] {one.getName(), one.getAge(), one.getCategory()});
						tableList.add(one);
					}
				}
			}
		}
		
	}
	
	
}