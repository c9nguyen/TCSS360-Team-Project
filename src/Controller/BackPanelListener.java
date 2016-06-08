package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.WebFrame;

public class BackPanelListener implements ActionListener{

	private WebFrame myFrame;
	
	public BackPanelListener(WebFrame theFrame) {
		myFrame = theFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		myFrame.goBack();
	}

}
