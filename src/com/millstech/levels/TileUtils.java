package com.millstech.levels;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.engine.render.OBJLoader;
import com.millstech.entities.Entity;
import com.millstech.entities.PlayerEntity;
import com.millstech.entities.map.Platform;
import com.millstech.game.Game;
import com.millstech.models.RawModel;
import com.millstech.models.TexturedModel;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.GameConstants;

public class TileUtils {
	public static PlayerEntity createCharacter(int posX, int posY) {
		PlayerEntity character = new PlayerEntity(new TexturedModel(OBJLoader.loadObjModel("tile", Game.loader), new ModelTexture(Game.loader.loadTexture("char/char_standingL"))), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
        Game.addToEntityList(character);
        return character;
	}
	
	public static PlayerEntity createScriptedCharacter(int posX, int posY) {
		PlayerEntity character = new PlayerEntity(new TexturedModel(OBJLoader.loadObjModel("tile", Game.loader), new ModelTexture(Game.loader.loadTexture("char/char_standingL"))), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT, true);
        Game.addToEntityList(character);
        return character;
	}
	
	public static void removeCharacter() {
		Game.purgePlayers();
	}
	
	public static Entity createFGTile(ModelTexture t, int posX, int posY) {
		RawModel model;
		model = OBJLoader.loadObjModel("tile", Game.loader);
	    Entity e = new Entity(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
	    Game.addToFGList(e);
        return e;
	}
	
	public static Entity createBGTile(ModelTexture t, int posX, int posY) {
		RawModel model;
		model = OBJLoader.loadObjModel("tile", Game.loader);
	    Entity e = new Entity(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
	    Game.addToBGList(e);
        return e;
	}
	
	public static Entity createBGImage(ModelTexture t) {
		RawModel model;
		model = OBJLoader.loadObjModel("bg", Game.loader);
	    Entity e = new Entity(new TexturedModel(model, t), new Vector3f(256 * GameConstants.UNIT, 0 * GameConstants.UNIT, -10.003f), 0, 270, 0, 2 * GameConstants.UNIT, true);
	    e.increasePosition(0, 0, -10 * GameConstants.LAYER_SPACING);
	    Game.addToBGList(e);
        return e;
	}
	
	public static Platform createPlatform(ModelTexture t, int posX, int posY) {
		RawModel model;
		Game.platformPos.add(new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, 0));
	    model = OBJLoader.loadObjModel("tile", Game.loader);
	    Platform p = new Platform(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
	    Game.addToPlatformList(p);
	    Game.registerPlatform(posX, posY, p);
	    return p;
	}
	
	public static Platform createClippablePlatform(ModelTexture t, int posX, int posY) {
		RawModel model;
		Game.platformPos.add(new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, 0));
	    model = OBJLoader.loadObjModel("tile", Game.loader);
	    Platform p = new Platform(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
	    Game.addToPlatformList(p);
	    return p;
	}
	
	public static Entity createNoInteractionPlatform(ModelTexture t, int posX, int posY) {
		RawModel model;
		model = OBJLoader.loadObjModel("tile", Game.loader);
	    Entity p = new Entity(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
	    Game.addToPlatformList(p);
	    return p;
	}
	
	public static void createPlatformBlock(ModelTexture t, int minX, int minY, int maxX, int maxY) {
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				createPlatform(t, i, j);
			}
		}
	}
	
	public static void createClippablePlatformBlock(ModelTexture t, int minX, int minY, int maxX, int maxY) {
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				createClippablePlatform(t, i, j);
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
