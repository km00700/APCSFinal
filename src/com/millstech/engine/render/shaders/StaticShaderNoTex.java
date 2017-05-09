package com.millstech.engine.render.shaders;

public class StaticShaderNoTex extends ShaderProgram {

	private static final String VERTEX_FILE = "src/com/millstech/shaders/vertexShader2.txt";
	private static final String FRAGMENT_FILE = "src/com/millstech/shaders/fragmentShader2.txt";
	
	public StaticShaderNoTex() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttrribute(0, "position");
		super.bindAttrribute(1, "textureCoords");
	}

	@Override
	protected void getAllUniformLocations() {
	
	}

}
