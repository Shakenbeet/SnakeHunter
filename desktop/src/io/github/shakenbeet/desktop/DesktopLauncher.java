package io.github.shakenbeet.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import io.github.shakenbeet.SnakeHunter;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SnakeHunter(), config);
		config.title = "Snake Hunter";
		config.width = 800;
		config.height = 600;
	}
}
