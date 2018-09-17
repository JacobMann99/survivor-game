package ca.jamann.game;

import javax.swing.JOptionPane;

public class Update {
	
	Speed spd = Speed.getInstance();
	Action act = Action.getInstance();
	Build build = Build.getInstance();
	GUI gui = GUI.getInstance();
	
	public int gameSpeed = 1;
	public int preFire;
	public int fireLevel = act.fireLevel;
	public int gameTick;
	public int hour;
	public boolean gameEnd = false;
	
	public void updateGame() {
		
		gameSpeed = spd.getSpeed();
		
		if (gameSpeed != 0 && !gameEnd) { // beginning of pause loop
			gameTick++;
		// gameTick values are in number of seconds multiplied 20
			if (gameTick % (2/gameSpeed) == 0) {
				// this tick check is for updating the fire level and fire graphic every tenth of a second
				preFire = fireLevel;
				fireLevel = act.getFireLevel();
				if (preFire > act.fireLevel) {
					if (act.fireLevel == 0) {
						gameEnd = true;
					} else if (act.fireLevel <= 200 && preFire > 200) {
						gui.setCampfireOut();
					} else if (act.fireLevel <= 500 && preFire > 500) {
						gui.setCampfireLow();
					} else if (act.fireLevel <= 750 && preFire > 750) {
						gui.setCampfireMid();
					} else if (act.fireLevel <= 1000 && preFire > 1000) {
						gui.setCampfireRoaring();
					} // at max fire of 1000 the fire lasts 40 in-game hours until it goes completely out
				} else if (act.fireLevel > preFire) {
					if (act.fireLevel <= 1000 && act.fireLevel > 750) {
						gui.setCampfireRoaring();
					} else if (act.fireLevel <= 750 && act.fireLevel > 500) {
						gui.setCampfireMid();
					} else if (act.fireLevel <= 500) {
						gui.setCampfireLow();
					}
				}
			}
			if (gameTick % (50/gameSpeed) == 0) {
				// this tick check is for running the time cycle every 2.5 seconds and eating food at regular meal times
				act.updateTime();
				if (hour == 23) {
					act.endDay();
				} else if (hour == 6) {
					act.beginDayText();
					gui.updateStatusText();
					act.eatFood();
					gui.updateStatusText();
				} else if (hour == 11) {
					act.eatFood();
					gui.updateStatusText();
				} else if (hour == 19) {
					act.eatFood();
					gui.updateStatusText();
				} else if (hour == 23) {
					act.endDayText();
					gui.updateStatusText();
				}
				gui.setFoodLabel();
				gui.setFoodMeterLength();
				hour = act.getTime();
				gui.setDayLabel();
				gui.setTimeLabel();
			}
			if (gameTick % (50/gameSpeed) == 0) {
				// this tick check is for running the Action popAdd method every time at 20:00
				int popAdd = act.addPops();
				if (popAdd > 0) {
					gui.setUnassignedLabel();
					gui.updateStatusText();
				}
			}
			if (gameTick % (120/gameSpeed) == 0) {
				// this tick check is for getting food through foragers every six seconds
				int update = act.forage();
				if (update == 1) {
					gui.updateStatusText();
				}
				gui.setFoodLabel();
				gui.setFoodMeterLength();
			}
			if (gameTick % (200/gameSpeed) == 0) {
				// this tick check is for getting wood through choppers every ten seconds
				int update = act.chop();
				if (update == 1) {
					gui.updateStatusText();
				}
				gui.setWoodLabel();
				gui.setWoodMeterLength();
			}
			if (gameTick % (2/gameSpeed) == 0) {
				// this tick check is for updating the water levels every tenth of a second
				act.updateWater();
				gui.setWaterLabel();
				gui.setWaterMeterLength();
			}
			if (gameTick % (2/gameSpeed) == 0) {
				// this tick check is for adding build percentage every tenth of a second during the daytime
				int updateA = act.hutBuilder();
				int updateB = act.barnBuilder();
				int updateC = act.storageBuilder();
				gui.setBuildMeterLength();
				gui.setHutLabel();
				gui.setBarnLabel();
				gui.setStorageLabel();
				gui.setBuildLabel();
				gui.setWoodLabel();
				gui.setWoodMeterLength();
				if (updateA + updateB + updateC == 1) {
					gui.updateStatusText();
				}
				
			}
			if (gameTick % (2/gameSpeed) == 0) {
				// this tick check is for ending the game if food or water runs to zero
				act.foodCount = act.getFood();
				act.waterLevel = act.getWater();
				if (act.foodCount == 0 || act.waterLevel == 0) {
					gameEnd = true;
				}
			}
			
		} else if (gameEnd = true && (act.foodCount == 0 || act.waterLevel == 0 || act.fireLevel == 0)) {
			JOptionPane.showMessageDialog(null, "You have perished.");
			System.exit( 0 );
		}
	}
	
}