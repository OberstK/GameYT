package de.benni.firstgame.level.tile;

import de.benni.firstgame.graphics.Screen;
import de.benni.firstgame.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);

	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}

}
