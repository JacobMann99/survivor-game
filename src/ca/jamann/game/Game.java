package ca.jamann.game;

public class Game implements Runnable {

	static final long serialVersionUID = 1L;
	
	public boolean running = false;
	public boolean begin = false;
	public int tickCount = 0;
	
	Update update = new Update();
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	
	/*
	public synchronized void stop() {
		running = false;
	}
	*/
	
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			
			while (delta >= 1) {
				tick();
				delta -= 1;
			}
			/*
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			*/
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
			}
		}
	}
	
	public void tick() {
		
		tickCount++;
		if (tickCount % 3 == 0) {
			update.updateGame();
			tickCount = 0;
		}
		
	}
	
	public static void main(String[] args) {
		new Game().start();
		
		GUI gameWindow = GUI.getInstance();
        gameWindow.setVisible(true);
	}

}
