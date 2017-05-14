package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.levels.models.Tardis;
import com.millstech.textures.Textures;
import com.millstech.toolbox.MathUtils;

public class LevelThree implements Level {
	public int spawnX = 3, spawnY = 4;
	private final int TARDIS_X = 81, TARDIS_Y = 2;
	
	@Override
	public void update() {
		//Win Detection
		if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == TARDIS_X && MathUtils.convertToBlockPos(Game.character.getPosition().y) == TARDIS_Y) {
			completed();
		}
		// TODO Entity Handling
		
	}
	
	public void loadLevel() {
		loadEntities();
		loadBackground();
        loadPlatforms();
        loadForeground();
        loadOffMap();
	}
	
	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createCharacter(spawnX, spawnY);
	}

	@Override
	public void loadBackground() {
		Tardis.loadTardis(81, 2);
		//TileUtils.createBGImage(Textures.level3);
	}

	@Override
	public void loadForeground() {
	
	}

	@Override
	public void loadPlatforms() {
		//GROUND
		TileUtils.createPlatformBlock(Textures.test, 0, 0, 255, 1);
		//SCENENERY
		
	}
	
	@Override
	public void loadEntities() {
		
	}
	
	@Override
	public void loadOffMap() {
		TileUtils.createFGBlock(Textures.test, -9, 0, -1, 1);
		TileUtils.createFGBlock(Textures.test, 254, 0, 264, 1);
	}

	@Override
	public int getMaxX() {
		return 255;
	}

	@Override
	public void completed() {
		// TODO LEVEL 4
		//Game.unlocked.add(new LevelFour());
		Game.nextLevel();
	}

	@Override
	public void onCheckpointTrigger() {
		// TODO Auto-generated method stub
	}
}
