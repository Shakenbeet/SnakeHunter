package io.github.shakenbeet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy {
    public Texture texture;

    private int speed;
    private int x;
    private int y;

    public int score;

    public Enemy(Texture texture, int spawnX, int spawnY, int speed)
    {
        this.texture = texture;
        this.speed = speed;

        x = spawnX;
        y = spawnY;

        score = 0;
    }

    public void Update()
    {
        x += speed;

        if (x < 0)
        {
            speed = -speed;
        }
        else if (x + texture.getWidth() > Gdx.graphics.getWidth())
        {
            speed = -speed;
        }
    }

    public void Render(SpriteBatch batch)
    {
        batch.draw(texture, x, y);
    }

    public void Hit()
    {
        score += 1;

        System.out.println(score);

        if (speed > 0)
        {
            speed += 1;
        }
        else
        {
            speed -= 1;
        }
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setSpeed(int speed)
    {
        if (this.speed > 0)
        {
            this.speed = speed;
        }
        else
        {
            this.speed = -speed;
        }
    }
}
