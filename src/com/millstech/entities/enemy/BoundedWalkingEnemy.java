package com.millstech.entities.enemy;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.entities.primative.WalkingEntity;
import com.millstech.game.Game;
import com.millstech.models.RawModel;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.GameUtils.Side;
import com.millstech.toolbox.MathUtils;

public class BoundedWalkingEnemy extends WalkingEntity {

	private int rBound = 0, lBound = 255; 
	private float walkSpeed = 0.03f;
	
	public BoundedWalkingEnemy(List<ModelTexture> leftList, List<ModelTexture> rightList, ModelTexture leftIdle, ModelTexture rightIdle, int rightBound, int leftBound, RawModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(rightList, model, position, rotX, rotY, rotZ, scale);
		idleL = leftIdle;
		idleR = rightIdle;
		walkRight = rightList;
		walkLeft = leftList;
		rBound = rightBound;
		lBound = leftBound;
	}

	@Override
	public void update() {
		if(MathUtils.convertToBlockPos(position).x == MathUtils.convertToBlockPos(Game.character.position).x
				&& MathUtils.convertToBlockPos(position).y == MathUtils.convertToBlockPos(Game.character.position).y) {
			Game.damage();
		}
		
		if(findPlayer() == Side.LEFT && position.x > lBound) {
			walkLeft();
			animateBackward();
		} else if(position.x < rBound) {
			walkRight();
			animateForward();
		} else {
			idle();
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
