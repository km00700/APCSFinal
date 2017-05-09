package com.millstech.entities.map;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.models.TexturedModel;

public class Ground extends Platform {

	public Ground(TexturedModel model, Vector3f pos, int rotX, int rotY, int rotZ, float scale) {
		super(model, pos, rotX, rotY, rotZ, scale);
	}

}
