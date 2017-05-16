package com.millstech.entities;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.game.Game;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.MathUtils.*;

public class Camera {

	private Vector3f position = new Vector3f(0, 0, 0);
	private float pitch; 
	private float yaw;
	private float roll;
	
	public Camera() {}
	
	public Camera(float posX, float posY, float posZ) {
		position.x = posX;
		position.y = posY;
		position.z = posZ;
	}
	
	public void move() {
        /*
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
            position.x += 0.02f;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
            position.x -= 0.02f;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
            position.y += 0.02f;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
            position.y -= 0.02f;
        }
        */
	}
	
	public void follow(Entity e) {
		if(Game.getCurrentLevel().hasDynamicCamera()) {
			position.x = 0.143f * e.getPosition().x;
		}
	}
	
	public void setPosition(Vector3f vec) {
		position = vec;
	}
	
	public void setTilePosition(Vector3f vec) {
		position.x = 0.143f * vec.x;
		position.y = 0.143f * vec.y;
		position.z = 0.143f * vec.z;
	}
	
	public void setTilePosition(float val, Coordinate c) {
		switch(c) {
		case X:
			position.x = val / GameConstants.CAMERA_UNIT;
			break;
		case Y:
			position.y = val / GameConstants.CAMERA_UNIT;
			break;
		case Z:
			position.z = val / GameConstants.CAMERA_UNIT;
			break;
		}
	}
	
	public Vector3f getPosition() {
		return position;
	}
	
	public Vector3f getTilePosition() {
		return new Vector3f(position.x * 6.99300703288f, position.y, position.z);
	}
	
	public float getPitch() {
		return pitch;
	}
	
	public float getYaw() {
		return yaw;
	}
	
	public float getRoll() {
		return roll;
	}
	
	
}
