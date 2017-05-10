package com.millstech.levels;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.engine.GameLoop;
import com.millstech.engine.render.OBJLoader;
import com.millstech.entities.Entity;
import com.millstech.entities.PlayerEntity;
import com.millstech.entities.map.Platform;
import com.millstech.models.RawModel;
import com.millstech.models.TexturedModel;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.Map;

public class TileUtils {
	public static PlayerEntity createCharacter(int posX, int posY) {
		PlayerEntity character = new PlayerEntity(new TexturedModel(OBJLoader.loadObjModel("tile", GameLoop.loader), new ModelTexture(GameLoop.loader.loadTexture("char/char_standingL"))), new Vector3f(posX * Map.UNIT, posY * Map.UNIT, -10.0f), 0, 270, 0, Map.UNIT);
        GameLoop.addToEntityList(character);
        return character;
	}
	
	public static void removeCharacter() {
		GameLoop.purgePlayers();
	}
	
	public static Entity createFGTile(ModelTexture t, int posX, int posY) {
		RawModel model;
		model = OBJLoader.loadObjModel("tile", GameLoop.loader);
	    Entity e = new Entity(new TexturedModel(model, t), new Vector3f(posX * Map.UNIT, posY * Map.UNIT, -10.0f), 0, 270, 0, Map.UNIT);
	    GameLoop.addToFGList(e);
        return e;
	}
	
	public static Entity createBGTile(ModelTexture t, int posX, int posY) {
		RawModel model;
		model = OBJLoader.loadObjModel("tile", GameLoop.loader);
	    Entity e = new Entity(new TexturedModel(model, t), new Vector3f(posX * Map.UNIT, posY * Map.UNIT, -10.0f), 0, 270, 0, Map.UNIT);
	    GameLoop.addToBGList(e);
        return e;
	}
	
	public static Entity createBGImage(ModelTexture t) {
		RawModel model;
		model = OBJLoader.loadObjModel("bg", GameLoop.loader);
	    Entity e = new Entity(new TexturedModel(model, t), new Vector3f(256 * Map.UNIT, 0 * Map.UNIT, -10.3f), 0, 270, 0, 2 * Map.UNIT);
	    GameLoop.addToBGList(e);
        return e;
	}
	
	public static Platform createPlatform(ModelTexture t, int posX, int posY) {
		RawModel model;
		GameLoop.platformPos.add(new Vector3f(posX * Map.UNIT, posY * Map.UNIT, 0));
	    model = OBJLoader.loadObjModel("tile", GameLoop.loader);
	    Platform p = new Platform(new TexturedModel(model, t), new Vector3f(posX * Map.UNIT, posY * Map.UNIT, -10.0f), 0, 270, 0, Map.UNIT);
	    GameLoop.addToPlatformList(p);
	    GameLoop.registerPlatform(posX, posY, p);
	    return p;
	}
	
	public static void createBlockPlatform(ModelTexture t, int minX, int minY, int maxX, int maxY) {
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				createPlatform(t, i, j);
			}
		}
	}
	
	public static void createFGBlock(ModelTexture t, int minX, int minY, int maxX, int maxY) {
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				createFGTile(t, i, j);
			}
		}
	}
	
	public static void createBGBlock(ModelTexture t, int minX, int minY, int maxX, int maxY) {
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				createBGTile(t, i, j);
			}
		}
	}
}
