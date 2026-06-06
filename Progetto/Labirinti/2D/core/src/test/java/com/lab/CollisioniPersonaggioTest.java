package com.lab;

import com.badlogic.gdx.math.Rectangle;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollisioniPersonaggioTest {
    @Test
    public void shouldCreateOneCollisionRectangleWithCorrectVValues(){
        CollisioniPersonaggio c = new CollisioniPersonaggio(10,20,30,40);

        Rectangle r = c.getCollisioni().get(0);

        assertEquals(10,r.x,0.01f);
        assertEquals(20,r.y,0.01f);
        assertEquals(30,r.width,0.01f);
        assertEquals(40,r.height,0.01f);

    }

}
