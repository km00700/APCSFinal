package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.levels.models.Tardis;
import com.millstech.levels.models.Tree;
import com.millstech.textures.Textures;
import com.millstech.toolbox.MathUtils;

public class LevelOne implements Level {
	private int spawnX = 2, spawnY = 2;
	private final int CHECKPOINT_X = 52, CHECKPOINT_Y = 4, TARDIS_X = 81, TARDIS_Y = 2;
	
	@Override
	public void update() {
		//Win Detection
		if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == TARDIS_X && MathUtils.convertToBlockPos(Game.character.getPosition().y) == TARDIS_Y) {
			completed();
		}
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
		//TARDIS
		Tardis.loadTardis(81, 2);
		//CHECKPOINT
		TileUtils.createCheckpoint(52, 4);
		//BACKGROUND IMAGE
		TileUtils.createBGImage(Textures.level1);
	}

	@Override
	public void loadForeground() {
	
	}

	@Override
	public void loadPlatforms() {
		//GROUND
		TileUtils.createPlatformBlock(Textures.dirt, 0, 0, 66, 0);
		TileUtils.createPlatformBlock(Textures.grass, 0, 1, 23, 1);
		TileUtils.createClippablePlatformBlock(Textures.dirt, 24, 1, 27, 1);
		TileUtils.createPlatformBlock(Textures.grass, 24, 2, 27, 2);
		TileUtils.createPlatformBlock(Textures.grass, 28, 1, 44, 1);
		TileUtils.createPlatformBlock(Textures.grass, 45, 2, 46, 2);
		TileUtils.createPlatform(Textures.grass, 50, 2);
		TileUtils.createPlatformBlock(Textures.grass, 47, 3, 49, 3);
		TileUtils.createPlatformBlock(Textures.dirt, 47, 2, 49, 2);
		TileUtils.createPlatformBlock(Textures.dirt, 45, 1, 50, 1);
		TileUtils.createPlatformBlock(Textures.dirt, 51, 1, 53, 1);
		TileUtils.createPlatformBlock(Textures.grass, 54, 1, 67, 1);
		TileUtils.createPlatformBlock(Textures.stone, 67, 0, 94, 0);
		TileUtils.createPlatformBlock(Textures.stone, 68, 1, 94, 1);
		TileUtils.createPlatformBlock(Textures.stone, 74, 2, 75, 2);
		
		TileUtils.createAnimatedFGBlock(Textures.waterLAnim, 51, 0, 51, 1, 10);
		TileUtils.createAnimatedFGBlock(Textures.waterAnim, 52, 0, 52, 1, 10);
		TileUtils.createAnimatedFGBlock(Textures.waterRAnim, 53, 0, 53, 1, 10);
		
		//SCENERY
		Tree.loadTreeTrunk(5, 2, 2);
		Tree.loadTreeTop(5, 4, 3, false);
		
		TileUtils.createNoInteractionPlatform(Textures.tree9, 8, 4);
		TileUtils.createNoInteractionPlatform(Textures.tree10, 9, 4);
		Tree.loadTreeTrunk(10, 2, 4);
		Tree.loadTreeTrunk(11, 2, 4);
		Tree.loadBranches(11, 3, 2, Tree.branchSide.RIGHT);
		int centerX = 10;
		int y = 6;
		TileUtils.createNoInteractionPlatform(Textures.tree7, centerX-2, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX-2, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree3, centerX-2, y+2);
		TileUtils.createNoInteractionPlatform(Textures.tree5, centerX-1, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX-1, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX-1, y+2);
		TileUtils.createNoInteractionPlatform(Textures.tree8, centerX, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+2);
		TileUtils.createNoInteractionPlatform(Textures.tree8, centerX+1, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+1, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+1, y+2);
		TileUtils.createNoInteractionPlatform(Textures.tree5, centerX+2, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+2, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+2, y+2);
		TileUtils.createNoInteractionPlatform(Textures.tree13, centerX+3, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+3, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree4, centerX+3, y+2);
		
		centerX = 15;
		Tree.loadTreeTrunk(15, 2, 4);
		Tree.loadBranches(15, 5, 2, Tree.branchSide.LEFT);
		Tree.loadBranches(15, 4, 1, Tree.branchSide.RIGHT);
		TileUtils.createNoInteractionPlatform(Textures.tree13, centerX-1, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX-1, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree8, centerX, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree5, centerX+1, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+1, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree6, centerX+2, y);
		TileUtils.createNoInteractionPlatform(Textures.tree4, centerX+2, y+1);
		TileUtils.createPlatform(Textures.rock, 16, 2);
		
		Tree.loadTreeTrunk(19, 2, 3);
		Tree.loadTreeTop(19, 5, 5, false);
		Tree.loadBranches(19, 3, 1, Tree.branchSide.LEFT);
		Tree.loadBranches(19, 3, 2, Tree.branchSide.RIGHT);
		
		TileUtils.createPlatform(Textures.rock, 23, 2);
		
		Tree.loadTreeTrunk(24, 3, 3);
		Tree.loadTreeTrunk(25, 3, 3);
		Tree.loadTreeTop(24, 6, 6, true);
		Tree.loadBranches(24, 4, 2, Tree.branchSide.LEFT);
		Tree.loadBranches(25, 4, 2, Tree.branchSide.RIGHT);
		
		TileUtils.createPlatform(Textures.rock, 28, 2);
		
		Tree.loadTreeTrunk(31, 2, 5);
		Tree.loadTreeTrunk(32, 2, 5);
		Tree.loadBranches(31, 3, 2, Tree.branchSide.LEFT);
		Tree.loadBranches(31, 5, 2, Tree.branchSide.LEFT);
		Tree.loadBranches(32, 4, 2, Tree.branchSide.RIGHT);
		Tree.loadTreeTop(31, 7, 6, true);
		
		TileUtils.createPlatform(Textures.rock, 35, 2);
		
		Tree.loadTreeTrunk(37, 2, 4);
		Tree.loadBranches(37, 4, 1, Tree.branchSide.LEFT);
		Tree.loadBranches(37, 4, 1, Tree.branchSide.RIGHT);
		centerX = 37;
		y = 6;
		TileUtils.createNoInteractionPlatform(Textures.tree7, centerX-2, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX-2, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree3, centerX-2, y+2);
		TileUtils.createNoInteractionPlatform(Textures.tree5, centerX-1, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX-1, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX-1, y+2);
		TileUtils.createNoInteractionPlatform(Textures.tree8, centerX, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+2);
		TileUtils.createNoInteractionPlatform(Textures.tree5, centerX+1, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+1, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+1, y+2);
		TileUtils.createNoInteractionPlatform(Textures.tree13, centerX+2, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+2, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree4, centerX+2, y+2);
		
		Tree.loadTreeTrunk(40, 2, 4);
		Tree.loadBranches(40, 3, 1, Tree.branchSide.LEFT);
		centerX = 40;
		y = 6;
		TileUtils.createNoInteractionPlatform(Textures.tree8, centerX, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree5, centerX+1, y);
		TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+1, y+1);
		TileUtils.createNoInteractionPlatform(Textures.tree6, centerX+2, y);
		TileUtils.createNoInteractionPlatform(Textures.tree4, centerX+2, y+1);
	
		TileUtils.createPlatform(Textures.rock, 42, 2);
		TileUtils.createPlatformBlock(Textures.log, 50, 3, 54, 3);
		TileUtils.createPlatform(Textures.rock, 54, 2);
		TileUtils.createPlatform(Textures.tree1, 55, 2);
		
		Tree.loadTreeTrunk(59, 2, 5);
		Tree.loadTreeTrunk(60, 2, 5);
		Tree.loadBranches(59, 5, 2, Tree.branchSide.LEFT);
		Tree.loadBranches(60, 4, 2, Tree.branchSide.RIGHT);
		Tree.loadTreeTop(59, 7, 6, true);
		
		Tree.loadTreeTrunk(65, 2, 4);
		Tree.loadTreeTrunk(66, 2, 4);
		Tree.loadTreeTop(65, 6, 4, false);
		
		TileUtils.createPlatform(Textures.rock, 71, 2);
		TileUtils.createClippableJumpablePlatformBlock(Textures.stoneLedge, 76, 3, 77, 3);
		TileUtils.createClippableJumpablePlatformBlock(Textures.stoneLedge, 78, 4, 79, 4);
		TileUtils.createClippableJumpablePlatformBlock(Textures.stoneLedge, 80, 5, 81, 5);
		//UL
		TileUtils.createNoInteractionPlatform(Textures.stoneUL, 68, 6);
		TileUtils.createNoInteractionPlatform(Textures.stoneUL, 72, 8);
		TileUtils.createNoInteractionPlatform(Textures.stoneUL, 75, 10);
		//DR
		TileUtils.createNoInteractionPlatform(Textures.stoneDR, 71, 4);
		TileUtils.createNoInteractionPlatform(Textures.stoneDR, 74, 6);
		//DL
		TileUtils.createNoInteractionPlatform(Textures.stoneDL, 68, 4);
		//DR INSIDE
		TileUtils.createNoInteractionPlatform(Textures.stoneULI, 71, 7);
		TileUtils.createNoInteractionPlatform(Textures.stoneULI, 74, 9);
		//UL INSIDE
		TileUtils.createNoInteractionPlatform(Textures.stoneDRI, 72, 5);
		TileUtils.createNoInteractionPlatform(Textures.stoneDRI, 75, 7);
		//CAVE INTERIOR
		TileUtils.createNoInteractionPlatformBlock(Textures.stone, 69, 4, 70, 4);
		TileUtils.createNoInteractionPlatformBlock(Textures.stone, 68, 5, 71, 5);
		TileUtils.createNoInteractionPlatformBlock(Textures.stone, 69, 6, 73, 6);
		TileUtils.createNoInteractionPlatformBlock(Textures.stone, 72, 7, 74, 7);
		TileUtils.createNoInteractionPlatformBlock(Textures.stone, 73, 8, 94, 8);
		TileUtils.createNoInteractionPlatformBlock(Textures.stone, 75, 9, 94, 9);
		TileUtils.createNoInteractionPlatformBlock(Textures.stone, 76, 10, 94, 10);
		
		
	}
	
	@Override
	public void loadEntities() {
		
	}
	
	@Override
	public void loadOffMap() {
		//GROUND
		TileUtils.createClippablePlatformBlock(Textures.dirt, -9, 0, -1, 0);
		TileUtils.createClippablePlatformBlock(Textures.grass, -9, 1, -1, 1);
		TileUtils.createClippablePlatformBlock(Textures.dirt, 254, 0, 264, 0);
		TileUtils.createClippablePlatformBlock(Textures.grass, 254, 1, 264, 1);
		
		//LEFT OF MAP
		TileUtils.createNoInteractionPlatform(Textures.tree11, 0, 4);
		TileUtils.createNoInteractionPlatform(Textures.tree12, 1, 4);
		
		Tree.loadTreeTrunk(-1, 2, 4);
		Tree.loadTreeTop(-1, 6, 5, true);
		
		Tree.loadTreeTrunk(-4, 2, 2);
		Tree.loadTreeTop(-4, 4, 3, false);
		
		TileUtils.createNoInteractionPlatform(Textures.rock, -6, 2);
		
		Tree.loadTreeTrunk(-7, 2, 3);
		Tree.loadTreeTop(-7, 5, 5, true);
		TileUtils.createNoInteractionPlatform(Textures.tree9, -8, 3);
		
		Tree.loadTreeTrunk(-10, 2, 6);
		Tree.loadTreeTop(-10, 8, 5, true);
		
		//RIGHT OF MAP
	}

	@Override
	public int getMaxX() {
		return 85;
	}

	@Override
	public void completed() {
		Game.unlocked.add(new LevelTwo());
		Game.nextLevel();
	}

	@Override
	public void onCheckpointTrigger() {
		spawnX = CHECKPOINT_X;
		spawnY = CHECKPOINT_Y;
	}
	
	@Override
	public boolean hasDynamicCamera() {
		return true;
	}
}
