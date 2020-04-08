package neu.edu.csye6200.av;

import java.awt.Color;
import java.awt.Graphics;

public class Truck extends Vehicle {
	
	
	public Truck(int x, int y) {
		super(x,y);
		 height=60;
		 width=120;
		 speed=8;
	}
	
	public void paintMe(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
}
