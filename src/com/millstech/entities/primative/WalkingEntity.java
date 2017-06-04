package com.millstech.entities.primative;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.entities.Entity;
import com.millstech.entities.map.Updatable;
import com.millstech.models.RawModel;
import com.millstech.models.TexturedModel;
import com.millstech.textures.ModelTexture;
import com.millstech.textures.Textures;

public abstract class WalkingEntity extends Entity implements Updatable {
	@SuppressWarnings("unused")
	private boolean facingRight = true, movingRight = true, movingLeft = false;
	private static final int animDelay = 5;
	private int frameCounter = 0, wrIndex = 0, wlIndex = 0;
	protected List<ModelTexture> walkRight = Textures.walkRight;
	protected List<ModelTexture> walkLeft = Textures.walkLeft;
	protected ModelTexture idleR = Textures.standR;
	protected ModelTexture idleL = Textures.standL;
	
	public WalkingEntity(List<ModelTexture> list, RawModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(list, model, position, rotX, rotY, rotZ, scale);
	}
	
	public WalkingEntity (TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
		this.setVisibleIsScripted(false);
	}
	
	public abstract void update();
	
	public abstract void move();
	
	public void animateForward() {
		if(frameCounter >= animDelay) {
			frameCounter = 0;
			super.getModel().setTexture(walkRightNext());
			movingRight = true;
			movingLeft = false;
			facingRight = true;
		} else {
			frameCounter++;
		}
	}
	
	public void animateBackward() {
		if(frameCounter >= animDelay) {
			frameCounter = 0;
			super.getModel().setTexture(walkLeftNext());
			movingRight = false;
			movingLeft = true;
			facingRight = false;
		} else {
			frameCounter++;
		}
	}
	
	private ModelTexture walkRightNext() {
		if(wrIndex < walkRight.size()) {
			ModelTexture t = walkRight.get(wrIndex);
			wrIndex++;
			return t;
		} else {
			wrIndex = 0;
			return walkRight.get(0);
		}
	}
	
	private ModelTexture walkLeftNext() {
		if(wlIndex < walkLeft.size()) {
			ModelTexture t = walkLeft.get(wlIndex);
			wlIndex++;
			return t;
		} else {
			wlIndex = 0;
			return walkLeft.get(0);
		}
	}
}
