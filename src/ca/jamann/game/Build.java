package ca.jamann.game;

public class Build {

	private static Build instance = null; // creates instance of type Build
	
	protected Build() {
		// Exists only to defeat instantiation
	}
	
	public static Build getInstance() {
		
		if (instance == null) {
			
			instance = new Build();
			// creates a new instance only if an instance has not already been initialized
			
		}
		
		return instance; // this is the method that must be called for a class to recognize the existence of the singleton class
		
	}
	
	int hutCompletion = 0;
	int hutPercentage = 0;
	int barnCompletion = 0;
	int barnPercentage = 0;
	int storageCompletion = 0;
	int storagePercentage = 0;
	
	public int buildHut(boolean buildStatus, int builders, int hutCount) {
		
		if (buildStatus) { // the player must have enough wood initially to begin the construction to call this method from Action
			
			hutCompletion += builders;
			hutPercentage = (int) (hutCompletion / (5*hutCount));
		}
		
		return hutPercentage; // Action method should check if the hutPercentage is 100, if it is the hut is complete and the hut should be reset
		
	}
	
	public void resetHut() {
		
		hutCompletion = 0;
		hutPercentage = 0;
		
	}
	
	public int buildBarn(boolean buildStatus, int builders, int barnCount) {
		
		if (buildStatus) { // the player must have enough wood initially to begin the construction to call this method from Action
			
			barnCompletion += builders;
			barnPercentage = (int) (barnCompletion / (5*(1+barnCount)));
		}
		
		return barnPercentage; // Action method should check if the barnPercentage is 100, if it is the food barn is complete and the barn should be reset
		
	}
	
	public void resetBarn() {
		
		barnCompletion = 0;
		barnPercentage = 0;
		
	}
	
	public int buildStorage(boolean buildStatus, int builders, int storageCount) {
		
		if (buildStatus) { // the player must have enough wood initially to begin the construction to call this method from Action
			
			storageCompletion += builders;
			storagePercentage = (int) (storageCompletion / (5*(1+storageCount)));
		}
		
		return storagePercentage; // Action method should check if the storagePercentage is 100, if it is the resource storage is complete and the storage should be reset
		
	}
	
	public void resetStorage() {
		
		storageCompletion = 0;
		storagePercentage = 0;
		
	}
	
}
