package de.benni.firstgame.entity.projectile;

import de.benni.firstgame.graphics.Screen;

public class WizardProjectile extends Projectile {

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
		damage = 20;
		rateOfFire = 5;
		sprite = sprite.projectileWizard;

		//Vektor des Projektils
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void update(){
		move();
	}
	
	protected void move(){
		x += nx;
		y += ny;
	}
	
	public void render(Screen screen){
		screen.renderProjectile(x, y, this);
	}

}
