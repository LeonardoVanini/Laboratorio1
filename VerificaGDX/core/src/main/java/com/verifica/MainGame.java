package com.verifica;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends ApplicationAdapter {
    private SpriteBatch batchA;
    private SpriteBatch batchB;
    private SpriteBatch batchC;
    private Texture ab;
    private Texture c;
    private int[][] velocita;
    private int[][] posizioni;
    private int[] buffer;
    private int wW;
    private int wH;
    private Random rnd;
    private int clearance; //valore che permette una zona di not spawn attorno alle fiamme

    private int[] posizioneRandom(){
        do {
            buffer = new int[]{rnd.nextInt(0, wW - 60), rnd.nextInt(0, wH - 60)};
        }
        while ((buffer[0]>=posizioni[0][0]-clearance && buffer[0]<=posizioni[0][0]+60+clearance &&
                buffer[1]>=posizioni[0][1]-clearance && buffer[1]<=posizioni[0][1]+60+clearance)||
               (buffer[0]>=posizioni[1][0]-clearance && buffer[0]<=posizioni[1][0]+60+clearance &&
                buffer[1]>=posizioni[1][1]-clearance && buffer[1]<=posizioni[1][1]+60+clearance));

        return buffer;
    }

    @Override
    public void create() {
        clearance=0;
        wW= Gdx.graphics.getWidth();
        wH= Gdx.graphics.getHeight();
        rnd = new Random();
        batchA = new SpriteBatch();
        batchB = new SpriteBatch();
        batchC = new SpriteBatch();
        ab = new Texture("Fireball.png");
        c = new Texture("kirby.png");
        velocita = new int[][]{{300,300},{-400,-400},{200,200}};
        posizioni = new int[][]{{0,0},{0,wH-60},{0,0}};
        posizioni[2]=posizioneRandom();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);


        batchA.begin();
        batchA.draw(ab, posizioni[0][0], posizioni[0][1],60,60);
        batchA.end();
        batchB.begin();
        batchB.draw(ab, posizioni[1][0], posizioni[1][1],60,60);
        batchB.end();
        batchC.begin();
        batchC.draw(c, posizioni[2][0], posizioni[2][1],60,60);
        batchC.end();

        for (int i = 0; i < posizioni.length; i++) {
            if (posizioni[i][0]<0||posizioni[i][0]>wW-60){
                velocita[i][0]*=-1;
            }
            if (posizioni[i][1]<0||posizioni[i][1]>wH-60){
                velocita[i][1]*=-1;
            }
            for (int j = 0; j < posizioni.length; j++) {
                if ((i==0 && j==1)||(i==1 && j==0)){
                    if (posizioni[i][0]>=posizioni[j][0] && posizioni[i][0]<=posizioni[j][0]+60 &&
                        posizioni[i][1]>=posizioni[j][1] && posizioni[i][1]<=posizioni[j][1]+60){

                        buffer = velocita[i];
                        velocita[i]=velocita[j];
                        velocita[j]=buffer;

                        posizioni[i][0]+=velocita[i][0]*Gdx.graphics.getDeltaTime();
                        posizioni[i][1]+=velocita[i][1]*Gdx.graphics.getDeltaTime();
                        posizioni[j][0]+=velocita[j][0]*Gdx.graphics.getDeltaTime();
                        posizioni[j][1]+=velocita[j][1]*Gdx.graphics.getDeltaTime();
                    }
                }
                if ((i==0 && j==2)||(i==2 && j==0)||(i==1 && j==2)||(i==2 && j==1)){
                    if (posizioni[i][0]>=posizioni[j][0] && posizioni[i][0]<=posizioni[j][0]+60 &&
                        posizioni[i][1]>=posizioni[j][1] && posizioni[i][1]<=posizioni[j][1]+60){

                        posizioni[2]=posizioneRandom();

                    }
                }
            }
        }

        for (int i = 0; i < posizioni.length; i++) {
            posizioni[i][0]+=velocita[i][0]*Gdx.graphics.getDeltaTime();
            posizioni[i][1]+=velocita[i][1]*Gdx.graphics.getDeltaTime();
        }
    }



    @Override
    public void dispose() {
        batchA.dispose();
        batchB.dispose();
        batchC.dispose();
        ab.dispose();
        c.dispose();
    }
}
