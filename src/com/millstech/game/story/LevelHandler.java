package com.millstech.game.story;

import java.util.*;

import com.millstech.game.Game;
import com.millstech.levels.*;

public class LevelHandler {
	private List<Level> levels = new ArrayList<Level>();
	private int prevLevel = 0;
	public LevelHandler () {
		levels.add(new MainMenu());
		levels.add(new LevelOne());
		levels.add(new LevelTwo());
		levels.add(new LevelThree());
		//levels.add(new LevelFour());
	}
	
	public Level getNextLevel() {
		unloadLevel();
		if(prevLevel + 1 < levels.size()) {
			prevLevel++;	
			return levels.get(prevLevel);
		} else {
			prevLevel = 0;
			return levels.get(0);
		}
	}
	
	public Level getLevel(int levelNum) {
		unloadLevel();
		if(0 < levelNum && (levelNum <= levels.size())) {
			return levels.get(levelNum--);
		} else {
			return levels.get(0);
		}
	}
	
	public void unloadLevel() {
		Game.purgePlayers();
		Game.purgeEntities();
		Game.platformPos = new ArrayList<>();
	}
	
	public Level loadTutorial() {
		unloadLevel();
		return new Tutorial();
	}
	
	public Level loadLevelSelector() {
		unloadLevel();
		return new LevelSelector();
	}
}
