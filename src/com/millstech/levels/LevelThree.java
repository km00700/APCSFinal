package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.levels.models.Tardis;
import com.millstech.toolbox.MathUtils;
import com.millstech.toolbox.TileUtils;

public class LevelThree implements Level {

	private int spawnX = 3, spawnY = 2;
	private final int CHECKPOINT_X = 52, CHECKPOINT_Y = 4, TARDIS_X = 86, TARDIS_Y = 2;

	@Override
	public void update() {
		// Win Detection
		if (MathUtils.convertToBlockPos(Game.character.getPosition().x) == TARDIS_X
				&& MathUtils.convertToBlockPos(Game.character.getPosition().y) == TARDIS_Y) {
			completed();
		}
	}

	@Override
	public void loadLevel() {
		loadEntities();
		loadBackground();
		loadPlatforms();
		loadForeground();
		loadOffMap();
	}

	@Override
	public void loadEntities() {
		//empty - nothing needed
	}

	@Override
	public void loadBackground() {
		Tardis.loadTardis(TARDIS_X, TARDIS_Y);
		TileUtils.createCheckpoint(CHECKPOINT_X, CHECKPOINT_Y);
		//BACKGROUND IMAGE ADD HERE										///////////
	}

	@Override
	public void loadForeground() {									
		// TODO FOREGROUND

	}

	@Override
	public void onCheckpointTrigger() {	
		spawnX = CHECKPOINT_X;
		spawnY = CHECKPOINT_Y;
	}

	@Override
	public void loadPlatforms() {										///////////
		// TODO Auto-generated method stub

	}

	@Override
	public void loadOffMap() {											///////////
		// TODO Auto-generated method stub

	}

	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createCharacter(spawnX, spawnY);
	}

	@Override
	public int getMaxX() {
		return 90;
	}

	@Override
	public void completed() {
		// Game.unlocked.add(new LevelFour());
		Game.nextLevel();
	}

	@Override
	public boolean hasDynamicCamera() {
		return true;
	}

}
