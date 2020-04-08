package neu.edu.csye6200.av;
/**
 *this is singleton class which contains all the vehicle that are on the road
 */

import java.io.IOException;
import java.util.ArrayList;

import neu.edu.csye6200.log.Log;

public class Road {
	final public int LANE_HEIGHT=120;
	final public int LANE_WIDTH=1035; 
	public ArrayList<Vehicle> cars=new ArrayList<>();
	public boolean laneSwitch= true;
	Log mylog= null;
	
	private static Road instance = null;

	   private Road(){
		   try {
				mylog = new Log("Log_Files.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
	   };
	   
	   public static Road instance() { 
	    if (instance == null) instance = new Road();
	    return (instance);
	    }
	
	
	public ArrayList<Vehicle> getCars(){
		return cars;
	}
	
	public void addCarr(Vehicle v) {
		mylog.logger.info("Vehicle is added on the road");
		cars.add(v);
	}
	
	
	public void removeCars() {
		cars.removeAll(cars);
	}
	
	public int carCount() {
		return cars.size();
	}
	
	public void offLaneSwitch() {
		mylog.logger.info("lane switch disallowed");
		laneSwitch= false;
	}
	
	public void allowLaneSwitch() {
		mylog.logger.info("lane switch allowed");
		laneSwitch= true;
	}
	
	public boolean getLaneSwitch() {
		return laneSwitch;
	}
	
	public void increaseSpeed() {
		mylog.logger.info("speed increased");
		for(Vehicle v: cars) {
			v.setSpeed(v.getSpeed()+5);
		}
	}
	
	public void decreaseSpeed() {
		mylog.logger.info("speed decreased");
		for(Vehicle v: cars) {
			if((v.getSpeed()-5)>0)
			{v.setSpeed(v.getSpeed()-5);}
		}
	}
	
}
