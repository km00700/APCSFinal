package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.levels.models.Tardis;
import com.millstech.textures.Textures;
import com.millstech.toolbox.MathUtils;
import com.millstech.toolbox.TileUtils;

public class LevelThree implements Level {

	private int spawnX = 3, spawnY = 2;
	private final int CHECKPOINT_X = 53, CHECKPOINT_Y = 4, TARDIS_X = 86, TARDIS_Y = 2;

	@Override
	public void update() {
		// Win Detection
		if (MathUtils.convertToBlockPos(Game.character.getPosition().x) == TARDIS_X
				&& MathUtils.convertToBlockPos(Game.character.getPosition().y) == TARDIS_Y) {
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
	public void loadEntities() {
		//empty - nothing needed
	}

	@Override
	public void loadBackground() {
		Tardis.loadTardis(TARDIS_X, TARDIS_Y);
		TileUtils.createCheckpoint(CHECKPOINT_X, CHECKPOINT_Y);
		//BACKGROUND IMAGE ADD HERE										///////////
	}

	//TODO THIS IS A COMMENT
	
	@Override
	public void loadForeground() {									
		// TODO FOREGROUND

	}

	@Override
	public void onCheckpointTrigger() {	
		spawnX = CHECKPOINT_X;
		spawnY = CHECKPOINT_Y;
	}

	@Override
	public void loadPlatforms() {								
		
		
		
		
		TileUtils.createPlatformBlock(Textures.stone, 0, 0, getMaxX(), 1);
		/*
		 
		TileUtils.createNoInteractionPlatform(Textures.pot, 6, 2);
		
		Column.loadColumn(14,2,3);
		Column.loadColumn(17,2,3);
		
		Decorations.loadBush(25, 2);
		
		
		Decorations.loadFountain(27, 2);
		
		Decorations.loadBush(30, 2);

		TileUtils.createNoInteractionPlatform(Textures.pot, 35, 2);
		
		TileUtils.createNoInteractionPlatform(Textures.pot, 41, 2);
		
		RomanHouse.loadHouse(8,2,1);
		RomanHouse.loadHouse(19,2,2);
		RomanHouse.loadHouse(31,2,3);
		
		Column.loadColumn(39,2,2);

		Aqueduct.loadDuct(42, 2, 1, false);
		
		Aqueduct.loadDuct(46, 2, 7, true);
		
		*/

	}

	@Override
	public void loadOffMap() {											///////////
		//LEFT OF MAP
		TileUtils.createClippablePlatformBlock(Textures.stone, -9, 0, -1, 1);
		//TileUtils.createNoInteractionPlatform(Textures.pot, -1, 2);
		//TileUtils.createNoInteractionPlatform(Textures.pot, -1, 3);
		//TileUtils.createNoInteractionPlatform(Textures.pot, -2, 2);
		
		
		
		//RIGHT OF MAP
		TileUtils.createClippablePlatformBlock(Textures.stone, -9, 0, -1, 1);

	}

	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createCharacter(spawnX, spawnY);
	}

	@Override
	public int getMaxX() {
		return 90;
	}

	@Override
	public void completed() {
		// Game.unlocked.add(new LevelFour());
		Game.nextLevel();
	}

	@Override
	public boolean hasDynamicCamera() {
		return true;
	}

}
