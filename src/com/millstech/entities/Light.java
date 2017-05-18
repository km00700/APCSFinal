package com.millstech.entities;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.game.Game;
import com.millstech.toolbox.MathUtils.Coordinate;

public class Light {

	private Vector3f position;
	private Vector3f color;
	
	public Light(Vector3f position, Vector3f color) {
		super();
		this.position = position;
		this.color = color;
	}
	
	public void folow(Entity e) {
		if(Game.getCurrentLevel().hasDynamicCamera()) {
			position.x = e.position.x;
		}
	}

	public Vector3f getPosition() {
		return position;
	}
	
	public void setTilePosition(float val, Coordinate c) {
		switch(c) {
		case X:
			position.x = val;
			break;
		case Y:
			position.y = val;
			break;
		case Z:
			position.z = val;
			break;
		}
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public Vector3f getColor() {
		return color;
	}

	public void setColor(Vector3f color) {
		this.color = color;
	}
}
