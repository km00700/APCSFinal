package com.millstech.levels.models.egypt;

import com.millstech.textures.Textures;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.TileUtils;

public class Obelisk {
	public static void createObelisk(float posX, float posY, TileUtils.Layer layer) {
		TileUtils.createTile(Textures.obeliskBottom, posX, posY, layer, false, GameConstants.UNIT);
		TileUtils.createTile(Textures.obeliskTop, posX, posY + 1, layer, false, GameConstants.UNIT);
	}
}
