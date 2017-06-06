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
	public static ModelTexture pyramid0 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/0"));
	public static ModelTexture pyramid1 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/1"));
	public static ModelTexture pyramid2 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/2"));
	public static ModelTexture pyramid3 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/3"));
	public static ModelTexture pyramid4 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/4"));
	public static ModelTexture pyramid5 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/5"));
	public static ModelTexture pyramid6 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/6"));
	public static ModelTexture pyramid7 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/7"));
	public static ModelTexture pyramid8 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/8"));
	public static ModelTexture pyramid9 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/9"));
	public static ModelTexture pyramid10 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/10"));
	public static ModelTexture pyramid11 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/11"));
	public static ModelTexture pyramid12 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/pyramid/12"));
	//Egypt House
	public static ModelTexture egyptHouseWall = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/house/1"));
	public static ModelTexture egyptHouseDoor = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/house/2"));
	public static ModelTexture egyptHouseWindow = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/house/3"));
	public static ModelTexture egyptHouseWallEye = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/house/4"));
	public static ModelTexture egypthouseDecC = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/house/5"));
	public static ModelTexture egyptHouseDecL = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/house/6"));
	public static ModelTexture egyptHouseDecR = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/house/7"));
	//Egypt Stone Roller
	public static ModelTexture egyptStoneRollerL = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/stoneroller/1"));
	public static ModelTexture egyptStoneRollerR = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/stoneroller/2"));
	//Obelisk
	public static ModelTexture obeliskBottom = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/obelisk/1"));
	public static ModelTexture obeliskTop = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/obelisk/2"));
	//Scarab
	public static ModelTexture scarab1 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/scarab/1"));
	public static ModelTexture scarab2 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/scarab/2"));
	public static ModelTexture scarab3 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/scarab/3"));
	public static ModelTexture scarab4 = new ModelTexture(Game.loader.loadTexture("map-objects/egypt/scarab/4"));
	//Tree
	public static ModelTexture tree1 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/1"));
	public static ModelTexture tree2 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/2"));
	public static ModelTexture tree3 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/3"));
	public static ModelTexture tree4 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/4"));
	public static ModelTexture tree5 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/5"));
	public static ModelTexture tree6 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/6"));
	public static ModelTexture tree7 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/7"));
	public static ModelTexture tree8 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/8"));
	public static ModelTexture tree9 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/9"));
	public static ModelTexture tree10 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/10"));
	public static ModelTexture tree11 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/11"));
	public static ModelTexture tree12 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/12"));
	public static ModelTexture tree13 = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/13"));
	public static ModelTexture log = new ModelTexture(Game.loader.loadTexture("map-objects/prehistoric/tree/log"));
	//House
	public static ModelTexture backgroundInterior = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/1"));
	public static ModelTexture wallTopCenter = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/2"));
	public static ModelTexture columnRTop = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/3"));
	public static ModelTexture columnR = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/4"));
	public static ModelTexture columnLTop = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/5"));
	public static ModelTexture columnL = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/6"));
	public static ModelTexture columnLWithDoor = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/7"));
	public static ModelTexture doorEntrance = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/8"));
	public static ModelTexture openEnteranceR = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/9"));
	public static ModelTexture openEnteranceL = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/10"));
	public static ModelTexture wallLCorner = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/11"));
	public static ModelTexture wallL = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/12"));
	public static ModelTexture tableL = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/13"));
	public static ModelTexture tableRCouchL = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/14"));
	public static ModelTexture opemEntranceCouchR = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/15"));
	public static ModelTexture wallTopLWindow = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/16"));
	public static ModelTexture windowL = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/17"));
	public static ModelTexture wallTopRWindow = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/18"));
	public static ModelTexture windowR = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/19"));
	public static ModelTexture wallTop = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/20"));
	public static ModelTexture wallRCorner = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/21"));
	public static ModelTexture wallR = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/22"));
	public static ModelTexture roofTileLSmall = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/23"));
	public static ModelTexture roofTileLLarge = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/24"));
	public static ModelTexture roofTileRLarge = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/25"));
	public static ModelTexture roofTileRSmall = new ModelTexture(Game.loader.loadTexture("map-objects/rome/house/26"));
	//Column
	public static ModelTexture column1 = new ModelTexture(Game.loader.loadTexture("map-objects/rome/column/1"));
	public static ModelTexture column2 = new ModelTexture(Game.loader.loadTexture("map-objects/rome/column/2"));
	public static ModelTexture column3 = new ModelTexture(Game.loader.loadTexture("map-objects/rome/column/3"));
	//Aqueduct
	public static ModelTexture duct1 = new ModelTexture(Game.loader.loadTexture("map-objects/rome/aqueduct/1"));
	public static ModelTexture duct2 = new ModelTexture(Game.loader.loadTexture("map-objects/rome/aqueduct/2"));
	public static ModelTexture duct3 = new ModelTexture(Game.loader.loadTexture("map-objects/rome/aqueduct/3"));
	public static ModelTexture duct4 = new ModelTexture(Game.loader.loadTexture("map-objects/rome/aqueduct/4"));
	//////////////////////////////
	//          TERRAIN         //
	//////////////////////////////
	//Metal
	public static ModelTexture metalGrate = new ModelTexture(Game.loader.loadTexture("terrain/metal/grate"));
	//Rocks
	public static ModelTexture rock = new ModelTexture(Game.loader.loadTexture("terrain/rocks/rock"));
	public static ModelTexture boulder1 = new ModelTexture(Game.loader.loadTexture("terrain/rocks/boulder/1"));
	public static ModelTexture boulder2 = new ModelTexture(Game.loader.loadTexture("terrain/rocks/boulder/2"));
	public static ModelTexture boulder3 = new ModelTexture(Game.loader.loadTexture("terrain/rocks/boulder/3"));
	public static ModelTexture boulder4 = new ModelTexture(Game.loader.loadTexture("terrain/rocks/boulder/4"));
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
	public static ModelTexture loading = new ModelTexture(Game.loader.loadTexture("background/loading"));
	public static ModelTexture level1 = new ModelTexture(Game.loader.loadTexture("background/l1"));
	public static ModelTexture credits = new ModelTexture(Game.loader.loadTexture("background/credits"));
	public static ModelTexture menu = new ModelTexture(Game.loader.loadTexture("background/menu"));
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

	//////////////////////////////
	//           TEXT           //
	//////////////////////////////
	
	//numerals
	public static ModelTexture num0 = new ModelTexture(Game.loader.loadTexture("game/text/num/bordered/zero"));
	public static ModelTexture num1 = new ModelTexture(Game.loader.loadTexture("game/text/num/bordered/one"));
	public static ModelTexture num2 = new ModelTexture(Game.loader.loadTexture("game/text/num/bordered/two"));
	public static ModelTexture num3 = new ModelTexture(Game.loader.loadTexture("game/text/num/bordered/three"));
	public static ModelTexture num4 = new ModelTexture(Game.loader.loadTexture("game/text/num/bordered/four"));
	public static ModelTexture num5 = new ModelTexture(Game.loader.loadTexture("game/text/num/bordered/five"));
	public static ModelTexture num6 = new ModelTexture(Game.loader.loadTexture("game/text/num/bordered/six"));
	public static ModelTexture num7 = new ModelTexture(Game.loader.loadTexture("game/text/num/bordered/seven"));
	public static ModelTexture num8 = new ModelTexture(Game.loader.loadTexture("game/text/num/bordered/eight"));
	public static ModelTexture num9 = new ModelTexture(Game.loader.loadTexture("game/text/num/bordered/nine"));
	
	public static ModelTexture num0_white = new ModelTexture(Game.loader.loadTexture("game/text/num/white/zero"));
	public static ModelTexture num1_white = new ModelTexture(Game.loader.loadTexture("game/text/num/white/one"));
	public static ModelTexture num2_white = new ModelTexture(Game.loader.loadTexture("game/text/num/white/two"));
	public static ModelTexture num3_white = new ModelTexture(Game.loader.loadTexture("game/text/num/white/three"));
	public static ModelTexture num4_white = new ModelTexture(Game.loader.loadTexture("game/text/num/white/four"));
	public static ModelTexture num5_white = new ModelTexture(Game.loader.loadTexture("game/text/num/white/five"));
	public static ModelTexture num6_white = new ModelTexture(Game.loader.loadTexture("game/text/num/white/six"));
	public static ModelTexture num7_white = new ModelTexture(Game.loader.loadTexture("game/text/num/white/seven"));
	public static ModelTexture num8_white = new ModelTexture(Game.loader.loadTexture("game/text/num/white/eight"));
	public static ModelTexture num9_white = new ModelTexture(Game.loader.loadTexture("game/text/num/white/nine"));
	//words
	public static ModelTexture loadingText1 = new ModelTexture(Game.loader.loadTexture("game/text/loading/1"));
	public static ModelTexture loadingText2 = new ModelTexture(Game.loader.loadTexture("game/text/loading2"));
	public static ModelTexture loadingText3 = new ModelTexture(Game.loader.loadTexture("game/text/loading3"));
	public static ModelTexture loadingText4 = new ModelTexture(Game.loader.loadTexture("game/text/loading4"));
	public static List<ModelTexture> LodingList = new ArrayList<ModelTexture>(Arrays.asList(loadingText1, loadingText2,loadingText3,loadingText4));
}
