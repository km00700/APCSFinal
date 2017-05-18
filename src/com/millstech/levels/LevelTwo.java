package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.levels.models.*;
import com.millstech.levels.models.egypt.*;
import com.millstech.textures.Textures;
import com.millstech.toolbox.MathUtils;
import com.millstech.toolbox.TileUtils;

public class LevelTwo implements Level {
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
		//TileUtils.createBGImage(Textures.level2);
	}

	@Override
	public void loadForeground() {
	
	}

	@Override
	public void loadPlatforms() {
		TileUtils.createPlatformBlock(Textures.sand, 0, 0, 255, 1);
	}
	
	@Override
	public void loadEntities() {
		
	}
	
	@Override
	public void loadOffMap() {
		//GROUND
		TileUtils.createFGBlock(Textures.sand, -9, 0, -1, 1);
		TileUtils.createFGBlock(Textures.sand, 254, 0, 264, 1);
		//LEFT OF MAP
		
		//RIGHT OF MAP
		
	}

	@Override
	public int getMaxX() {
		return 255;
	}

	@Override
	public void completed() {
		Game.unlocked.add(new LevelThree());
		Game.nextLevel();
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
