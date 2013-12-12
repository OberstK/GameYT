package de.benni.firstgame.level.tile.spawn_level;

import de.benni.firstgame.graphics.Screen;
import de.benni.firstgame.graphics.Sprite;
import de.benni.firstgame.level.tile.Tile;

public class SpawnWallTile extends Tile {

	public SpawnWallTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid(){
		return true;
	}

}
