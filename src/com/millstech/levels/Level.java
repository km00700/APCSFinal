package com.millstech.levels;

import com.millstech.entities.PlayerEntity;

public interface Level {
	public void loadLevel();
	public void unloadLevel();
	public PlayerEntity spawn();
}
