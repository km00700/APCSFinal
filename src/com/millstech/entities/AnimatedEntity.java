package com.millstech.entities;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.engine.render.ModelLoader;
import com.millstech.models.TexturedModel;

public class AnimatedEntity extends Entity {

	ModelLoader loader;
	
	public AnimatedEntity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, ModelLoader ml) {
		super(model, position, rotX, rotY, rotZ, scale);
		loader = ml;
	}

}
