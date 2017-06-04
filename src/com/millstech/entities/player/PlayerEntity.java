package com.millstech.entities.player;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.engine.physics.GravityEntity;
import com.millstech.entities.map.ClippablePlatform;
import com.millstech.entities.map.Platform;
import com.millstech.entities.primative.WalkingEntity;
import com.millstech.game.Game;
import com.millstech.game.control.Controls;
import com.millstech.models.TexturedModel;
import com.millstech.textures.Textures;
import com.millstech.toolbox.GameConstants;
import com.millstech.toolbox.MathUtils;
import com.millstech.toolbox.flags.Player;

public class PlayerEntity extends WalkingEntity implements Player, GravityEntity {
	private static final int jumpCooldown = 5;
	private int cooldownCounter = 0;
	private double walkSpeed = 0.04, fallSpeed = 0, maxFallSpeed = 0.5, acceleration = 0.002, jumpPower = 0.058; // jump 0.058 walk 0.038 acceleration 0.002
	private boolean isGrounded = true, jumping = false, colliding = false, hasClearance = false, moveEnabled = true, jumpEnabled = true, useGravity = true;
	private boolean facingRight = true;
	
	public PlayerEntity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, boolean movable, boolean jumpable, boolean gravity) {
		this(model, position, rotX, rotY, rotZ, scale);
		moveEnabled = movable;
		jumpEnabled = jumpable;
		useGravity = gravity;
		idleL = Textures.standL;
		idleR = Textures.standR;
		walkRight = Textures.walkRight;
		walkLeft = Textures.walkLeft;
	}
	
	public PlayerEntity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
		this.setVisibleIsScripted(false);
		idleL = Textures.standL;
		idleR = Textures.standR;
		walkRight = Textures.walkRight;
		walkLeft = Textures.walkLeft;
	}
	@Override
	public void move() {                                                                                                                                                                     
		checkJumpClearance();
		checkForCollision();
		checkIfGrounded();
		if((Controls.right() && Controls.left()) || (!Controls.right() && !Controls.left())) {
			if(facingRight) super.getModel().setTexture(idleR);
			else super.getModel().setTexture(idleL);
		} else {
			if(Controls.right() && moveEnabled) {
				if(position.x < GameConstants.UPPER_BOUND - GameConstants.UNIT && Game.getCurrentLevel().getMaxX() > 0 && position.x / GameConstants.UNIT < Game.getCurrentLevel().getMaxX()) {
					super.position.x += (float) walkSpeed;
				}
				facingRight = true;
				animateForward();
			}
			if(Controls.left() && moveEnabled) {
				if(position.x > GameConstants.LOWER_BOUND) {
					position.x -= (float) walkSpeed;
				}
				facingRight = false;
				animateBackward();
			}
		}
		if(Controls.jump() && hasClearance && jumpEnabled) {
			if(cooldownCounter >= jumpCooldown && !colliding) {
				cooldownCounter = 0;
				jump();
			}
		}
		if(Controls.reload()) {
			Game.getCurrentLevel().loadLevel();
		}
		cooldownCounter++;
		fall();
	}
	
	public void fall() {
		if (isGrounded && jumping) {
			position.y += 0.03f;
			fallSpeed = -jumpPower;
			jumping = false;
		} else if(isGrounded && !jumping) {
			fallSpeed = 0;
		} else if(useGravity) {
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
			if((Math.abs(position.x - v.x) < GameConstants.UNIT / 2) && (position.y - v.y <= GameConstants.UNIT) && (position.y - v.y >= 0.0f)) {
				isGrounded = true;
				if(position.y - v.y < 0.85f * GameConstants.UNIT && position.y - v.y > 0.6f * GameConstants.UNIT) {
					position.y += 0.15f * GameConstants.UNIT;
				}
				
				if(position.y - v.y < 0.6f * GameConstants.UNIT && position.y - v.y > 0.0f * GameConstants.UNIT) {
					position.y -= 0.15f * GameConstants.UNIT;
				}
				return;
			} else {
				isGrounded = false;
			}
		}
	}
	
	public void checkJumpClearance() {
		for(Platform p : Game.platforms) {
			if((Math.abs(position.x - p.position.x) < GameConstants.UNIT / 2) && (p.position.y - position.y <= 1.15f * GameConstants.UNIT) && (position.y - p.position.y <= 0) && !(p instanceof ClippablePlatform)) {
				hasClearance = false;
				return;
			} else {
				hasClearance = true;
			}
		}
		/*
		for(Vector3f v : Game.platformPos) {
			if((Math.abs(position.x - v.x) < GameConstants.UNIT / 2) && (v.y - position.y <= 1.15f * GameConstants.UNIT) && (position.y - v.y <= 0)) {
				hasClearance = false;
				return;
			} else {
				hasClearance = true;
			}
		}
		*/
	}
	
	public void checkForCollision() {
		if(facingRight && Game.isPlatformAtLocation(MathUtils.convertToBlockPos(position.x) + 1, MathUtils.convertToBlockPos(position.y) + 4)) {
			if((Game.getPlatformAtLocation(MathUtils.convertToBlockPos(position.x) + 1, MathUtils.convertToBlockPos(position.y) + 4).position.x - position.x) < 0.5) {
				position.x -= 0.05;
				colliding = true;
			}
			if((Game.getPlatformAtLocation(MathUtils.convertToBlockPos(position.x) + 1, MathUtils.convertToBlockPos(position.y) + 4).position.x - position.x) < 0.45) {
				colliding = true;
			}
		} else if(!facingRight && Game.isPlatformAtLocation(MathUtils.convertToBlockPos(position.x), MathUtils.convertToBlockPos(position.y) + 4)) {
			if(position.x - (Game.getPlatformAtLocation(MathUtils.convertToBlockPos(position.x), MathUtils.convertToBlockPos(position.y) + 4).position.x) < 0.5) {
				position.x += 0.05;
				colliding = true;
			}
		} else {
			colliding = false;
		}
	}
	
	public void checkForClip() {
		if((Game.getPlatformAtLocation(MathUtils.convertToBlockPos(position.x) + 1, MathUtils.convertToBlockPos(position.y) + 4).position.x - position.x) < 0.5) {
			
		}
	}
	
	public boolean isJumping() {
		return jumping;
	}
	
	public void setPlayerType(PlayerType type) {
		switch(type) {
			case DOCTOR:
				walkLeft = Textures.walkLeft;
				walkRight = Textures.walkRight;
				idleL = Textures.standL;
				idleR = Textures.standR;
				break;
			case MARIO:
				walkLeft = Textures.marioLeft;
				walkRight = Textures.marioRight;
				idleL = Textures.MstandL;
				idleR = Textures.MstandR;
				break;
		}
	}
	
	public enum PlayerType {
		DOCTOR, MARIO;
	}

	@Override
	public void update() { }
	
}
