package neu.edu.csye6200.av;

import java.io.IOException;
import java.util.Observable;

import neu.edu.csye6200.log.Log;

public class Simulation extends Observable implements Runnable {
	AVRules av = null;
	boolean running= false;
	Thread t= null;
	Log mylog= null;
	
	public Simulation(){
		try {
			mylog = new Log("Log_Files.txt");
			mylog.logger.info("simulation is created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this function allows to start the simulation;
	 */
	public void startSimulation() {
		if(running==false) {
			av =new AVRules();
			running=true;
			t= new Thread(this);
			mylog.logger.info("simulation is starting");
			t.start();
			
		}
	}
	
	
	/**
	 * this function allows to clear the cars on the road 
	 */
	public void ClearSimulation() {
		if(av==null)	return;
		running=false;
		av.CleanSlate();
		av=null;
		mylog.logger.info("simulation is stoped");
		setChanged();
		notifyObservers(this);
	}
	
	
	/**
	 * this function allow to take pause the simulation
	 */
	
	public void stopSimulation() {
		mylog.logger.info("the simulation is paused");
		running=false;
	}
	
	
	@Override
	public void run() {
		while(running) {
			motionrunning();
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				//
			}
		}

	}
	
	public void motionrunning() {
		
		av.startMoving();
		setChanged();
		notifyObservers(this);
	}
	

	

}
