package neu.edu.csye6200.ui;

import neu.edu.csye6200.av.Simulation;

public class NameApp {
	MAPanel mapanel=null; 
	Simulation sim=null;
	
	
	public NameApp() {
		sim=new Simulation();	
		mapanel=new MAPanel(sim);
		sim.addObserver(mapanel);
	}
	
	public static void main(String[] args) {
		new NameApp();
	}
}
