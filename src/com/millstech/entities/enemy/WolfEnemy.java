package com.millstech.entities.enemy;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.entities.primative.WalkingEntity;
import com.millstech.game.Game;
import com.millstech.models.RawModel;
import com.millstech.models.TexturedModel;
import com.millstech.textures.Textures;
import com.millstech.toolbox.GameUtils.Side;
import com.millstech.toolbox.MathUtils;
import com.millstech.toolbox.TileUtils;

public class WolfEnemy extends WalkingEntity {

	private int rBound = 0, lBound = 255; 
	private float walkSpeed = 0.03f;
	
	public WolfEnemy(int rightBound, int leftBound, RawModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(new TexturedModel(TileUtils.model, Textures.rock), position, rotX, rotY, rotZ, scale);
		System.out.println(leftBound + " "  + rightBound);
		idleL = Textures.standL;
		idleR = Textures.standR;
		walkRight = Textures.walkRight;
		walkLeft = Textures.walkLeft;
		rBound = rightBound;
		lBound = leftBound;
		System.out.println(lBound + " "  + rBound);
	}

	@Override
	public void update() {
		/*
		if(MathUtils.convertToBlockPos(position).x == MathUtils.convertToBlockPos(Game.character.position).x
				&& MathUtils.convertToBlockPos(position).y == MathUtils.convertToBlockPos(Game.character.position).y) {
			Game.damage();
		}
		*/
		if(inBounds() && inRenderDistance()) {
			if(findPlayer() == Side.LEFT) {
				walkLeft();
			}
			if(findPlayer() == Side.RIGHT) {
				walkRight();
			}
		} else {
		
		}
	}
	
	private boolean inBounds() {
		if(findPlayer() == Side.RIGHT) {
			return MathUtils.convertToBlockPos(position.x) <= rBound;
		} else {
			return MathUtils.convertToBlockPos(position.x) >= lBound;
		}
	}
	
	private void walkRight() {
		position.x += walkSpeed;
	}
	
	private void walkLeft() {
		position.x -= walkSpeed;
	}
	
	private Side findPlayer() {
		return position.x < Game.character.getPosition().getX() ? Side.RIGHT : Side.LEFT;
	}
}