package com.lab;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Map<Integer,Texture> labirintoImage;

    private int[][] labirinto;


    private int dimensioneImmagine = 256;
    private int screenHeight;




    private int impostaDimensioneImmagine;

    @Override
    public void create() {
        labirintoImage = new HashMap<>();

        batch = new SpriteBatch();
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





        labirinto = LabirintoDFS.ottieniLabirinto();
        screenHeight= Gdx.graphics.getHeight();
        impostaDimensioneImmagine=screenHeight/ labirinto.length;
    }

    @Override
    public void render() {

        draw();
    }

    private void draw(){
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                //System.out.println(impostaDimensioneImmagine);
                batch.draw(labirintoImage.get(labirinto[i][j]),impostaDimensioneImmagine*i,impostaDimensioneImmagine*(labirinto[i].length-j)-impostaDimensioneImmagine,impostaDimensioneImmagine,impostaDimensioneImmagine);
            }
        }
        //batch.draw(image, 140, 210);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}

class LabirintoDFS {
    static final int SIZE = 99;
    static int[][] labirinto = new int[SIZE][SIZE];
    static Random rand = new Random();
    static Scanner input = new Scanner(System.in);
    static ArrayList<int[]> finali;
    static int differenzaPosizione = 10;
    static ArrayList<boolean[]> direzioniImage = new ArrayList<>();

    static void prepara() {
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


    public static int[][] ottieniLabirinto() {
        inizializzaGriglia();

        prepara();

        genera(1, 1);
        analizza();
        //completa();
        stampaLabirinto();
        return labirinto;

    }



    // Inizializza tutta la griglia con muri (0)
    static void inizializzaGriglia() {
        for (int i = 0; i < SIZE; i++) {
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
    static void completa(){
        finali.clear();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (labirinto[i][j] == 1) {
                    finali.add(new int[]{i, j});
                }
            }
        }
        int[] start= finali.get(rand.nextInt(finali.size()));
        int[] end;
        do {
            end = finali.get(rand.nextInt(finali.size()));
        }while (start == end);
        /*
        for (int[] i : finali) {
            System.out.println(i[0]+", "+i[1]);
        }*/
        //labirinto[start[0]][start[1]]=5+differenzaPosizione;
        //labirinto[end[0]][end[1]]=6;
    }
    static void analizza(){
        //finali.clear();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
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
        return x > 0 && y > 0 && x < SIZE - 1 && y < SIZE - 1 && labirinto[x][y] == 0;
    }
    static boolean èlabirinto(int x, int y){
        return labirinto[x][y] != 0;
    }

    // Stampa il labirinto in console
    static void stampaLabirinto() {
        /*Color muro = Color.WHITE;//0  Bianco
        Color percorso =Color.GREEN;//2   Verde
        Color puntoFinale =Color.RED;//1	Rosso
        Color giunzione=Color.BLUE;//3   Blu
        Color inizio=Color.VIOLET;//5    Viola
        Color fine=Color.BLACK;//6 Nero*/

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
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
