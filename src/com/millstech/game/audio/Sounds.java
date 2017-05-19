package com.millstech.game.audio;

import com.millstech.engine.audio.*;

public class Sounds {
	public static SoundThreadManager Theme = new SoundThreadManager(new Sound("res/audio/music/theme.wav"), "theme");
	public static SoundThreadManager TheDoctor = new SoundThreadManager(new Sound("res/audio/music/i_am_the_doctor.wav"), "iatd");
}
