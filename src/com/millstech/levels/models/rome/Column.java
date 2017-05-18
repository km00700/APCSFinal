package com.millstech.levels.models.rome;

import com.millstech.textures.Textures;
import com.millstech.toolbox.TileUtils;

public class Column {
	public static void loadColumn(int posX, int posY, int height) {
		if(height == 2) {
			TileUtils.createNoInteractionPlatform(Textures.column1, posX, posY);
			TileUtils.createPlatform(Textures.column3, posX, posY + 1);
		} else if(height == 3) {
			TileUtils.createNoInteractionPlatform(Textures.column1, posX, posY);
			TileUtils.createNoInteractionPlatform(Textures.column2, posX, posY + 1);
			TileUtils.createPlatform(Textures.column3, posX, posY + 2);
		} else if(height == 4) {
			TileUtils.createNoInteractionPlatform(Textures.column1, posX, posY);
			TileUtils.createNoInteractionPlatform(Textures.column2, posX, posY + 1);
			TileUtils.createNoInteractionPlatform(Textures.column2, posX, posY + 2);
			TileUtils.createPlatform(Textures.column3, posX, posY + 3);
		} else if(height == 5) {
			TileUtils.createNoInteractionPlatform(Textures.column1, posX, posY);
			TileUtils.createNoInteractionPlatform(Textures.column2, posX, posY + 1);
			TileUtils.createNoInteractionPlatform(Textures.column2, posX, posY + 2);
			TileUtils.createNoInteractionPlatform(Textures.column2, posX, posY + 3);
			TileUtils.createPlatform(Textures.column3, posX, posY + 4);
		}
	}
}
