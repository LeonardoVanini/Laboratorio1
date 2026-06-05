package com.lab;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;


import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ModuleLayer;
import java.util.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 * Classe principale del gioco.
 */

/*
Crediti:
Protagonista e scala a : https://www.pixilart.com/
Suoni: https://www.zapsplat.com/
Controller: https://github.com/libgdx/gdx-controllers
R/W: https://libgdx.com/wiki/file-handling
Capire errori, e aiuto nell imparare nuovi concetti: Copilot
 */
public class MainGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private ShapeRenderer shape;
    private Texture stone;
    private Texture ladder;
    private Map<Integer,Texture> labirintoImage;
    private ConnectLabirintoS connect;
    private CollisioniBase[][] collisioni;

    private int[][] labirinto;
    private int[] cameraPosition;
    private int[] fini;

    private int[] bufferEvento = new int[2];

    private int[][] personaggio;
    private CollisioniBase collisioniPersonaggio;

    private int dimensioneImmagine = 256;
    private int screenWidth;
    private int screenHeight;
    private int dimensioneLato =5;
    private int best;
    private int velocita = 5;

    private int worldX;
    private int worldY;
    private int centerX;
    private int centerY;
    private int[] posizione;

    private boolean mostraMessaggio = false;
    private String testo ="";
    private float timer =0;
    private float durata =2f;
    private BitmapFont font;

    private Music music;
    private ArrayList<Sound> effetti;
    private float tempoDisponibile=0;
    private float effettoDurata =0.5f;

    private Controller c;
    private boolean esiste = false;

    private FileHandle file;

    @Override
    public void create() {
        connect = new ConnectLabirintoS();
        labirintoImage = new HashMap<>();
        music = Gdx.audio.newMusic(Gdx.files.internal("background.mp3"));
        font = new BitmapFont();
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        stone = new Texture("stone.png");
        ladder = new Texture("ladder.png");
        labirintoImage.put(0,new Texture("pieno.png"));//.get(chiave)
        labirintoImage.put(1,new Texture("fineAlto.png"));
        labirintoImage.put(2,new Texture("fineDestra.png"));
        labirintoImage.put(3,new Texture("fineBasso.png"));
        labirintoImage.put(4,new Texture("fineSinistra.png"));
        labirintoImage.put(5,new Texture("curvaWD.png"));
        labirintoImage.put(6,new Texture("curvaSD.png"));
        labirintoImage.put(7,new Texture("curvaSA.png"));
        labirintoImage.put(8,new Texture("curvaWA.png"));
        labirintoImage.put(9,new Texture("incrocioTalto.png"));
        labirintoImage.put(10,new Texture("incrocioTdestra.png"));
        labirintoImage.put(11,new Texture("incrocioTbasso.png"));
        labirintoImage.put(12,new Texture("incrocioTsinistra.png"));
        labirintoImage.put(13,new Texture("incrocio4.png"));
        labirintoImage.put(14,new Texture("dirittoVerticale.png"));
        labirintoImage.put(15,new Texture("dirittoOrizzontale.png"));
        effetti = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            effetti.add(Gdx.audio.newSound(Gdx.files.internal((i+1)+".wav")));
        }

        file = Gdx.files.local("punteggio.txt");
        try {
            if (file.exists()) {
                best = Integer.parseInt(file.readString());
            }else {
                best =0;
            }
        }catch (Exception e){
            best =0;
            System.out.println("Errore caricamento file");
        }

        music.setLooping(true);
        music.play();
        screenHeight= Gdx.graphics.getHeight();
        screenWidth = Gdx.graphics.getWidth();
        centerX=Gdx.graphics.getWidth()/2;
        centerY=Gdx.graphics.getHeight()/2;
        personaggio = new int[][]{{centerX- stone.getWidth()/2,centerY- stone.getHeight()/2},{stone.getWidth(), stone.getHeight()}};
        collisioniPersonaggio = new CollisioniPersonaggio(personaggio[0][0],personaggio[0][1],personaggio[1][0],personaggio[1][1]);
        font.getData().setScale(3);

        if (Controllers.getControllers().size ==0){//Controlla solo all'avvio se è presente un controller
            System.out.println("Nessun joystick collegato");
        }
        else {
            esiste = true;
            c = Controllers.getControllers().first();
        }
        spawn();
    }

    @Override
    public void render() {
        try {
            event();
        } catch (Exception e) {
            System.out.println("Eccezzione trovata in eventi"+e.toString());
        }
        try{
            updateCollisioni();
        } catch (Exception e) {
            System.out.println("Eccezzione trovata in collisioni"+e.toString());
        }
        try {
            draw();
        }
         catch (Exception e) {
            System.out.println("Eccezzione trovata in disegno"+e.toString());
        }
        try {
            fine();
        }
          catch (Exception e) {
            System.out.println("Eccezzione trovata in fine"+e.toString());
        }

        if (mostraMessaggio){
            timer -= Gdx.graphics.getDeltaTime();
            if (timer <=0){
                mostraMessaggio = false;
            }
        }
        tempoDisponibile-=Gdx.graphics.getDeltaTime();
    }

    /**
     * Aggiorna il file del punteggio.
     * @param punteggio valore da salvare
     */
    private void aggiornaFile(int punteggio){
        if (punteggio>best){
            file.writeString(String.valueOf(punteggio),false);
        }
    }

    /**
     * Controlla se il giocatore ha raggiunto l'uscita.
     */
    private void fine(){
        if (fini[2] == posizione[0] && fini[3] ==posizione[1]){
            dimensioneLato+=2;
            spawn();
        }
    }

    /** Riproduce un effetto sonoro con cooldown. */
    private void playEffetto(){
        if (tempoDisponibile>0){
            return;
        }

        long id =effetti.get((int)Math.random()*effetti.size()).play(1f);
        tempoDisponibile=effettoDurata;
    }

    /**
     * Mostra un messaggio temporaneo a schermo.
     * @param testo testo da mostrare
     */
    private void messaggio(String testo){
        mostraMessaggio = true;
        this.testo=testo;
        timer=durata;
    }

    /**
     * Controlla collisioni tra giocatore e celle vicine.
     * @return true se collide
     */
    private boolean collide(){
        for (int i = posizione[0]-1; i <= posizione[0]+1; i++) {
            for (int j = posizione[1]-1; j <= posizione[1]+1; j++) {
                if (i<0||j<0||i>=collisioni.length||j>=collisioni[i].length){
                    continue;
                }
                for (Rectangle rect : collisioni[i][j].getCollisioni()){
                    if (collisioniPersonaggio.getCollisioni().get(0).overlaps(rect)){
                        return true;
                    }
                }

            }

        }
        return false;
    }

    /** Gestisce input da tastiera o controller. */
    private void event(){
        int spostamento =velocita;
        for (int i = 0; i < bufferEvento.length; i++) {
            switch (bufferEvento[i]){
                case 1:
                    worldY+=spostamento;
                    updateCollisioni();
                    if (collide()){
                        worldY-=spostamento;
                    }
                    playEffetto();
                    break;
                case 2:
                    worldX+=spostamento;
                    updateCollisioni();
                    if (collide()){
                        worldX-=spostamento;
                    }
                    playEffetto();
                    break;
                case 3:
                    worldY-=spostamento;
                    updateCollisioni();
                    if (collide()){
                        worldY+=spostamento;
                    }
                    playEffetto();
                    break;
                case 4:
                    worldX-=spostamento;
                    updateCollisioni();
                    if (collide()){
                        worldX+=spostamento;
                    }
                    playEffetto();
                    break;
            }
            bufferEvento[i]=0;
        }

        if (esiste){
            float x=c.getAxis(0);
            float y=c.getAxis(1);
            //System.out.println(x+" "+y);

            if (y<-0.5) {
                bufferEvento[0] = 1;
            } else if (y>0.5) {
                bufferEvento[0] = 3;
            }
            if (x>0.5) {
                bufferEvento[1] = 2;
            } else if (x<-0.5) {
                bufferEvento[1] = 4;
            }

        }else {
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                bufferEvento[0] = 1;
            } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                bufferEvento[0] = 3;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                bufferEvento[1] = 2;
            } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                bufferEvento[1] = 4;
            }
        }
    }

    /** Genera un nuovo livello e resetta posizione e dati. */
    private void spawn(){
        int punteggio=(int)(Math.floor((dimensioneLato-4)/2)+1);
        aggiornaFile(punteggio);
        messaggio("Benvenuto nel livello : "+punteggio+"\nMigliore di sempre: "+best);
        connect.setLabirinto(dimensioneLato);
        labirinto = connect.getLabirinto();
        collisioni = new CollisioniBase[dimensioneLato][dimensioneLato];
        fini = connect.getFini();
        posizione = new int[]{fini[0],fini[1]};
        worldX=fini[0]*dimensioneImmagine-centerX+dimensioneImmagine/2;
        worldY= (labirinto.length- fini[1])*dimensioneImmagine -dimensioneImmagine-centerY+dimensioneImmagine/2;
    }

    /** Aggiorna le collisioni delle celle in base alla camera. */
    private void updateCollisioni(){
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                int x = dimensioneImmagine * i - worldX;
                int y = dimensioneImmagine * (labirinto[i].length - j) - dimensioneImmagine - worldY;
                int d = dimensioneImmagine;
                collisioni[i][j] = new CollisioniS(x, y, d,d, 256-2*28, labirinto[i][j]);

            }
        }
    }

    /** Disegna labirinto, player e messaggi. */
    private void draw(){
        ScreenUtils.clear(0f, 0f, 0f, 1f);

        posizione[0]=(personaggio[0][0]+worldX)/dimensioneImmagine;
        posizione[1]=labirinto.length-1-(personaggio[0][1]+worldY)/dimensioneImmagine;

        batch.begin();

        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                int x =dimensioneImmagine*i -worldX;
                int y=dimensioneImmagine*(labirinto[i].length-j)-dimensioneImmagine -worldY;
                int d=dimensioneImmagine;
                batch.draw(labirintoImage.get(labirinto[i][j]),x,y,d,d);
                batch.draw(stone,personaggio[0][0],personaggio[0][1],personaggio[1][0],personaggio[1][1]);
                if (fini[0] == i && fini[1] ==j){
                    batch.draw(ladder,x+dimensioneImmagine/2-24,y+dimensioneImmagine/2-24,48,48,0,48,48,48,false,false);
                }
                if (fini[2] == i && fini[3] ==j){
                    batch.draw(ladder,x+dimensioneImmagine/2-24,y+dimensioneImmagine/2-24,48,48,0,0,48,48,false,false);
                }
            }
        }

        batch.end();

        if (mostraMessaggio){
            ScreenUtils.clear(0f, 0f, 0f, 1f);
            batch.begin();
            font.draw(batch,testo,screenWidth/2f - font.getRegion().getRegionWidth(),screenHeight/2f);
            batch.end();

        }
        /*
        //Usato per il debug, permette di vedere le collisioni
        shape.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                int x = dimensioneImmagine * i;
                int y = dimensioneImmagine * (labirinto[i].length - j) - dimensioneImmagine;
                int d = dimensioneImmagine;
                CollisioniS test = (CollisioniS) collisioni[i][j];
                test.testCollisioni(shape);

            }
        }
        shape.end();

         */
    }

    @Override
    public void dispose() {
        batch.dispose();
        shape.dispose();
        stone.dispose();
        ladder.dispose();
        for (Texture t: labirintoImage.values()){
            t.dispose();
        }
        font.dispose();
        music.dispose();
        for (Sound s: effetti){
            s.dispose();
        }
    }
}
