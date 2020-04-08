package neu.edu.csye6200.av;
/***
 * this is like a skeleton class using which is extended to create different vehicle class 
 */
import java.awt.Graphics;

public class Vehicle {
	public int x;
	public int y;
	public int height;
	public int width;
	public int speed;
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Vehicle(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void paintMe(Graphics g) {
		// this function is to create the design of the vehicle 
		// and there definition is given is provided in the child objects 
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getSpeed() {
		return speed;
	}

}
