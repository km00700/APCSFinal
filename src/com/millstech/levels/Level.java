package com.millstech.levels;

import com.millstech.entities.PlayerEntity;

public interface Level {
	public void loadLevel();
	public void loadEntities();
	public void loadBackground();
	public void loadForeground();
	public void loadPlatforms();
	public void loadOffMap();
	public void unloadLevel();
	public PlayerEntity spawn();
}
