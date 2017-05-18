package com.millstech.entities.map;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.millstech.entities.Entity;
import com.millstech.game.Game;
import com.millstech.models.RawModel;
import com.millstech.models.TexturedModel;
import com.millstech.textures.ModelTexture;
import com.millstech.toolbox.MathUtils;

public class CheckPoint extends Entity implements Updatable {
	private List<ModelTexture> textureList;
	
	public CheckPoint(List<ModelTexture> list, RawModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(new TexturedModel(model, list.get(0)), position, rotX, rotY, rotZ, scale);
		textureList = list;
	}

	public void update() {
		if(MathUtils.convertToBlockPos(Game.character.getPosition().x) == MathUtils.convertToBlockPos(position.x)) {
			trigger();
		}
	}
	
	public void trigger() {
		super.getModel().setTexture(textureList.get(1));
		Game.getCurrentLevel().onCheckpointTrigger();
	}
}
