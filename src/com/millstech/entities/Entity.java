package com.millstech.entities;

import java.util.List;

import org.lwjgl.util.vector.*;

import com.millstech.game.Game;
import com.millstech.models.*;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.GameConstants;

public class Entity {
	private boolean visible, scriptedVisibility = true, forceRender;
	private TexturedModel model;
	public Vector3f position;
	protected float rotX, rotY, rotZ;
	protected float scale;
	
	public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, boolean alwaysRender) {
		this(model, position, rotX, rotY, rotZ, scale);
		forceRender = alwaysRender;
	}
	
	public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}
	
	public Entity(List<ModelTexture> list, RawModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		TexturedModel texModel = new TexturedModel(model, list.get((int) (Math.random() * list.size())));
		this.model = texModel;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}
	
	public void increasePosition(float dx, float dy, float dz) {
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}
	
	public void setPosition(float x, float y, float z) {
		this.position.x = x;
		this.position.y = y;
		this.position.z = z;
	}
	
	public void increaseRotation(float dx, float dy, float dz) {
		this.rotX += dx;
		this.rotY += dy;
		this.rotZ += dz;
	}
	
	public void setRotation(float rx, float ry, float rz) {
		this.rotX += rx;
		this.rotY += ry;
		this.rotZ += rz;
	}

	public TexturedModel getModel() {
		return model;
	}

	public void setModel(TexturedModel model) {
		this.model = model;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public float getRotX() {
		return rotX;
	}

	public void setRotX(float rotX) {
		this.rotX = rotX;
	}

	public float getRotY() {
		return rotY;
	}

	public void setRotY(float rotY) {
		this.rotY = rotY;
	}

	public float getRotZ() {
		return rotZ;
	}

	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean v) {
		scriptedVisibility = v;
	}
	
	public void updateVisible() {
		if(forceRender) {
			visible = true;
			return;
		}
		if((Math.abs(position.x - Game.getCamera().getTilePosition().x) < GameConstants.RENDER_DISTANCE)) {
			visible = scriptedVisibility;
		} else {
			visible = false;
		}
	}

	public boolean hasScriptedVisibility() {
		return scriptedVisibility;
	}

	public void setVisibleIsScripted(boolean scripted) {
		scriptedVisibility = scripted;
	}
	
	public boolean inRenderDistance() {
		return Math.abs(position.x - Game.getCamera().getTilePosition().x) < GameConstants.RENDER_DISTANCE;
	}
}
