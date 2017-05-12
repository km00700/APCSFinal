package com.millstech.game.playerinfo;

import com.millstech.game.Game;
import com.millstech.toolbox.GameConstants;

public class LifeHandler {
	private static int lives = 0;
	private static int health = 0;
	
	public LifeHandler() {
		lives = GameConstants.DEFAULT_LIVES;
		health = GameConstants.DEFAULT_HEALTH;
	}
	
	public void takeDamage() {
		System.out.println(lives + " " + health);
		if(health > 0) {
			health--;
		} else {
			takeLife();
			lives = GameConstants.DEFAULT_LIVES;
		}
	}
	
	public void takeLife() {
		System.out.println("Taking Life:" + lives + " " + health);
		if(lives > 0) {
			lives--;
		} else {
			Game.reset();
		}
	}
}
