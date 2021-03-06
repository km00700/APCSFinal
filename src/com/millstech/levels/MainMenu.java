package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.game.control.Controls;
import com.millstech.levels.models.Tardis;
import com.millstech.textures.Textures;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.MathUtils;
import com.millstech.toolbox.TileUtils;
import com.millstech.toolbox.MathUtils.Coordinate;

public class MainMenu implements Level {

	public final int TUTORIAL = 2, LEVEL_SELECTION = 9, CREDITS = 16;
	
	@Override
	public void update() {
		if(Controls.attack()) {
			if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == TUTORIAL) {
				Game.setLevel(Game.levelHandler.loadTutorial());
			}
			if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == LEVEL_SELECTION) {
				Game.setLevel(Game.levelHandler.loadLevelSelector());
			}
			if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == CREDITS) {
				Game.setLevel(Game.levelHandler.loadCredits());
				//Game.loadLevel(1);
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
        Game.getCamera().setTilePosition(9 * GameConstants.UNIT, Coordinate.X);
        Game.getLight().setTilePosition(9 * GameConstants.UNIT, Coordinate.X);
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
		TileUtils.createPlatformBlock(Textures.test, 0, 0, 18, 1);
	}

	@Override
	public void loadOffMap() { }

	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createScriptedCharacter(9, 2, true, true, false, true);
	}

	@Override
	public int getMaxX() {
		return 18;
	}

	@Override
	public void completed() {}

	@Override
	public void onCheckpointTrigger() { }

	@Override
	public boolean hasDynamicCamera() {
		return false;
	}
}
