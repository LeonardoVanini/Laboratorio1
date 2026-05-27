package com.lab;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private ShapeRenderer shape;
    private Texture image;
    private Map<Integer,Texture> labirintoImage;
    private ConnectLabirinto connect;
    private Collisioni[][] collisioni;

    private int[][] labirinto;
    private int[] cameraPosition;
    private int[] fini;

    private int bufferEvento;



    private int dimensioneImmagine = 64;
    private int screenHeight;
    private int dimensioneLato =15;

    private int worldX;
    private int worldY;


    private int impostaDimensioneImmagine;

    @Override
    public void create() {
        connect = new ConnectLabirinto();
        labirintoImage = new HashMap<>();

        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        image = new Texture("libgdx.png");
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




        connect.setLabirinto(dimensioneLato);
        labirinto = connect.getLabirinto();
        collisioni = new Collisioni[dimensioneLato][dimensioneLato];
        fini = connect.getFini();
        screenHeight= Gdx.graphics.getHeight();
        //impostaDimensioneImmagine=(int)Math.ceil((double)screenHeight/ labirinto.length);

        worldX=fini[0]*dimensioneImmagine;
        worldY= (labirinto.length- fini[1])*dimensioneImmagine -dimensioneImmagine;

    }

    @Override
    public void render() {

        draw();
    }

    private void event(){
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            bufferEvento=1;
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            bufferEvento=3;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            bufferEvento=2;
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            bufferEvento=4;
        }
    }
/*
Quindi worldX/worldY devono essere offset della mappa

Nel draw:

INVECE di:

batch.draw(texture, x, y, d, d);

devi fare:

batch.draw(texture, x - worldX, y - worldY, d, d);
Quello è il camera offset

Se:

worldX = 100

allora tutto il mondo viene disegnato:

100 pixel più a sinistra

quindi sembra che:

la camera si sia spostata a destra
Come si centra lo spawn

Hai:

fini[0]
fini[1]

che sono coordinate tile.

Convertile in coordinate mondo.

Coordinate mondo dello spawn
int startX = fini[0] * dimensioneImmagine;

int startY =
        dimensioneImmagine *
        (labirinto.length - fini[1])
        - dimensioneImmagine;
Centro dello schermo
int centerX = Gdx.graphics.getWidth() / 2;
int centerY = Gdx.graphics.getHeight() / 2;
Camera offset corretto
worldX = startX - centerX + dimensioneImmagine / 2;
worldY = startY - centerY + dimensioneImmagine / 2;
Perché il + dimensioneImmagine/2 ?

Perché:

startX/startY
sono l’angolo della tile
tu vuoi il centro della tile
Risultato finale

La tile iniziale apparirà esattamente:

al centro dello schermo

mentre:

il mondo viene traslato attorno ad essa
Draw corretto
Texture
batch.draw(
    labirintoImage.get(labirinto[i][j]),
    x - worldX,
    y - worldY,
    d,
    d
);
Collisioni debug

Anche loro:

shape.rect(
    rect.x - worldX,
    rect.y - worldY,
    rect.width,
    rect.height
);
IMPORTANTISSIMO

Ora hai finalmente separato:

WORLD COORDINATES

Coordinate vere del labirinto.

CAMERA OFFSET

worldX/worldY

SCREEN COORDINATES

Dove viene disegnato tutto.

Questo è il pattern corretto nei giochi 2D
drawX = worldX - cameraX
drawY = worldY - cameraY

sempre.
 */
    private void draw(){
        ScreenUtils.clear(0f, 1f, 0f, 1f);
        batch.begin();

        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                int x =dimensioneImmagine*i -worldX;
                int y=dimensioneImmagine*(labirinto[i].length-j)-dimensioneImmagine -worldY;
                int d=dimensioneImmagine;
                //System.out.println(impostaDimensioneImmagine);
                //batch.begin();
                //batch.draw(labirintoImage.get(labirinto[i][j]),impostaDimensioneImmagine*i,impostaDimensioneImmagine*(labirinto[i].length-j)-impostaDimensioneImmagine,impostaDimensioneImmagine,impostaDimensioneImmagine);
                batch.draw(labirintoImage.get(labirinto[i][j]),x,y,d,d);
                collisioni[i][j] = new Collisioni(x,y,d,50/2,labirinto[i][j]);

                //batch.end();





                /*if ((fini[0] == i && fini[1] ==j) ||(fini[2] == i && fini[3] ==j)){
                    shape.begin();
                    shape.setColor(0,1,0,1);
                    shape.rect(dimensioneImmagine*i+(int)(dimensioneImmagine-dimensioneInizio)/2,dimensioneImmagine*(labirinto[i].length-j)-dimensioneImmagine+(int)(dimensioneImmagine-dimensioneInizio)/2,dimensioneInizio,dimensioneInizio);
                    shape.end();
                }*/
            }
        }
        //batch.draw(image, 140, 210);

        batch.end();

        shape.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                int x = dimensioneImmagine * i;
                int y = dimensioneImmagine * (labirinto[i].length - j) - dimensioneImmagine;
                int d = dimensioneImmagine;
                collisioni[i][j].testCollisioni(shape);
            }
        }
        shape.end();
    }





    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}

class Collisioni{
    private int x;
    private int y;
    private int width;
    private int whiteSpace;
    private int blackSpace;
    private int id;
    private boolean[] directions;

    private ArrayList<Rectangle> collisioni;

    public Collisioni (int x, int y, int width, int whiteSpace, int id){
        this.x=x;
        this.y=y;
        this.width=width;
        this.whiteSpace = whiteSpace;
        blackSpace=Math.round((width-whiteSpace)/2f);
        this.id = id;
        directions = LabirintoDFS.direzioniImage.get(id);
        collisioni =new ArrayList<>();
        popola();
    }

    public void testCollisioni(ShapeRenderer shape){
        shape.setColor(Color.BLUE);
        for (Rectangle rect : collisioni){
            shape.rect(rect.x, rect.y, rect.width,rect.height);
        }
    }

    private void popola() {
        collisioni.add(new Rectangle(x,y,blackSpace,blackSpace));
        collisioni.add(new Rectangle(x+width-blackSpace,y,blackSpace,blackSpace));
        collisioni.add(new Rectangle(x,y+width-blackSpace,blackSpace,blackSpace));
        collisioni.add(new Rectangle(x+width-blackSpace,y+width-blackSpace,blackSpace,blackSpace));
        if (!directions[0]){
            collisioni.add(new Rectangle(x+blackSpace,y+width-blackSpace,whiteSpace,blackSpace));
        }
        if (!directions[1]){
            collisioni.add(new Rectangle(x+blackSpace+whiteSpace,y+blackSpace,blackSpace,whiteSpace));
        }
        if (!directions[2]){
            collisioni.add(new Rectangle(x+blackSpace,y,whiteSpace,blackSpace));
        }
        if (!directions[3]){
            collisioni.add(new Rectangle(x,y+blackSpace,blackSpace,whiteSpace));
        }
    }

    public ArrayList<Rectangle> getCollisioni() {
        return collisioni;
    }
}

class ConnectLabirinto{
    private int[][] labirinto;
    private int[] fini;

    public void setLabirinto(int dimensione) {
        this.labirinto = LabirintoDFS.ottieniLabirinto(dimensione);
        this.fini = LabirintoDFS.completa();
    }



    public int[][] getLabirinto() {
        return labirinto;
    }

    public int[] getFini() {
        return fini;
    }


}

class LabirintoDFS {
    static int size = 21;
    static int[][] labirinto;
    static Random rand = new Random();
    static Scanner input = new Scanner(System.in);
    static ArrayList<int[]> finali;
    static ArrayList<boolean[]> direzioniImage = new ArrayList<>();

    static void prepara() {
        labirinto = new int[size][size];
        direzioniImage.clear();
        direzioniImage.add(new boolean[]{false, false, false, false});
        direzioniImage.add(new boolean[]{true, false, false, false});
        direzioniImage.add(new boolean[]{false, true, false, false});
        direzioniImage.add(new boolean[]{false, false, true, false});
        direzioniImage.add(new boolean[]{false, false, false, true});
        direzioniImage.add(new boolean[]{true, true, false, false});
        direzioniImage.add(new boolean[]{false, true, true, false});
        direzioniImage.add(new boolean[]{false, false, true, true});
        direzioniImage.add(new boolean[]{true, false, false, true});
        direzioniImage.add(new boolean[]{true, true, false, true});
        direzioniImage.add(new boolean[]{true, true, true, false});
        direzioniImage.add(new boolean[]{false, true, true, true});
        direzioniImage.add(new boolean[]{true, false, true, true});
        direzioniImage.add(new boolean[]{true, true, true, true});
        direzioniImage.add(new boolean[]{true, false, true, false});
        direzioniImage.add(new boolean[]{false, true, false, true});
    }


    public static int[][] ottieniLabirinto(int dimensione) {
        if (dimensione >0){
            size = dimensione;
        }
        prepara();
        inizializzaGriglia();



        genera(1, 1);
        analizza();

        stampaLabirinto();
        return labirinto;

    }



    // Inizializza tutta la griglia con muri (0)
    static void inizializzaGriglia() {
        for (int i = 0; i < size; i++) {
            Arrays.fill(labirinto[i], 0);
        }
        finali = new ArrayList<>();
    }


    // Algoritmo DFS con backtracking
    static void genera(int x, int y) {
        labirinto[x][y] = 1;



        int[] dx = {0, 0, -2, 2}; // sinistra, destra, su, giù
        int[] dy = {-2, 2, 0, 0};
        Integer[] direzioni = {0, 1, 2, 3};
        Collections.shuffle(Arrays.asList(direzioni));

        for (int dir : direzioni) {

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (èValida(nx, ny)) {
                labirinto[x + dx[dir] / 2][y + dy[dir] / 2] = 1; // scava muro intermedio

                //stampaLabirinto();


                genera(nx, ny); // ricorsione

                //stampaLabirinto();



            }
        }
    }
    static int[] completa(){

        finali.clear();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (labirinto[i][j] >=1 && labirinto[i][j]<=4) {
                    finali.add(new int[]{i, j});
                }
            }
        }
        int[] start= finali.get(rand.nextInt(finali.size()));
        int[] end;


        do {
            end = finali.get(rand.nextInt(finali.size()));
        }while (start == end);
        //System.out.println(start +""+ end);

        return new int[]{start[0],start[1],end[0],end[1]};
    }
    static void analizza(){
        //finali.clear();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = labirinto[i][j];
                //int count =0;
                if (value != 0){
                    int[] dx = {0, 0, -1, 1}; //  su, giù, sinistra, destra
                    int[] dy = {-1, 1, 0, 0};
                    Integer[] direzioni = {0, 3, 1, 2};// su, destra, giù, sinistra
                    boolean[] risultati ={false,false,false,false};


                    for (int k = 0; k < direzioni.length; k++) {
                        int dir = direzioni[k];
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        risultati[k]=èlabirinto(nx,ny);
                    }




                    labirinto[i][j]=definisci(risultati);
                    //finali.add(new int[]{i,j});
                }
            }
        }
    }

    static int definisci(boolean[] risultato){
        for (int i = 0; i < direzioniImage.size(); i++) {
            if (Arrays.equals(risultato,direzioniImage.get(i))){
                return i;
            }
        }
        return 100;
    }

    // Verifica se la cella è valida per scavare
    static boolean èValida(int x, int y) {
        return x > 0 && y > 0 && x < size - 1 && y < size - 1 && labirinto[x][y] == 0;
    }
    static boolean èlabirinto(int x, int y){
        try{
            return labirinto[x][y] != 0;
        }catch (Exception ex){
            return false;
        }

    }

    // Stampa il labirinto in console
    static void stampaLabirinto() {
        /*Color muro = Color.WHITE;//0  Bianco
        Color percorso =Color.GREEN;//2   Verde
        Color puntoFinale =Color.RED;//1	Rosso
        Color giunzione=Color.BLUE;//3   Blu
        Color inizio=Color.VIOLET;//5    Viola
        Color fine=Color.BLACK;//6 Nero*/

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(labirinto[j][i]+" \t");
                /*if(labirinto[i][j] == 0){
                    System.out.print(muro);
                }else if (labirinto[i][j] ==1){
                    System.out.print(puntoFinale);
                } else if (labirinto[i][j]==2) {
                    System.out.print(percorso);
                }else if (labirinto[i][j]==3 ||labirinto[i][j]==4) {
                    System.out.print(giunzione);
                }else if (labirinto[i][j]==5) {
                    System.out.print(inizio);
                }else {
                    System.out.print(fine);
                }*/
            }
            System.out.println();
        }
        System.out.println();
    }
}

/*


🟥	Rosso
🟦	Blu
🟩	Verde
🟨	Giallo
🟧	Arancione
🟪	Viola
🟫	Marrone
⬛	Nero grande
⬜	Bianco grande

*/
