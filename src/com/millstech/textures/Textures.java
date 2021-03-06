package com.millstech.textures;

import com.millstech.game.Game;
import java.util.*;

public class Textures {
	//////////////////////////////
	//         ENTITIES         //
	//////////////////////////////
	//Player
	public static ModelTexture standR = new ModelTexture(Game.loader.loadTexture("entity/char/char_standingL"));
	public static ModelTexture standL = new ModelTexture(Game.loader.loadTexture("entity/char/char_standingLI"));
	public static ModelTexture walkR00 = new ModelTexture(Game.loader.loadTexture("entity/char/char_walking00L"));
	public static ModelTexture walkR11 = new ModelTexture(Game.loader.loadTexture("entity/char/char_walking11L"));
	public static ModelTexture walkR12 = new ModelTexture(Game.loader.loadTexture("entity/char/char_walking12L"));
	public static ModelTexture walkR21 = new ModelTexture(Game.loader.loadTexture("entity/char/char_walking12L"));
	public static ModelTexture walkR22 = new ModelTexture(Game.loader.loadTexture("entity/char/char_walking22L"));
	public static List<ModelTexture> walkRight = new ArrayList<ModelTexture>(Arrays.asList(walkR00, walkR11, walkR12, walkR00, walkR21, walkR22));
	public static ModelTexture walkL00 = new ModelTexture(Game.loader.loadTexture("entity/char/char_walking00LI"));
	public static ModelTexture walkL11 = new ModelTexture(Game.loader.loadTexture("entity/char/char_walking11LI"));
	public static ModelTexture walkL12 = new ModelTexture(Game.loader.loadTexture("entity/char/char_walking12LI"));
	public static ModelTexture walkL21 = new ModelTexture(Game.loader.loadTexture("entity/char/char_walking21LI"));
	public static ModelTexture walkL22 = new ModelTexture(Game.loader.loadTexture("entity/char/char_walking22LI"));
	public static List<ModelTexture> walkLeft = new ArrayList<ModelTexture>(Arrays.asList(walkL00, walkL11, walkL12, walkL00, walkL21, walkL22));
	//Mario Player
	public static ModelTexture MstandR = new ModelTexture(Game.loader.loadTexture("entity/mario/standR"));
	public static ModelTexture MstandL = new ModelTexture(Game.loader.loadTexture("entity/mario/standL"));
	public static ModelTexture MwalkR00 = new ModelTexture(Game.loader.loadTexture("entity/mario/00R"));
	public static ModelTexture MwalkR11 = new ModelTexture(Game.loader.loadTexture("entity/mario/11R"));
	public static ModelTexture MwalkR12 = new ModelTexture(Game.loader.loadTexture("entity/mario/12R"));
	public static List<ModelTexture> marioRight = new ArrayList<ModelTexture>(Arrays.asList(MwalkR00, MwalkR11,MwalkR12, MwalkR00));
	public static ModelTexture MwalkL00 = new ModelTexture(Game.loader.loadTexture("entity/mario/00L"));
	public static ModelTexture MwalkL11 = new ModelTexture(Game.loader.loadTexture("entity/mario/11L"));
	public static ModelTexture MwalkL12 = new ModelTexture(Game.loader.loadTexture("entity/mario/12L"));
	public static List<ModelTexture> marioLeft = new ArrayList<ModelTexture>(Arrays.asList(MwalkL00, MwalkL11, MwalkL12, MwalkL00));
	//////////////////////////////
	//       MAP OBJECTS        //
	//////////////////////////////
	//Tardis
	public static ModelTexture tardisTop = new ModelTexture(Game.loader.loadTexture("map-objects/tardis/top"));
	public static ModelTexture tardisBottom = new ModelTexture(Game.loader.loadTexture("map-objects/tardis/bottom"));
	//Pyramid
	public static ModelTexture pyramid0 = new ModelTexture(Game.loader.loadTexture("map-objects/pyramid/0"));
	public static ModelTexture pyramid1 = new ModelTexture(Game.loader.loadTexture("map-objects/pyramid/1"));
	public static ModelTexture pyramid2 = new ModelTexture(Game.loader.loadTexture("map-objects/pyramid/2"));
	public static ModelTexture pyramid3 = new ModelTexture(Game.loader.loadTexture("map-objects/pyramid/3"));
	public static ModelTexture pyramid4 = new ModelTexture(Game.loader.loadTexture("map-objects/pyramid/4"));
	public static ModelTexture pyramid5 = new ModelTexture(Game.loader.loadTexture("map-objects/pyramid/5"));
	public static ModelTexture pyramid6 = new ModelTexture(Game.loader.loadTexture("map-objects/pyramid/6"));
	public static ModelTexture pyramid7 = new ModelTexture(Game.loader.loadTexture("map-objects/pyramid/7"));
	public static ModelTexture pyramid8 = new ModelTexture(Game.loader.loadTexture("map-objects/pyramid/8"));
	//Tree
	public static ModelTexture tree1 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/1"));
	public static ModelTexture tree2 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/2"));
	public static ModelTexture tree3 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/3"));
	public static ModelTexture tree4 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/4"));
	public static ModelTexture tree5 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/5"));
	public static ModelTexture tree6 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/6"));
	public static ModelTexture tree7 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/7"));
	public static ModelTexture tree8 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/8"));
	public static ModelTexture tree9 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/9"));
	public static ModelTexture tree10 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/10"));
	public static ModelTexture tree11 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/11"));
	public static ModelTexture tree12 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/12"));
	public static ModelTexture tree13 = new ModelTexture(Game.loader.loadTexture("map-objects/tree/13"));
	public static ModelTexture log = new ModelTexture(Game.loader.loadTexture("map-objects/tree/log"));
	//Column
	public static ModelTexture column1 = new ModelTexture(Game.loader.loadTexture("map-objects/column/1"));
	public static ModelTexture column2 = new ModelTexture(Game.loader.loadTexture("map-objects/column/2"));
	public static ModelTexture column3 = new ModelTexture(Game.loader.loadTexture("map-objects/column/3"));
	//Aqueduct
	public static ModelTexture duct1 = new ModelTexture(Game.loader.loadTexture("map-objects/aqueduct/1"));
	public static ModelTexture duct2 = new ModelTexture(Game.loader.loadTexture("map-objects/aqueduct/2"));
	public static ModelTexture duct3 = new ModelTexture(Game.loader.loadTexture("map-objects/aqueduct/3"));
	public static ModelTexture duct4 = new ModelTexture(Game.loader.loadTexture("map-objects/aqueduct/4"));
	//////////////////////////////
	//          TERRAIN         //
	//////////////////////////////
	public static ModelTexture rock = new ModelTexture(Game.loader.loadTexture("terrain/rock"));
	//Dirt Variants
	public static ModelTexture dirt = new ModelTexture(Game.loader.loadTexture("terrain/ground/dirt/dirt"));
	public static ModelTexture grass = new ModelTexture(Game.loader.loadTexture("terrain/ground/dirt/grass"));
	public static ModelTexture grass2 = new ModelTexture(Game.loader.loadTexture("terrain/ground/dirt/grass2"));
	public static List<ModelTexture> grasses = new ArrayList<ModelTexture>(Arrays.asList(grass, grass2));
	//Sand Variants
	public static ModelTexture sand = new ModelTexture(Game.loader.loadTexture("terrain/ground/sand/sand"));
	public static ModelTexture sandL = new ModelTexture(Game.loader.loadTexture("terrain/ground/sand/endL"));
	public static ModelTexture sandR = new ModelTexture(Game.loader.loadTexture("terrain/ground/sand/endR"));
	//Stone Variants
	public static ModelTexture stone = new ModelTexture(Game.loader.loadTexture("terrain/ground/stone/1"));
	public static ModelTexture stoneUL = new ModelTexture(Game.loader.loadTexture("terrain/ground/stone/2"));
	public static ModelTexture stoneUR = new ModelTexture(Game.loader.loadTexture("terrain/ground/stone/3"));
	public static ModelTexture stoneDL = new ModelTexture(Game.loader.loadTexture("terrain/ground/stone/4"));
	public static ModelTexture stoneDR = new ModelTexture(Game.loader.loadTexture("terrain/ground/stone/5"));
	public static ModelTexture stoneULI = new ModelTexture(Game.loader.loadTexture("terrain/ground/stone/6"));
	public static ModelTexture stoneURI = new ModelTexture(Game.loader.loadTexture("terrain/ground/stone/7"));
	public static ModelTexture stoneDLI = new ModelTexture(Game.loader.loadTexture("terrain/ground/stone/8"));
	public static ModelTexture stoneDRI = new ModelTexture(Game.loader.loadTexture("terrain/ground/stone/9"));
	public static ModelTexture stoneLedge = new ModelTexture(Game.loader.loadTexture("terrain/ground/stone/10"));
	//Water
	public static ModelTexture water1 = new ModelTexture(Game.loader.loadTexture("terrain/water/1"));
	public static ModelTexture water2 = new ModelTexture(Game.loader.loadTexture("terrain/water/2"));
	public static ModelTexture water3 = new ModelTexture(Game.loader.loadTexture("terrain/water/3"));
	public static ModelTexture water4 = new ModelTexture(Game.loader.loadTexture("terrain/water/4"));
	public static ModelTexture water5 = new ModelTexture(Game.loader.loadTexture("terrain/water/5"));
	public static ModelTexture water6 = new ModelTexture(Game.loader.loadTexture("terrain/water/6"));
	public static ModelTexture water7 = new ModelTexture(Game.loader.loadTexture("terrain/water/7"));
	public static ModelTexture water8 = new ModelTexture(Game.loader.loadTexture("terrain/water/8"));
	public static List<ModelTexture> waterAnim = new ArrayList<ModelTexture>(Arrays.asList(water1, water2, water3, water4, water5, water6, water7, water8));
	public static ModelTexture waterL1 = new ModelTexture(Game.loader.loadTexture("terrain/water/l1"));
	public static ModelTexture waterL2 = new ModelTexture(Game.loader.loadTexture("terrain/water/l2"));
	public static ModelTexture waterL3 = new ModelTexture(Game.loader.loadTexture("terrain/water/l3"));
	public static ModelTexture waterL4 = new ModelTexture(Game.loader.loadTexture("terrain/water/l4"));
	public static ModelTexture waterL5 = new ModelTexture(Game.loader.loadTexture("terrain/water/l5"));
	public static ModelTexture waterL6 = new ModelTexture(Game.loader.loadTexture("terrain/water/l6"));
	public static ModelTexture waterL7 = new ModelTexture(Game.loader.loadTexture("terrain/water/l7"));
	public static ModelTexture waterL8 = new ModelTexture(Game.loader.loadTexture("terrain/water/l8"));
	public static List<ModelTexture> waterLAnim = new ArrayList<ModelTexture>(Arrays.asList(waterL1, waterL2, waterL3, waterL4, waterL5, waterL6, waterL7, waterL8));
	public static ModelTexture waterR1 = new ModelTexture(Game.loader.loadTexture("terrain/water/r1"));
	public static ModelTexture waterR2 = new ModelTexture(Game.loader.loadTexture("terrain/water/r2"));
	public static ModelTexture waterR3 = new ModelTexture(Game.loader.loadTexture("terrain/water/r3"));
	public static ModelTexture waterR4 = new ModelTexture(Game.loader.loadTexture("terrain/water/r4"));
	public static ModelTexture waterR5 = new ModelTexture(Game.loader.loadTexture("terrain/water/r5"));
	public static ModelTexture waterR6 = new ModelTexture(Game.loader.loadTexture("terrain/water/r6"));
	public static ModelTexture waterR7 = new ModelTexture(Game.loader.loadTexture("terrain/water/r7"));
	public static ModelTexture waterR8 = new ModelTexture(Game.loader.loadTexture("terrain/water/r8"));
	public static List<ModelTexture> waterRAnim = new ArrayList<ModelTexture>(Arrays.asList(waterR1, waterR2, waterR3, waterR4, waterR5, waterR6, waterR7, waterR8));
	
	//////////////////////////////
	//         BACKGROUND       //
	//////////////////////////////
	public static ModelTexture level1 = new ModelTexture(Game.loader.loadTexture("background/l1"));
	public static ModelTexture credits = new ModelTexture(Game.loader.loadTexture("background/credits"));
	//public static ModelTexture  = new ModelTexture(Game.loader.loadTexture(""));
	//public static ModelTexture  = new ModelTexture(Game.loader.loadTexture(""));
	//CHECKPOINT
	public static ModelTexture checkPoint = new ModelTexture(Game.loader.loadTexture("map-objects/checkpoint/1"));
	public static ModelTexture checkPoint_CAP = new ModelTexture(Game.loader.loadTexture("map-objects/checkpoint/2"));
	public static List<ModelTexture> checkPointList = new ArrayList<ModelTexture>(Arrays.asList(checkPoint, checkPoint_CAP));
	//////////////////////////////
	//           GAME           //
	//////////////////////////////
	public static ModelTexture invisable = new ModelTexture(Game.loader.loadTexture("game/invisable"));
	public static ModelTexture missing = new ModelTexture(Game.loader.loadTexture("game/missing"));
	public static ModelTexture test = new ModelTexture(Game.loader.loadTexture("game/test"));
}
