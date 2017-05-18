package com.millstech.engine.audio;

import java.io.*;
import java.util.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.util.WaveData;

import com.millstech.entities.Entity;

public class MasterAudio {
	
	private static List<Integer> buffers = new ArrayList<Integer>();
	
	public static void initialize() {
		try {
			AL.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public static void cleanUp() {
		for(Integer i : buffers) {
			AL10.alDeleteBuffers(i);
		}
		AL.destroy();
	}
	
	public static void setListenerProps() {
		AL10.alListener3f(AL10.AL_POSITION, 0, 0, 0);
		AL10.alListener3f(AL10.AL_VELOCITY, 0, 0, 0);
	}
	
	public static void follow(Entity e) {
		AL10.alListener3f(AL10.AL_POSITION, e.getPosition().x, e.getPosition().y, e.getPosition().z);
	}
	
	public static int loadSound(String file) {
		int buffer = AL10.alGenBuffers();
		buffers.add(buffer);
		WaveData waveFile = WaveData.create(file);
		AL10.alBufferData(buffer, waveFile.format, waveFile.data, waveFile.samplerate);
		waveFile.dispose();
		return buffer;
	}
}
