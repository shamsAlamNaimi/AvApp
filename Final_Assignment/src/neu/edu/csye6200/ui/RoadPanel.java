package neu.edu.csye6200.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import neu.edu.csye6200.av.Road;
import neu.edu.csye6200.av.Vehicle;

public class RoadPanel extends JPanel {
	Road road = null;

	RoadPanel() {
		super();
		road= Road.instance();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);;

		g.setColor(Color.black);
		g.fillRect(0, 10, getWidth(), 4* road.LANE_HEIGHT);
		g.setColor(Color.WHITE);
		for (int i = road.LANE_HEIGHT; i < 5 * (road.LANE_HEIGHT); i = i + road.LANE_HEIGHT) {
			if(i<4*road.LANE_HEIGHT) {
			for (int j = 0; j < getWidth(); j = j + 40) {
				g.fillRect(j, i, 30, 5);
			}}
			else {
				g.setColor(Color.green);
				for (int j = 0; j < getWidth(); j = j + 1) {
					g.fillRect(j, i, 30, road.LANE_HEIGHT+20);
				}
			}
		}
		for (Vehicle v : road.getCars()) {	
			v.paintMe(g);
		}
	}
}
