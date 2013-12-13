package de.benni.firstgame.level.tile;

import de.benni.firstgame.graphics.Screen;
import de.benni.firstgame.graphics.Sprite;
import de.benni.firstgame.level.tile.spawn_level.SpawnFloorTile;
import de.benni.firstgame.level.tile.spawn_level.SpawnGrassTile;
import de.benni.firstgame.level.tile.spawn_level.SpawnHedgeTile;
import de.benni.firstgame.level.tile.spawn_level.SpawnWallTile;
import de.benni.firstgame.level.tile.spawn_level.SpawnWaterTile;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public static Tile spawnGrass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawnHedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawnWater = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawnWall1 = new SpawnWallTile(Sprite.spawn_wall1);
	public static Tile spawnWall2 = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawnFloor = new SpawnFloorTile(Sprite.spawn_floor);

	public final static int colSpawnGrass = 0xff00ff00;
	public final static int colSpawnHedge = 0; //unused
	public final static int colSpawnWater = 0; //unused
	public final static int colSpawnWall1 = 0xff808080;
	public final static int colSpawnWall2 = 0xff303030;
	public final static int colSpawnFloor = 0xff7F4213;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}
}
