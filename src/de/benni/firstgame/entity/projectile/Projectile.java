package de.benni.firstgame.entity.projectile;

import java.util.Random;

import de.benni.firstgame.entity.Entity;
import de.benni.firstgame.graphics.Sprite;

public abstract class Projectile extends Entity {
	
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x, y;
	protected double nx, ny;
	protected double distance;
	protected double speed, range, damage;
	protected final Random random = new Random();

	public Projectile(int x, int y, double dir) {
		this.xOrigin = x;
		this.yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	public Sprite getSprite(){
		return sprite;
	}
	
	protected void move(){
		
	}

	public int getSpriteSize(){
		return sprite.SIZE;
	}
}
