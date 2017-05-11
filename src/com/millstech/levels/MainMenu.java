package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;

public class MainMenu implements Level {

	@Override
	public void loadLevel() { }

	@Override
	public void loadEntities() { }

	@Override
	public void loadBackground() { }

	@Override
	public void loadForeground() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadPlatforms() { }

	@Override
	public void loadOffMap() { }

	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createScriptedCharacter(0, 0);
	}

}
