package com.millstech.toolbox;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.engine.render.OBJLoader;
import com.millstech.entities.AnimatedEntity;
import com.millstech.entities.Entity;
import com.millstech.entities.PlayerEntity;
import com.millstech.entities.map.CheckPoint;
import com.millstech.entities.map.ClippablePlatform;
import com.millstech.entities.map.MovingTile;
import com.millstech.entities.map.Platform;
import com.millstech.game.Game;
import com.millstech.models.RawModel;
import com.millstech.models.TexturedModel;
import com.millstech.textures.ModelTexture;
import com.millstech.textures.Textures;

public class TileUtils {
	private static RawModel model = OBJLoader.loadObjModel("models/tile", Game.loader);
	private static RawModel bgModel = OBJLoader.loadObjModel("models/bg", Game.loader);
	
	public enum Layer {
		GRAPHICS, FOREGROUND, ENTITY, PLATFORM, BACKGROUND, MENUTEXT;
	}
	
	public static PlayerEntity createCharacter(int posX, int posY) {
		PlayerEntity character = new PlayerEntity(new TexturedModel(model, new ModelTexture(Game.loader.loadTexture("entity/char/char_standingL"))), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
        character.setVisible(true);
		Game.addToEntityLayer(character);
        return character;
	}
	
	public static PlayerEntity createScriptedCharacter(int posX, int posY, boolean visible, boolean moveEnabled, boolean JumpEnabled, boolean useGravity) {
		PlayerEntity character = new PlayerEntity(new TexturedModel(model, new ModelTexture(Game.loader.loadTexture("entity/char/char_standingL"))), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT, moveEnabled, JumpEnabled, useGravity);
        character.setVisible(visible);
		Game.addToEntityLayer(character);
        return character;
	}
	
	public static void removeCharacter() {
		Game.purgePlayers();
	}
	
	public static Entity createFGTile(ModelTexture t, int posX, int posY) {
		Entity e = new Entity(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
		e.increasePosition(e.getPosition().x * -0.0004f, 0, 0);
    	Game.addToForegroundLayer(e);
        return e;
	}
	
	public static Entity createMovingTile(ModelTexture t, int posX, int posY, float dx, float dy, Layer l, float scale) {
		MovingTile e = new MovingTile(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT * scale, posY * GameConstants.UNIT * scale, -10.0f), 0, 270, 0, GameConstants.UNIT * scale, dx, dy);
	    switch(l) {
	    case GRAPHICS:
	    	Game.addToGraphicsLayer(e);
	    	break;
	    case FOREGROUND:
	    	e.increasePosition(e.getPosition().x * -0.0004f, 0, 0);
	    	Game.addToForegroundLayer(e);
	    	break;
	    case PLATFORM:
	    	Game.addToVisualPlatformLayer(e);
	    	break;
	    case ENTITY:
	    	Game.addToEntityLayer(e);
	    	break;
	    case BACKGROUND:
	    	e.increasePosition(e.getPosition().x * 0.0002f, 0, 0);
	    	Game.addToBackgroundLayer(e);
	    	break;
	    case MENUTEXT:
	    	e.setPosition(e.getPosition().x, e.getPosition().y, -4.5f);
	    	Game.addToForegroundLayer(e);
	    	break;
	    }
        Game.registerUpdatable(e);
	    return e;
	}
	
	public static Entity createBGTile(ModelTexture t, int posX, int posY) {
		Entity e = new Entity(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
		e.increasePosition(e.getPosition().x * 0.0002f, 0, 0);
    	Game.addToBackgroundLayer(e);
        return e;
	}
	
	public static CheckPoint createCheckpoint(int posX, int posY) {
		CheckPoint cp = new CheckPoint(Textures.checkPointList, model, new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
		cp.increasePosition(cp.getPosition().x * 0.0002f, 0, 0);
    	Game.registerUpdatable(cp);
	    Game.addToBackgroundLayer(cp);
        return cp;
	}
	
	public static Entity createBGImage(ModelTexture t) {
		Entity e = new Entity(new TexturedModel(bgModel, t), new Vector3f(256 * GameConstants.UNIT, 0 * GameConstants.UNIT, -10.003f), 0, 270, 0, 2 * GameConstants.UNIT, true);
	    e.increasePosition(0, 0, -10 * GameConstants.LAYER_SPACING);
	    Game.addToBackgroundLayer(e);
        return e;
	}
	
	public static Platform createPlatform(ModelTexture t, int posX, int posY) {
		Game.platformPos.add(new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, 0));
		Platform p = new Platform(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
	    Game.addToPlatformLayer(p);
	    Game.registerPlatform(posX, posY, p);
	    return p;
	}
	
	public static Platform createClippablePlatform(ModelTexture t, int posX, int posY) {
		Game.platformPos.add(new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, 0));
		Platform p = new Platform(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
	    Game.addToPlatformLayer(p);
	    return p;
	}
	
	public static Platform createClippableJumpablePlatform(ModelTexture t, int posX, int posY) {
		Game.platformPos.add(new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, 0));
	    Platform p = new ClippablePlatform(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
	    Game.addToPlatformLayer(p);
	    return p;
	}
	
	public static Entity createNoInteractionPlatform(ModelTexture t, int posX, int posY) {
		Entity p = new ClippablePlatform(new TexturedModel(model, t), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, GameConstants.UNIT);
	    Game.addToPlatformLayer((Platform) p);
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
	
	public static void createNoInteractionPlatformBlock(ModelTexture t, int minX, int minY, int maxX, int maxY) {
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				createNoInteractionPlatform(t, i, j);
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
	
	public static AnimatedEntity createAnimatedTile(List<ModelTexture> list, int posX, int posY, Layer layer, int animDelay, boolean isPlatform) {
		return createAnimatedTile(list, posX, posY, layer, animDelay, isPlatform, GameConstants.UNIT);
	}
	
	public static AnimatedEntity createAnimatedTile(List<ModelTexture> list, float posX, float posY, Layer layer, int animDelay, boolean isPlatform, float scale) {
		AnimatedEntity e;
		if(animDelay < 0) {
			e = new AnimatedEntity(new TexturedModel(model, list.get((int) (Math.random() * list.size()))), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, scale, animDelay);
		} else {
	    	e = new AnimatedEntity(new TexturedModel(model, Textures.test), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, scale, animDelay);
	    	e.loadAnimations(list);
		}
	    
		switch(layer) {
		    case GRAPHICS:
		    	Game.addToGraphicsLayer(e);
		    	break;
		    case FOREGROUND:
		    	e.increasePosition(e.getPosition().x * -0.0004f, 0, 0);
		    	Game.addToForegroundLayer(e);
		    	break;
		    case PLATFORM:
		    	Game.addToVisualPlatformLayer(e);
		    	break;
		    case ENTITY:
		    	Game.addToEntityLayer(e);
		    	break;
		    case BACKGROUND:
		    	e.increasePosition(e.getPosition().x * 0.0002f, 0, 0);
		    	Game.addToBackgroundLayer(e);
		    	break;
		    case MENUTEXT:
		    	e.setPosition(e.getPosition().x, e.getPosition().y, -4.5f);
		    	Game.addToForegroundLayer(e);
		    	break;
	    }

		if(isPlatform) {
	    	createPlatform(Textures.invisable, (int) Math.rint(posX), (int) Math.rint(posY));
	    }
		
		Game.registerUpdatable(e);
	    return e;
	}
	
	public static void createAnimatedBlock(List<ModelTexture> list, int minX, int minY, int maxX, int maxY, Layer l, int animDelay, boolean platform) {
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				createAnimatedTile(list, i, j, l, animDelay, platform);
			}
		}
	}

	public static void createClippableJumpablePlatformBlock(ModelTexture t, int minX, int minY, int maxX, int maxY) {
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				createClippableJumpablePlatform(t, i, j);
			}
		}
	}
	
	public static Entity createSplashTile(ModelTexture t, float x, float y) {
		float scale = 7.0f;
		Entity e = new Entity(new TexturedModel(model, t), new Vector3f(x * GameConstants.UNIT, y * GameConstants.UNIT, -5.0f), 0, 270, 0, scale);
		Game.addToForegroundLayer(e);
		return e;
	}
	
	public static Entity createTile(ModelTexture texture, float posX, float posY, Layer layer, boolean isPlatform, float scale) {
		Entity e = new Entity(new TexturedModel(model, texture), new Vector3f(posX * GameConstants.UNIT, posY * GameConstants.UNIT, -10.0f), 0, 270, 0, scale);
		
		switch(layer) {
		    case GRAPHICS:
		    	Game.addToGraphicsLayer(e);
		    	break;
		    case FOREGROUND:
		    	e.increasePosition(e.getPosition().x * -0.0004f, 0, 0);
		    	Game.addToForegroundLayer(e);
		    	break;
		    case PLATFORM:
		    	Game.addToVisualPlatformLayer(e);
		    	break;
		    case ENTITY:
		    	Game.addToEntityLayer(e);
		    	break;
		    case BACKGROUND:
		    	e.increasePosition(e.getPosition().x * 0.0002f, 0, 0);
		    	Game.addToBackgroundLayer(e);
		    	break;
		    case MENUTEXT:
		    	e.setPosition(e.getPosition().x, e.getPosition().y, -4.5f);
		    	Game.addToForegroundLayer(e);
		    	break;
	    }

		if(isPlatform) {
	    	createPlatform(Textures.invisable, (int) Math.rint(posX), (int) Math.rint(posY));
	    }
		
		return e;
	}
	
	public static void createBlock(ModelTexture texture, int minX, int minY, int maxX, int maxY, Layer layer, boolean isPlatform, float scale) {
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				createTile(texture, i, j, layer, isPlatform, scale);
			}
		}
	}
}
