package com.lab;

import com.badlogic.gdx.ApplicationAdapter;
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
    private int[][] labirinto;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        labirinto = LabirintoDFS.ottieniLabirinto();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 140, 210);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}

class LabirintoDFS {
    static final int SIZE = 20;
    static int dimensione = 20;
    static int[][] labirinto = new int[SIZE][SIZE];
    static Random rand = new Random();
    static Scanner input = new Scanner(System.in);
    static ArrayList<int[]> finali;
    static int differenzaPosizione = 10;

    public static int[][] ottieniLabirinto() {
        inizializzaGriglia();
        genera(1, 1);
        analizza();
        completa();
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
        labirinto[start[0]][start[1]]=5+differenzaPosizione;
        labirinto[end[0]][end[1]]=6;
    }
    static void analizza(){
        //finali.clear();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int value = labirinto[i][j];
                int count =0;
                if (value != 0){
                    int[] dx = {0, 0, -1, 1}; // sinistra, destra, su, giù
                    int[] dy = {-1, 1, 0, 0};
                    Integer[] direzioni = {0, 1, 2, 3};


                    for (int dir : direzioni) {

                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if (èlabirinto(nx,ny)) {
                            count++;
                        }
                    }
                    labirinto[i][j]=count;
                    //finali.add(new int[]{i,j});
                }
            }
        }
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
        Color muro = Color.WHITE;//0  Bianco
        Color percorso =Color.GREEN;//2   Verde
        Color puntoFinale =Color.RED;//1	Rosso
        Color giunzione=Color.BLUE;//3   Blu
        Color inizio=Color.VIOLET;//5    Viola
        Color fine=Color.BLACK;//6 Nero

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                //System.out.print(labirinto[i][j]+"  ");
                if(labirinto[i][j] == 0){
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
                }
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
