package com.millstech.engine.audio;

public class SoundThreadManager {
	private RunnableSound rSound;
	private Thread sThread;
	
	public SoundThreadManager(Sound soundIn, String name) {
		rSound = new RunnableSound(soundIn);
		sThread = new Thread(rSound, "name");
	}
	
	public void start() {
		sThread.start();
	}
	
	public void stop() {
		rSound.stopThread();
	}
	
	public RunnableSound getRunnableSound() {
		return rSound;
	}	
}
