package com.millstech.levels.models.egypt;

import com.millstech.textures.Textures;
import com.millstech.toolbox.TileUtils;

public class StoneRoller {
	public static void createStoneRoller(int posX, int posY) {
		TileUtils.createPlatform(Textures.egyptStoneRollerL, posX, posY);
		TileUtils.createPlatform(Textures.egyptStoneRollerR, posX+1, posY);
	}
}
