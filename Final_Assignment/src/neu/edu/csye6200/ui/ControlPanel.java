package neu.edu.csye6200.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JLabel;
import javax.swing.JPanel;

import neu.edu.csye6200.av.Road;
import neu.edu.csye6200.av.Simulation;

public class ControlPanel {
	Road road= Road.instance();
	Simulation sim = null;
	JButton start= null;
	JButton stop= null;
	JButton clear= null;
	
	
	public ControlPanel(Simulation s) {
		sim= s;
		start= new JButton("Start");
		stop= new JButton("pause");
		clear= new JButton("Clear");
	}
	
	public JPanel getControlPAnel() {
		JPanel con= new JPanel();
		con.setLayout(new GridLayout(1,3));
		con.add(start);
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sim.startSimulation();
			}	
		});
		
		con.add(stop);
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sim.stopSimulation();
			}	
		});	
		
		con.add(clear);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sim.ClearSimulation();
			}	
		});
		
		
		return con;
	}
}
