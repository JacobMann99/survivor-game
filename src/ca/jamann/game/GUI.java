package ca.jamann.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static GUI instance = null; // creates instance of type GUI
	
	public static GUI getInstance() {
		
		if (instance == null) {
			
			instance = new GUI();
			// creates a new instance only if an instance has not already been initialized
			
		}
		
		return instance; // this is the method that must be called for a class to recognize the existence of the singleton class
		
	}
	
	Speed spd = Speed.getInstance();
	Action act = Action.getInstance();
	Build build = Build.getInstance();
	
	public static final int WIDTH = 840;
	public static final int HEIGHT = (int) (WIDTH / 12 * 9);
	public static final int SCALE = 1;
	public static final String NAME = "Survivor Game";
	public static final int BUTTONWIDTH = 120;
	public static final int BUTTONHEIGHT = BUTTONWIDTH / 3;
	public static final int BUTTONSCALE = 1;
	
	String statusStringA = "You wake up in darkness";
	String statusStringB = "They've started a fire";
	String statusStringC = "The days ahead look dark";
	String statusStringD = "You're a survivor now";
	private static JLabel StatusA;
	private static JLabel StatusB;
	private static JLabel StatusC;
	private static JLabel StatusD;
	
	private static JLabel dayLabel; // shows day count
	private static JLabel timeLabel; // shows current time
	private static JLabel popLabel; // shows pop count
	private static JLabel foodLabel; // overlay of food meter that shows percentage of food left
	private static JLabel waterLabel; // overlay of water meter that shows percentage of water left
	private static JLabel woodLabel; // overlay of wood meter that shows amount of wood stockpiled
	private static JLabel buildLabel; // overlay of build meter that shows percentage complete of current project
	private static JLabel assignedForagers; // number of pops assigned to foraging
	private static JLabel assignedChoppers; // number of pops assigned to chopping
	private static JLabel assignedWaterers; // number of pops assigned to watering
	private static JLabel assignedBuilders; // number of pops assigned to building
	private static JLabel assignedExplorers; // number of pops assigned to exploring
	private static JLabel unassignedPops; // number of pops unassigned to a task
	
	private static JLabel hutLabel; // number of huts
	private static JLabel barnLabel; // number of food barns
	private static JLabel storageLabel; // number of storage barns
	private static JButton buildHut; // button to start a hut build
	private static JButton buildBarn; // button to start a barn build
	private static JButton buildStorage; // button to start a storage build
	
	private static JButton assignForager;
	private static JButton unassignForager;
	private static JButton assignChopper;
	private static JButton unassignChopper;
	private static JButton assignWaterer;
	private static JButton unassignWaterer;
	private static JButton assignBuilder;
	private static JButton unassignBuilder;
	private static JButton assignExplorer;
	private static JButton unassignExplorer;
	
	private static JButton normalSpeedButton;
	private static JButton fastForwardButton;
	private static JButton pauseButton;
	
	private static JButton fireButton;
	
	private JLabel campfire;
	private JLabel foodMeter;
    private JLabel waterMeter;
    private JLabel backgroundMeterA;
    private JLabel backgroundMeterB;
    private JLabel woodMeter;
    private JLabel backgroundMeterWood;
    private JLabel buildMeter;
    private JLabel backgroundMeterBuild;
    private JLabel foodSymbol;
    private JLabel waterSymbol;
    private JLabel woodSymbol;
	
	private BufferedImage campfireB0;
    private ImageIcon campfire0;
    private BufferedImage campfireB1;
    private ImageIcon campfire1;
    private BufferedImage campfireB2;
    private ImageIcon campfire2;
    private BufferedImage campfireB3;
    private ImageIcon campfire3;
    
    private BufferedImage apple;
    private ImageIcon foodSymbolImg;
    private BufferedImage water;
    private ImageIcon waterSymbolImg;
    private BufferedImage wood;
    private ImageIcon woodSymbolImg;
    
    private BufferedImage meterA;
    private ImageIcon foodMeterImg;
    private BufferedImage meterB;
    private ImageIcon waterMeterImg;
    private BufferedImage meterC;
    private ImageIcon backgroundMeterImg;
    private BufferedImage meterD;
    private ImageIcon woodMeterImg;
    private BufferedImage meterG;
    private ImageIcon buildMeterImg;
	
	private void loadCampfireA() {
    	try {
			campfireB0 = ImageIO.read(GUI.class.getResource("/images/campfire_0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	campfire0 = new ImageIcon(campfireB0);
    	
    }
    
    private void loadCampfireB() {
    	try {
			campfireB1 = ImageIO.read(GUI.class.getResource("/images/campfire_1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	campfire1 = new ImageIcon(campfireB1);
    	
    }
    
    private void loadCampfireC() {
    	try {
			campfireB2 = ImageIO.read(GUI.class.getResource("/images/campfire_2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	campfire2 = new ImageIcon(campfireB2);
    	
    }
    
    private void loadCampfireD() {
    	try {
			campfireB3 = ImageIO.read(GUI.class.getResource("/images/campfire_3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	campfire3 = new ImageIcon(campfireB3);
    	
    }
    
    private void loadApple() {
    	try {
			apple = ImageIO.read(GUI.class.getResource("/images/apple.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	foodSymbolImg = new ImageIcon(apple);
    	
    }
    
    private void loadWater() {
    	try {
			water = ImageIO.read(GUI.class.getResource("/images/water.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	waterSymbolImg = new ImageIcon(water);
    	
    }
    
    private void loadWood() {
    	try {
			wood = ImageIO.read(GUI.class.getResource("/images/wood.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	woodSymbolImg = new ImageIcon(wood);
    	
    }
    
    private void loadWaterMeter() {
    	try {
			meterB = ImageIO.read(GUI.class.getResource("/images/water_meter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	waterMeterImg = new ImageIcon(meterB);
    	
    }
    
    private void loadFoodMeter() {
    	try {
			meterA = ImageIO.read(GUI.class.getResource("/images/food_meter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	foodMeterImg = new ImageIcon(meterA);
    	
    }
    
    private void loadWoodMeter() {
    	try {
			meterD = ImageIO.read(GUI.class.getResource("/images/wood_meter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	woodMeterImg = new ImageIcon(meterD);
    	
    }
    
    private void loadBuildMeter() {
    	try {
			meterG = ImageIO.read(GUI.class.getResource("/images/build_meter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	buildMeterImg = new ImageIcon(meterG);
    	
    }
    
    private void loadBackgroundMeter() {
    	try {
			meterC = ImageIO.read(GUI.class.getResource("/images/background_meter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	backgroundMeterImg = new ImageIcon(meterC);
    	
    }
	
	public GUI() {
	
		loadCampfireA();
    	loadCampfireB();
    	loadCampfireC();
    	loadCampfireD();
    	
    	loadApple();
    	loadWater();
    	loadWood();
    	
    	loadFoodMeter();
    	loadWaterMeter();
    	loadBackgroundMeter();
    	loadBuildMeter();
    	loadWoodMeter();
		
		setLayout(null);
		setSize(WIDTH*SCALE, HEIGHT*SCALE);
		setTitle(NAME);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.lightGray);
		
		campfire = new JLabel(campfire2);
		foodSymbol = new JLabel(foodSymbolImg);
        waterSymbol = new JLabel(waterSymbolImg);
        woodSymbol = new JLabel(woodSymbolImg);
        foodMeter = new JLabel(foodMeterImg);
        waterMeter = new JLabel(waterMeterImg);
        backgroundMeterA = new JLabel(backgroundMeterImg);
        backgroundMeterB = new JLabel(backgroundMeterImg);
        woodMeter = new JLabel(woodMeterImg);
        backgroundMeterWood = new JLabel(backgroundMeterImg);
        buildMeter = new JLabel(buildMeterImg);
        backgroundMeterBuild = new JLabel(backgroundMeterImg);
		
        StatusA = new JLabel(statusStringA);
        StatusB = new JLabel(statusStringB);
        StatusC = new JLabel(statusStringC);
        StatusD = new JLabel(statusStringD);
        
		dayLabel = new JLabel(act.dayText);
		dayLabel.setFont(new Font("Courier",Font.BOLD,20));
		timeLabel = new JLabel(act.timeText);
		timeLabel.setFont(new Font("Courier",Font.BOLD,20));
		popLabel = new JLabel(act.popString);
		foodLabel = new JLabel(act.foodString);
		waterLabel = new JLabel(act.waterString);
		woodLabel = new JLabel(act.woodString);
		buildLabel = new JLabel(act.buildString);
		assignedForagers = new JLabel(act.assignedPopForageString);
		assignedChoppers = new JLabel(act.assignedPopChopString);
		assignedWaterers = new JLabel(act.assignedPopWaterString);
		assignedBuilders = new JLabel(act.assignedPopBuildString);
		assignedExplorers = new JLabel(act.assignedPopExploreString);
		unassignedPops = new JLabel(act.unassignedPopString);
		
		hutLabel = new JLabel(act.hutString);
		barnLabel = new JLabel(act.barnString);
		storageLabel = new JLabel(act.storageString);
		buildHut = new JButton("Build Hut");
		buildBarn = new JButton("Build Food Barn");
		buildStorage = new JButton("Build Storage");
		
		assignForager = new JButton("+");
		unassignForager = new JButton("--");
		assignChopper = new JButton("+");
		unassignChopper = new JButton("--");
		assignWaterer = new JButton("+");
		unassignWaterer = new JButton("--");
		assignBuilder = new JButton("+");
		unassignBuilder = new JButton("--");
		assignExplorer = new JButton("+");
		unassignExplorer = new JButton("--");
		
		normalSpeedButton = new JButton("Normal");
		fastForwardButton = new JButton("Fast");
		pauseButton = new JButton("Pause");
		
		fireButton = new JButton("Fire");
		
		StatusA.setBounds(90,305,528,30);
		StatusB.setBounds(90,330,528,30);
		StatusC.setBounds(90,355,528,30);
		StatusD.setBounds(90,380,528,30);
		
		dayLabel.setBounds(220,30,120,30);
		timeLabel.setBounds(100,30,120,30);
		popLabel.setBounds(124,260,200,30);
		foodLabel.setBounds(134,424,120,30);
		waterLabel.setBounds(134,464,120,30);
		woodLabel.setBounds(134,504,120,30);
		buildLabel.setBounds(470,424,235,30);
		assignedForagers.setBounds(134,125,200,30);
		assignedChoppers.setBounds(134,215,200,30);
		assignedWaterers.setBounds(385,125,200,30);
		assignedBuilders.setBounds(636,125,200,30);
		assignedExplorers.setBounds(636,215,200,30);
		unassignedPops.setBounds(592,260,200,30);
		
		hutLabel.setBounds(592,305,200,30);
		barnLabel.setBounds(592,335,200,30);
		storageLabel.setBounds(592,365,200,30);
		buildHut.setBounds(460,464,124,32);
		buildHut.addActionListener(this);
		buildBarn.setBounds(592,464,124,32);
		buildBarn.addActionListener(this);
		buildStorage.setBounds(460,504,124,32);
		buildStorage.addActionListener(this);
		
		int buttonSize = 45;
		
		assignForager.setBounds(169,80,buttonSize,buttonSize);
		assignForager.addActionListener(this);
		unassignForager.setBounds(124,80,buttonSize,buttonSize);
		unassignForager.addActionListener(this);
		assignChopper.setBounds(169,170,buttonSize,buttonSize);
		assignChopper.addActionListener(this);
		unassignChopper.setBounds(124,170,buttonSize,buttonSize);
		unassignChopper.addActionListener(this);
		assignWaterer.setBounds(420,80,buttonSize,buttonSize);
		assignWaterer.addActionListener(this);
		unassignWaterer.setBounds(375,80,buttonSize,buttonSize);
		unassignWaterer.addActionListener(this);
		assignBuilder.setBounds(671,80,buttonSize,buttonSize);
		assignBuilder.addActionListener(this);
		unassignBuilder.setBounds(626,80,buttonSize,buttonSize);
		unassignBuilder.addActionListener(this);
		assignExplorer.setBounds(671,170,buttonSize,buttonSize);
		assignExplorer.addActionListener(this);
		unassignExplorer.setBounds(626,170,buttonSize,buttonSize);
		unassignExplorer.addActionListener(this);
		
		normalSpeedButton.setBounds(580,30,80,30);
		normalSpeedButton.addActionListener(this);
		fastForwardButton.setBounds(660,30,80,30);
		fastForwardButton.addActionListener(this);
		pauseButton.setBounds(500,30,80,30);
		pauseButton.addActionListener(this);
		
		campfire.setBounds(388,175,64,64);
		campfire.setVisible(true);
		foodMeter.setBounds(124,424,act.foodMeterLength,32);
		foodMeter.setVisible(true);
		waterMeter.setBounds(124,464,act.waterMeterLength,32);
		waterMeter.setVisible(true);
		backgroundMeterA.setBounds(124,424,256,32);
		backgroundMeterA.setVisible(true);
		backgroundMeterB.setBounds(124,464,256,32);
		backgroundMeterB.setVisible(true);
		woodMeter.setBounds(124,504,act.woodMeterLength,32);
		woodMeter.setVisible(true);
		backgroundMeterWood.setBounds(124,504,256,32);
		backgroundMeterWood.setVisible(true);
		buildMeter.setBounds(460,424,act.buildMeterLength,32);
		buildMeter.setVisible(true);
		backgroundMeterBuild.setBounds(460,424,256,32);
		backgroundMeterBuild.setVisible(true);
		foodSymbol.setBounds(74,424,32,32);
		foodSymbol.setVisible(true);
		waterSymbol.setBounds(74,464,32,32);
		waterSymbol.setVisible(true);
		woodSymbol.setBounds(74,504,32,32);
		woodSymbol.setVisible(true);
		
		fireButton.setBounds(380,260,80,30);
		fireButton.addActionListener(this);
		
		add(StatusA);
		add(StatusB);
		add(StatusC);
		add(StatusD);
		
		add(dayLabel);
		add(timeLabel);
		add(popLabel);
		add(foodLabel);
		add(waterLabel);
		add(woodLabel);
		add(buildLabel);
		add(assignedForagers);
		add(assignedChoppers);
		add(assignedWaterers);
		add(assignedBuilders);
		add(assignedExplorers);
		add(unassignedPops);
		
		add(hutLabel);
		add(barnLabel);
		add(storageLabel);
		add(buildHut);
		add(buildBarn);
		add(buildStorage);
		
		add(assignForager);
		add(unassignForager);
		add(assignChopper);
		add(unassignChopper);
		add(assignWaterer);
		add(unassignWaterer);
		add(assignBuilder);
		add(unassignBuilder);
		add(assignExplorer);
		add(unassignExplorer);
		
		add(normalSpeedButton);
		normalSpeedButton.setBackground(Color.green);
		add(fastForwardButton);
		fastForwardButton.setBackground(Color.white);
		add(pauseButton);
		pauseButton.setBackground(Color.white);
		
		add(campfire);
		add(foodSymbol);
		add(foodMeter);
		add(waterSymbol);
		add(waterMeter);
		add(woodMeter);
		add(buildMeter);
		add(backgroundMeterA, -1, -1);
		add(backgroundMeterB, -1, -1);
		add(backgroundMeterWood, -1, -1);
		add(backgroundMeterBuild, -1, -1);
		add(woodSymbol);
		
		add(fireButton);
		
		setTextColor(Color.white);
		setTextColor(Color.black);
		
	}
	
	public void updateStatusText() {
		
		statusStringD = statusStringC;
		statusStringC = statusStringB;
		statusStringB = statusStringA;
		statusStringA = act.returnStatusText();
		StatusA.setText(statusStringA);
		StatusB.setText(statusStringB);
		StatusC.setText(statusStringC);
		StatusD.setText(statusStringD);
		
	}
	
	public void setCampfireOut() {
		
		campfire.setIcon(campfire0);
		getContentPane().setBackground(Color.darkGray);
		setTextColor(Color.white);
		revalidate();
		repaint();
		
	}
	
	public void setCampfireLow() {
		
		campfire.setIcon(campfire1);
		getContentPane().setBackground(Color.gray);
		setTextColor(Color.white);
		revalidate();
		repaint();
		
	}
	
	public void setCampfireMid() {
		
		campfire.setIcon(campfire2);
		getContentPane().setBackground(Color.lightGray);
		setTextColor(Color.black);
		revalidate();
		repaint();
		
	}
	
	public void setCampfireRoaring() {
		
		campfire.setIcon(campfire3);
		getContentPane().setBackground(Color.white);
		setTextColor(Color.black);
		revalidate();
		repaint();
		
	}
	
	public void setFoodMeterLength() {
		
		act.foodMeterLength = act.getFoodMeterLength();
		foodMeter.setBounds(124,424,act.foodMeterLength,32);
		revalidate();
		repaint();
		
	}
	
	public void setWaterMeterLength() {
		
		act.waterMeterLength = act.getWaterMeterLength();
		waterMeter.setBounds(124,464,act.waterMeterLength,32);
		revalidate();
		repaint();
		
	}
	
	public void setWoodMeterLength() {
		
		act.woodMeterLength = act.getWoodMeterLength();
		woodMeter.setBounds(124,504,act.woodMeterLength,32);
		revalidate();
		repaint();
		
	}
	
	public void setBuildMeterLength() {
		
		act.buildMeterLength = act.getBuildMeterLength();
		buildMeter.setBounds(460,424,act.buildMeterLength,32);
		revalidate();
		repaint();
		
	}
	
	public void setTextColor(Color color) {
		StatusA.setForeground(color);
		StatusB.setForeground(color);
		StatusC.setForeground(color);
		StatusD.setForeground(color);
		dayLabel.setForeground(color);
		timeLabel.setForeground(color);
		popLabel.setForeground(color);
		assignedForagers.setForeground(color);
		assignedChoppers.setForeground(color);
		assignedWaterers.setForeground(color);
		assignedBuilders.setForeground(color);
		assignedExplorers.setForeground(color);
		unassignedPops.setForeground(color);
		hutLabel.setForeground(color);
		barnLabel.setForeground(color);
		storageLabel.setForeground(color);
		
		if (color == Color.white) {
			foodLabel.setForeground(color);
			waterLabel.setForeground(color);
			woodLabel.setForeground(color);
			buildLabel.setForeground(color);
		}
	}
	
	public void setDayLabel() {
		
		act.dayText = act.getDayString();
		dayLabel.setText(act.dayText);
		revalidate();
		repaint();
		
	}
	
	public void setTimeLabel() {
		
		act.timeText = act.getTimeString();
		timeLabel.setText(act.timeText);
		revalidate();
		repaint();
		
	}
	
	public void setFoodLabel() {
		
		act.foodString = act.getFoodString();
		foodLabel.setText(act.foodString);
		revalidate();
		repaint();
		
	}
	
	public void setWaterLabel() {
		
		act.waterString = act.getWaterString();
		waterLabel.setText(act.waterString);
		revalidate();
		repaint();
		
	}
	
	public void setWoodLabel() {
		
		act.woodString = act.getWoodString();
		woodLabel.setText(act.woodString);
		revalidate();
		repaint();
		
	}
	
	public void setBuildLabel() {
		
		act.buildString = act.getBuildString();
		buildLabel.setText(act.buildString);
		revalidate();
		repaint();
		
	}
	
	public void setHutLabel() {
		
		act.hutString = act.getHutString();
		hutLabel.setText(act.hutString);
		revalidate();
		repaint();
		
	}
	
	public void setBarnLabel() {
		
		act.barnString = act.getBarnString();
		barnLabel.setText(act.barnString);
		revalidate();
		repaint();
		
	}
	
	public void setStorageLabel() {
		
		act.storageString = act.getStorageString();
		storageLabel.setText(act.storageString);
		revalidate();
		repaint();
		
	}
	
	public void setUnassignedLabel() {
		
		act.unassignedPopString = act.getUnassigned();
		unassignedPops.setText(act.unassignedPopString);
		revalidate();
		repaint();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == normalSpeedButton) {
			spd.setSpeed(1);
			normalSpeedButton.setBackground(Color.green);
			fastForwardButton.setBackground(Color.white);
			pauseButton.setBackground(Color.white);
		} else if (e.getSource() == fastForwardButton) {
			spd.setSpeed(2);
			normalSpeedButton.setBackground(Color.white);
			fastForwardButton.setBackground(Color.green);
			pauseButton.setBackground(Color.white);
		} else if (e.getSource() == pauseButton) {
			spd.setSpeed(0);
			normalSpeedButton.setBackground(Color.white);
			fastForwardButton.setBackground(Color.white);
			pauseButton.setBackground(Color.red);
		} else if (e.getSource() == assignForager) {
			act.assignForagers(1);
			act.assignedPopForageString = act.getForagers();
			assignedForagers.setText(act.assignedPopForageString);
			setUnassignedLabel();
		} else if (e.getSource() == unassignForager) {
			act.assignForagers(-1);
			act.assignedPopForageString = act.getForagers();
			assignedForagers.setText(act.assignedPopForageString);
			setUnassignedLabel();
		} else if (e.getSource() == assignChopper) {
			act.assignChoppers(1);
			act.assignedPopChopString = act.getChoppers();
			assignedChoppers.setText(act.assignedPopChopString);
			setUnassignedLabel();
		} else if (e.getSource() == unassignChopper) {
			act.assignChoppers(-1);
			act.assignedPopChopString = act.getChoppers();
			assignedChoppers.setText(act.assignedPopChopString);
			setUnassignedLabel();
		} else if (e.getSource() == fireButton) {
			act.fuelFire();
			setWoodLabel();
			setWoodMeterLength();
			updateStatusText();
		} else if (e.getSource() == assignWaterer) {
			act.assignWaterers(1);
			act.assignedPopWaterString = act.getWaterers();
			assignedWaterers.setText(act.assignedPopWaterString);
			setUnassignedLabel();
		} else if (e.getSource() == unassignWaterer) {
			act.assignWaterers(-1);
			act.assignedPopWaterString = act.getWaterers();
			assignedWaterers.setText(act.assignedPopWaterString);
			setUnassignedLabel();
		} else if (e.getSource() == assignBuilder) {
			act.assignBuilders(1);
			act.assignedPopBuildString = act.getBuilders();
			assignedBuilders.setText(act.assignedPopBuildString);
			setUnassignedLabel();
		} else if (e.getSource() == unassignBuilder) {
			act.assignBuilders(-1);
			act.assignedPopBuildString = act.getBuilders();
			assignedBuilders.setText(act.assignedPopBuildString);
			setUnassignedLabel();
		} else if (e.getSource() == assignExplorer) {
			act.assignExplorers(1);
			act.assignedPopExploreString = act.getExplorers();
			assignedExplorers.setText(act.assignedPopExploreString);
			setUnassignedLabel();
		} else if (e.getSource() == unassignExplorer) {
			act.assignExplorers(-1);
			act.assignedPopExploreString = act.getExplorers();
			assignedExplorers.setText(act.assignedPopExploreString);
			setUnassignedLabel();
		} else if (e.getSource() == buildHut) {
			act.startHutBuild();
			updateStatusText();
		} else if (e.getSource() == buildBarn) {
			act.startBarnBuild();
			updateStatusText();
		} else if (e.getSource() == buildStorage) {
			act.startStorageBuild();
			updateStatusText();
		}
		revalidate();
		repaint();
	}

}