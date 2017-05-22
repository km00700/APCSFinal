package com.millstech.engine.audio;

public class RunnableSound implements Runnable {
	private volatile boolean exit = false;
	private Sound sound;
	
	public RunnableSound(Sound soundIn) {
		sound = soundIn;
	}
	
	@Override
	public void run() {
		while(!exit) {
			sound.play();
		}
		sound.stop();
	}
	
	public void reset() {
		exit = false;
	}
	
	public void stopThread() {
		exit = true;
	}
	
	public Sound getSound() {
		return sound;
	}
}
