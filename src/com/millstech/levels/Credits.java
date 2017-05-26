package com.millstech.levels;

import com.millstech.entities.PlayerEntity;
import com.millstech.game.Game;
import com.millstech.game.audio.Sounds;
import com.millstech.textures.CreditsTextures;
import com.millstech.textures.Textures;
import com.millstech.toolbox.TileUtils;
import com.millstech.toolbox.TileUtils.Layer;

public class Credits implements Level {
	public int spawnX = 0, spawnY = 4, counter = 0, counterMax = 4200; //Max Counter = (-1 * bottomYValue / 0.006f) / scale
	public final float scale = 0.7f;
	
	@Override
	public void update() {
		counter++;
		if(counter > counterMax) {
			Game.loadLevel(0);
		}
	}
	
	public void loadLevel() {
		Game.stopSound();
		loadEntities();
		loadBackground();
        loadPlatforms();
        loadForeground();
        loadOffMap();
        Game.setCurrentMusic(Sounds.Theme);
        Game.startSoundFromBeginning();
	}
	
	@Override
	public PlayerEntity spawn() {
		Game.purgePlayers();
		return TileUtils.createScriptedCharacter(spawnX, spawnY, false, false, false, false);
	}

	@Override
	public void loadBackground() {
		TileUtils.createBGSplashTile(Textures.credits, 0.0f, 3.75f);
		//TileUtils.createBGImage(Textures.credits);
	}

	@Override
	public void loadForeground() {
		//////////////////////////////
		//          TITLES          //
		//////////////////////////////
		
		//PRODUCTION MANAGER
		TileUtils.createMovingTile(CreditsTextures.prod1, -5, 0, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.prod2, -4, 0, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.prod3, -3, 0, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.prod4, -2, 0, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.prod5, -1, 0, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.prod6, 0, 0, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.prod7, 1, 0, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.prod8, 2, 0, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.prod9, 3, 0, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.prod10, 4, 0, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.prod11, 5, 0, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		
		//LEVEL DESIGNER
		TileUtils.createMovingTile(CreditsTextures.lev1, -3, -5, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.lev2, -2, -5, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.lev3, -1, -5, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.lev4, 0, -5, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.lev5, 1, -5, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.lev6, 2, -5, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.lev7, 3, -5, 0.0f, 0.006f, Layer.FOREGROUND, scale);

		//TEXTURE DESIGN
		TileUtils.createMovingTile(CreditsTextures.tex1, -3, -10, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.tex2, -2, -10, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.tex3, -1, -10, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.tex4, 0, -10, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.tex5, 1, -10, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.tex6, 2, -10, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.tex7, 3, -10, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		
		//MUSIC:
		TileUtils.createMovingTile(CreditsTextures.mus1, -1, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.mus2, 0, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.mus3, 1, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		
		//"I Am the Doctor"
		TileUtils.createMovingTile(CreditsTextures.iatd1, -3, -17, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.iatd2, -2, -17, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.iatd3, -1, -17, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.iatd4, 0, -17, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.iatd5, 1, -17, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.iatd6, 2, -17, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.iatd7, 3, -17, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		
		//"Doctor Who Theme"
		TileUtils.createMovingTile(CreditsTextures.theme1, -4, -18, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.theme2, -3, -18, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.theme3, -2, -18, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.theme4, -1, -18, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.theme5, 0, -18, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.theme6, 1, -18, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.theme7, 2, -18, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.theme8, 3, -18, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.theme9, 4, -18, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		//////////////////////////////
		//           NAMES          //
		//////////////////////////////
		
		//Kai Mills
		TileUtils.createMovingTile(CreditsTextures.kai1, -1, -2, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.kai2, 0, -2, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.kai3, 1, -2, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		
		//Ryan Mintzer
		TileUtils.createMovingTile(CreditsTextures.ryan1, -2, -7, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.ryan2, -1, -7, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.ryan3, 0, -7, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.ryan4, 1, -7, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.ryan5, 2, -7, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		
		//Kai Mills & Ryan Mintzer
		TileUtils.createMovingTile(CreditsTextures.kai1, -4, -12, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.kai2, -3, -12, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.kai3, -2, -12, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.and, -1, -12, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.ryan1, 0, -12, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.ryan2, 1, -12, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.ryan3, 2, -12, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.ryan4, 3, -12, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.ryan5, 4, -12, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		
		//Murray Gold
		TileUtils.createMovingTile(CreditsTextures.murray1, -2, -20, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.murray2, -1, -20, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.murray3, 0, -20, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.murray4, 1, -20, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(CreditsTextures.murray5, 2, -20, 0.0f, 0.006f, Layer.FOREGROUND, scale);
	}

	@Override
	public void loadPlatforms() {
	
	}
	
	@Override
	public void loadEntities() {
		
	}
	
	@Override
	public void loadOffMap() {}

	@Override
	public int getMaxX() {
		return 255;
	}

	@Override
	public void completed() { }

	@Override
	public void onCheckpointTrigger() { }

	@Override
	public boolean hasDynamicCamera() {
		return true;
	}
	
	/* TEMPLATE
	 	TileUtils.createMovingTile(Textures.invisable, -8, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, -7, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, -6, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, -5, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, -4, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, -3, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, -2, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, -1, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, 0, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, 1, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, 2, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, 3, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, 4, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, 5, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, 6, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, 7, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
		TileUtils.createMovingTile(Textures.invisable, 8, -15, 0.0f, 0.006f, Layer.FOREGROUND, scale);
	 */
}
