package com.millstech.engine.audio;

import java.io.*;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.util.WaveData;

import com.millstech.entities.Entity;

public class AudioMaster {
	
	private static List<Integer> buffers = new ArrayList<Integer>();
	
	public static void initialize() {
		try {
			AL.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setListenerData() {
		AL10.alListener3f(AL10.AL_POSITION, 0, 0, 0);
		AL10.alListener3f(AL10.AL_VELOCITY, 0, 0, 0);
	}
	
	public static void follow(Entity e) {
		AL10.alListener3f(AL10.AL_POSITION, e.getPosition().x, e.getPosition().y, e.getPosition().z);
	}
	
	public static AudioInputStream getStream(String filePath) {
		File soundFile = new File(filePath);
		AudioInputStream audioInputStream = null;
	    try {
	      audioInputStream = AudioSystem.getAudioInputStream(soundFile);
	    } catch (Exception ex) { }
		return audioInputStream;
	}
	
	public static int loadSound(String filePath) {
		int buffer = AL10.alGenBuffers();
		buffers.add(buffer);
		
		WaveData waveFile = null;
		try {
			waveFile = WaveData.create(new BufferedInputStream(new FileInputStream(filePath)));
		} catch (FileNotFoundException e) { }
		
		if(waveFile != null) {
			AL10.alBufferData(buffer, waveFile.format, waveFile.data, waveFile.samplerate);
			waveFile.dispose();
		} else {
			System.out.println("NO WAVEFILE");
		}
		return buffer;
	}
	
	public static int loadSound(AudioInputStream stream) {
		int buffer = AL10.alGenBuffers();
		buffers.add(buffer);
		
		WaveData waveFile = null;
		try {
			waveFile = WaveData.create(stream);
		} catch (Exception e) { }
		
		if(waveFile != null) {
			AL10.alBufferData(buffer, waveFile.format, waveFile.data, waveFile.samplerate);
			waveFile.dispose();
		} else {
			System.out.println("NO WAVEFILE");
		}
		return buffer;
	}
	
	public static void cleanUp() {
		for(Integer i : buffers) {
			AL10.alDeleteBuffers(i);
		}
		AL.destroy();
	}
}
