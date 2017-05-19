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
		System.out.println("stopping");
		sound.stop();
	}
	
	public void stopThread() {
		exit = true;
	}
}
