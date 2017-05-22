package com.millstech.engine.audio;

import org.lwjgl.openal.AL10;

import com.millstech.entities.Entity;

public class Source {
	private int sourceID;
	
	public Source() {
		sourceID = AL10.alGenSources();
	}
	
	public Source(boolean withInit) {
		sourceID = AL10.alGenSources();
		setPosition(0, 0, 0);
		setVolume(1);
		setPitch(1);
	}
	
	public void setPosition(float x, float y, float z) {
		AL10.alSource3f(sourceID, AL10.AL_POSITION, x, y, z);
	}
	
	public void follow(Entity e) {
		AL10.alSource3f(sourceID, AL10.AL_POSITION, e.getPosition().x, e.getPosition().y, e.getPosition().z);
	}
	
	public void setVolume(float volume) {
		AL10.alSourcef(sourceID, AL10.AL_GAIN, volume);
	}
	
	public void setPitch(float pitch) {
		AL10.alSourcef(sourceID, AL10.AL_PITCH, pitch);
	}
	
	public void setLooping(boolean loop) {
		AL10.alSourcei(sourceID, AL10.AL_LOOPING, loop ? AL10.AL_TRUE : AL10.AL_FALSE);
	}
	
	public boolean isPlaying() {
		return AL10.alGetSourcei(sourceID, AL10.AL_SOURCE_STATE) == AL10.AL_PLAYING;
	}
	
	public void play(int buffer) {
		stop();
		AL10.alSourcei(sourceID, AL10.AL_BUFFER, buffer);
		resume();
	}
	
	public void pause() {
		AL10.alSourcePause(sourceID);
	}
	
	public void resume() {
		AL10.alSourcePlay(sourceID);
	}
	
	public void stop() {
		AL10.alSourceStop(sourceID);
	}
	
	public void delete() {
		stop();
		AL10.alDeleteSources(sourceID);
	}
}
