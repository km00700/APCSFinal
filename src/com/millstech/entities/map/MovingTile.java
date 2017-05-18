package com.millstech.entities.map;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.entities.Entity;
import com.millstech.models.TexturedModel;

public class MovingTile extends Entity implements Updatable {
	private float deltaX, deltaY;
	
	public MovingTile(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, float dx, float dy) {
		super(model, position, rotX, rotY, rotZ, scale);
		deltaX = dx;
		deltaY = dy;
	}
	
	public void update() {
		position.x += deltaX;
		position.y += deltaY;
	}
}
