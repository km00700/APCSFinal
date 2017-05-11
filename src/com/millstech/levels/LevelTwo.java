package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.levels.models.Pyramid;
import com.millstech.levels.models.Tardis;
import com.millstech.levels.models.Tree;
import com.millstech.textures.ModelTexture;

public class LevelTwo implements Level {
	public int spawnX = 3, spawnY = 4;
	
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
		TileUtils.createBGImage(new ModelTexture(Game.loader.loadTexture("bg/template")));
	}

	@Override
	public void loadForeground() {
	
	}

	@Override
	public void loadPlatforms() {
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("test")), 0, 0, 255, 1);
	}
	
	@Override
	public void loadEntities() {
		
	}
	
	@Override
	public void loadOffMap() {
		TileUtils.createFGBlock(new ModelTexture(Game.loader.loadTexture("test")), -9, 0, -1, 1);
		TileUtils.createFGBlock(new ModelTexture(Game.loader.loadTexture("test")), 254, 0, 264, 1);
	}
}
