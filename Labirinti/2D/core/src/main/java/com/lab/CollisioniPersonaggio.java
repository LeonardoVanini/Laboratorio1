package com.lab;

import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Hitbox del personaggio.
 */
public class CollisioniPersonaggio extends CollisioniBase{
    /**
     * @param x posizione X
     * @param y posizione Y
     * @param width larghezza
     * @param height altezza
     */
    public CollisioniPersonaggio(int x, int y, int width, int height){
        super(x, y, width, height);
        popola();
    }

    /** Crea un solo rettangolo di collisione. */
    @Override
    protected void popola() {
        collisioni.add(new Rectangle(x,y,width,height));
    }
}
