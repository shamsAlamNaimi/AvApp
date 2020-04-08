package neu.edu.csye6200.av;

import java.awt.Color;
import java.awt.Graphics;

public class SportsCar extends Vehicle {
	
	
	public SportsCar(int x, int y) {
		super(x,y);
		 height=40;
		 width=120;
		 speed=20;
	}
	
	public void paintMe(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}
}
