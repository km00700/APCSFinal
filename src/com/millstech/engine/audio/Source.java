package com.millstech.engine.audio;

import org.lwjgl.openal.AL10;

public class Source {
	private int sourceID;
	
	public Source() {
		sourceID = AL10.alGenSources();
	}
	
	public void play(int buffer) {
		AL10.alSourcei(sourceID, AL10.AL_BUFFER, buffer);
		AL10.alSourcePlay(sourceID);
	}
	
	public void setPosition(float x, float y, float z) {
		AL10.alSource3f(sourceID, AL10.AL_POSITION, x, y, z);
	}
	
	public void setVolume(float volume) {
		AL10.alSourcef(sourceID, AL10.AL_GAIN, 1);
	}
	
	public void setPitch(float pitch) {
		AL10.alSourcef(sourceID, AL10.AL_PITCH, 1);
	}
	
	public void setLooping(boolean loop) {
		AL10.alSourcei(sourceID, AL10.AL_LOOPING, loop ? AL10.AL_TRUE : AL10.AL_FALSE);
	}
	
	public boolean isPlaying() {
		return AL10.alGetSourcei(sourceID, AL10.AL_SOURCE_STATE) == AL10.AL_PLAYING;
	}
	
	public void delete() {
		AL10.alDeleteSources(sourceID);
	}
	
	public int getID() {
		return sourceID;
	}
}
