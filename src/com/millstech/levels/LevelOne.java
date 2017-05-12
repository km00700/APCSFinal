package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
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
		//Tardis.loadTardis(35, 2);
	}

	@Override
	public void loadForeground() {
	
	}

	@Override
	public void loadPlatforms() {
		//GROUND
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/dirt")), 0, 0, 255, 0);
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/grass")), 0, 1, 23, 1);
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/grass")), 28, 1, 255, 1);
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/dirt")), 24, 1, 27, 1);
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("ground/grass")), 24, 2, 27, 2);
		
		Tree.loadTreeTrunk(5, 2, 2);
		Tree.loadTreeTop(5, 4, 3, false);
		
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/9")), 8, 4);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/10")), 9, 4);
		Tree.loadTreeTrunk(10, 2, 4);
		Tree.loadTreeTrunk(11, 2, 4);
		Tree.loadBranches(11, 3, 2, Tree.branchSide.RIGHT);
		int centerX = 10;
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
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/8")), centerX+1, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+1, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+1, y+2);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/5")), centerX+2, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+2, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+2, y+2);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/13")), centerX+3, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+3, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+3, y+2);
		
		centerX = 15;
		Tree.loadTreeTrunk(15, 2, 4);
		Tree.loadBranches(15, 5, 2, Tree.branchSide.LEFT);
		Tree.loadBranches(15, 4, 1, Tree.branchSide.RIGHT);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/5")), centerX-1, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX-1, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/8")), centerX, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/5")), centerX+1, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+1, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/6")), centerX+2, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+2, y+1);
		TileUtils.createPlatform(new ModelTexture(Game.loader.loadTexture("rock")), 16, 2);
		
		Tree.loadTreeTrunk(19, 2, 3);
		Tree.loadTreeTop(19, 5, 5, false);
		Tree.loadBranches(19, 3, 1, Tree.branchSide.LEFT);
		Tree.loadBranches(19, 3, 2, Tree.branchSide.RIGHT);
		
		TileUtils.createPlatform(new ModelTexture(Game.loader.loadTexture("rock")), 23, 2);
		
		Tree.loadTreeTrunk(24, 3, 3);
		Tree.loadTreeTrunk(25, 3, 3);
		Tree.loadTreeTop(24, 6, 6, true);
		Tree.loadBranches(24, 4, 2, Tree.branchSide.LEFT);
		Tree.loadBranches(25, 4, 2, Tree.branchSide.RIGHT);
		
		TileUtils.createPlatform(new ModelTexture(Game.loader.loadTexture("rock")), 28, 2);
		
		Tree.loadTreeTrunk(31, 2, 5);
		Tree.loadTreeTrunk(32, 2, 5);
		Tree.loadBranches(31, 3, 2, Tree.branchSide.LEFT);
		Tree.loadBranches(31, 5, 2, Tree.branchSide.LEFT);
		Tree.loadBranches(32, 4, 2, Tree.branchSide.RIGHT);
		Tree.loadTreeTop(31, 7, 6, true);
		
		TileUtils.createPlatform(new ModelTexture(Game.loader.loadTexture("rock")), 35, 2);
		
		Tree.loadTreeTrunk(37, 2, 4);
		Tree.loadBranches(37, 4, 1, Tree.branchSide.LEFT);
		Tree.loadBranches(37, 4, 1, Tree.branchSide.RIGHT);
		centerX = 37;
		y = 6;
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
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/13")), centerX+2, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+2, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+2, y+2);
		
		Tree.loadTreeTrunk(40, 2, 4);
		Tree.loadBranches(40, 3, 1, Tree.branchSide.LEFT);
		centerX = 40;
		y = 6;
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/8")), centerX, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/5")), centerX+1, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+1, y+1);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/6")), centerX+2, y);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+2, y+1);
	
		TileUtils.createPlatform(new ModelTexture(Game.loader.loadTexture("rock")), 42, 2);
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
		
		Tree.loadTreeTrunk(-1, 2, 4);
		Tree.loadTreeTop(-1, 6, 5, true);
		
		Tree.loadTreeTrunk(-4, 2, 2);
		Tree.loadTreeTop(-4, 4, 3, false);
		
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("rock")), -6, 2);
		
		Tree.loadTreeTrunk(-7, 2, 3);
		Tree.loadTreeTop(-7, 5, 5, true);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/9")), -8, 3);
		
		Tree.loadTreeTrunk(-10, 2, 6);
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
