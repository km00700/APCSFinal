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
		//levels.add(new LevelFive());
	}
	
	public Level getNextLevel() {
		unloadLevel();
		if(prevLevel < levels.size() - 1) {
			prevLevel++;
			return levels.get(prevLevel);
		} else {
			prevLevel = -1;
			return levels.get(0);
		}
	}
	
	public Level getLevel(int levelIndex) {
		unloadLevel();
		if(0 <= levelIndex && (levelIndex < levels.size())) {
			prevLevel = levelIndex;
			return levels.get(levelIndex);
		} else {
			prevLevel = 0;
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
	
	public Level loadCredits() {
		unloadLevel();
		return new Credits();
	}
	
	public Level loadLevelSelector() {
		unloadLevel();
		return new LevelSelector();
	}
}
