package com.millstech.game.control;

import org.lwjgl.input.Keyboard;

public class Controls {
	private static int right = Keyboard.KEY_D, left = Keyboard.KEY_A, jump = Keyboard.KEY_W, jump2 = Keyboard.KEY_SPACE, attack = Keyboard.KEY_RETURN;
	
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
		return Keyboard.isKeyDown(jump) || Keyboard.isKeyDown(jump2);
	}
	
	public static boolean attack() {
		return Keyboard.isKeyDown(attack) && Keyboard.isRepeatEvent();
	}

}
