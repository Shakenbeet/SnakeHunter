package io.github.shakenbeet;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class SnakeHunter extends ApplicationAdapter {
	SpriteBatch batch;

	Texture img;
	Texture enemyImg;

	Player player;
	Enemy enemy;

	BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("panda.png");
		enemyImg = new Texture("snake.png");

		player = new Player(img, 0, 500, 8);
		enemy = new Enemy(enemyImg, 250, 0, 2);

		font = new BitmapFont();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		// DRAWING
		batch.begin();

		player.Render(batch);
		enemy.Render(batch);
		font.draw(batch, "Score: " + enemy.score, 380, 300);

		for (Bullet bullet : player.listOfBullets)
		{
			if (!bullet.dead)
			{
				bullet.Render(batch);
			}
		}

		batch.end();

		// UPDATES
		player.Update();
		enemy.Update();

		for (Bullet bullet : player.listOfBullets)
		{
			if (!bullet.dead)
			{
				bullet.Update(enemy);
			}

			if (bullet.playerLost)
			{
				RestartGame();
				bullet.playerLost = false;
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		enemyImg.dispose();
	}

	private void RestartGame()
	{
		enemy.score = 0;
		enemy.setSpeed(2);

	}
}
