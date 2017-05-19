package com.millstech.engine.audio;

public class SoundThreadManager {
	private RunnableSound rSound;
	private Thread sThread;
	private String name;
	
	public SoundThreadManager(Sound soundIn, String nameIn) {
		rSound = new RunnableSound(soundIn);
		name = nameIn;
	}
	
	public SoundThreadManager(RunnableSound rSoundIn, String nameIn) {
		rSound = rSoundIn;
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
		sThread.interrupt();
		rSound.getSound().stop();
	}
	
	public void setRunnableSound(RunnableSound r) {
		rSound = r;
	}
	
	public void loadRunnableSound(RunnableSound r, String n) {
		rSound = r;
		name = n;
	}
	
	public RunnableSound getRunnableSound() {
		return rSound;
	}

	public String getName() {
		return name;
	}	
	
}
