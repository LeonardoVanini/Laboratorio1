package com.lab;

import java.util.*;

/**
 * Genera un labirinto con DFS.
 */
public class LabirintoDFSS {//Depth-First Search
    static int size = 21;
    static int[][] labirinto;
    static Random rand = new Random();
    static Scanner input = new Scanner(System.in);
    static ArrayList<int[]> finali;
    static ArrayList<boolean[]> direzioniImage = new ArrayList<>();

    /** Prepara le strutture interne. */
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

    /**
     * @param dimensione lato del labirinto
     * @return matrice generata
     */
    public static int[][] ottieniLabirinto(int dimensione) {
        if (dimensione >0){
            size = dimensione;
        }
        prepara();
        inizializzaGriglia();



        genera(1, 1);
        analizza();

        //stampaLabirinto();
        return labirinto;
    }

    /** Inizializza la griglia. */
    static void inizializzaGriglia() {
        for (int i = 0; i < size; i++) {
            Arrays.fill(labirinto[i], 0);
        }
        finali = new ArrayList<>();
    }

    /**
     * DFS ricorsiva.
     * @param x cella X
     * @param y cella Y
     */
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
                genera(nx, ny); // ricorsione
            }
        }
    }

    /**
     * @return coordinate start/end
     */
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

        return new int[]{start[0],start[1],end[0],end[1]};
    }

    /** Analizza le celle e assegna l'ID corretto. */
    static void analizza(){

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = labirinto[i][j];
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
                }
            }
        }
    }

    /**
     * @param risultato direzioni aperte
     * @return ID della cella
     */
    static int definisci(boolean[] risultato){
        for (int i = 0; i < direzioniImage.size(); i++) {
            if (Arrays.equals(risultato,direzioniImage.get(i))){
                return i;
            }
        }
        return 100;
    }

    /**
     * @param x coordinata X
     * @param y coordinata Y
     * @return true se scavabile
     */
    static boolean èValida(int x, int y) {
        return x > 0 && y > 0 && x < size - 1 && y < size - 1 && labirinto[x][y] == 0;
    }

    /**
     * @param x coordinata X
     * @param y coordinata Y
     * @return true se è parte del labirinto
     */
    static boolean èlabirinto(int x, int y){
        try{
            return labirinto[x][y] != 0;
        }catch (Exception ex){
            return false;
        }

    }

    /** Stampa il labirinto. */
    static void stampaLabirinto() {


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(labirinto[j][i]+" \t");

            }
            System.out.println();
        }
        System.out.println();
    }
}





