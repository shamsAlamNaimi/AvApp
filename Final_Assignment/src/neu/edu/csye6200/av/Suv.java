package neu.edu.csye6200.av;

import java.awt.Color;
import java.awt.Graphics;

public class Suv extends Vehicle {
	
	
	public Suv(int x, int y) {
		super(x,y);
		 height=60;
		 width=100;
		 speed=12;
	}
	
	public void paintMe(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
