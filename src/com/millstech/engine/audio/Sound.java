package com.millstech.engine.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Sound {
	private SourceDataLine line = null;
	private Clip c;
	public Sound(String fileName, boolean looping) {
		File soundFile = new File(fileName);
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception ex) {
			System.out.println("*** Cannot find " + fileName + " ***");
			System.exit(1);
		}

		//AudioFormat audioFormat = audioInputStream.getFormat();
		//DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		try {
			c = AudioSystem.getClip();
			c.open(audioInputStream);
			if(looping) c.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (LineUnavailableException e) { } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isPlaying() {
		return line.isActive();
	}

	public void play() {
		c.start();
	}

	public void setToStart() {
		c.setFramePosition(0);
	}
	
	public void stop() {
		c.stop();
	}
}
