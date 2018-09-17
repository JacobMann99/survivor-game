package ca.jamann.game;

public class Speed {
	
	private static Speed instance = null; // creates instance of type Speed
	
	protected Speed() {
		// Exists only to defeat instantiation
	}
	
	public static Speed getInstance() {
		
		if (instance == null) {
			
			instance = new Speed();
			// creates a new instance only if an instance has not already been initialized
			
		}
		
		return instance; // this is the method that must be called for a class to recognize the existence of the singleton class
		
	}
	
	private int speed = 1;
	public String speedLabel = "Normal speed";
	
	public void setSpeed(int n) {
		
		this.speed = n;
		
	}
	
	public int getSpeed() {
		
		return speed;
		
	}
	
}