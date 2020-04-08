package neu.edu.csye6200.av;
/**
 * this is the class which guides the movement of the vehicle on lane 
 * @author SHAMS ALAM
 *
 */
public class AVRules {
	Road road=null;
	
	public AVRules() {
		road=Road.instance();
	}
	
	/**
	 * this method starts the movement of the vehicle on the road
	 */
	public void startMoving() {
		
		for (Vehicle v : road.getCars()) {
			if (!collision(v.getX() + v.getSpeed(), v.getY(), v)) {
				v.setX(v.getX() + v.getSpeed());
				if (v.getX() > road.LANE_WIDTH) { // check the condition where the road end then start from zero
					if (!collision(0, v.getY(), v)) {
						v.setX(0);
					}
				}
			}
			else {
				if(road.getLaneSwitch()){
					laneChange(v);
					}
			}
		}
	} 
	
	public void CleanSlate() {
		road.removeCars();
	}
	
	
	
	private void laneChange(Vehicle v) {
		if((v.getY()>40)&&!collision(v.getX(),v.getY()-road.LANE_HEIGHT,v)) {
			v.setY(v.getY()-road.LANE_HEIGHT);
		}
		else if((v.getY()<40+3*road.LANE_HEIGHT)&&!collision(v.getX(),v.getY()+road.LANE_HEIGHT,v)) {
			v.setY(v.getY()+road.LANE_HEIGHT);
		}
	}

	/**
	 * this function check if there is a collision between the given vehicle and different vehicle on the road
	 *  
	 * @param x the x position where the car is moving to 
	 * @param y the y position where the car is moving to
	 * @param v the vehicle which we want to check for collision 
	 * @return true if there is a collision
	 */
	public boolean collision(int x, int y, Vehicle v) {
		for (Vehicle u : road.getCars()) {
			if (y == u.getY()) { // checks for the same lane
				if (!u.equals(v)) {
					if (x < u.getX() + u.getWidth() && x + v.getWidth() > u.getX()) {
						return true;
					}
				}
			}
		}

		return false;
	}

}
