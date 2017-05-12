package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.game.control.Controls;
import com.millstech.levels.models.Tardis;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.GameConstants;

public class MainMenu implements Level {

	public final int TUTORIAL = 2, LEVEL_SELECTION = 9, CREDITS = 16;
	
	@Override
	public void update() {
		if(Controls.attack()) {
			if(Math.rint(Game.character.getPosition().x / GameConstants.UNIT) == TUTORIAL) {
				Game.setLevel(Game.levelHandler.loadTutorial());
			}
			if(Math.rint(Game.character.getPosition().x / GameConstants.UNIT) == LEVEL_SELECTION) {
				Game.setLevel(Game.levelHandler.loadLevelSelector());
			}
			if(Math.rint(Game.character.getPosition().x / GameConstants.UNIT) == CREDITS) {
				//SET CREDITS Game.setLevel(Game.levelHandler.loadLevelSelector());
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
		Tardis.loadTardis(9, 2);
		Tardis.loadTardis(16, 2);
	}
		
	@Override
	public void loadForeground() {
		// TODO Auto-generated method stub
	}

	@Override
	public void loadPlatforms() { 
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("test")), 0, 0, 18, 1);
	}

	@Override
	public void loadOffMap() { 
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("missing")), -9, 0, -1, 1);
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("missing")), 19, 0, 27, 1);
	}

	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createScriptedCharacter(9, 2, false, true, true, true);
	}

	@Override
	public int getMaxX() {
		return 18;
	}

	@Override
	public void completed() {}

}
