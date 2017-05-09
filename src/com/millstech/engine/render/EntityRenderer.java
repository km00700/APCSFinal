package com.millstech.engine.render;

import java.util.*;

import org.lwjgl.opengl.*;
import org.lwjgl.util.vector.*;

import com.millstech.engine.render.shaders.StaticShader;
import com.millstech.entities.Entity;
import com.millstech.models.RawModel;
import com.millstech.models.TexturedModel;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.MathUtils;

public class EntityRenderer {
	
	private StaticShader shader;
	
	public EntityRenderer(StaticShader shaderIn, Matrix4f mat) {
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
		shader = shaderIn;
		shader.start();
		shader.loadProjectionMatrix(mat);
		shader.stop();
	}
	
	/*
	public void prepare() {
		prepare(0.0f, 1.5f, 0.0f);
	}
	
	public void prepare(float red, float green, float blue) {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(red, green, blue, 1);
	}
	*/
	public void render(Map<TexturedModel, List<Entity>> entities) {
		for(TexturedModel model : entities.keySet()) {
			prepareTexturedModel(model);
			List<Entity> batch = entities.get(model);
			for(Entity e : batch) {
				prepareInstance(e);
				GL11.glDrawElements(GL11.GL_TRIANGLES, model.getRawModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
			}
		}
	}
	
	public void renderForeground(Map<TexturedModel, List<Entity>> entities) {
		for(TexturedModel model : entities.keySet()) {
			prepareTexturedModel(model);
			List<Entity> batch = entities.get(model);
			for(Entity e : batch) {
				prepareInstance(e);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glDrawElements(GL11.GL_TRIANGLES, model.getRawModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
				GL11.glDisable(GL11.GL_BLEND);
			}
		}
	}
	
	private void prepareTexturedModel(TexturedModel model) {
		RawModel rModel= model.getRawModel();
		GL30.glBindVertexArray(rModel.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glEnableVertexAttribArray(2);
        ModelTexture texture = model.getTexture();
        if(texture.isTransparent()) {
        	MasterRender.disableCulling();
        } else {
        	MasterRender.enableCulling();
        }
        shader.loadShineVariables(texture.getShineDamper(), texture.getReflectivity());
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getID());
    }
	
	public void unbindTexturedModel() {
		GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL20.glDisableVertexAttribArray(2);
        GL30.glBindVertexArray(0);
	}

	private void prepareInstance(Entity entity) {
		Matrix4f transformationMatrix = MathUtils.createTransformationMatrix(entity.getPosition(), entity.getRotX(), entity.getRotY(), entity.getRotZ(), entity.getScale());
        shader.loadTransformationMatrix(transformationMatrix);
    }
	
	/*
	public void render(RawModel model){
        GL30.glBindVertexArray(model.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
    }
	
	public void render(TexturedModel texturedModel) {
		RawModel model= texturedModel.getRawModel();
		GL30.glBindVertexArray(model.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturedModel.getTexture().getID());
        GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL30.glBindVertexArray(0);
	}
	
	public void render(Entity entity, StaticShader shader) {
		TexturedModel texturedModel = entity.getModel();
		RawModel model= texturedModel.getRawModel();
		GL30.glBindVertexArray(model.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glEnableVertexAttribArray(2);
        Matrix4f transformationMatrix = MathUtils.createTransformationMatrix(entity.getPosition(), entity.getRotX(), entity.getRotY(), entity.getRotZ(), entity.getScale());
        shader.loadTransformationMatrix(transformationMatrix);
        
        ModelTexture texture = texturedModel.getTexture();
        shader.loadShineVariables(texture.getShineDamper(), texture.getReflectivity());
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturedModel.getTexture().getID());
        GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL20.glDisableVertexAttribArray(2);
        GL30.glBindVertexArray(0);
	}
	*/
	
}
