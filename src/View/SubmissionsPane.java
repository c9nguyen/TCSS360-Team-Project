package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class SubmissionsPane extends AbstractPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2802682035896331012L;
	/**
	 * Create the panel.
	 */
	public SubmissionsPane(WebFrame theFrame, AbstractPanel caller) {
		super(theFrame, caller);
		super.nextPanel = null;
		
		setLayout(new BorderLayout(0,0));
		eastPane();
//		westPanel();
		setupHeader();
		
		JPanel westPane = new JPanel();
		
		add(westPane, BorderLayout.WEST);
		westPane.setLayout(new BorderLayout(0, 0));
		
		JPanel entryPane = new JPanel();
		westPane.add(entryPane);
		entryPane.setLayout(new BoxLayout(entryPane, BoxLayout.X_AXIS));
		
		JPanel namePane = new JPanel();
		entryPane.add(namePane);
		
		JLabel nameLbl = new JLabel("Entry Name:");
		nameLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		namePane.add(nameLbl);
		
	
//		
//		DefaultTableModel model = new DefaultTableModel(new String[] {
//             "A lonely chair" ,  "The Desk" }, new Integer[] {  });
		
		DefaultTableModel m = new DefaultTableModel(10, 1);
		
		JTable table = new JTable(m);
		JScrollPane tableContainer = new JScrollPane(table);
		entryPane.add(tableContainer,BorderLayout.CENTER);

	}
	public void eastPane(){
		JPanel ePanel = new JPanel();
		add(ePanel,BorderLayout.EAST);
		ePanel.setLayout(new BorderLayout(0,0));
		
		JPanel agePanel = new JPanel();
		ePanel.add(agePanel, BorderLayout.WEST);
		
		JPanel ageStrPane = new JPanel();
		agePanel.add(ageStrPane);
		
		JLabel age = new JLabel("Age");
		age.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ageStrPane.add(age);
		
		
		JPanel categoryPane = new JPanel();
		ePanel.add(categoryPane, BorderLayout.EAST);
		
		JPanel catStrPane = new JPanel();
		categoryPane.add(catStrPane);
		
		JLabel cat = new JLabel("Category");
		cat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		catStrPane.add(cat);
	
	}
	public void westPanel(){
		JPanel wPanel = new JPanel();
		wPanel.setBackground(Color.YELLOW);
		add(wPanel, BorderLayout.WEST);
		
	}
	private void setupHeader() {

		JPanel northPane = new JPanel();
		add(northPane, BorderLayout.NORTH);
		northPane.setLayout(new BorderLayout(0, 0));
		JPanel headerPane = new JPanel();
		northPane.add(headerPane);
		headerPane.setBorder(new TitledBorder(null, "Contest Submissions", TitledBorder.LEADING, 
				TitledBorder.TOP, new Font("Arial", Font.PLAIN, 30), null));
		headerPane.setLayout(new BorderLayout(0, 0));
		headerPane.setPreferredSize(new Dimension(100, 100));

}
}