package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.levels.models.*;
import com.millstech.levels.models.egypt.*;
import com.millstech.textures.Textures;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.MathUtils;
import com.millstech.toolbox.TileUtils;
import com.millstech.toolbox.TileUtils.Layer;

public class LevelTwo implements Level {
	public int spawnX = 0, spawnY = 2; //0, 2
	private final int TARDIS_X = 85, TARDIS_Y = 4, CHECKPOINT_X = 47, CHECKPOINT_Y = 4;
	
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
		//TARDIS
		Tardis.loadTardis(TARDIS_X, TARDIS_Y);
		//CHECKPOINT
		TileUtils.createCheckpoint(CHECKPOINT_X, CHECKPOINT_Y);
		//PYRAMIDS
		Pyramid.loadPyramidGroup(48, 2);
	}

	@Override
	public void loadForeground() {
		TileUtils.createFGTile(Textures.egyptHouseDecL, 6, 3);
		TileUtils.createFGBlock(Textures.egypthouseDecC, 7, 3, 11, 3);
		TileUtils.createFGTile(Textures.egyptHouseDecR, 12, 3);
		
		TileUtils.createFGTile(Textures.egyptHouseDecL, 12, 4);
		TileUtils.createFGBlock(Textures.egypthouseDecC, 13, 4, 17, 4);
		TileUtils.createFGTile(Textures.egyptHouseDecR, 18, 4);
		
		TileUtils.createFGTile(Textures.egyptHouseDecL, 26, 3);
		TileUtils.createFGBlock(Textures.egypthouseDecC, 27, 3, 30, 3);
		TileUtils.createFGTile(Textures.egyptHouseDecR, 31, 3);
		
		TileUtils.createFGTile(Textures.egyptHouseDecL, 31, 4);
		TileUtils.createFGBlock(Textures.egypthouseDecC, 32, 4, 35, 4);
		TileUtils.createFGTile(Textures.egyptHouseDecR, 36, 4);
		
		TileUtils.createFGTile(Textures.egyptHouseDecL, 36, 3);
		TileUtils.createFGBlock(Textures.egypthouseDecC, 37, 3, 40, 3);
		TileUtils.createFGTile(Textures.egyptHouseDecR, 41, 3);
		
		Scarab.loadScarab(71, 8);
	}

	@Override
	public void loadPlatforms() {
		//ground
		TileUtils.createPlatformBlock(Textures.sand, 0, 0, 255, 1);
		TileUtils.createPlatformBlock(Textures.sand, 21, 2, 25, 2);
		TileUtils.createPlatformBlock(Textures.sand, 22, 3, 24, 3);
		TileUtils.createNoInteractionPlatform(Textures.sandL, 20, 2);
		TileUtils.createNoInteractionPlatform(Textures.sandL, 21, 3);
		TileUtils.createNoInteractionPlatform(Textures.sandR, 26, 2);
		TileUtils.createNoInteractionPlatform(Textures.sandR, 25, 3);
		
		TileUtils.createPlatformBlock(Textures.sand, 45, 2, 49, 2);
		TileUtils.createPlatformBlock(Textures.sand, 46, 3, 48, 3);
		TileUtils.createNoInteractionPlatform(Textures.sandL, 44, 2);
		TileUtils.createNoInteractionPlatform(Textures.sandL, 45, 3);
		TileUtils.createNoInteractionPlatform(Textures.sandR, 50, 2);
		TileUtils.createNoInteractionPlatform(Textures.sandR, 49, 3);
		
		TileUtils.createPlatformBlock(Textures.sand, 82, 2, 94, 2);
		TileUtils.createPlatformBlock(Textures.sand, 84, 3, 94, 3);
		TileUtils.createNoInteractionPlatform(Textures.sandL, 81, 2);
		TileUtils.createNoInteractionPlatform(Textures.sandL, 83, 3);
		//Pyramid Platform
		TileUtils.createPlatformBlock(Textures.pyramid12,64, 2, 78, 2);
		TileUtils.createPlatformBlock(Textures.pyramid12,65, 3, 77, 3);
		TileUtils.createPlatformBlock(Textures.pyramid12,66, 4, 76, 4);
		TileUtils.createPlatformBlock(Textures.pyramid12,67, 5, 75, 5);
		
		//level elements
		StoneRoller.createStoneRoller(4, 2);
		TileUtils.createClippableJumpablePlatformBlock(Textures.egyptHouseWall, 7, 3, 11, 3);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWall, 7, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWindow, 8, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWallEye, 9, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseDoor, 10, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWall, 11, 2);
		
		TileUtils.createClippableJumpablePlatformBlock(Textures.egyptHouseWall, 13, 4, 17, 4);
		TileUtils.createNoInteractionPlatformBlock(Textures.egyptHouseWall, 13, 3, 17, 3);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWall, 13, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWindow, 14, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseDoor, 15, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWindow, 16, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWall, 17, 2);
		
		TileUtils.createClippableJumpablePlatformBlock(Textures.egyptHouseWall, 27, 3, 30, 3);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWall, 27, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseDoor, 28, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWindow, 29, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWall, 30, 2);
		
		TileUtils.createClippableJumpablePlatformBlock(Textures.egyptHouseWall, 32, 4, 35, 4);
		TileUtils.createNoInteractionPlatformBlock(Textures.egyptHouseWall, 32, 3, 35, 3);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWall, 32, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWallEye, 33, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseDoor, 34, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWall, 35, 2);
		
		TileUtils.createClippableJumpablePlatformBlock(Textures.egyptHouseWall, 37, 3, 40, 3);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWall, 37, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWindow, 38, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseDoor, 39, 2);
		TileUtils.createNoInteractionPlatform(Textures.egyptHouseWall, 40, 2);
		
		Obelisk.createObelisk(42, 2, Layer.PLATFORM);
		
		Obelisk.createObelisk(52, 2, Layer.PLATFORM);
		StoneRoller.createStoneRoller(53, 2);
		StoneRoller.createStoneRoller(57, 2);
		StoneRoller.createStoneRoller(60, 2);
		TileUtils.createTile(Textures.egyptStoneRollerL, 74, 6, 0, Layer.FOREGROUND, true, GameConstants.UNIT);
		TileUtils.createTile(Textures.egyptStoneRollerR, 75, 6, 0, Layer.FOREGROUND, true, GameConstants.UNIT);
	
		TileUtils.createTile(Textures.pyramid10, 63, 2, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid10, 64, 3, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid10, 65, 4, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid10, 66, 5, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid10, 67, 6, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid10, 68, 7, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid10, 69, 8, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid10, 70, 9, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		
		TileUtils.createBlock(Textures.pyramid6, 68, 6, 70, 6, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid9, 71, 6, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createBlock(Textures.pyramid6, 72, 6, 74, 6, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createBlock(Textures.pyramid6, 69, 7, 73, 7, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createBlock(Textures.pyramid6, 70, 8, 72, 8, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid6, 71, 9, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid11, 71, 10, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		
		TileUtils.createTile(Textures.pyramid7, 79, 2, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid7, 78, 3, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid7, 77, 4, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid7, 76, 5, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid7, 75, 6, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid7, 74, 7, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid7, 73, 8, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.pyramid7, 72, 9, 0, Layer.PLATFORM, false, GameConstants.UNIT);
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
		return 85;
	}

	@Override
	public void completed() {
		Game.unlocked.add(new LevelThree());
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
