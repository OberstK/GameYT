package de.benni.firstgame.entity.mob;

import de.benni.firstgame.Game;
import de.benni.firstgame.graphics.Screen;
import de.benni.firstgame.graphics.Sprite;
import de.benni.firstgame.input.Keyboard;
import de.benni.firstgame.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private int anim = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	int counter = 0;

	public void update() {
		int xa = 0, ya = 0;
		counter++;
		if (counter % 3 < 2) {
			if (anim < 7500) anim++;
			else
				anim = 0;
		}
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}

		updateShooting();
	}

	private void updateShooting() {

		if (Mouse.getButton() == 1) {
			double dx = Mouse.getX()- Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
		}
	}

	public void render(Screen screen) {
		int flip = 0;
		switch (dir) {
		case 0:
			sprite = Sprite.playerForward;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerForward1;
				} else {
					sprite = Sprite.playerForward2;
				}
			}
			break;
		case 1:
			sprite = Sprite.playerSide;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerSide1;
				} else {
					sprite = Sprite.playerSide2;
				}
			}
			flip = 1;
			break;
		case 2:
			sprite = Sprite.playerBack;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerBack1;
				} else {
					sprite = Sprite.playerBack2;
				}
			}
			break;
		case 3:
			sprite = Sprite.playerSide;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerSide1;
				} else {
					sprite = Sprite.playerSide2;
				}
			}
			break;
		default:
			sprite = Sprite.playerForward;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerForward1;
				} else {
					sprite = Sprite.playerForward2;
				}
			}
			break;
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
}
