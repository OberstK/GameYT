package de.benni.firstgame.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private int width, height;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 3, 0, SpriteSheet.tiles);

	//Spawn Level Sprites:
	public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawnLevel);
	public static Sprite spawn_hedge = new Sprite(16, 1, 2, SpriteSheet.spawnLevel);
	public static Sprite spawn_water = new Sprite(16, 3, 0, SpriteSheet.spawnLevel);
	public static Sprite spawn_wall1 = new Sprite(16, 0, 1, SpriteSheet.spawnLevel);
	public static Sprite spawn_wall2 = new Sprite(16, 1, 1, SpriteSheet.spawnLevel);
	public static Sprite spawn_floor = new Sprite(16, 0, 2, SpriteSheet.spawnLevel);

	//32x32 Player Sprites:
	public static Sprite playerForward = new Sprite(32, 6, 7, SpriteSheet.tiles);
	public static Sprite playerForward1 = new Sprite(32, 5, 7, SpriteSheet.tiles);
	public static Sprite playerForward2 = new Sprite(32, 7, 7, SpriteSheet.tiles);

	public static Sprite playerBack = new Sprite(32, 6, 4, SpriteSheet.tiles);
	public static Sprite playerBack1 = new Sprite(32, 5, 4, SpriteSheet.tiles);
	public static Sprite playerBack2 = new Sprite(32, 7, 4, SpriteSheet.tiles);

	public static Sprite playerSide = new Sprite(32, 6, 5, SpriteSheet.tiles);
	public static Sprite playerSide1 = new Sprite(32, 5, 5, SpriteSheet.tiles);
	public static Sprite playerSide2 = new Sprite(32, 7, 5, SpriteSheet.tiles);

	//16x16 Player Sprites:

	//	public static Sprite playerForward = new Sprite(16, 13, 3, SpriteSheet.tiles);
	//	public static Sprite playerForward1 = new Sprite(16, 14, 3, SpriteSheet.tiles);
	//	public static Sprite playerForward2 = new Sprite(16, 15, 3, SpriteSheet.tiles);
	//
	//	public static Sprite playerBack = new Sprite(16, 13, 0, SpriteSheet.tiles);
	//	public static Sprite playerBack1 = new Sprite(16, 14, 0, SpriteSheet.tiles);
	//	public static Sprite playerBack2 = new Sprite(16, 15, 0, SpriteSheet.tiles);
	//
	//	public static Sprite playerSide = new Sprite(16, 13, 1, SpriteSheet.tiles);
	//	public static Sprite playerSide1 = new Sprite(16, 14, 1, SpriteSheet.tiles);
	//	public static Sprite playerSide2 = new Sprite(16, 15, 1, SpriteSheet.tiles);

	//Projectile Sprites:
	public static Sprite projectileWizard = new Sprite(16, 0, 0, SpriteSheet.wizardProjectile);

	//Particles
	public static Sprite particleNormal = new Sprite(3,0xAAAAAA);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColor(color);
	}

	public Sprite(int size, int color) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = color;
		}

	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
