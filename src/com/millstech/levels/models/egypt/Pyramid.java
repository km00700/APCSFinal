package com.millstech.levels.models.egypt;

import com.millstech.game.Game;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.TileUtils;

public class Pyramid {
	public static void loadPyramid(int height, int blX, int blY) {
		if(height == 1) {
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/5")), blX, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/7")), blX + 1, blY);
		} else if(height == 2) {
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/0")), blX, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/4")), blX + 1, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/6")), blX + 2, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/7")), blX + 3, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/5")), blX + 1, blY + 1);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/7")), blX + 2, blY + 1);
		} else if(height == 3) {
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/0")), blX, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/1")), blX + 1, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/3")), blX + 2, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/6")), blX + 3, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/6")), blX + 4, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/7")), blX + 5, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/0")), blX + 1, blY + 1);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/4")), blX + 2, blY + 1);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/6")), blX + 3, blY + 1);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/7")), blX + 4, blY + 1);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/5")), blX + 2, blY + 2);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/7")), blX + 3, blY + 2);
		} else if(height == 4) {
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/0")), blX, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/1")), blX + 1, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/1")), blX + 2, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/2")), blX + 3, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/6")), blX + 4, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/6")), blX + 5, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/6")), blX + 6, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/7")), blX + 7, blY);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/0")), blX + 1, blY + 1);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/1")), blX + 2, blY + 1);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/3")), blX + 3, blY + 1);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/6")), blX + 4, blY + 1);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/6")), blX + 5, blY + 1);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/7")), blX + 6, blY + 1);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/0")), blX + 2, blY + 2);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/4")), blX + 3, blY + 2);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/6")), blX + 4, blY + 2);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/7")), blX + 5, blY + 2);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/5")), blX + 3, blY + 3);
			TileUtils.createBGTile(new ModelTexture(Game.loader.loadTexture("pyramid/7")), blX + 4, blY + 3);
		}
	}
	
	public static void loadPyramidGroup(int PosX, int PosY) {
		loadPyramid(3, PosX + 10, PosY);
        loadPyramid(4, PosX + 3, PosY);
        loadPyramid(2, PosX, PosY);
	}
}
