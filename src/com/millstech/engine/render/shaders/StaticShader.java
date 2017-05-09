package com.millstech.engine.render.shaders;

import org.lwjgl.util.vector.*;

import com.millstech.entities.Camera;
import com.millstech.entities.Light;
import com.millstech.toolbox.MathUtils;

public class StaticShader extends ShaderProgram {

	private static final String VERTEX_FILE = "src/com/millstech/shaders/shader.vsh";
	private static final String FRAGMENT_FILE = "src/com/millstech/shaders/shader.fsh";
	
	private int location_tranformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	private int location_lightPosition;
	private int location_lightColor;
	private int location_shineDamper;
	private int location_reflectivity;
	
	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttrribute(0, "position");
		super.bindAttrribute(1, "textureCoords");
		super.bindAttrribute(2, "normal");
	}

	@Override
	protected void getAllUniformLocations() {
		location_tranformationMatrix = super.getUniformLocation("transformationMatrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
		location_lightPosition = super.getUniformLocation("lightPosition");
		location_lightColor = super.getUniformLocation("lightColor");
		location_shineDamper = super.getUniformLocation("shineDamper");
		location_reflectivity = super.getUniformLocation("reflectivity");
	}
	
	public void loadShineVariables(float shineDamper, float reflectivity) {
		super.loadFloat(this.location_shineDamper, shineDamper);
		super.loadFloat(this.location_reflectivity, reflectivity);
	}
	
	public void loadTransformationMatrix(Matrix4f transformation) {
		super.loadMatrix(location_tranformationMatrix, transformation);
	}
	
	public void loadLight(Light light) {
		super.loadVector(location_lightPosition, light.getPosition());
		super.loadVector(location_lightColor, light.getColor());
	}
	
	public void loadViewMatrix(Camera camera) {
		Matrix4f viewMatrix = MathUtils.createViewMatrix(camera);
		super.loadMatrix(location_viewMatrix, viewMatrix);
	}
	
	public void loadProjectionMatrix(Matrix4f projection) {
		super.loadMatrix(location_projectionMatrix, projection);
	}
}
