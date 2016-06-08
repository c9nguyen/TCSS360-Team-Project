package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.WebFrame;

public class NextPanelListener implements ActionListener{

	private WebFrame myFrame;
	
	public NextPanelListener(WebFrame theFrame) {
		myFrame = theFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		myFrame.goNext();
	}

}
