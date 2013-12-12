package de.benni.firstgame.level.tile;

import de.benni.firstgame.graphics.Screen;
import de.benni.firstgame.graphics.Sprite;

public class FlowerTile extends Tile {

	public FlowerTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
