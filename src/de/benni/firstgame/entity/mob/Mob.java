package de.benni.firstgame.entity.mob;

import java.util.ArrayList;
import java.util.List;

import de.benni.firstgame.entity.Entity;
import de.benni.firstgame.entity.projectile.Projectile;
import de.benni.firstgame.entity.projectile.WizardProjectile;
import de.benni.firstgame.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public void update() {
	}

	public void shoot(int xp, int yp, double dir) {
		Projectile p = new WizardProjectile(x,y, dir);
		level.addProjectile(p);
	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			// c interriert zwischen 0 und 1. entweder man geht um 11 Pixel auf der X Achse oder um 0. die 22 abzüglich der 11 bedingt die Kollison nach rechts. die 11 alleine die Kollison nach links.
			int xt = ((x + xa) + c % 2 * 22 - 11) / 16;
			// c ist 0, 0.5, 1, 1.5. Man geht also um 0, 7.5, 15 oder 22.5 auf der Y Achse. 12 bedingt die Collision nach unten, 3 die nach oben.
			int yt = ((y + ya) + c / 2 * 12 + 3) / 16;
			if (level.getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}

	public void render() {

	}

}
