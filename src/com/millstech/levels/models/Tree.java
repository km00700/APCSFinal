package com.millstech.levels.models;

import com.millstech.game.Game;
import com.millstech.levels.TileUtils;
import com.millstech.textures.ModelTexture;

public class Tree {
	public static enum branchSide {
		LEFT, RIGHT;
	}
	
	public static void loadTreeTop(int centerX, int y, int size) {
		if(size == 5) {
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/7")), centerX-2, y);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/3")), centerX-2, y+1);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/5")), centerX-1, y);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX-1, y+1);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/8")), centerX, y);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX, y+1);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/5")), centerX+1, y);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+1, y+1);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/6")), centerX+2, y);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+2, y+1);
		} else {
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/7")), centerX-1, y);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/3")), centerX-1, y+1);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/8")), centerX, y);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX, y+1);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/6")), centerX+1, y);
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+1, y+1);
		}
	}
	
	public static void loadTreeTrunk(int x, int y, int height, int clippableLevel) {
		for(int i = y; i < y + height; i++) {
			if(i == y || i == y + (clippableLevel-1)) {
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/1")), x, i); //NoInteraction
			} else {
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/1")), x, i); //Interaction
			}
		}
	}
	
	public static void loadBranches(int centerX, int y, int length, branchSide side) {
		if(side == branchSide.LEFT) {
			if(length == 1) {
				TileUtils.createClippablePlatform(new ModelTexture(Game.loader.loadTexture("tree/9")), centerX - 1, y);
			} else {
				TileUtils.createClippablePlatform(new ModelTexture(Game.loader.loadTexture("tree/9")), centerX - 2, y);
				TileUtils.createClippablePlatform(new ModelTexture(Game.loader.loadTexture("tree/10")), centerX - 1, y);
			}
		} else {
			if(length == 1) {
				TileUtils.createClippablePlatform(new ModelTexture(Game.loader.loadTexture("tree/12")), centerX + 1, y);
			} else {
				TileUtils.createClippablePlatform(new ModelTexture(Game.loader.loadTexture("tree/11")), centerX + 1, y);
				TileUtils.createClippablePlatform(new ModelTexture(Game.loader.loadTexture("tree/12")), centerX + 2, y);
			}
		}
	}
	
	
}
