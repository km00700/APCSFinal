package com.millstech.levels.models.egypt;

import com.millstech.textures.Textures;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.TileUtils;
import com.millstech.toolbox.TileUtils.Layer;

public class Scarab {
	public static void loadScarab(int posX, int posY) {
		TileUtils.createTile(Textures.scarab1, posX, posY + 1, -GameConstants.LAYER_SPACING - 10, Layer.FOREGROUND, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.scarab2, posX -1, posY, -GameConstants.LAYER_SPACING - 10, Layer.FOREGROUND, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.scarab3, posX, posY, -GameConstants.LAYER_SPACING - 10, Layer.FOREGROUND, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.scarab4, posX + 1, posY, -GameConstants.LAYER_SPACING - 10, Layer.FOREGROUND, false, GameConstants.UNIT);
	}
}
