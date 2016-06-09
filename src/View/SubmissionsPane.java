package View;

import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class SubmissionsPane extends AbstractPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2802682035896331012L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 */
	public SubmissionsPane(WebFrame theFrame, AbstractPanel caller) {
		super(theFrame, caller);
		super.nextPanel = null;
		
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
		lblSortBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSortBy.setHorizontalAlignment(SwingConstants.CENTER);
		eastPanel.add(lblSortBy);
		
		JPanel panel_1 = new JPanel();
		eastPanel.add(panel_1);
		
		JPanel panel = new JPanel();
		eastPanel.add(panel);
		
		JRadioButton ageRadioBtn = new JRadioButton("Age");
		ageRadioBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		eastPanel.add(ageRadioBtn);
		
		JPanel panel_2 = new JPanel();
		eastPanel.add(panel_2);
		
		JRadioButton catRadioBtn = new JRadioButton("Categories");
		catRadioBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		eastPanel.add(catRadioBtn);
		ButtonGroup group = new ButtonGroup();
		group.add(ageRadioBtn);
		group.add(catRadioBtn);
		
		JLabel lblFilter = new JLabel("Filter:");
		lblFilter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFilter.setHorizontalAlignment(SwingConstants.CENTER);
		eastPanel.add(lblFilter);
		
		JPanel panel_3 = new JPanel();
		eastPanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		eastPanel.add(panel_4);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(lblFrom);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField);
		textField.setColumns(5);
		
		JPanel panel_5 = new JPanel();
		eastPanel.add(panel_5);
		
		JLabel lblTo = new JLabel("To:");
		panel_5.add(lblTo);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(textField_1);
		textField_1.setColumns(5);
		
		JPanel panel_6 = new JPanel();
		eastPanel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		eastPanel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		eastPanel.add(panel_8);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_8.add(btnApply);
		
		JPanel panel_9 = new JPanel();
		eastPanel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		eastPanel.add(panel_10);
		
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnView.setEnabled(false);
		panel_10.add(btnView);
		eastPane();
//		westPanel();
		setupHeader();
		
	
//		
//		DefaultTableModel model = new DefaultTableModel(new String[] {
//             "A lonely chair" ,  "The Desk" }, new Integer[] {  });
		
		DefaultTableModel m = new DefaultTableModel(10, 1);

	}
	public void eastPane(){
	
	}
	public void westPanel(){
		JPanel wPanel = new JPanel();
		wPanel.setBackground(Color.YELLOW);
		add(wPanel, BorderLayout.WEST);
		
	}
	private void setupHeader() {

}
}