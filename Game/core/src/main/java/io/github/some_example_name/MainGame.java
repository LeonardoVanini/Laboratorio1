package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends ApplicationAdapter {
    ShapeRenderer shape;
    float x =0;
    float y =0;
    float w;
    float h;
    float vx = 2.5f;
    float vy =2.5f;


    @Override
    public void create() {
        shape = new ShapeRenderer();
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

    }

    @Override
    public void render() {
        ScreenUtils.clear(0,0,0,1);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(0f,1,0,1f);
        x += vx;
        y += vy;
        if (x < 0 || x + 50 > w){
            vx = -vx;
        }
        if (y < 0 || y + 100 > h){
            vy = -vy;
        }
        shape.rect(x,y,50,100);

        shape.end();

    }

    private void aggiorna(int i){

    }

    @Override
    public void dispose() {
        shape.dispose();
    }
}
