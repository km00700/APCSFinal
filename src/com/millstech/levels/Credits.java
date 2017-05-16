package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.textures.Textures;

public class Credits implements Level {
	public int spawnX = 3, spawnY = 4, counter = 0, counterMax = 1500;
	
	@Override
	public void update() {
		counter++;
		if(counter > counterMax) {
			Game.loadLevel(0);
		}
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
		return TileUtils.createScriptedCharacter(spawnX, spawnY, false, false, false, false);
	}

	@Override
	public void loadBackground() {
		TileUtils.createBGImage(Textures.level1);
	}

	@Override
	public void loadForeground() {
		TileUtils.createMovingTile(Textures.test, 1, 0, 0.0f, 0.006f, TileUtils.Layer.FOREGROUND);
		TileUtils.createMovingTile(Textures.test, 2, 0, 0.0f, 0.006f, TileUtils.Layer.FOREGROUND);
		TileUtils.createMovingTile(Textures.test, 3, 0, 0.0f, 0.006f, TileUtils.Layer.FOREGROUND);
		TileUtils.createMovingTile(Textures.test, 4, 0, 0.0f, 0.006f, TileUtils.Layer.FOREGROUND);
		TileUtils.createMovingTile(Textures.test, 5, 0, 0.0f, 0.006f, TileUtils.Layer.FOREGROUND);
	}

	@Override
	public void loadPlatforms() {
	
	}
	
	@Override
	public void loadEntities() {
		
	}
	
	@Override
	public void loadOffMap() {}

	@Override
	public int getMaxX() {
		return 255;
	}

	@Override
	public void completed() {
		// TODO LEVEL 4
		//Game.unlocked.add(new LevelFour());
	}

	@Override
	public void onCheckpointTrigger() { }

	@Override
	public boolean hasDynamicCamera() {
		return true;
	}
}
