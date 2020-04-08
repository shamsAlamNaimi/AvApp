package neu.edu.csye6200.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import neu.edu.csye6200.av.AVRules;
import neu.edu.csye6200.av.Road;
import neu.edu.csye6200.av.SportsCar;
import neu.edu.csye6200.av.Suv;
import neu.edu.csye6200.av.Truck;

public class ComboButton {
	MAPanel maPanel= null;
	Road road= null;
	JButton sportsCar=null;
	JButton suv = null;
	JButton truck= null;
	JButton switchLane = null;
	JButton noSwitchLane= null;
	JButton increaseSpeed= null;
	JButton decreseSpeed = null;
	AVRules avrules= null;
	
	public ComboButton(MAPanel mp) {
		maPanel= mp;
		road=Road.instance();
		 sportsCar= new JButton("ADD Sports Car");
		 suv = new JButton(" ADD Suv");
		 truck= new JButton("ADD Truck");
		 switchLane= new JButton("Allow Switch Lane");
		 noSwitchLane= new JButton("Off Switch Lane");
		 increaseSpeed= new JButton("Increase Speed");
		 decreseSpeed = new JButton("decrese Speed");
		 
		 avrules = new AVRules();
	}
	
	
	public JPanel getComboButton() {
		JPanel con = new JPanel();
		con.setLayout(new GridLayout(5,1));
		con.add(sportsCar);
		sportsCar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SportsCar spCar =new SportsCar(0,30);
				road.addCarr(spCar);
				for(int i=0; i<road.LANE_WIDTH;i= i+20) {
					for(int j=40 ; j<480; j=j+120) {
						spCar.setX(i);
						spCar.setY(j);
						
						if(!avrules.collision(i, j, spCar)) {
							maPanel.getPanel().revalidate();
							maPanel.getPanel().repaint();
							return;
						}
					}
				}
				
			}
			
		});
		con.add(suv);
		suv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Suv suv =new Suv(0,30);
				road.addCarr(suv);
				for(int i=0; i<road.LANE_WIDTH;i= i+20) {
					for(int j=40 ; j<480; j=j+120) {
						suv.setX(i);
						suv.setY(j);
						
						if(!avrules.collision(i, j, suv)) {
							maPanel.getPanel().revalidate();
							maPanel.getPanel().repaint();
							return;
						}
					}
				}
				
			}
			
		});
		con.add(truck);
		truck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Truck truck =new Truck(0,30);
				road.addCarr(truck);
				for(int i=0; i<road.LANE_WIDTH;i= i+20) {
					for(int j=40 ; j<480; j=j+120) {
						truck.setX(i);
						truck.setY(j);
						
						if(!avrules.collision(i, j, truck)) {
							maPanel.getPanel().revalidate();
							maPanel.getPanel().repaint();
							return;
						}
					}
				}
				
			}
			
		});
		
		
		con.add(laneSwitch());
		con.add(speedChange());
		return con;
		
	}
	
	
	public JPanel laneSwitch() {
		JPanel inner= new JPanel();
		inner.setLayout(new GridLayout(1,2));
		inner.add(switchLane);
		switchLane.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				road.allowLaneSwitch();
			}	
		});
		inner.add(noSwitchLane);
		noSwitchLane.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				road.offLaneSwitch();
			}	
		});
		
		return inner;	
	}
	
	
	
	public JPanel speedChange(){
		JPanel inner = new JPanel();
		inner.setLayout(new GridLayout(1,2));
		inner.add(increaseSpeed);
		increaseSpeed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				road.increaseSpeed();
			}
		});
		inner.add(decreseSpeed);
		decreseSpeed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				road.decreaseSpeed();
			}
		});
		return inner;
			
	}
	
	
	
}
