package com.millstech.engine.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Sound {
	private SourceDataLine line = null;
	private byte[] audioBytes;
	private int numBytes;
	private Clip c;
	public Sound(String fileName) {
		File soundFile = new File(fileName);
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception ex) {
			System.out.println("*** Cannot find " + fileName + " ***");
			System.exit(1);
		}

		AudioFormat audioFormat = audioInputStream.getFormat();
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		try {
			c = AudioSystem.getClip();
			c.open(audioInputStream);
		} catch (LineUnavailableException e) { } catch (IOException e) {
			e.printStackTrace();
		}
		/*
		try {
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(audioFormat);
		} catch (LineUnavailableException ex) {
			System.out.println("*** Audio line unavailable ***");
			System.exit(1);
		}

		line.start();

		audioBytes = new byte[(int) soundFile.length()];

		try {
			numBytes = audioInputStream.read(audioBytes, 0, audioBytes.length);
		} catch (IOException ex) {
			System.out.println("*** Cannot read " + fileName + " ***");
			System.exit(1);
		}
		*/
	}
	
	public boolean isPlaying() {
		return line.isActive();
	}

	public void play() {
		c.start();
		//line.write(audioBytes, 0, numBytes);
	}

	public void stop() {
		c.stop();
	}
	
	public void pause() {
		line.stop();
	}
}
