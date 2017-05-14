package com.millstech.entities;

import org.lwjgl.util.vector.Vector3f;

import java.util.*;

import com.millstech.entities.map.Updatable;
import com.millstech.models.TexturedModel;
import com.millstech.textures.ModelTexture;

public class AnimatedEntity extends Entity implements Updatable {
	List<ModelTexture> animList;
	int animIndex = 0, animDelay = 10, timeCounter = 0;;
	
	public AnimatedEntity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, int delay) {
		this(model, position, rotX, rotY, rotZ, scale);
		animDelay = delay;
	}
	
	public AnimatedEntity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
	}
	
	public void update() {
		if(timeCounter > animDelay) {
			super.getModel().setTexture(animNext());
			timeCounter = 0;
		} else {
			timeCounter++;
		}
	}
	
	public void loadAnimations(List<ModelTexture> list) {
		animList = list;
	}
	
	public void setAnimDelay(int delay) {
		animDelay = delay;
	}
	
	private ModelTexture animNext() {
		if(animIndex < animList.size()) {
			ModelTexture t = animList.get(animIndex);
			animIndex++;
			return t;
		} else {
			animIndex = 0;
			return (ModelTexture) animList.get(0);
		}
	} 

}
