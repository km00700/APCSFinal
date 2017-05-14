package com.millstech.game;

import java.util.*;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.*;

import com.millstech.engine.render.*;
import com.millstech.entities.*;
import com.millstech.entities.map.Platform;
import com.millstech.entities.map.Updatable;
import com.millstech.game.control.Controls;
import com.millstech.game.playerinfo.LifeHandler;
import com.millstech.game.story.LevelHandler;
import com.millstech.levels.Level;
import com.millstech.levels.*;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.flags.Player;
//TODO ADD ANIM LIST
public class Game {
	//Private Fields
	private static List<Entity> entityList = new ArrayList<Entity>();
	private static Camera camera;
	private static Light light;
	private static MasterRender renderer;
	private static Level currentLevel;
	private static List<Entity> allEntityList = new ArrayList<Entity>();
	private static List<Updatable> updateList = new ArrayList<Updatable>();
	private static Entity[][] platformList = new Entity[256][11];
	//Public Fields
	public static List<Platform> platforms = new ArrayList<Platform>();
	public static List<Vector3f> platformPos = new ArrayList<Vector3f>();
	public static List<Level> unlocked = new ArrayList<Level>();
	public static ModelLoader loader;
	public static LifeHandler lifeHandler;
	public static LevelHandler levelHandler;
	public static PlayerEntity character;
	
	public static void loop() {
		while(!Display.isCloseRequested()){
            character.move();
            camera.follow(character);
            light.folow(character);
            checkUpdatables();
            currentLevel.update();
            render();
        }
	}
	
	public static void main(String[] args) {
		initialize();
        
		loop();
		
		close();
    }
	
	public static void render() {
		for(Entity e : allEntityList) {
        	renderer.processEntity(e);
        }
        
        renderer.render(light, camera);
        
        DisplayManager.updateDisplay();         
    
	}
	
	public static void initialize() {
		unlocked.add(new LevelOne());
        DisplayManager.createDisplay();
        Controls.initialize();
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
	
	public static void addToGraphicsLayer(Entity e) {
		e.increasePosition(0, 0, 2.2f * GameConstants.LAYER_SPACING);
		allEntityList.add(e);
	}
	
	public static void addToForegroundLayer(Entity e) {
		e.increasePosition(0, 0, 2 * GameConstants.LAYER_SPACING);
		allEntityList.add(e);
	}
	
	public static void addToEntityLayer(Entity e) {
		e.increasePosition(0, 0, GameConstants.LAYER_SPACING);
		allEntityList.add(e);
	}
	
	public static void addToPlatformLayer(Platform p) {
		p.increasePosition(0, 0, 0.0f);
		platforms.add((Platform) p);
		allEntityList.add(p);
	}
	
	public static void addToVisualPlatformLayer(Entity e) {
		e.increasePosition(0, 0, 0.0f);
		allEntityList.add(e);
	}
	
	public static void addToBackgroundLayer(Entity e) {
		e.increasePosition(0, 0, -1 * GameConstants.LAYER_SPACING);
		allEntityList.add(e);
	}
	
	public static void purgeEntities() {
		allEntityList = new ArrayList<Entity>();
		updateList = new ArrayList<Updatable>();
		platforms = new ArrayList<Platform>();
		platformPos = new ArrayList<Vector3f>();
		entityList = new ArrayList<Entity>();
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
	
	public static void setLevel(Level l) {
		currentLevel = l;
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
	
	public static Level getCurrentLevel() {
		return currentLevel;
	}
	
	public static void registerUpdatable(Updatable u) {
		updateList.add(u);
	}
	
	public static void checkUpdatables() {
		for(Updatable u : updateList) {
			u.update();
		}
	}
}
