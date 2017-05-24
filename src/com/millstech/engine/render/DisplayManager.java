package com.millstech.engine.render;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

import com.millstech.toolbox.GameConstants;

public class DisplayManager {
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static final int WIDTH = screenSize.width, HEIGHT = 720, FPS_CAP = 120;
	
	
	public static void createDisplay() {
		createDisplay(" ");
	}
	
	public static void createDisplay(String title) {
		
		ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle(GameConstants.TITLE);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	public static void updateDisplay() {
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	public static void closeDisplay() {
		Display.destroy();
	}
}
