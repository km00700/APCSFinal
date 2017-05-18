package com.millstech.levels.models.rome;

import com.millstech.textures.Textures;
import com.millstech.toolbox.TileUtils;

public class Aqueduct {
	public static void loadSegment(int posX, int posY, int height) {
		if(height == 3) {
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY);
			TileUtils.createNoInteractionPlatform(Textures.duct2, posX, posY + 1);
			TileUtils.createPlatform(Textures.duct3, posX, posY + 2);
			TileUtils.createPlatform(Textures.duct4, posX + 1, posY + 2);
		} else if(height == 4) {
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY);
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY + 1);
			TileUtils.createNoInteractionPlatform(Textures.duct2, posX, posY + 2);
			TileUtils.createPlatform(Textures.duct3, posX, posY + 3);
			TileUtils.createPlatform(Textures.duct4, posX + 1, posY + 3);
		} else if(height == 5) {
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY);
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY + 1);
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY + 2);
			TileUtils.createNoInteractionPlatform(Textures.duct2, posX, posY + 3);
			TileUtils.createPlatform(Textures.duct3, posX, posY + 4);
			TileUtils.createPlatform(Textures.duct4, posX + 1, posY + 4);
		}
	}
	
	public static void loadEnd(int posX, int posY, int height) {
		if(height == 3) {
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY);
			TileUtils.createNoInteractionPlatform(Textures.duct2, posX, posY + 1);
			TileUtils.createPlatform(Textures.duct3, posX, posY + 2);
		} else if(height == 4) {
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY);
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY + 1);
			TileUtils.createNoInteractionPlatform(Textures.duct2, posX, posY + 2);
			TileUtils.createPlatform(Textures.duct3, posX, posY + 3);
		} else if(height == 5) {
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY);
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY + 1);
			TileUtils.createNoInteractionPlatform(Textures.duct1, posX, posY + 2);
			TileUtils.createNoInteractionPlatform(Textures.duct2, posX, posY + 3);
			TileUtils.createPlatform(Textures.duct3, posX, posY + 4);
		}
	}
	
	public static void loadDuct(int posX, int posY, int height, int numSegments, boolean hasEnd) {
		for(int i = 0; i < numSegments; i++) {
			loadSegment(posX + 2 * i, posY, height);
		}
		
		if(hasEnd) loadEnd(posX + 2 * numSegments, posY, height);
	}
}
