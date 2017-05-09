package com.millstech.entities.map;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.entities.Entity;
import com.millstech.models.TexturedModel;

public class Platform extends Entity {

	public Platform(TexturedModel model, Vector3f pos, int rotX, int rotY, int rotZ, float scale) {
		super(model, pos, rotX, rotY, rotZ, scale);
	}

}
