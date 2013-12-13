package de.benni.firstgame.graphics;

import java.util.Random;

import de.benni.firstgame.entity.projectile.Projectile;

public class Screen {

	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOffest, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
			tiles[0] = 0;
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		if (fixed) {
			xp -= xOffest;
			yp -= yOffset;
		}
		for (int y = 0; y < sprite.getHeight(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getWidth(); x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.getWidth()];
			}
		}

	}

	/*
	 * Offset Prinzip xp = x Position -> wo soll es hin x = welches Pixel wird
	 * geändert xa = absolute Position -> wo ist es dann
	 */
	public void renderTile(int xp, int yp, Sprite sprite) {
		xp -= xOffest;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				// Breaken wenn gerendert wird wo der Screen aufhört. Nur
				// rendern was auf dem Screnn ist!
				// -Size für die Reihe knapp außerhalb
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
			}
		}
	}

	public void renderProjectile(int xp, int yp, Projectile p) {
		xp -= xOffest;
		yp -= yOffset;
		for (int y = 0; y < p.getSpriteSize(); y++) {
			int ya = y + yp;
			for (int x = 0; x < p.getSpriteSize(); x++) {
				int xa = x + xp;
				// Breaken wenn gerendert wird wo der Screen aufhört. Nur
				// rendern was auf dem Screnn ist!
				// -Size für die Reihe knapp außerhalb
				if (xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = p.getSprite().pixels[x + y * p.getSpriteSize()];
				if (col != 0xFFFFFFFF) pixels[xa + ya * width] = col;
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
		xp -= xOffest;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			int ys = y;
			if (flip == 2 || flip == 3) {
				ys = (sprite.SIZE - 1) - y;
			}
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				int xs = x;
				// Flip mit -31 (von links nach rechts)
				if (flip == 1 || flip == 3) {
					xs = (sprite.SIZE - 1) - x;
				}
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * sprite.SIZE];
				if (col != 0xffffffff) pixels[xa + ya * width] = col;
			}
		}
		//Ursprung-Tile des Spielers weiß
		//		for(int x = 0; x <16; x++){
		//			for(int y = 0; y< 16; y++){
		//				pixels[(xp+x) + (yp+y) * width] = 0xffffffff;
		//			}
		//		}

	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffest = xOffset;
		this.yOffset = yOffset;
	}
}
