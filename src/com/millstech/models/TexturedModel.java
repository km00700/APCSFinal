package com.millstech.models;

import com.millstech.textures.ModelTexture;

public class TexturedModel {
	private RawModel rawModel;
	private ModelTexture texture;
	
	public TexturedModel(RawModel model, ModelTexture tex) {
		rawModel = model;
		texture = tex;
	}

	public RawModel getRawModel() {
		return rawModel;
	}

	public ModelTexture getTexture() {
		return texture;
	}
	
	public void setTexture(ModelTexture tex) {
		texture = tex;
	}
}
