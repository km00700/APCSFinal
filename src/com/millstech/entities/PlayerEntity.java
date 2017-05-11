package com.millstech.entities;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.engine.physics.GravityEntity;
import com.millstech.game.Game;
import com.millstech.game.control.Controls;
import com.millstech.models.TexturedModel;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.flags.Player;

public class PlayerEntity extends Entity implements Player, GravityEntity {
	private static final int animDelay = 5, jumpCooldown = 10;
	private int frameCounter = 0, cooldownCounter = 0, wrIndex = 0, wlIndex = 0;
	private double walkSpeed = 0.035, fallSpeed = 0, maxFallSpeed = 0.5, acceleration = 0.004, jumpPower = 0.085;
	private boolean isGrounded = true, jumping = false, colliding = false, hasClearance = false, scripted = false;
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
    
	public PlayerEntity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, boolean isScripted) {
		this(model, position, rotX, rotY, rotZ, scale);
		scripted = isScripted;
	}
	
	public PlayerEntity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
		this.setVisibleIsScripted(false);
		standR = new ModelTexture(Game.loader.loadTexture("char/char_standingL"));
		standL = new ModelTexture(Game.loader.loadTexture("char/char_standingLI"));
		
		walkR00 = new ModelTexture(Game.loader.loadTexture("char/char_walking00L"));
		walkR11 = new ModelTexture(Game.loader.loadTexture("char/char_walking11L"));
		walkR12 = new ModelTexture(Game.loader.loadTexture("char/char_walking12L"));
		walkR21 = new ModelTexture(Game.loader.loadTexture("char/char_walking21L"));
		walkR22 = new ModelTexture(Game.loader.loadTexture("char/char_walking22L"));
		walkRight.add(walkR00);
		walkRight.add(walkR11);
		walkRight.add(walkR12);
		walkRight.add(walkR00);
		walkRight.add(walkR21);
		walkRight.add(walkR22);
		
		walkL00 = new ModelTexture(Game.loader.loadTexture("char/char_walking00LI"));
		walkL11 = new ModelTexture(Game.loader.loadTexture("char/char_walking11LI"));
		walkL12 = new ModelTexture(Game.loader.loadTexture("char/char_walking12LI"));
		walkL21 = new ModelTexture(Game.loader.loadTexture("char/char_walking21LI"));
		walkL22 = new ModelTexture(Game.loader.loadTexture("char/char_walking22LI"));
		walkLeft.add(walkL00);
		walkLeft.add(walkL11);
		walkLeft.add(walkL12);
		walkLeft.add(walkL00);                                                                       
		walkLeft.add(walkL21);
		walkLeft.add(walkL22);
	}
	
	public void move() {                                                                                                                                                                     
		if(!scripted) {
			checkJumpClearance();
			checkForCollision();
			checkIfGrounded();
			if((Controls.right() && Controls.left()) || (!Controls.right() && !Controls.left())) {
				wrIndex = 0;
	        	wrIndex = 0;
	        	if(facingRight) super.getModel().setTexture(standR);
	        	else super.getModel().setTexture(standL);
			} else {
				if(Controls.right()) {
					if(position.x < GameConstants.UPPER_BOUND - GameConstants.UNIT) {
						super.position.x += (float) walkSpeed;
					}
		            facingRight = true;
					animateForward();
		        }
		        if(Controls.left()) {
		            if(position.x > GameConstants.LOWER_BOUND) {
		            	position.x -= (float) walkSpeed;
		            }
		            facingRight = false;
		            animateBackward();
		        }
			}
			if(Controls.jump() && hasClearance) {
				if(cooldownCounter >= jumpCooldown && !colliding) {
					cooldownCounter = 0;
					jump();
				}
			}
	        if(Controls.attack()) {
	        	// TODO Remove Testing calls
	        	//Game.spawn();
	        	Game.nextLevel();
	        }
	        cooldownCounter++;
	        fall();
		} else {
			/*
			 *    TODO SCRIPTED CONTROL
			 * 
			 *  Temporary stuff below
			 */
			setVisible(false);
			if(Controls.attack()) {
	        	Game.nextLevel();
	        }
		}
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
			fallSpeed = -jumpPower;
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
		for(Vector3f v : Game.platformPos) {
			if((Math.abs(position.x - v.x) < GameConstants.UNIT / 2) && (position.y - v.y <= GameConstants.UNIT) && (position.y - v.y >= 0)) {
				isGrounded = true;
				if(position.y - v.y < 0.85f * GameConstants.UNIT) {
					position.y += 0.15f * GameConstants.UNIT;
				}
				return;
			} else {
				isGrounded = false;
			}
		}
	}
	
	public void checkJumpClearance() {
		for(Vector3f v : Game.platformPos) {
			if((Math.abs(position.x - v.x) < GameConstants.UNIT / 2) && (v.y - position.y <= 1.15f * GameConstants.UNIT) && (position.y - v.y <= 0)) {
				hasClearance = false;
				return;
			} else {
				hasClearance = true;
			}
		}
	}
	
	public void checkForCollision() {
		if(facingRight && Game.isPlatformAtLocation(convertToBlockPos(position.x) + 1, convertToBlockPos(position.y) + 4)) {
			if((Game.getPlatformAtLocation(convertToBlockPos(position.x) + 1, convertToBlockPos(position.y) + 4).position.x - position.x) < 0.5) {
				position.x -= 0.05;
				colliding = true;
			}
			if((Game.getPlatformAtLocation(convertToBlockPos(position.x) + 1, convertToBlockPos(position.y) + 4).position.x - position.x) < 0.45) {
				colliding = true;
			}
		} else if(!facingRight && Game.isPlatformAtLocation(convertToBlockPos(position.x), convertToBlockPos(position.y) + 4)) {
			if(position.x - (Game.getPlatformAtLocation(convertToBlockPos(position.x), convertToBlockPos(position.y) + 4).position.x) < 0.5) {
				position.x += 0.05;
				colliding = true;
			}
		} else {
			colliding = false;
		}
	}
	
	public void checkForClip() {
		if((Game.getPlatformAtLocation(convertToBlockPos(position.x) + 1, convertToBlockPos(position.y) + 4).position.x - position.x) < 0.5) {
			
		}
	}
	
	public int convertToBlockPos(float rawPos) {
		return (int)(rawPos / GameConstants.UNIT + (GameConstants.UNIT / 2));
	}
	
}
