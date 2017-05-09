package com.millstech.levels;

import java.util.*;

import com.millstech.engine.GameLoop;
import com.millstech.entities.PlayerEntity;
import com.millstech.textures.ModelTexture;

public class LevelOne implements Level {
	public LevelOne() {
		unloadLevel();
		loadLevel();
	}
	
	public void loadLevel() {
		loadEntities();
		loadBackground();
        loadPlatforms();
        loadForeground();
	}
	
	public void unloadLevel() {
		GameLoop.purgePlayers();
		GameLoop.purgeEntities();
		GameLoop.platformPos = new ArrayList<>();
	}

	@Override
	public PlayerEntity spawn() {
		return TileUtils.createCharacter(-2, 0);
	}

	@Override
	public void loadBackground() {
		TileUtils.createBGTile(new ModelTexture(GameLoop.loader.loadTexture("tardis_top")), 0, 1);
        TileUtils.createBGTile(new ModelTexture(GameLoop.loader.loadTexture("tardis_bottom")), 0, 0);
    }

	@Override
	public void loadForeground() {
	
	}

	@Override
	public void loadPlatforms() {
		TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), -5, -1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), -4, -1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), -3, -1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), -2, -1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), -1, -1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 0, -1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 1, -1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 2, -1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 3, -1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 4, -1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 5, -1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 3, 0);
        //TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 4, 1);
        TileUtils.createPlatform(new ModelTexture(GameLoop.loader.loadTexture("test")), 5, 1);
	}

	@Override
	public void loadEntities() {
	
	}
}
