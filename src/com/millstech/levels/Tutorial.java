package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.levels.models.Tardis;
import com.millstech.textures.Textures;
import com.millstech.toolbox.MathUtils;

public class Tutorial implements Level {

	public final int RETURN_TO_MENU = 15, RETURN_TO_MENU_Y = 4;
	
	@Override
	public void update() {
		if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == RETURN_TO_MENU && MathUtils.convertToBlockPos(Game.character.getPosition().y) == RETURN_TO_MENU_Y) { 
			completed();
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
		TileUtils.createPlatformBlock(Textures.test, 0, 0, 18, 1);
		TileUtils.createPlatformBlock(Textures.test, 12, 2, 27, 2);
		TileUtils.createPlatformBlock(Textures.test, 14, 3, 20, 3);
	}

	@Override
	public void loadOffMap() { 
		TileUtils.createClippablePlatformBlock(Textures.test, -9, 0, -1, 1);
		TileUtils.createClippablePlatformBlock(Textures.test, 19, 0, 27, 1);
	}

	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createScriptedCharacter(0, 2, true, true, true, true);
	}

	@Override
	public int getMaxX() {
		return 18;
	}

	@Override
	public void completed() {
		Game.loadLevel(0);
	}

	@Override
	public void onCheckpointTrigger() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean hasDynamicCamera() {
		return true;
	}
}
