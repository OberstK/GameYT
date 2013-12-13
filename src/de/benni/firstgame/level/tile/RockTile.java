package de.benni.firstgame.level.tile;

import de.benni.firstgame.graphics.Screen;
import de.benni.firstgame.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this.sprite);
	}

	@Override
	public boolean solid() {
		return true;
	}
}
