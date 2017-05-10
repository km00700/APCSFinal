package com.millstech.entities;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.engine.GameLoop;
import com.millstech.engine.physics.GravityEntity;
import com.millstech.game.control.Controls;
import com.millstech.models.TexturedModel;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.Map;
import com.millstech.toolbox.flags.Player;

public class PlayerEntity extends Entity implements Player, GravityEntity {
	private static final int animDelay = 10, jumpCooldown = 10;
	private int frameCounter = 0, cooldownCounter = 0, wrIndex = 0, wlIndex = 0;
	private double walkSpeed = 0.035, fallSpeed = 0, maxFallSpeed = 0.5, acceleration = 0.004, jumpPower = 0.085;
	private boolean isGrounded = true, jumping = false, colliding = false;;
	private boolean facingRight = true;
	private List<ModelTexture> walkRight = new ArrayList<ModelTexture>();
	private List<ModelTexture> walkLeft = new ArrayList<ModelTexture>();
	
	private ModelTexture standR;
	private ModelTexture walkR00;
	private ModelTexture walkR11;
	private ModelTexture walkR12;
	private ModelTexture walkR21;
	private ModelTexture walkR22;
	private ModelTexture standL;
	private ModelTexture walkL00;
	private ModelTexture walkL11;
	private ModelTexture walkL12;
	private ModelTexture walkL21;
	private ModelTexture walkL22;
    
	
	public PlayerEntity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
		standR = new ModelTexture(GameLoop.loader.loadTexture("char/char_standingL"));
		standL = new ModelTexture(GameLoop.loader.loadTexture("char/char_standingLI"));
		
		walkR00 = new ModelTexture(GameLoop.loader.loadTexture("char/char_walking00L"));
		walkR11 = new ModelTexture(GameLoop.loader.loadTexture("char/char_walking11L"));
		walkR12 = new ModelTexture(GameLoop.loader.loadTexture("char/char_walking12L"));
		walkR21 = new ModelTexture(GameLoop.loader.loadTexture("char/char_walking21L"));
		walkR22 = new ModelTexture(GameLoop.loader.loadTexture("char/char_walking22L"));
		walkRight.add(walkR00);
		walkRight.add(walkR11);
		walkRight.add(walkR12);
		walkRight.add(walkR00);
		walkRight.add(walkR21);
		walkRight.add(walkR22);
		
		walkL00 = new ModelTexture(GameLoop.loader.loadTexture("char/char_walking00LI"));
		walkL11 = new ModelTexture(GameLoop.loader.loadTexture("char/char_walking11LI"));
		walkL12 = new ModelTexture(GameLoop.loader.loadTexture("char/char_walking12LI"));
		walkL21 = new ModelTexture(GameLoop.loader.loadTexture("char/char_walking21LI"));
		walkL22 = new ModelTexture(GameLoop.loader.loadTexture("char/char_walking22LI"));
		walkLeft.add(walkL00);
		walkLeft.add(walkL11);
		walkLeft.add(walkL12);
		walkLeft.add(walkL00);                                                                       
		walkLeft.add(walkL21);
		walkLeft.add(walkL22);
	}
	
	public void move() {                                                                                                                                                                     
		checkIfGrounded();
		checkForCollision();
		if((Controls.right() && Controls.left()) || (!Controls.right() && !Controls.left())) {
			wrIndex = 0;
        	wrIndex = 0;
        	if(facingRight) super.getModel().setTexture(standR);
        	else super.getModel().setTexture(standL);
		} else {
			if(Controls.right()) {
				if(position.x < Map.UPPER_BOUND) {
					super.position.x += (float) walkSpeed;
				}
	            facingRight = true;
				animateForward();
	        }
	        if(Controls.left()) {
	            if(position.x > Map.LOWER_BOUND) {
	            	position.x -= (float) walkSpeed;
	            }
	            facingRight = false;
	            animateBackward();
	        }
		}
		if(Controls.jump()) {
			if(cooldownCounter >= jumpCooldown && !colliding) {
				cooldownCounter = 0;
				jump();
			} else {
				cooldownCounter++;
			}
			
        }
        if(Controls.attack()) {
        	GameLoop.spawn();
        }
        
        fall();
	}
	
	public void animateForward() {
		if(frameCounter >= animDelay) {
			frameCounter = 0;
			super.getModel().setTexture(walkRightNext());
		} else {
			frameCounter++;
		}
	}
	
	public void animateBackward() {
		if(frameCounter >= animDelay) {
			frameCounter = 0;
			super.getModel().setTexture(walkLeftNext());
		} else {
			frameCounter++;
		}
	}
	
	private ModelTexture walkRightNext() {
		if(wrIndex < walkRight.size() - 1) {
			wrIndex++;
			return walkRight.get(wrIndex - 1);
		} else {
			wrIndex = 0;
			return walkRight.get(0);
		}
	}
	
	private ModelTexture walkLeftNext() {
		if(wlIndex < walkLeft.size() - 1) {
			wlIndex++;
			return walkLeft.get(wlIndex - 1);
		} else {
			wlIndex = 0;
			return walkLeft.get(0);
		}
	}
	
	public void fall() {
		if (isGrounded && jumping) {
			position.y += 0.03f;
			fallSpeed -= jumpPower;
			jumping = false;
		} else if(isGrounded && !jumping) {
			fallSpeed = 0;
		} else {
			fallSpeed += acceleration;
			fallSpeed = Math.min(fallSpeed, maxFallSpeed);
			position.y -= (float)fallSpeed;
		}
	}
	
	public void jump() {
		jumping = true;
	}
	
	public void checkIfGrounded() {
		///*
		for(Vector3f v : GameLoop.platformPos) {
			if((Math.abs(position.x - v.x) < Map.UNIT / 2) && (position.y - v.y < Map.UNIT) && (position.y - v.y >= 0)) {
				isGrounded = true;
				return;
			} else {
				isGrounded = false;
			}
		}
		//*/
		/*
		if(GameLoop.isPlatformAtLocation(convertToBlockPos(position.x) + 1, convertToBlockPos(position.y) + 3) && position.y - (GameLoop.getPlatformAtLocation(convertToBlockPos(position.x) + 1, convertToBlockPos(position.y) + 3).position.y) < 0.76) {
			isGrounded = true;
		} else {
			isGrounded = false;
		}
		*/
	}
	
	public void checkForCollision() {
		if(facingRight && GameLoop.isPlatformAtLocation(convertToBlockPos(position.x) + 1, convertToBlockPos(position.y) + 4)) {
			if((GameLoop.getPlatformAtLocation(convertToBlockPos(position.x) + 1, convertToBlockPos(position.y) + 4).position.x - position.x) < 0.5) {
				position.x -= 0.05;
			}
			if((GameLoop.getPlatformAtLocation(convertToBlockPos(position.x) + 1, convertToBlockPos(position.y) + 4).position.x - position.x) < 0.45) {
				colliding = true;
			}
		} else if(!facingRight && GameLoop.isPlatformAtLocation(convertToBlockPos(position.x), convertToBlockPos(position.y) + 4)) {
			if(position.x - (GameLoop.getPlatformAtLocation(convertToBlockPos(position.x), convertToBlockPos(position.y) + 4).position.x) < 0.5) {
				position.x += 0.05;
				colliding = true;
			}
		} else {
			colliding = false;
		}
	}
	
	public int convertToBlockPos(float rawPos) {
		return (int)(rawPos / Map.UNIT + (Map.UNIT / 2));
	}
}
