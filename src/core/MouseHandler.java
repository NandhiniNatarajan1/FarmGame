package core;

import org.lwjgl.input.Mouse;


public class MouseHandler {

	public int getMouseX() {
		return (int) (Mouse.getX() + Farming.offsetX);
	}
	
	public int getMouseY() {
		return (int) (Main.screenHeight - Mouse.getY() + Farming.offsetY);
	}
	
	public int getBlockX() {
		return getMouseX() / Tile.BLOCK;
	}
	
	public int getBlockY() {
		return getMouseY() / Tile.BLOCK;
	}
	
	public int getMouseDY() {
		return Mouse.getDY();
	}
	
	public int getBlockOnScreenX() {
		return getMouseOnScreenX() / Tile.BLOCK;
	}
	
	public int getBlockOnScreenY() {
		return getMouseOnScreenY() / Tile.BLOCK;
	}
	
	public int getMouseOnScreenX() {
		return Mouse.getX();
	}
	
	public int getMouseOnScreenY() {
		return Main.screenHeight - Mouse.getY();
	}
	
	public int getMouseDX() {
		return Mouse.getDX();
	}
	
}
