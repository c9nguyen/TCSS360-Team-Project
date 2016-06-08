package View;

import javax.swing.JPanel;

public class AbstractPanel extends JPanel{

	protected AbstractPanel nextPanel;
	
	protected AbstractPanel backPanel;
	
	protected WebFrame myFrame;
	
	public AbstractPanel(WebFrame theFrame,  AbstractPanel caller) {
		myFrame = theFrame;
		backPanel = caller;
	}
	
	public AbstractPanel getNextPanel() {
		return nextPanel;
	}



	public AbstractPanel getBackPanel() {
		return backPanel;
	}
}
