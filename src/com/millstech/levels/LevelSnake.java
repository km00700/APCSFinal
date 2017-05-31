package com.millstech.levels;

import java.util.ArrayList;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.game.control.Controls;
import com.millstech.textures.Textures;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.TileUtils;
import com.millstech.toolbox.TileUtils.Layer;
import com.millstech.toolbox.MathUtils.Coordinate;

public class LevelSnake implements Level {
	public static boolean firstLoad = true;
	private static int tickTimer = 0, POSX = 9, POSY = 4, LENGTH = 0, F_POSX = 9, F_POSY = 7;
	private static ArrayList<Vector3f> positions;
	private enum DIRECTION {
		UP, DOWN, LEFT, RIGHT;
	}
	private DIRECTION direction = DIRECTION.UP;
	public final int MINX = 0, MINY = 0, MAXX = 18, MAXY = 10;
	
	@Override
	public void update() {
		if(tickTimer < 10) {   //2000
			tickTimer++;
		} else {
			tickTimer = 0;
			tick();
		}
	}
	
	public void tick() {
		if((Controls.jump() ||Controls.upArrow()) && (direction == DIRECTION.LEFT || direction == DIRECTION.RIGHT)) {
			direction = DIRECTION.UP;
		} else if((Controls.crouch() || Controls.downArrow()) && (direction == DIRECTION.LEFT || direction == DIRECTION.RIGHT)) {
			direction = DIRECTION.DOWN;
		} else if((Controls.right() || Controls.rightArrow()) && (direction == DIRECTION.UP || direction == DIRECTION.DOWN)) {
			direction = DIRECTION.RIGHT;
		} else if((Controls.left() || Controls.leftArrow()) && (direction == DIRECTION.UP || direction == DIRECTION.DOWN)) {
			direction = DIRECTION.LEFT;
		}
		Game.purgeEntities();
		drawFood();
		
		TileUtils.createTile(Textures.metalGrate, POSX, POSY, -10, Layer.PLATFORM, false, GameConstants.UNIT);
		if(direction == DIRECTION.UP) {
			if(POSY > MAXY) loadLevel();
			POSY++;
		} else if(direction == DIRECTION.DOWN) {
			if(POSY < MINY) loadLevel();
			POSY--;
		} else if(direction == DIRECTION.LEFT) {
			if(POSX < MINX) loadLevel();
			POSX--;
		} else if(direction == DIRECTION.RIGHT) {
			if(POSX > MAXX) loadLevel();
			POSX++;
		}
		
		if(POSX == F_POSX && POSY == F_POSY) {
			LENGTH++;
			moveFood();
		}
		
		positions.add(new Vector3f(POSX, POSY, 0));
		
		int removeCount = 0;
		if(positions.size() > LENGTH) {
			removeCount = positions.size() - LENGTH;
		}
		
		for(int i = 0; i < removeCount; i++){
			positions.remove(0);
		}
		
		for(int i = 0; i < positions.size(); i++) {
			Vector3f v = positions.get(i);
			//if(i != 0 && v.x == POSX && v.y == POSY) loadLevel();
			if(LENGTH != 0)TileUtils.createTile(Textures.metalGrate, v.x, v.y, -10, Layer.PLATFORM, false, GameConstants.UNIT);
		}
		if(positions.size() >= 1) {
			for(int i = 0; i < positions.size() - 1; i++) {
				if(POSX == (int) positions.get(i).x && POSY == (int) positions.get(i).y) loadLevel();
			}
		}
		scoreBoard();
	}
	
	@Override
	public void loadLevel() {
		Game.purgeEntities();
		POSX = 9;
		POSY = 4;
		moveFood();
		LENGTH = 0;
		direction = DIRECTION.UP;
		
		positions = new ArrayList<Vector3f>();
		
		Game.getCamera().setTilePosition(9 * GameConstants.UNIT, Coordinate.X);
        Game.getLight().setTilePosition(9 * GameConstants.UNIT, Coordinate.X);
   }
	
	public void drawFood() { 
		TileUtils.createTile(Textures.stone, F_POSX, F_POSY, -10, Layer.PLATFORM, false, GameConstants.UNIT);
	}

	public void moveFood() {
		F_POSX = (MINX+1) + (int)(Math.random() * (((MAXX-1) - (MINX+1)) + 1));
		F_POSY = (MINY+1) + (int)(Math.random() * (((MAXY-1) - (MINY+1)) + 1));
	}
	
	public void scoreBoard() {
		int hundreds = LENGTH / 100;
		int tens = (LENGTH - 100 * hundreds) / 10;
		int ones = (LENGTH - 100 * hundreds) % 10;
		makeDigit(hundreds, 2);
		makeDigit(tens, 1);
		makeDigit(ones, 0);
	}
	
	public void makeDigit(int value, int position) {
		float PosX = -255;
		
		if(position == 0) {
			PosX = 9.4f;
		} else if(position == 1) {
			PosX = 9.0f;
		} else {
			PosX = 8.6f;
		}
		
		switch(value) {
			case 0:
				TileUtils.createTile(Textures.num0, PosX, 9, -10, Layer.FOREGROUND, false, GameConstants.UNIT);
				break;
			case 1:
				TileUtils.createTile(Textures.num1, PosX, 9, -10, Layer.FOREGROUND, false, GameConstants.UNIT);
				break;
			case 2:
				TileUtils.createTile(Textures.num2, PosX, 9, -10, Layer.FOREGROUND, false, GameConstants.UNIT);
				break;
			case 3:
				TileUtils.createTile(Textures.num3, PosX, 9, -10, Layer.FOREGROUND, false, GameConstants.UNIT);
				break;
			case 4:
				TileUtils.createTile(Textures.num4, PosX, 9, -10, Layer.FOREGROUND, false, GameConstants.UNIT);
				break;
			case 5:
				TileUtils.createTile(Textures.num5, PosX, 9, -10, Layer.FOREGROUND, false, GameConstants.UNIT);
				break;
			case 6:
				TileUtils.createTile(Textures.num6, PosX, 9, -10, Layer.FOREGROUND, false, GameConstants.UNIT);
				break;
			case 7:
				TileUtils.createTile(Textures.num7, PosX, 9, -10, Layer.FOREGROUND, false, GameConstants.UNIT);
				break;
			case 8:
				TileUtils.createTile(Textures.num8, PosX, 9, -10, Layer.FOREGROUND, false, GameConstants.UNIT);
				break;
			case 9:
				TileUtils.createTile(Textures.num9, PosX, 9, -10, Layer.FOREGROUND, false, GameConstants.UNIT);
				break;
		}
	}
	
	@Override
	public void loadEntities() { }
	
	@Override
	public void loadBackground() { }
		
	@Override
	public void loadForeground() { }

	@Override
	public void loadPlatforms() { }

	@Override
	public void loadOffMap() { }

	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createScriptedCharacter(9, 2, false, true, false, true);
	}

	@Override
	public int getMaxX() {
		return 255;
	}

	@Override
	public void completed() {}

	@Override
	public void onCheckpointTrigger() { }

	@Override
	public boolean hasDynamicCamera() {
		return false;
	}
}
