package de.benni.firstgame.level;

import java.util.ArrayList;
import java.util.List;

import de.benni.firstgame.entity.Entity;
import de.benni.firstgame.graphics.Screen;
import de.benni.firstgame.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	private List<Entity> entities = new ArrayList<Entity>();
	public static Level spawn = new SpawnLevel("/levels/spawn.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {

	}

	public void loadLevel(String path) {

	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		// Tile Precision. Ohne Bitshift ist es das exakte Pixel
		// + 16 f�r doe Reihe au�erhalb des Screens -> eine zus�tzliche Reihe rendern
		int x0 = xScroll >> 4; // xScroll / 16
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4; // yScroll / 16
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
	}

	public void add(Entity e) {
		entities.add(e);
	}

	/* 	
	*	Grass =  0xFF00 -> 0x00FF00
	*	Flower = 0xFFFF00
	*	Rock = 0x7F7F00
	*
	*	FF nach dem 0x wegen dem Alpha-Channel
	*/
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.colSpawnFloor) return Tile.spawnFloor;
		if (tiles[x + y * width] == Tile.colSpawnGrass) return Tile.spawnGrass;
		if (tiles[x + y * width] == Tile.colSpawnHedge) return Tile.spawnHedge;
		if (tiles[x + y * width] == Tile.colSpawnWall1) return Tile.spawnWall1;
		if (tiles[x + y * width] == Tile.colSpawnWall2) return Tile.spawnWall2;
		if (tiles[x + y * width] == Tile.colSpawnWater) return Tile.spawnWater;
		return Tile.voidTile;
	}
}
