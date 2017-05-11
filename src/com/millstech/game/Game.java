package com.millstech.game;

import java.util.*;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.*;

import com.millstech.engine.render.*;
import com.millstech.entities.*;
import com.millstech.game.control.Controls;
import com.millstech.game.playerinfo.LifeHandler;
import com.millstech.game.story.LevelHandler;
import com.millstech.levels.Level;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.flags.Player;

public class Game {
	public static List<Entity> allEntityList = new ArrayList<Entity>();
	private static List<Entity> entityList = new ArrayList<Entity>();
	private static List<Entity> backgroundList = new ArrayList<Entity>();
	private static List<Entity> foregroundList = new ArrayList<Entity>();
	public static List<Vector3f> platformPos = new ArrayList<Vector3f>();
	public static Entity[][] platformList = new Entity[256][11];
	
	public static ModelLoader loader;
	private static LifeHandler lifeHandler;
	private static LevelHandler levelHandler;
	private static Camera camera;
	private static Light light;
	private static MasterRender renderer;
	private static Level currentLevel;
	public static PlayerEntity character;
	
	public static void loop() {
		while(!Display.isCloseRequested()){
            character.move();
            camera.follow(character);
            light.folow(character);
            render();
        }
	}
	
	public static void main(String[] args) {
		initialize();
        
		loop();
		
		close();
    }
	
	public static void render() {
		for(Entity e : backgroundList) {
        	renderer.processEntity(e);
        }
        
        for(Entity e : entityList) {
        	renderer.processEntity(e);
        }
        
        for(Entity e : foregroundList) {
        	renderer.processEntity(e);
        }
        
        renderer.render(light, camera);
        
        DisplayManager.updateDisplay();         
    
	}
	
	public static void initialize() {
		Controls.initialize();
        DisplayManager.createDisplay();
        reset();
	}
	
	public static void reset() {
		loader = new ModelLoader();
        camera = new Camera(0.0f, 1.25f * GameConstants.UNIT, 0.0f);
        light = new Light(new Vector3f(0, 0, 0), new Vector3f(1, 1, 1));
        renderer = new MasterRender();
        levelHandler = new LevelHandler();
        lifeHandler = new LifeHandler();
        loadLevel(0);
	}
	
	public static void addToFGList(Entity e) {
		e.increasePosition(0, 0, 2 * GameConstants.LAYER_SPACING);
		foregroundList.add(e);
		allEntityList.add(e);
	}
	
	public static void addToEntityList(Entity e) {
		e.increasePosition(0, 0, GameConstants.LAYER_SPACING);
		entityList.add(e);
		allEntityList.add(e);
	}
	
	public static void addToPlatformList(Entity e) {
		e.increasePosition(0, 0, 0.0f);
		foregroundList.add(e);
		allEntityList.add(e);
	}
	
	public static void addToBGList(Entity e) {
		e.increasePosition(0, 0, -1 * GameConstants.LAYER_SPACING);
		backgroundList.add(e);
		allEntityList.add(e);
	}
	
	public static void purgeEntities() {
		allEntityList = new ArrayList<Entity>();
		entityList = new ArrayList<Entity>();
		backgroundList = new ArrayList<Entity>();
		foregroundList = new ArrayList<Entity>();
		platformList = new Entity[256][11];
	}
	
	public static void purgePlayers() {
		for(int i = 0; i < entityList.size(); i++) {
			if(entityList.get(i) instanceof Player)
				entityList.remove(i);
				i--;
		}
	}

	public static void registerPlatform(int posX, int posY, Entity e) {
		platformList[posX][posY + 2] = e;
	}
	
	public static boolean isPlatformAtLocation(int x, int y) { 
		if(platformList[Math.max(x, 0)][Math.max(y - 2, 0)] != null) return true;
		else return false;
	}
	
	public static Entity getPlatformAtLocation(int x, int y) {
		return platformList[Math.max(x, 0)][Math.max(y - 2, 0)];
	}
	
	public static void spawn() {
		character = currentLevel.spawn();
	}
	
	public static void nextLevel() {
		currentLevel = levelHandler.getNextLevel();
        currentLevel.loadLevel();
		character = currentLevel.spawn();
	}
	
	public static void loadLevel(int lNum) {
		currentLevel = levelHandler.getLevel(lNum);
        currentLevel.loadLevel();
		character = currentLevel.spawn();
	}
	
	public static void close() {
		renderer.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
	}
	
	public static void damage() {
		lifeHandler.takeDamage();
	}
	
	public static void kill() {
		lifeHandler.takeLife();
	}
}
