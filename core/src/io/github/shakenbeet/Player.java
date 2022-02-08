package io.github.shakenbeet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Player {
    private Texture texture;

    private int speed;
    private int x;
    private int y;

    public ArrayList<Bullet> listOfBullets;

    public Player(Texture texture, int spawnX, int spawnY, int speed)
    {
        listOfBullets = new ArrayList<Bullet>();

        this.texture = texture;
        this.speed = speed;

        x = spawnX;
        y = spawnY;
    }

    // TODO: ADD FRAMERATE INDEPENDENCE
    public void Update()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            x -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            x += speed;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            Shoot();
        }

        if (x <= 0)
        {
            x = 0;
        }
        if (x + texture.getWidth() >= Gdx.graphics.getWidth())
        {
            x = Gdx.graphics.getWidth() - texture.getWidth();
        }
    }

    public void Render(SpriteBatch batch)
    {
        batch.draw(texture, x, y);
    }

    private void Shoot()
    {
        Bullet bullet = new Bullet(x + texture.getWidth() / 2,y);
        listOfBullets.add(bullet);
    }
}
