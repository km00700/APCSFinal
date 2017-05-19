package com.millstech.engine.audio;

public class SoundThreadManager {
	private RunnableSound rSound;
	private Thread sThread;
	private String name;
	
	public SoundThreadManager(Sound soundIn, String nameIn) {
		rSound = new RunnableSound(soundIn);
		name = nameIn;
	}
	
	public void start() {
		rSound.reset();
		sThread = new Thread(rSound, name);
		sThread.start();
	}
	
	public void startFromBeginning() {
		rSound.reset();
		rSound.getSound().setToStart();
		sThread = new Thread(rSound, name);
		sThread.start();
	}
	
	public void stop() {
		rSound.stopThread();
	}
	
	public RunnableSound getRunnableSound() {
		return rSound;
	}	
}
