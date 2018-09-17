package ca.jamann.game;

public class Action {

	private static Action instance = null; // creates instance of type Action
	
	protected Action() {
		// Exists only to defeat instantiation
	}
	
	public static Action getInstance() {
		
		if (instance == null) {
			
			instance = new Action();
			// creates a new instance only if an instance has not already been initialized
			
		}
		
		return instance; // this is the method that must be called for a class to recognize the existence of the singleton class
		
	}
	
	Build build = Build.getInstance();
	
	boolean hutBuildStatus = false;
	int hutCompletion;
	int hutCount = 1;
	String hutString = hutCount + " huts";
	boolean barnBuildStatus = false;
	int barnCompletion;
	int barnCount = 0;
	String barnString = barnCount + " food barns";
	boolean storageBuildStatus = false;
	int storageCompletion;
	int storageCount = 0;
	String storageString = storageCount + " resource storages";
	int buildMeterLength = 0;
	
	int popCount = 5;
	int popCap = 5;
	
	int dayCount = 1;
	int hourCount = 8;
	int foodCount = 50;
	int foodCap = 100;
	int foodMeterLength = (int) (foodCount * 256) / foodCap;
	int waterLevel = 1000;
	int waterMeterLength = (int) (foodCount * 256) / 1000;
	int woodCount = 50;
	int woodCap = 100;
	int woodMeterLength = (int) (woodCount * 256) / woodCap;
	int fireLevel = 600;
	int assignedPopForage = 0;
	int assignedPopChop = 0;
	int assignedPopWater = 0;
	int assignedPopBuilder = 0;
	int assignedPopExplorer = 0;
	int unassignedPop = popCount - (assignedPopForage + assignedPopChop);
	
	String StatusUpdate;
	
	String dayText = "Day: " + dayCount;
	String timeText = "0" + hourCount + ":00";
	String foodString = foodCount + " food of " + foodCap;
	String waterString;
	String woodString = woodCount + " wood of " + woodCap;
	String popString = popCount + " population of " + popCap;
	String buildString;
	String assignedPopForageString = "Foragers: " + assignedPopForage;
	String assignedPopChopString = "Choppers: " + assignedPopChop;
	String assignedPopWaterString = "Waterers: " + assignedPopWater;
	String assignedPopBuildString = "Builders: " + assignedPopBuilder;
	String assignedPopExploreString = "Explorers: " + assignedPopExplorer;
	String unassignedPopString = "Unassigned: " + unassignedPop;
	
	public void endDay() {
		
		dayCount++;
		
		dayText = "Day: " + dayCount;
		
	}
	
	public void beginDayText() {
		
		StatusUpdate = "The sun rises on a new day";
		
	}
	
	public void endDayText() {
		
		StatusUpdate = "The survivors return to the huts as the moon rises";
		
	}
	
	public void eatFood() {
		
		if (popCount <= foodCount) {
			foodCount -= popCount;
		} else if (popCount > foodCount) {
			foodCount = 0;
		}
		
		StatusUpdate = timeText + "  The survivors have eaten " + popCount + " food";
		
	}
	
	public void updateTime() {
		
		hourCount++;
		
		if (hourCount == 24) {
			hourCount = 0;
		}
		
		if (hourCount < 10) {
			timeText = "0" + hourCount + ":00";
		} else {
			timeText = hourCount + ":00";
		}
		
	}
	
	public int getTime() {
		
		return hourCount;
		
	}
	
	public String getDayString() {
		
		return dayText;
		
	}
	
	public String getTimeString() {
		
		return timeText;
		
	}
	
	public int forage() {
		
		int update = 0;
		
		if (hourCount >= 7 && hourCount <= 22) {
			if (assignedPopForage > 0) {
				update = 1;
				if (assignedPopForage * 2 > foodCap - foodCount) {
					StatusUpdate = timeText + "  Foragers have brought back " + (foodCap - foodCount) + " food";
					foodCount = foodCap;
				} else {
					StatusUpdate = timeText + "  Foragers have brought back " + (assignedPopForage * 2) + " food";
					foodCount += assignedPopForage * 2;
				}
			}
		}
		
		return update;
		
	}
	
	public int getFood() {
		
		return foodCount;
		
	}
	
	public int getFoodMeterLength() {
		
		foodMeterLength = (int) (foodCount * 256) / foodCap;
		
		return foodMeterLength;
		
	}
	
	public String getFoodString() {
		
		foodString = foodCount + " food of " + foodCap;
		
		return foodString;
		
	}
	
	public void updateWater() {
		
		int rand = (int) (Math.random() * (popCount * 2 / 5));
		if (waterLevel != 1000 && assignedPopWater > 0 && hourCount >= 7 && hourCount <= 21) {
			waterLevel += assignedPopWater;
		} else if (assignedPopWater == 0 || (hourCount < 7 || hourCount > 21)) {
			waterLevel -= rand;
		}
		
	}
	
	public int getWater() {
		
		return waterLevel;
		
	}
	
	public int getWaterMeterLength() {
		
		waterMeterLength = (int) (waterLevel * 256) / 1000;
		
		return waterMeterLength;
		
	}
	
	public String getWaterString() {
		
		int waterPercent = (int) (waterLevel / 10);
		waterString = waterPercent + "%";
		
		return waterString;
		
	}
	
	public int chop() {
		
		int update = 0;
		
		if (hourCount >= 7 && hourCount <= 22) {
			if (assignedPopChop > 0) {
				update = 1;
				if (assignedPopChop * 3 > woodCap - woodCount) {
					StatusUpdate = timeText + "  Gatherers have brought back " + (woodCap - woodCount) + " wood";
					woodCount = woodCap;
				} else {
					StatusUpdate = timeText + "  Gatherers have brought back " + (assignedPopChop * 3) + " wood";
					woodCount += assignedPopChop * 3;
				}
			}
		}
		return update;
	}
	
	public String getWoodString() {
		
		woodString = woodCount + " wood of " + woodCap;
		
		return woodString;
		
	}
	
	public int getWoodMeterLength() {
		
		woodMeterLength = (int) (woodCount * 256) / woodCap;
		
		return woodMeterLength;
		
	}
	
	public String getPopString() {
		
		popString = popCount + " population of " + popCap;
		
		return popString;
		
	}
	
	public String getHutString() {
		
		if (hutCount == 1) {
			hutString = "1 Hut";
		} else {
			hutString = hutCount + " Huts";
		}
		
		return hutString;
		
	}
	
	public String getBarnString() {
		
		if (barnCount == 1) {
			barnString = "1 Food Barn";
		} else {
			barnString = barnCount + " Food Barns";
		}
		
		return barnString;
		
	}
	
	public String getStorageString() {
		
		if (storageCount == 1) {
			storageString = "1 Resource Storage";
		} else {
			storageString = storageCount + " Resource Storages";
		}
		
		return storageString;
		
	}
	
	public String getBuildString() {
		
		if (hutBuildStatus) {
			buildString = "Hut: " + hutCompletion + "% complete!";
		} else if (barnBuildStatus) {
			buildString = "Food Barn: " + barnCompletion + "% complete!";
		} else if (storageBuildStatus) {
			buildString = "Storage Barn: " + storageCompletion + "% complete!";
		} else {
			buildString = "No current build task";
		}
		
		return buildString;
		
	}
	
	public void fuelFire() {
		
		if (fireLevel <= 200 && woodCount >= popCount) {
			woodCount -= popCount;
			fireLevel = 500;
			StatusUpdate = timeText + "  You rekindled the fire";
		} else if (fireLevel <= 500 && fireLevel > 200 && woodCount >= 2*popCount) {
			woodCount -= 2*popCount;
			fireLevel = 750;
			StatusUpdate = timeText + "  The fire burns strong";
		} else if (fireLevel <= 750 && fireLevel > 500 && woodCount >= 3*popCount) {
			woodCount -= 3*popCount;
			fireLevel = 1000;
			StatusUpdate = timeText + "  The flame roars";
		}
		
	}
	
	public int getFireLevel() {
		
		fireLevel--;
		
		return fireLevel;
		
	}
	
	public int addPops() {
		
		int rand;
		int popAdd = 0;
		
		
		if (hourCount == 20 && assignedPopExplorer != 0 && popCount < popCap) {
			
			for (int i = 0; i < assignedPopExplorer; i++) {
				
				rand = (int) (Math.random() * 10);
				if (rand >= 9) {
					popAdd++;
				}
			}
			if (popCap - popCount <= popAdd) {
				popCount = popCap;
				StatusUpdate = timeText + "  Explorers have found " + (popCap - popCount) + " survivors!";
			} else {
				StatusUpdate = timeText + "  Explorers have found " + popAdd + " survivors!";
				popCount += popAdd;
			}
		}
		
		return popAdd;
		
	}
	
	public void assignForagers(int assign) {
		
		unassign();
		
		if (assign > 0) {
			if (unassignedPop != 0) {
				assignedPopForage += assign;
			}
		} else if (assign < 0) {
			if (assignedPopForage != 0) {
				assignedPopForage += assign;
			}
		}
	}
	
	public String getForagers() {
		
		assignedPopForageString = "Foragers: " + assignedPopForage;
		
		return assignedPopForageString;
		
	}
	
	public void assignChoppers(int assign) {

		unassign();
		
		if (assign > 0) {
			if (unassignedPop != 0) {
				assignedPopChop += assign;
			}
		} else if (assign < 0) {
			if (assignedPopChop != 0) {
				assignedPopChop += assign;
			}
		}
	}
	
	public String getChoppers() {
		
		assignedPopChopString = "Choppers: " + assignedPopChop;
		
		return assignedPopChopString;
		
	}
	
	public void assignWaterers(int assign) {
		
		unassign();
		
		if (assign > 0) {
			if (unassignedPop != 0) {
				assignedPopWater += assign;
			}
		} else if (assign < 0) {
			if (assignedPopWater != 0) {
				assignedPopWater += assign;
			}
		}
		
	}
	
	public String getWaterers() {
		
		assignedPopWaterString = "Waterers: " + assignedPopWater;
		
		return assignedPopWaterString;
		
	}
	
	public void assignBuilders(int assign) {
		
		unassign();
		
		if (assign > 0) {
			if (unassignedPop != 0) {
				assignedPopBuilder += assign;
			}
		} else if (assign < 0) {
			if (assignedPopBuilder != 0) {
				assignedPopBuilder += assign;
			}
		}
		
	}
	
	public String getBuilders() {
		
		assignedPopBuildString = "Builders: " + assignedPopBuilder;
		
		return assignedPopBuildString;
		
	}
	
	public void assignExplorers(int assign) {
		
		unassign();
		
		if (assign > 0) {
			if (unassignedPop != 0) {
				assignedPopExplorer += assign;
			}
		} else if (assign < 0) {
			if (assignedPopExplorer != 0) {
				assignedPopExplorer += assign;
			}
		}
		
	}
	
	public String getExplorers() {
		
		assignedPopExploreString = "Explorers: " + assignedPopExplorer;
		
		return assignedPopExploreString;
		
	}
	
	public String getUnassigned() {
		
		unassign();
		unassignedPopString = "Unassigned: " + unassignedPop;
		
		return unassignedPopString;
		
	}
	
	public void unassign() {
		
		unassignedPop = popCount - (assignedPopForage + assignedPopChop + assignedPopWater + assignedPopBuilder + assignedPopExplorer);
		
	}
	
	public void startHutBuild() {
		
		int hutCost = 25 * hutCount;
		
		if ( !(hutBuildStatus || barnBuildStatus || storageBuildStatus) && woodCount >= hutCost ) {
			woodCount -= hutCost;
			hutBuildStatus = true;
			StatusUpdate = timeText + "  Production on a hut has begun";
		} else if (hutBuildStatus || barnBuildStatus || storageBuildStatus) {
			StatusUpdate = "There is already another building project!";
		} else if (hutCost > woodCount) {
			StatusUpdate = hutCost + " wood is required to begin building";
		}
	}
	
	public int hutBuilder() {
		
		int update = 0;
		
		if (hourCount >= 7 && hourCount <= 22) {
		
			hutCompletion = build.buildHut(hutBuildStatus,assignedPopBuilder,hutCount);
			if (hutCompletion == 100) {
				build.resetHut();
				hutBuildStatus = false;
				hutCount++;
				popCap += 5;
				StatusUpdate = timeText + "  Builders have finished building a new hut!";
				update = 1;
			} else {
				update = 0;
			}
		}
		
		return update;
		
	}
	
	public void startBarnBuild() {
		
		int barnCost = 100 * (1 + barnCount);
		
		if ( !(hutBuildStatus || barnBuildStatus || storageBuildStatus) && woodCount >= barnCost ) {
			woodCount -= barnCost;
			barnBuildStatus = true;
			StatusUpdate = timeText + "  Production on a food barn has begun";
		} else if (hutBuildStatus || barnBuildStatus || storageBuildStatus) {
			StatusUpdate = "There is already another building project!";
		} else if (barnCost > woodCount) {
			StatusUpdate = barnCost + " wood is required to begin building";
		}
	}
	
	public int barnBuilder() {
		
		int update = 0;
		
		if (hourCount >= 7 && hourCount <= 22) {
		
			barnCompletion = build.buildBarn(barnBuildStatus,assignedPopBuilder,barnCount);
			if (barnCompletion == 100) {
				build.resetBarn();
				barnBuildStatus = false;
				barnCount++;
				foodCap += 100;
				StatusUpdate = timeText + "  Builders have finished building a new food barn!";
				update = 1;
			} else {
				update = 0;
			}
		}
		
		return update;
		
	}
	
	public void startStorageBuild() {
		
		int storageCost = 75 * (1 + storageCount);
		
		if ( !(hutBuildStatus || barnBuildStatus || storageBuildStatus) && woodCount >= storageCost ) {
			woodCount -= storageCost;
			storageBuildStatus = true;
			StatusUpdate = timeText + "  Production on a storage barn has begun";
		} else if (hutBuildStatus || barnBuildStatus || storageBuildStatus) {
			StatusUpdate = "There is already another building project!";
		} else if (storageCost > woodCount) {
			StatusUpdate = storageCost + " wood is required to begin building";
		}
	}
	
	public int storageBuilder() {
		
		int update = 0;
		
		if (hourCount >= 7 && hourCount <= 22) {
		
			storageCompletion = build.buildStorage(storageBuildStatus,assignedPopBuilder,storageCount);
			if (storageCompletion == 100) {
				build.resetStorage();
				storageBuildStatus = false;
				storageCount++;
				woodCap += 100;
				StatusUpdate = timeText + "  Builders have finished building a new storage barn!";
				update = 1;
				//stoneCap increase
				//ironCap increase
				//fiberCap increase
				//hideCap increase
			} else {
				update = 0;
			}
		}
		
		return update;
	}
	
	public int getBuildMeterLength() {
		
		if (hutBuildStatus) {
			buildMeterLength = (int) ((hutCompletion * 256) / 100);
		} else if (barnBuildStatus) {
			buildMeterLength = (int) ((hutCompletion * 256) / 100);
		} else if (storageBuildStatus) {
			buildMeterLength = (int) ((hutCompletion * 256) / 100);
		} else {
			buildMeterLength = 0;
		}
		
		return buildMeterLength;
		
	}
	
	public String returnStatusText() {
		
		return StatusUpdate;
		
	}
}