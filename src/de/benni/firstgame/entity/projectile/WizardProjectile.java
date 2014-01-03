package de.benni.firstgame.entity.projectile;

import de.benni.firstgame.entity.spawner.ParticleSpawner;
import de.benni.firstgame.graphics.Screen;
import de.benni.firstgame.graphics.Sprite;

public class WizardProjectile extends Projectile {

	public static final int FIRE_RATE = 15; //Höher bedeutet langsamer -> wie viele Ticks bis Schuss

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 3;
		damage = 20;
		sprite = Sprite.projectileWizard;

		//Vektor des Projektils
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	@Override
	public void update() {
		if (level.tileCollision(x, y, nx, ny, 7)) {
			level.add(new ParticleSpawner((int) x, (int) y, 44, 50, level));
			remove();
		}
		move();
	}

	@Override
	protected void move() {
		x += nx;
		y += ny;
		if (distance() > range) remove();
	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;
	}

	@Override
	public void render(Screen screen) {
		screen.renderProjectile((int) x - 10, (int) y - 2, this);
	}

}
