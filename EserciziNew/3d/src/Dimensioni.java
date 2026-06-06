public class Dimensioni {
    private int x;
    private int y;
    private int z;

    private int xPunto;
    private int yPunto;
    private int zPunto;

    private boolean[][][] matrice;


    Dimensioni(int volume) {
        this.x = volume;
        this.y = volume;
        this.z = volume;
        this.xPunto = 0;
        this.yPunto = 0;
        this.zPunto = 0;
        this.matrice = new boolean[x][y][z];
        inizializzazione();
    }


    private void inizializzazione() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    matrice[i][j][k] = false;
                }
            }
        }
        matrice[xPunto][yPunto][zPunto] = true;
    }

    void stampaMatrice() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    if (matrice[i][j][k]){
                        System.out.print("O  ");
                    }
                    else{
                        System.out.print("*  ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
        for (int i = 0; i < x; i++) {
            System.out.print("--");
        }
        System.out.println();
    }
    void spostamento(int xSpostamento, int ySpostamento, int zSpostamento) {
        matrice[xPunto][yPunto][zPunto] = false;
        matrice[xPunto+xSpostamento][yPunto-ySpostamento][zPunto-zSpostamento] = true;
    }
}
