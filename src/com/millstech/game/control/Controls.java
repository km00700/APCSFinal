package com.millstech.game.control;

import org.lwjgl.input.Keyboard;

public class Controls {
	private static int right = Keyboard.KEY_D, left = Keyboard.KEY_A, jump = Keyboard.KEY_W, jump2 = Keyboard.KEY_SPACE, attack = Keyboard.KEY_RETURN, exit = Keyboard.KEY_ESCAPE, debug_rl = Keyboard.KEY_R;
	
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
		return (Keyboard.isKeyDown(jump) || Keyboard.isKeyDown(jump2)) && !Keyboard.isRepeatEvent();
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
}
