package com.millstech.levels.models;

import com.millstech.textures.Textures;
import com.millstech.toolbox.TileUtils;

public class Tardis {
	public static void loadTardis(int x, int y) {
		TileUtils.createBGTile(Textures.tardisBottom, x, y);
        TileUtils.createBGTile(Textures.tardisTop, x, y+1);
    }
}
