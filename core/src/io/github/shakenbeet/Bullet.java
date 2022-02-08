package io.github.shakenbeet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {
    private Texture texture;

    private int speed;
    private int x;
    private int y;

    public boolean dead;
    public boolean playerLost;

    public Bullet(int spawnX, int spawnY)
    {
        texture = new Texture("bullet.png");
        x = spawnX;
        y = spawnY;

        dead = false;
        playerLost = false;
        speed = 20;
    }

    public void Update(Enemy enemy)
    {
        y -= speed;

        // SCUFFED COLLISION SYSTEM, PLEASE HELP ME
        if (x + texture.getWidth() > enemy.getX() && x < enemy.getX() + enemy.texture.getWidth() && y + texture.getHeight() > enemy.getY() && y < enemy.getY() + enemy.texture.getHeight())
        {
            if (!dead)
            {
                System.out.println("HIT! ENEMY");
                enemy.Hit();
                dead = true;

            }
        }

        if (y < 0)
        {
            System.out.println("Caught the Player lacking");
            dead = true;
            playerLost = true;
        }
    }

    public void Render(SpriteBatch batch)
    {
        if (!dead)
        {
            batch.draw(texture, x, y);
        }
    }
}
