package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.game.control.Controls;
import com.millstech.levels.models.Tardis;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.GameConstants;

public class Tutorial implements Level {

	public final int RETURN_TO_MENU = 15, RETURN_TO_MENU_Y = 4;
	
	@Override
	public void update() {
		if(Controls.attack()) { 
			if(Math.rint(Game.character.getPosition().x / GameConstants.UNIT) == RETURN_TO_MENU && Math.rint(Game.character.getPosition().y / GameConstants.UNIT) == RETURN_TO_MENU_Y) {
				Game.loadLevel(0);
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
		Tardis.loadTardis(15, 4);
	}
		
	@Override
	public void loadForeground() {
		// TODO Auto-generated method stub
	}

	@Override
	public void loadPlatforms() { 
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("test")), 0, 0, 18, 1);
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("test")), 12, 2, 27, 2);
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("test")), 14, 3, 20, 3);
	}

	@Override
	public void loadOffMap() { 
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("test")), -9, 0, -1, 1);
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("test")), 19, 0, 27, 1);
	}

	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createScriptedCharacter(0, 2, false, true, true, true);
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
