package com.ragnarok.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ragnarok.game.BaseGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Breakout game";
		config.useGL30 = false;
		config.width = 800;
		config.height = 600;
		
		new LwjglApplication(new BaseGame(), config);
	}
}
