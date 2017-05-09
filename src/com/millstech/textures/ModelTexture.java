package com.millstech.textures;

public class ModelTexture {
	private int textureID;
	
	private float shineDamper = 1;
	private float reflectivity = 0;
	
	private boolean transparent = false;
	
	public boolean isTransparent() {
		return transparent;
	}

	public void setTransparent(boolean hasTransparency) {
		transparent = hasTransparency;
	}

	public float getReflectivity() {
		return reflectivity;
	}

	public void setReflectivity(float reflectivity) {
		this.reflectivity = reflectivity;
	}
	
	public float getShineDamper() {
		return shineDamper;
	}

	public void setShineDamper(float damper) {
		shineDamper = damper;
	}

	public ModelTexture(int id) {
		textureID = id;
	}

	public int getID() {
		return textureID;
	}
}
