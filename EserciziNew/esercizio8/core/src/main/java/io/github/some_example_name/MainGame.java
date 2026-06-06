package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture player;
    private Texture enemy;
    private Texture background;
    private int w;
    private int h;
    private float[] velocity;
    private float[] position;

    //Ctrl + Shift + F10 (su Windows)

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Texture("player.png");
        enemy = new Texture("enemy.png");
        background = new Texture("background.png");
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        velocity =new float[] {200f,-300f};
        position=new float[] {0f,(float) w-enemy.getWidth(),20f,20f};

    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(background,0,0,640, 480);

        batch.draw(player, position[0], position[2]);
        batch.draw(enemy,position[1] , position[3]);

        batch.end();



        position[0] += velocity[0]*Gdx.graphics.getDeltaTime();
        position[1] += velocity[1]*Gdx.graphics.getDeltaTime();

        for (int i = 0; i < velocity.length; i++) {
            if (position[i] <=0 || position[i]+player.getWidth()>=w){
                velocity[i] *=-1;
            }
            for (int j = 0; j < velocity.length; j++) {
                if (position[i]+player.getWidth()>position[j]&&i<j){
                    velocity[i] *=-1;
                    velocity[j] *=-1;
                    position[2] +=10;
                    position[3] +=10;
                }
            }
        }

    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
        enemy.dispose();
        background.dispose();
    }
}
