package com.millstech.game.control;

import org.lwjgl.input.Keyboard;

public class Controls {
	private static int right = Keyboard.KEY_D, left = Keyboard.KEY_A, jump = Keyboard.KEY_W, crouch = Keyboard.KEY_S, attack = Keyboard.KEY_RETURN, exit = Keyboard.KEY_ESCAPE, debug_rl = Keyboard.KEY_R;
	
	public static void initialize() {
		Keyboard.enableRepeatEvents(true);
	}
	
	public static boolean right() {
		return Keyboard.isKeyDown(right);
	}
	
	public static boolean left() {
		return Keyboard.isKeyDown(left);
	}
	
	public static boolean jump() {
		return Keyboard.isKeyDown(jump) && !Keyboard.isRepeatEvent();
	}
	
	public static boolean crouch() {
		return Keyboard.isKeyDown(crouch);
	}
	
	public static boolean attack() {
		return Keyboard.isKeyDown(attack) && !Keyboard.isRepeatEvent();
	}
	
	public static boolean exit() {
		return Keyboard.isKeyDown(exit) && !Keyboard.isRepeatEvent();
	}
	
	public static boolean reload() {
		return Keyboard.isKeyDown(debug_rl);
	}
	
	public static boolean upArrow() {
		return Keyboard.isKeyDown(Keyboard.KEY_UP);
	}
	
	public static boolean downArrow() {
		return Keyboard.isKeyDown(Keyboard.KEY_DOWN);
	}
	
	public static boolean leftArrow() {
		return Keyboard.isKeyDown(Keyboard.KEY_LEFT);
	}
	
	public static boolean rightArrow() {
		return Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
	}
}
