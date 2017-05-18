package com.millstech.levels.models;

import com.millstech.levels.TileUtils;
import com.millstech.textures.Textures;

public class Tree {
	public static enum branchSide {
		LEFT, RIGHT;
	}
	
	public static void loadTreeTop(int centerX, int y, int size, boolean tall) {
		if(!tall) {
			if (size == 6) {
				TileUtils.createNoInteractionPlatform(Textures.tree7, centerX-2, y);
				TileUtils.createNoInteractionPlatform(Textures.tree3, centerX-2, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree5, centerX-1, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX-1, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree8, centerX, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree8, centerX+1, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+1, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree5, centerX+2, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+2, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree6, centerX+3, y);
				TileUtils.createNoInteractionPlatform(Textures.tree4, centerX+3, y+1);
			} else if(size == 5) {
				TileUtils.createNoInteractionPlatform(Textures.tree7, centerX-2, y);
				TileUtils.createNoInteractionPlatform(Textures.tree3, centerX-2, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree5, centerX-1, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX-1, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree8, centerX, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree5, centerX+1, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+1, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree6, centerX+2, y);
				TileUtils.createNoInteractionPlatform(Textures.tree4, centerX+2, y+1);
			} else if(size == 4) {
				TileUtils.createNoInteractionPlatform(Textures.tree7, centerX-1, y);
				TileUtils.createNoInteractionPlatform(Textures.tree3, centerX-1, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree8, centerX, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree8, centerX+1, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+1, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree6, centerX+2, y);
				TileUtils.createNoInteractionPlatform(Textures.tree4, centerX+2, y+1);
			} else {
				TileUtils.createNoInteractionPlatform(Textures.tree7, centerX-1, y);
				TileUtils.createNoInteractionPlatform(Textures.tree3, centerX-1, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree8, centerX, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree6, centerX+1, y);
				TileUtils.createNoInteractionPlatform(Textures.tree4, centerX+1, y+1);
			}
		} else {
			if (size == 6) {
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
				TileUtils.createNoInteractionPlatform(Textures.tree6, centerX+3, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+3, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree4, centerX+3, y+2);
			} else if(size == 5) {
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
				TileUtils.createNoInteractionPlatform(Textures.tree6, centerX+2, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+2, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree4, centerX+2, y+2);
			} else {
				TileUtils.createNoInteractionPlatform(Textures.tree7, centerX-1, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX-1, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree3, centerX-1, y+2);
				TileUtils.createNoInteractionPlatform(Textures.tree8, centerX, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX, y+2);
				TileUtils.createNoInteractionPlatform(Textures.tree6, centerX+1, y);
				TileUtils.createNoInteractionPlatform(Textures.tree2, centerX+1, y+1);
				TileUtils.createNoInteractionPlatform(Textures.tree4, centerX+1, y+2);
			}
		}
	}
	
	public static void loadTreeTrunk(int x, int y, int height) {
		for(int i = y; i < y + height; i++) {
			TileUtils.createNoInteractionPlatform(Textures.tree1, x, i); //Interaction
		}
	}
	
	public static void loadClippableTreeTrunk(int x, int y, int height, int clippableLevel) {
		for(int i = y; i < y + height; i++) {
			if(i == y || i == y + (clippableLevel-1)) {
				TileUtils.createNoInteractionPlatform(Textures.tree1, x, i); //NoInteraction
			} else {
				TileUtils.createPlatform(Textures.tree1, x, i); //Interaction
			}
		}
	}
	
	public static void loadBranches(int centerX, int y, int length, branchSide side) {
		if(side == branchSide.LEFT) {
			if(length == 1) {
				TileUtils.createClippableJumpablePlatform(Textures.tree9, centerX - 1, y);
			} else {
				TileUtils.createClippableJumpablePlatform(Textures.tree9, centerX - 2, y);
				TileUtils.createClippableJumpablePlatform(Textures.tree10, centerX - 1, y);
			}
		} else {
			if(length == 1) {
				TileUtils.createClippableJumpablePlatform(Textures.tree12, centerX + 1, y);
			} else {
				TileUtils.createClippableJumpablePlatform(Textures.tree11, centerX + 1, y);
				TileUtils.createClippableJumpablePlatform(Textures.tree12, centerX + 2, y);
			}
		}
	}
	
	
}
