package com.millstech.levels.models.prehistoric;

import com.millstech.textures.Textures;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.TileUtils;
import com.millstech.toolbox.TileUtils.Layer;

public class Boulder {
	public static void loadBoulder(int posX, int posY) {
		TileUtils.createTile(Textures.boulder1, posX, posY, 0, Layer.PLATFORM, true, GameConstants.UNIT);
		TileUtils.createTile(Textures.boulder2, posX + 1, posY, 0, Layer.PLATFORM, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.boulder3, posX, posY + 1, 0, Layer.PLATFORM, true, GameConstants.UNIT);
		TileUtils.createTile(Textures.boulder4, posX + 1, posY + 1, 0, Layer.PLATFORM, false, GameConstants.UNIT);
	}
}
