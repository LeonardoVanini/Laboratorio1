package com.flappy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.Random;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends ApplicationAdapter {
    private Texture flappy;
    private Texture backgroung;
    private Texture pipe;
    private SpriteBatch batch;
    private float velY =400;
    private float velX =-100;
    private float DEFAULTX=-100;
    private float GRAVITY = -500;
    private float FLAP_FORCE = 200;
    private float flappyY;
    private float pipeY;
    private float pipeX=300;
    private int vite=4;
    private boolean gameOver = false;
    private BitmapFont font;
    private BitmapFont bigFont;
    private int score =0;
    private boolean point = true;

    private int pipeGap = 150;

    private Random rnd = new Random();

    private Rectangle flappyBounds;
    private Rectangle bottomPipeBounds;
    private Rectangle topPipeBounds;

    private float[] spawn;
    //Ho cercato tramite ai come ottenere la dimensione di un testo prima di stamparlo
    private GlyphLayout layout = new GlyphLayout();

    private Music bgMusic;

    @Override
    public void create() {
        batch = new SpriteBatch();
        flappy = new Texture("flappy.png");
        backgroung = new Texture("background.png");
        pipe = new Texture("pipe.png");

        font = new BitmapFont();
        font.setColor(Color.YELLOW);
        font.getData().setScale(1.0f);
        bigFont = new BitmapFont();
        bigFont.setColor(Color.YELLOW);
        bigFont.getData().setScale(3);
        spawn = new float[]{(Gdx.graphics.getWidth()-flappy.getWidth())/2,(Gdx.graphics.getHeight()-flappy.getHeight())/2,velY};
        //flappyY=spawn[1];
        respawn();
        random();

        flappyBounds = new Rectangle((int)spawn[0],(int)flappyY,flappy.getWidth(),flappy.getHeight());
        bottomPipeBounds = new Rectangle(0,50,pipe.getWidth(),0);
        topPipeBounds = new Rectangle(0,0,pipe.getWidth(),0);

        bgMusic = Gdx.audio.newMusic(Gdx.files.internal("Morning.mp3"));
        bgMusic.setVolume(1);
        bgMusic.setLooping(true);
        bgMusic.play();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        float dt = Gdx.graphics.getDeltaTime();
        if (!gameOver) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) {
                velY = FLAP_FORCE;

            }
            if (velX>DEFAULTX){
                velX -= 10*dt;
            }
            velY += GRAVITY * dt;
            flappyY += velY * dt;
            pipeX+=velX*dt;

            flappyBounds.set( spawn[0], flappyY, 60, flappy.getHeight() - 20);

            bottomPipeBounds.y=50;
            bottomPipeBounds.x=(int)pipeX;
            bottomPipeBounds.height=(int)pipeY;

            topPipeBounds.x=(int)pipeX;
            topPipeBounds.y=(int)(50+pipeY+pipeGap);
            topPipeBounds.height=(int)(backgroung.getHeight()-50-pipeGap-pipeY);


            if (flappyY < 43) {
                respawn();
            }
            if (flappyBounds.overlaps(topPipeBounds)||flappyBounds.overlaps(bottomPipeBounds)){

                respawn();
                pipeX+=200;
            }
            if (pipeX+pipe.getWidth()/2<spawn[0] && point){
                score++;
                point = false;
            }
            if (pipeX <0-pipe.getWidth()){
                point = true;
                pipeX = backgroung.getWidth();
                random();
            }
        }else {
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                gameOver=false;
                score=0;
                vite=4;
                respawn();

            }
        }
        draw();




    }

    private void respawn(){
        vite--;
        if (vite<0){
            gameOver=true;
            return;
        }
        flappyY=spawn[1];
        velY = spawn[2];
        velX = -20;

    }

    private void random(){
        pipeY=rnd.nextInt(0,10)*25 +25;
    }

    private void draw(){
        batch.begin();
        batch.draw(backgroung, 0, 0);
        batch.draw(pipe, pipeX, 50,pipe.getWidth(),pipeY);
        batch.draw(pipe, pipeX, 50+pipeY+pipeGap,pipe.getWidth(),backgroung.getHeight()-50-pipeGap-pipeY);




        if (!gameOver) {
            batch.draw(flappy, spawn[0], flappyY, 60, flappy.getHeight() - 20);
            font.draw(batch, "Score:" + score, 20, Gdx.graphics.getHeight() - 20);
            font.draw(batch, "Vite:" + vite, 20, Gdx.graphics.getHeight() - 40);
        }else {

            layout.setText(bigFont, "GAME OVER");
            bigFont.draw(batch, layout, (Gdx.graphics.getWidth() - layout.width) / 2, (Gdx.graphics.getHeight() + layout.height) / 2);

        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        flappy.dispose();
        backgroung.dispose();
        pipe.dispose();
        font.dispose();

    }
}
