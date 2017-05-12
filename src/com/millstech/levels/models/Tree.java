package com.millstech.levels.models;

import com.millstech.game.Game;
import com.millstech.levels.TileUtils;
import com.millstech.textures.ModelTexture;

public class Tree {
	public static enum branchSide {
		LEFT, RIGHT;
	}
	
	public static void loadTreeTop(int centerX, int y, int size, boolean tall) {
		if(!tall) {
			if (size == 6) {
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/7")), centerX-2, y);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/3")), centerX-2, y+1);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/5")), centerX-1, y);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX-1, y+1);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/8")), centerX, y);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX, y+1);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/8")), centerX+1, y);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+1, y+1);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/5")), centerX+2, y);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+2, y+1);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/6")), centerX+3, y);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+3, y+1);
			} else if(size == 5) {
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
		} else {
			if (size == 6) {
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
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/6")), centerX+3, y);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+3, y+1);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+3, y+2);
			} else if(size == 5) {
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
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/6")), centerX+2, y);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+2, y+1);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+2, y+2);
			} else {
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/7")), centerX-1, y);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX-1, y+1);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/3")), centerX-1, y+2);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/8")), centerX, y);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX, y+1);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX, y+2);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/6")), centerX+1, y);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/2")), centerX+1, y+1);
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/4")), centerX+1, y+2);
			}
		}
	}
	
	public static void loadTreeTrunk(int x, int y, int height) {
		for(int i = y; i < y + height; i++) {
			TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/1")), x, i); //Interaction
		}
	}
	
	public static void loadClippableTreeTrunk(int x, int y, int height, int clippableLevel) {
		for(int i = y; i < y + height; i++) {
			if(i == y || i == y + (clippableLevel-1)) {
				TileUtils.createNoInteractionPlatform(new ModelTexture(Game.loader.loadTexture("tree/1")), x, i); //NoInteraction
			} else {
				TileUtils.createPlatform(new ModelTexture(Game.loader.loadTexture("tree/1")), x, i); //Interaction
			}
		}
	}
	
	public static void loadBranches(int centerX, int y, int length, branchSide side) {
		if(side == branchSide.LEFT) {
			if(length == 1) {
				TileUtils.createClippableJumpablePlatform(new ModelTexture(Game.loader.loadTexture("tree/9")), centerX - 1, y);
			} else {
				TileUtils.createClippableJumpablePlatform(new ModelTexture(Game.loader.loadTexture("tree/9")), centerX - 2, y);
				TileUtils.createClippableJumpablePlatform(new ModelTexture(Game.loader.loadTexture("tree/10")), centerX - 1, y);
			}
		} else {
			if(length == 1) {
				TileUtils.createClippableJumpablePlatform(new ModelTexture(Game.loader.loadTexture("tree/12")), centerX + 1, y);
			} else {
				TileUtils.createClippableJumpablePlatform(new ModelTexture(Game.loader.loadTexture("tree/11")), centerX + 1, y);
				TileUtils.createClippableJumpablePlatform(new ModelTexture(Game.loader.loadTexture("tree/12")), centerX + 2, y);
			}
		}
	}
	
	
}