package com.millstech.levels.models.rome;

public class Decorations {

	public void createBush(int posX, int posY)
	{
		TileUtils.createNoInteractionPlatform(Textures.bush1, posX, posY);
		TileUtils.createNoInteractionPlatform(Textures.bush2, posX, posY + 1);
	}
	public void createFountain(int posX, int posY)
	{
		TileUtils.createPlatform(Textures.fountain1, posX, posY);
		TileUtils.createNoInteractionPlatform(Textures.fountain2, posX, posY + 1);
		TileUtils.createPlatform(Textures.fountain3, posX + 1, posY);
		TileUtils.createNoInteractionPlatform(Textures.fountain4, posX + 1, posY + 1);
	}
	
}
