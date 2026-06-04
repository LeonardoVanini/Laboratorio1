package com.lab;

import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Base per oggetti con collisioni.
 */
public abstract class CollisioniBase {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected ArrayList<Rectangle> collisioni;

    /**
     * @param x posizione X
     * @param y posizione Y
     * @param width larghezza
     * @param height altezza
     */
    public CollisioniBase (int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        collisioni =new ArrayList<>();
    }

    /** Popola la lista delle collisioni. */
    protected abstract void popola();

    /**
     * @return lista dei rettangoli di collisione
     */
    public ArrayList<Rectangle> getCollisioni(){
        return collisioni;
    }
}
