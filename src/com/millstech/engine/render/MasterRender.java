package com.millstech.engine.render;

import java.util.*;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;

import com.millstech.engine.render.shaders.*;
import com.millstech.entities.*;
import com.millstech.models.*;
import com.millstech.toolbox.GameConstants;

public class MasterRender {
	private StaticShader shader = new StaticShader();
	private EntityRenderer renderer;
	
	private static final float FOV = 70;
	private static final float NEAR_PLANE = 0.05F;
	private static final float FAR_PLANE = 1000F;
	
	private Matrix4f projectionMatrix;
	
	private Map<TexturedModel, List<Entity>> entities = new HashMap<TexturedModel, List<Entity>>();
	
	public MasterRender() {
		enableCulling();
		createProjectionMatrix();
		renderer = new EntityRenderer(shader, projectionMatrix);
	}
	
	public static void enableCulling() {
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
	}
	
	public static void disableCulling() {
		GL11.glDisable(GL11.GL_CULL_FACE);
	}
	
	public void render(Light sun, Camera camera) {
		prepare();
		shader.start();
		shader.loadLight(sun);
		shader.loadViewMatrix(camera);
		
		renderer.render(entities);
		
		shader.stop();
		entities.clear();
	}
	
	public void processEntity(Entity entity) {
		entity.updateVisible();
		TexturedModel entityModel = entity.getModel();
		List<Entity> batch = entities.get(entityModel);
		if(batch != null) {
			if(entity.isVisible()) {
				batch.add(entity);
			}
		} else {
			List<Entity> newBatch = new ArrayList<Entity>();
			if(entity.isVisible()) {
				newBatch.add(entity);
				entities.put(entityModel, newBatch);
			}
		}
	}
	
	public void cleanUp() {
		shader.cleanUp();
	}
	
	public void prepare() {
		prepare(GameConstants.DEFAULT_BG_COLOR.x, GameConstants.DEFAULT_BG_COLOR.y, GameConstants.DEFAULT_BG_COLOR.z);
	}
	
	public void prepare(float red, float green, float blue) {
		if(GameConstants.PERSPECTIVE) GL11.glEnable(GL11.GL_DEPTH_TEST);
		else GL11.glDepthFunc(GL11.GL_NEVER);  
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(red, green, blue, 1);
	}
	
	private void createProjectionMatrix() {
		float aspectRatio = (float) Display.getWidth() / (float) Display.getHeight();
        float y_scale = (float) ((1f / Math.tan(Math.toRadians(FOV/2f))) * aspectRatio);
        float x_scale = y_scale / aspectRatio;
        float frustum_length = FAR_PLANE - NEAR_PLANE;
       
        float scale = (float) Math.tan(Math.toRadians(FOV/2f) * 2.163); 
        float r = aspectRatio * scale, l = -r; 
        float t = scale, b = -t; 
        
        projectionMatrix = new Matrix4f();
        if(GameConstants.PERSPECTIVE) {
        	projectionMatrix.m00 = x_scale;
	        projectionMatrix.m11 = y_scale;
	        projectionMatrix.m22 = -((FAR_PLANE + NEAR_PLANE) / frustum_length);
	        projectionMatrix.m23 = -1;
	        projectionMatrix.m32 = -((2 * NEAR_PLANE * FAR_PLANE) / frustum_length);
	        projectionMatrix.m33 = 0;
        } else {
	        projectionMatrix.m00 = 2 / (r - l);
	        projectionMatrix.m11 = 2 / (t - b);
	        projectionMatrix.m22 = -2 / (2 * FAR_PLANE - 2 * NEAR_PLANE);
	        projectionMatrix.m30 = -(r + l) / (r - l);
	        projectionMatrix.m31 = -(t + b) / (t - b);
	        projectionMatrix.m32 = -(2 * FAR_PLANE + 2 * NEAR_PLANE) / (2 * FAR_PLANE - 2 * NEAR_PLANE);
	        projectionMatrix.m33 = 1;
	   }
    }
}
