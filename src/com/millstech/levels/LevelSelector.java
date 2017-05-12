package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.game.control.Controls;
import com.millstech.levels.models.Tardis;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.GameConstants;

public class LevelSelector implements Level {

	public final int LEVEL1 = 2, LEVEL2 = 4, LEVEL3 = 6, LEVEL4 = 8, LEVEL5 = 10;
	
	@Override
	public void update() {
		if(Controls.attack()) {
			if(Math.rint(Game.character.getPosition().x / GameConstants.UNIT) == LEVEL1 && Game.unlocked.get(0) instanceof LevelOne) {
				Game.loadLevel(1);
			}
			
			if(Math.rint(Game.character.getPosition().x / GameConstants.UNIT) == LEVEL2 && Game.unlocked.get(0) instanceof LevelTwo) {
				Game.loadLevel(2);
			}
			
			if(Math.rint(Game.character.getPosition().x / GameConstants.UNIT) == LEVEL3) {
				Game.loadLevel(3);
			}
			if(Math.rint(Game.character.getPosition().x / GameConstants.UNIT) == LEVEL4) {
				Game.loadLevel(4);
			}
			if(Math.rint(Game.character.getPosition().x / GameConstants.UNIT) == LEVEL5) {
				Game.loadLevel(5);
			}
		}
	}
	
	@Override
	public void loadLevel() {
		loadEntities();
		loadBackground();
        loadPlatforms();
        loadForeground();
        loadOffMap();
	}

	@Override
	public void loadEntities() { }

	@Override
	public void loadBackground() { 
		Tardis.loadTardis(2, 2);
		Tardis.loadTardis(4, 2);
		Tardis.loadTardis(6, 2);
		Tardis.loadTardis(8, 2);
		Tardis.loadTardis(10, 2);
		Tardis.loadTardis(12, 2);
		Tardis.loadTardis(14, 2);
		Tardis.loadTardis(16, 2);
	}
		
	@Override
	public void loadForeground() {
		// TODO Auto-generated method stub
	}

	@Override
	public void loadPlatforms() { 
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/sand/sand")), 0, 0, 18, 1);
	}

	@Override
	public void loadOffMap() { 
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("missing")), -9, 0, -1, 1);
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("missing")), 19, 0, 27, 1);
	}

	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createScriptedCharacter(9, 2, false, true, false, true);
	}

	@Override
	public int getMaxX() {
		return 18;
	}

	@Override
	public void completed() {
		// TODO Auto-generated method stub
		
	}

}
