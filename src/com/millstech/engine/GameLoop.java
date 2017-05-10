package com.millstech.engine;

import java.util.*;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.*;

import com.millstech.engine.render.*;
import com.millstech.entities.*;
import com.millstech.game.control.Controls;
import com.millstech.levels.Level;
import com.millstech.levels.*;
import com.millstech.toolbox.Map;
import com.millstech.toolbox.flags.Player;

public class GameLoop {
	
	private static List<Entity> entityList = new ArrayList<Entity>();
	private static List<Entity> backgroundList = new ArrayList<Entity>();
	private static List<Entity> foregroundList = new ArrayList<Entity>();
	public static List<Vector3f> platformPos = new ArrayList<Vector3f>();
	public static Entity[][] platformList = new Entity[256][11];
	
	public static ModelLoader loader;
	private static Camera camera;
	private static Light light;
	private static MasterRender renderer;
	private static Level currentLevel;
	private static PlayerEntity character;
	
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
        
		currentLevel = new LevelOne();
        character = currentLevel.spawn();
        
        //currentLevel = new LevelTwo();
        //character = currentLevel.spawn();
        
        loop();
 
        renderer.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
 
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
        loader = new ModelLoader();
        camera = new Camera(0.0f, 1.25f * Map.UNIT, 0.0f);
        light = new Light(new Vector3f(0, 0, 0), new Vector3f(1, 1, 1));
        renderer = new MasterRender();
	}
	
	public static void addToFGList(Entity e) {
		e.increasePosition(0, 0, 0.06f);
		foregroundList.add(e);
	}
	
	public static void addToEntityList(Entity e) {
		e.increasePosition(0, 0, 0.03f);
		entityList.add(e);
	}
	
	public static void addToPlatformList(Entity e) {
		e.increasePosition(0, 0, 0.0f);
		foregroundList.add(e);
	}
	
	public static void addToBGList(Entity e) {
		e.increasePosition(0, 0, -0.03f);
		backgroundList.add(e);
	}
	
	public static void purgeEntities() {
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
}
