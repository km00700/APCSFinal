package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.levels.models.Pyramid;
import com.millstech.levels.models.Tardis;
import com.millstech.levels.models.Tree;
import com.millstech.textures.ModelTexture;

public class LevelOne implements Level {
	public int spawnX = 0, spawnY = 2;
	
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
		//TileUtils.createBGImage(new ModelTexture(GameLoop.loader.loadTexture("bg/template")));
		Tardis.loadTardis(30, 2);
		Pyramid.loadPyramidGroup(11, 2);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("sand/endL")), 5, 2);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("sand/endL")), 7, 3);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("sand/endR")), 9, 3);
		TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("sand/endR")), 10, 2);
	}

	@Override
	public void loadForeground() {
	
	}

	@Override
	public void loadPlatforms() {
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("sand/sand")), 0, 0, 255, 1);
		TileUtils.createClippablePlatformBlock(new ModelTexture(Game.loader.loadTexture("sand/sand")), 6, 2, 9, 2);
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("sand/sand")), 8, 3, 8, 3);
		TileUtils.createPlatformBlock(new ModelTexture(Game.loader.loadTexture("rock")), 35, 2, 40, 2);
		
		Tree.loadTreeTrunk(33, 2, 3, 3);
		Tree.loadTreeTop(33, 5, 3);
		Tree.loadBranches(33, 3, 1, Tree.branchSide.LEFT);
	}
	
	@Override
	public void loadEntities() {
		
	}
	
	@Override
	public void loadOffMap() {
		TileUtils.createFGBlock(new ModelTexture(Game.loader.loadTexture("sand/sand")), -9, 0, -1, 1);
		TileUtils.createFGBlock(new ModelTexture(Game.loader.loadTexture("sand/sand")), 254, 0, 264, 1);
	}
}
