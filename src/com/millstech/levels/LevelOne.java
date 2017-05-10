package com.millstech.levels;

import java.util.*;

import com.millstech.engine.GameLoop;
import com.millstech.entities.PlayerEntity;
import com.millstech.levels.models.Pyramid;
import com.millstech.levels.models.Tardis;
import com.millstech.textures.ModelTexture;

public class LevelOne implements Level {
	public int spawnX = 0, spawnY = 2;
	
	public LevelOne() {
		unloadLevel();
		loadLevel();
	}
	
	public void loadLevel() {
		loadEntities();
		loadBackground();
        loadPlatforms();
        loadForeground();
        loadOffMap();
	}
	
	public void unloadLevel() {
		GameLoop.purgePlayers();
		GameLoop.purgeEntities();
		GameLoop.platformPos = new ArrayList<>();
	}

	@Override
	public PlayerEntity spawn() {
		GameLoop.purgePlayers();
		return TileUtils.createCharacter(spawnX, spawnY);
	}

	@Override
	public void loadBackground() {
		TileUtils.createBGImage(new ModelTexture(GameLoop.loader.loadTexture("bg/template")));
		Tardis.loadTardis(30, 2);
		Pyramid.loadPyramidGroup(11, 2);
   }

	@Override
	public void loadForeground() {
	
	}

	@Override
	public void loadPlatforms() {
		TileUtils.createBlockPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 0, 0, 255, 1);
		TileUtils.createBlockPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 6, 2, 9, 2);
		TileUtils.createBlockPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 8, 3, 9, 3);
		TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 11, 4);
		TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 13, 4);
		TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 16, 3);
	}
	
	@Override
	public void loadEntities() {
		
	}
	
	@Override
	public void loadOffMap() {
		TileUtils.createFGBlock(new ModelTexture(GameLoop.loader.loadTexture("test")), -9, 0, -1, 1);
		TileUtils.createFGBlock(new ModelTexture(GameLoop.loader.loadTexture("test")), 254, 0, 264, 6);
	}
}
