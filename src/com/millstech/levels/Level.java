package com.millstech.levels;

import com.millstech.entities.PlayerEntity;

public interface Level {
	public void update();
	public void loadLevel();
	public void loadEntities();
	public void loadBackground();
	public void loadForeground();
	public void onCheckpointTrigger();
	public void loadPlatforms();
	public void loadOffMap();
	public PlayerEntity spawn();
	public int getMaxX();
	public void completed();
}
