package de.benni.firstgame.entity.particle;

import de.benni.firstgame.entity.Entity;
import de.benni.firstgame.graphics.Screen;
import de.benni.firstgame.graphics.Sprite;

public class Particle extends Entity {

	private Sprite sprite;

	private int life;
	private int time = 0;

	protected double xx, yy, xa, ya;

	public Particle(int x, int y, int life) {
		System.out.println("Particle life: " + life);
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life + (random.nextInt(30) - 10);
		sprite = Sprite.particleNormal;

		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
	}

	public void update() {
		time++;
		if (time >= 7400) time = 0;
		if (time > life) remove();
		this.xx += xa;
		this.yy += ya;
	}

	public void render(Screen screen) {
		screen.renderSprite((int) xx, (int) yy, sprite, true);
	}

}
