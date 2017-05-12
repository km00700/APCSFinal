package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.levels.models.Pyramid;
import com.millstech.levels.models.Tardis;
import com.millstech.levels.models.Tree;
import com.millstech.textures.ModelTexture;

public class LevelOne implements Level {
	public int spawnX = 2, spawnY = 2;
	
	@Override
	public void update() {
		// TODO Entity Handling
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
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createCharacter(spawnX, spawnY);
	}

	@Override
	public void loadBackground() {
		TileUtils.createBGImage(new ModelTexture(Game.loader.loadTexture("bg/l1")));
		Tardis.loadTardis(35, 2);
	}

	@Override
	public void loadForeground() {
	
	}

	@Override
	public void loadPlatforms() {
		//GROUND
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/dirt")), 0, 0, 255, 0);
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/grass")), 0, 1, 255, 1);
		
		
	}
	
	@Override
	public void loadEntities() {
		
	}
	
	@Override
	public void loadOffMap() {
		//GROUND
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/dirt")), -9, 0, -1, 0);
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/grass")), -9, 1, -1, 1);
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/dirt")), 254, 0, 264, 0);
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/grass")), 254, 1, 264, 1);
		
		//LEFT OF MAP
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/11")), 0, 4);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/12")), 1, 4);
		
		Tree.loadTreeTrunk(-1, 2, 4, 3);
		Tree.loadTreeTop(-1, 6, 5, true);
		
		Tree.loadTreeTrunk(-4, 2, 2, 3);
		Tree.loadTreeTop(-4, 4, 3, false);
		
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("rock")), -6, 2);
		
		Tree.loadTreeTrunk(-7, 2, 3, 3);
		Tree.loadTreeTop(-7, 5, 5, true);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/9")), -8, 3);
		
		Tree.loadTreeTrunk(-10, 2, 6, 3);
		Tree.loadTreeTop(-10, 8, 5, true);
		
		//RIGHT OF MAP
	}

	@Override
	public int getMaxX() {
		return 255;
	}

	@Override
	public void completed() {
		Game.unlocked.add(new LevelTwo());
		Game.nextLevel();
	}
}
