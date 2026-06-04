package com.lab;

import com.badlogic.gdx.math.Rectangle;
import java.util.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

/**
 * Collisioni per una cella del labirinto.
 */
public class CollisioniS extends CollisioniBase{
    private int whiteSpace;
    private int blackSpace;
    private boolean[] directions;

    /**
     * @param x posizione X
     * @param y posizione Y
     * @param width larghezza cella
     * @param height altezza cella
     * @param whiteSpace spazio centrale
     * @param id tipo di cella
     */
    public CollisioniS (int x, int y, int width, int height, int whiteSpace, int id){
        super(x, y, width, height);
        this.whiteSpace = whiteSpace;
        blackSpace=Math.round((width-whiteSpace)/2f);
        directions = LabirintoDFSS.direzioniImage.get(id);
        popola();
    }

    /**
     * Disegna i rettangoli di collisione.
     * @param shape renderer
     */
    public void testCollisioni(ShapeRenderer shape){
        shape.setColor(Color.BLUE);
        for (Rectangle rect : collisioni){
            shape.rect(rect.x, rect.y, rect.width,rect.height);
        }
    }

    /**
     * Crea i rettangoli di collisione in base alle direzioni della cella.
     */
    @Override
    protected void popola() {
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
}
