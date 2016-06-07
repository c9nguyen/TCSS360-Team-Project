package View;

import javax.swing.JPanel;

public class AbstractPanel extends JPanel{

	protected AbstractPanel nextPanel;
	
	protected AbstractPanel backPanel;
	
	public AbstractPanel(AbstractPanel caller) {
		backPanel = caller;
	}
}
