package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.levels.models.*;
import com.millstech.textures.ModelTexture;

public class TestLevel implements Level {
	public int spawnX = 3, spawnY = 4;
	
	@Override
	public void update() {
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
		TileUtils.createBGImage(new ModelTexture(Game.loader.loadTexture("bg/template")));
	}

	@Override
	public void loadForeground() {
	
	}

	@Override
	public void loadPlatforms() {
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("test")), 0, 0, 255, 1);
		
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/sand/sand")), 6, 2, 9, 2);
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/sand/sand")), 8, 3, 8, 3);
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("rock")), 38, 2, 40, 2);
		
		TileUtils.createPlatform(new ModelTexture(Game.loader.loadTexture("rock")), 29, 2);
		
		
		Tree.loadTreeTrunk(32, 2, 4);
		//Tree.loadTreeTop(32, 6, 5, true);
		Tree.loadBranches(32, 3, 1, Tree.branchSide.RIGHT);
		
		int centerX = 32;
		int y = 6;
		
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/7")), centerX-2, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX-2, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/3")), centerX-2, y+2);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/5")), centerX-1, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX-1, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX-1, y+2);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/8")), centerX, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX, y+2);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/5")), centerX+1, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+1, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+1, y+2);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/5")), centerX+2, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+2, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+2, y+2);
		
		centerX = 35;
		
		Tree.loadTreeTrunk(35, 2, 4);
		//Tree.loadTreeTop(35, 6, 3, false);
		Tree.loadBranches(35, 2, 1, Tree.branchSide.LEFT);
		
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/8")), centerX, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/6")), centerX+1, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+1, y+1);
		
		//Tree.loadBranches(33, 3, 2, Tree.branchSide.LEFT);
		//Tree.loadBranches(34, 3, 2, Tree.branchSide.RIGHT);
	}
	
	@Override
	public void loadEntities() {
		
	}
	
	@Override
	public void loadOffMap() {
		TileUtils.createFGBlock(new ModelTexture(Game.loader.loadTexture("test")), -9, 0, -1, 1);
		TileUtils.createFGBlock(new ModelTexture(Game.loader.loadTexture("test")), 254, 0, 264, 1);
	}

	@Override
	public int getMaxX() {
		return 255;
	}

	@Override
	public void completed() {
		// TODO LEVEL 4
		//Game.unlocked.add(new LevelFour());
	}
}
