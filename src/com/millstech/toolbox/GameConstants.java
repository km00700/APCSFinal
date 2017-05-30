package com.millstech.toolbox;

import org.lwjgl.util.vector.Vector3f;

public class GameConstants {
	public static final String TITLE = "Doctor Who: Quest of the TARDIS";
	
	public static final float UNIT = 0.75f;
	public static final float CAMERA_UNIT = 6.99300703288f;
	public static final Vector3f DEFAULT_BG_COLOR = new Vector3f(0.0f, 0.75f, 1.0f); //LIGHT SKY(0.0f, 0.75f, 1.0f) DARK SKY(0.2f, 0.375f, 0.5f)
	public static final float RENDER_DISTANCE = 8.0f; //8
	public static final float LAYER_SPACING = 0.003f;
	public static final float LOWER_BOUND = 0 * UNIT;
	public static final float UPPER_BOUND = 255 * UNIT;
	public static final float KILL_HEIGHT = -10 * UNIT;
	
	public static final int DEFAULT_LIVES = 5;
	public static final int DEFAULT_HEALTH = 5;
	
	public static final boolean PERSPECTIVE = true;
}
