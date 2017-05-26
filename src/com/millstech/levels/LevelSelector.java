package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.game.control.Controls;
import com.millstech.levels.models.Tardis;
import com.millstech.textures.Textures;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.MathUtils;
import com.millstech.toolbox.TileUtils;
import com.millstech.toolbox.MathUtils.Coordinate;

public class LevelSelector implements Level {

	public final int LEVEL1 = 2, LEVEL2 = 4, LEVEL3 = 6, LEVEL4 = 8, LEVEL5 = 10;
	
	@Override
	public void update() {
		if(Controls.attack()) {
			if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == LEVEL1 && Game.unlocked.size() >= 1 && Game.unlocked.get(0) instanceof LevelOne) {
				Game.loadLevel(1);
			}
			
			if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == LEVEL2 && Game.unlocked.size() >= 2 && Game.unlocked.get(1) instanceof LevelTwo) {
				Game.loadLevel(2);
			}
			
			if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == LEVEL3 && Game.unlocked.size() >= 3 && Game.unlocked.get(2) instanceof LevelThree) {
				Game.loadLevel(3);
			}
			if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == LEVEL4 && Game.unlocked.size() >= 4) {
				Game.loadLevel(4);
			}
			if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == LEVEL5 && Game.unlocked.size() >= 5) {
				Game.loadLevel(5);
			}
			if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == LEVEL5 && Game.unlocked.size() >= 6) {
				Game.loadLevel(6);
			}
			if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == LEVEL5 && Game.unlocked.size() >= 7) {
				Game.loadLevel(7);
			}
			if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == LEVEL5 && Game.unlocked.size() >= 8) {
				Game.loadLevel(8);
			}
		}
	}
	
	@Override
	public void loadLevel() {
		loadEntities();
		loadBackground();
        loadPlatforms();
        loadForeground();
        loadOffMap();
        Game.getCamera().setTilePosition(9 * GameConstants.UNIT, Coordinate.X);
        Game.getLight().setTilePosition(9 * GameConstants.UNIT, Coordinate.X);
	}

	@Override
	public void loadEntities() { }

	@Override
	public void loadBackground() { 
		Tardis.loadTardis(2, 2);
		Tardis.loadTardis(4, 2);
		Tardis.loadTardis(6, 2);
		Tardis.loadTardis(8, 2);
		Tardis.loadTardis(10, 2);
		Tardis.loadTardis(12, 2);
		Tardis.loadTardis(14, 2);
		Tardis.loadTardis(16, 2);
		TileUtils.createBGSplashTile(Textures.menu, 9.08f, 2.5f);
	}
		
	@Override
	public void loadForeground() {
		TileUtils.createFGTile(Textures.num1_white, 2, 1);
		TileUtils.createFGTile(Textures.num2_white, 4, 1);
		TileUtils.createFGTile(Textures.num3_white, 6, 1);
		TileUtils.createFGTile(Textures.num4_white, 8, 1);
		TileUtils.createFGTile(Textures.num5_white, 10, 1);
		TileUtils.createFGTile(Textures.num6_white, 12, 1);
		TileUtils.createFGTile(Textures.num7_white, 14, 1);
		TileUtils.createFGTile(Textures.num8_white, 16, 1);
	}

	@Override
	public void loadPlatforms() { 
		TileUtils.createPlatformBlock(Textures.metalGrate, 0, 0, 18, 1);
	}

	@Override
	public void loadOffMap() { }

	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createScriptedCharacter(9, 2, true, true, false, true);
	}

	@Override
	public int getMaxX() {
		return 18;
	}

	@Override
	public void completed() { }

	@Override
	public void onCheckpointTrigger() { }

	@Override
	public boolean hasDynamicCamera() {
		return false;
	}
}
