package com.millstech.levels.models;

import com.millstech.engine.GameLoop;
import com.millstech.levels.TileUtils;
import com.millstech.textures.ModelTexture;

public class Tardis {
	public static void loadTardis(int x, int y) {
		TileUtils.createBGTile(new ModelTexture(GameLoop.loader.loadTexture("tardis/bottom")), x, y);
        TileUtils.createBGTile(new ModelTexture(GameLoop.loader.loadTexture("tardis/top")), x, y+1);
    }
}
