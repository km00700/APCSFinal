package com.millstech.levels.models;

import com.millstech.levels.TileUtils;
import com.millstech.textures.Textures;

public class Tardis {
	public static void loadTardis(int x, int y) {
		TileUtils.createBGTile(Textures.tardisBottom, x, y);
        TileUtils.createBGTile(Textures.tardisTop, x, y+1);
    }
}
