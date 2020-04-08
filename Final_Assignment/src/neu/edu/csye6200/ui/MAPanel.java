package neu.edu.csye6200.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import neu.edu.csye6200.av.Simulation;
import neu.edu.csye6200.myapp.AVApp;



public class MAPanel extends AVApp implements Observer {
	RoadPanel roadPanel = null;
	Simulation sim= null;
	Container south = null;
	Container west= null;
	ControlPanel cPanel=null;
	ComboButton cButton= null;
	AVApp avapp=null;
	

	
	public MAPanel(Simulation s) {
		sim =s;
		roadPanel = new RoadPanel();
		cPanel= new ControlPanel(sim);
		cButton =new ComboButton(this);
		super.initGUI();
		super.showUI();
		
	
		
	}
	
	public RoadPanel getPanel() {
		return roadPanel;
	}

	@Override
	public void update(Observable o, Object arg) {
		roadPanel.repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JPanel getMainPanel() {
		 JPanel panel= new JPanel();
		 panel.setSize(1000, 550);
		 panel.setLayout(new BorderLayout());
		 panel.add(BorderLayout.CENTER,roadPanel);
		 panel.add(BorderLayout.SOUTH,cPanel.getControlPAnel());
		 panel.add(BorderLayout.WEST,cButton.getComboButton());
		 
		return panel;
	}
	

}
