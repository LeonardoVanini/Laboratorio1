package com.lab;

/**
 * Gestisce labirinto e punti di inizio/fine.
 */
public class ConnectLabirintoS {
    private int[][] labirinto;
    private int[] fini;

    /**
     * @param dimensione lato del labirinto
     */
    public void setLabirinto(int dimensione) {
        this.labirinto = LabirintoDFSS.ottieniLabirinto(dimensione);
        this.fini = LabirintoDFSS.completa();
    }

    /**
     * @return matrice del labirinto
     */
    public int[][] getLabirinto() {
        return labirinto;
    }

    /**
     * @return startX, startY, endX, endY
     */
    public int[] getFini() {
        return fini;
    }
}

