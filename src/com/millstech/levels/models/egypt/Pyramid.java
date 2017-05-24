package com.millstech.levels.models.egypt;

import com.millstech.textures.Textures;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.TileUtils;
import com.millstech.toolbox.TileUtils.Layer;

public class Pyramid {
	public static void loadPyramid(int height, int blX, int blY) {
		if(height == 1) {
			TileUtils.createTile(Textures.pyramid5, blX, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid7, blX + 1, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
		} else if(height == 2) {
			TileUtils.createTile(Textures.pyramid0, blX, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid4, blX + 1, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid6, blX + 2, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid7, blX + 3, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid5, blX + 1, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid7, blX + 2, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
		} else if(height == 3) {
			TileUtils.createTile(Textures.pyramid0, blX, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid1, blX + 1, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid3, blX + 2, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid6, blX + 3, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid6, blX + 4, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid7, blX + 5, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid0, blX + 1, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid4, blX + 2, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid6, blX + 3, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid7, blX + 4, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid5, blX + 2, blY + 2, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid7, blX + 3, blY + 2, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
		} else if(height == 4) {
			TileUtils.createTile(Textures.pyramid0, blX, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid1, blX + 1, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid1, blX + 2, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid2, blX + 3, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid6, blX + 4, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid6, blX + 5, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid6, blX + 6, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid7, blX + 7, blY, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid0, blX + 1, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid1, blX + 2, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid3, blX + 3, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid6, blX + 4, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid6, blX + 5, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid7, blX + 6, blY + 1, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid0, blX + 2, blY + 2, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid4, blX + 3, blY + 2, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid6, blX + 4, blY + 2, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid7, blX + 5, blY + 2, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid5, blX + 3, blY + 3, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
			TileUtils.createTile(Textures.pyramid7, blX + 4, blY + 3, -10.03f, Layer.BACKGROUND, false, GameConstants.UNIT);
		}
	}
	
	public static void loadPyramidGroup(int posX, int posY) {
		loadPyramid(3, posX + 10, posY);
        loadPyramid(4, posX + 3, posY);
        loadPyramid(2, posX, posY);
	}
}
