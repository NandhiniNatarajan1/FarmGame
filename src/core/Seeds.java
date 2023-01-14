package core;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Seeds extends Tile {
	
	public Image seed[];
	private Timer time;
	private boolean justTicked = false;
	private boolean finishedGrowing = false;
	public boolean harvested = false;
	
	private Level level = new Level();
	
	public int state = 0;

	public Seeds(int x, int y, int ID, String path[]) {
		super(x, y, ID, "images/seeds.png");
		seed = new Image[path.length];
		time = new Timer();
		
		try {
			for (int i = 0; i < seed.length; i++) {
				seed[i] = new Image(path[i]);
			}
 		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(int delta) {
		x = oX - Farming.offsetX;
		y = oY - Farming.offsetY;
		
		//Changes stages depending on time.
		if (time.day() && justTicked && finishedGrowing == false) {
			state += 1;
			justTicked = false;
			
			
			
			if (state == seed.length - 1) {
				finishedGrowing = true;
				System.out.println("Plant ready to be harvested: " + state);
			}
		}
		
		
		if (time.day() == false) {
			justTicked = true;
		}

		tileArea.setBounds((int) x, (int) y, BLOCK, BLOCK);
		if(tileArea.contains(mouse.getMouseX() - Farming.offsetX, mouse.getMouseY() - Farming.offsetY)){
			showBorders = true;
		}else{
			showBorders = false;
		}
		
		
	}
	
	//Picks the plant / harvests it.
	public void pickPlant() {
		if (harvested == false) {
			harvest();
			
			level.replaceTile((int) oX/32, (int) oY/32, id, 3);
		}
		
	    harvested = true;
	}
	
	public abstract void harvest();

}
