package com.millstech.entities;

import org.lwjgl.util.vector.Vector3f;

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
		position.x = 0.143f * e.getPosition().x;
	}
	
	public void setPosition(Vector3f vec) {
		position = vec;
	}
	
	public Vector3f getPosition() {
		return position;
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
